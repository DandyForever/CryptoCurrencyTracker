package isteriagroup.cryptotracker.InfoCollector;

import isteriagroup.cryptotracker.daos.CurrencyDao;
import isteriagroup.cryptotracker.entities.Currency;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.net.*;
import java.io.*;
import java.util.Stack;



//@Component
public class CourseCollector implements CommandLineRunner {

    private static void parseHtmlDoc(int dataNamesSize, Stack<String> dataVal){

        try {
            URL lab = new URL("https://www.rbc.ru/crypto/?utm_source=topline");
            InputStreamReader isr = new InputStreamReader(lab.openStream(), "UTF-8");

            BufferedReader d = new BufferedReader(isr);
            String line;

            while ((line = d.readLine()) != null) {
                if (line.lastIndexOf("<span class=\"currencies__inset__inner\">") != -1) {
                    line = d.readLine();
                    if ((line.lastIndexOf("</span>") == -1) & ((line.lastIndexOf("</div>") == -1))) {
                        String lineTmp = line.replaceAll(" ", "");

                        if (dataVal.size() == 2 * dataNamesSize) {
                            break;
                        }

                        dataVal.push(lineTmp);
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(dataVal);
        }
    }

    private static void fillMass(String changes[], String values[], Stack<String> dataVal){

        int dataSize = dataVal.size();

        int i = 0;
        int tmp;

        for (i = 0; i < dataSize; i++) {
            if (i % 2 == 0) {
                tmp = i / 2;
                changes[tmp] = dataVal.pop();
            }

            if (i % 2 == 1) {
                tmp = (i - 1) / 2;
                values[tmp] = dataVal.pop();
            }
        }
    }

    private static void printGottenData(int dataNamesSize, String changes[], String values[], String dataNames[]){

        int i = 0;

        for (i = 0; i < dataNamesSize; i++) {
            System.out.println(dataNames[dataNamesSize - 1 - i] + " " + values[i] + " " + changes[i] + " ");
        }
    }


    private  CurrencyDao currencyDao;


    @PostConstruct
    public void initCurrencies(String changes[], String values[], String dataNames[]){
        currencyDao.save(new Currency(dataNames[0],
                new BigDecimal(values[0]),
                new BigDecimal(changes[0])));

    }

    private static void replaceCommaByDot(String mass[]){
        int i = 0;
        int size = mass.length;

        for (i = 0; i < size; i++)
        {
            mass[i] = mass[i].replaceAll(",", ".");
        }
    }

    public void run(String... strings) throws Exception{

        String dataNames[] = {"BTC/USD", "ETH/USD", "NEO/USD", "XRP/USD",
                "IOT/USD", "DSH/USD", "BTG/USD",
                "LTC/USD", "XMR/USD", "ETC/USD",
                "EOS/USD", "OMG/USD", "QTM/USD",
                "ZEC/USD", "AVT/USD", "ETP/USD", "EDO/USD"};

        Stack<String> dataVal = new Stack<>();

        int dataNamesSize = dataNames.length;

        String changes[] = new String[dataNamesSize];
        String values[] = new String[dataNamesSize];

        parseHtmlDoc(dataNamesSize, dataVal);
        fillMass(changes, values, dataVal);

        replaceCommaByDot(changes);
        replaceCommaByDot(values);

        printGottenData(dataNamesSize, changes, values, dataNames);

        initCurrencies(changes, values, dataNames);
        /*BigDecimal num = new BigDecimal(changes[1]);
        System.out.println(num);*/

    }
}
