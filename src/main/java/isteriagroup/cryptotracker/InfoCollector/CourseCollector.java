package isteriagroup.cryptotracker.InfoCollector;

import java.net.*;
import java.io.*;
import java.util.Stack;

public class CourseCollector {
    public static void main(String main[]) {

        Stack<String> dataVal = new Stack<>();

        String dataNames[] = {"BTC/USD", "ETH/USD", "NEO/USD", "XRP/USD",
                "IOT/USD", "DSH/USD", "BTG/USD",
                "LTC/USD", "XMR/USD", "ETC/USD",
                "EOS/USD", "OMG/USD", "QTM/USD",
                "ZEC/USD", "AVT/USD", "ETP/USD", "EDO/USD"};


        int dataNamesSize = dataNames.length;

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

        int dataSize = dataVal.size();

        int i = 0;
        int tmp;
        String changes[] = new String[dataNamesSize];
        String valuse[] = new String[dataNamesSize];

        for (i = 0; i < dataSize; i++) {
            if (i % 2 == 0) {
                tmp = i / 2;
                changes[tmp] = dataVal.pop();
            }

            if (i % 2 == 1) {
                tmp = (i - 1) / 2;
                valuse[tmp] = dataVal.pop();
            }
        }

        for (i = 0; i < dataNamesSize; i++) {
            //System.out.print(changes[i] + " ");
            System.out.println(dataNames[dataNamesSize - 1 - i] + " " + valuse[i] + " " + changes[i] + " ");
        }
    }
}