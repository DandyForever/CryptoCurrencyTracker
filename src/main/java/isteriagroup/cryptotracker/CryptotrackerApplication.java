package isteriagroup.cryptotracker;


import isteriagroup.cryptotracker.InfoCollector.CourseCollector;
import isteriagroup.cryptotracker.daos.CurrencyDao;
import isteriagroup.cryptotracker.entities.Currency;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;


@SpringBootApplication
public class CryptotrackerApplication {


    public static void main(String[] args) {
        SpringApplication.run(CryptotrackerApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertCurrencies(CurrencyDao currencyDao) {

        CourseCollector.runCollector();

        String changes[] = CourseCollector.getChanges();
        String values[] = CourseCollector.getValues();
        String dataNames[] = CourseCollector.getDataNames();

        int quantityCurrency = changes.length;

        return args -> {
            currencyDao.deleteAll();

            int i = 0;
            for (i = 0; i < quantityCurrency; i++){
                currencyDao.save(new Currency(dataNames[i], new BigDecimal(values[i]), new BigDecimal(changes[i])));
            }

            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("-----------------------Currency data has been initialized-----------------------");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------");
        };
    }
}

