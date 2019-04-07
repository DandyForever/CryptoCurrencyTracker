package isteriagroup.cryptotracker.InfoCollector;

import isteriagroup.cryptotracker.CryptotrackerApplication;
import isteriagroup.cryptotracker.entities.Currency;
import isteriagroup.cryptotracker.daos.CurrencyDao;

import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@Component
@NoArgsConstructor
public class RunData{

    private static final Logger log = LoggerFactory.getLogger(CryptotrackerApplication.class);

    @Bean
    public CommandLineRunner insertCurrencies(CurrencyDao currencyDao) {

        CourseCollector.runCollector();

        String changes[] = CourseCollector.getChanges();
        String values[] = CourseCollector.getValues();
        String dataNames[] = CourseCollector.getDataNames();
        int quantityCurrency = changes.length;

        Currency currencies[] = new Currency[quantityCurrency];
        int iter = 0;
        for (iter = 0; iter < quantityCurrency; iter++){
            currencies[iter] = new Currency((long) iter, dataNames[iter], new BigDecimal(values[iter]), new BigDecimal(changes[iter]));
        }


        return args -> {

            int i;
            for (i = 0; i < quantityCurrency; i++){
                currencyDao.save(currencies[i]);
            }

            log.info("-----------------------Currency data has been initialized-----------------------");
        };
    }
}