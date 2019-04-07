package isteriagroup.cryptotracker.InfoCollector;

import isteriagroup.cryptotracker.entities.Currency;
import isteriagroup.cryptotracker.daos.CurrencyDao;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@Component
public class RunData{

    private static final Logger log = LoggerFactory.getLogger(RunData.class);
    private final int fixedRate = 21000;

    private final CurrencyDao currencyDao;

    public RunData(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    private void insertCurrencies() {

        CourseCollector.runCollector();

        String changes[] = CourseCollector.getChanges();
        String values[] = CourseCollector.getValues();
        String dataNames[] = CourseCollector.getDataNames();
        int quantityCurrency = changes.length;

        Currency currencies[] = new Currency[quantityCurrency];
        int iter = 0;
        for (iter = 0; iter < quantityCurrency; iter++) {
            currencies[iter] = new Currency((long) iter, dataNames[iter], new BigDecimal(values[iter]), new BigDecimal(changes[iter]));
        }

        int i;
        for (i = 0; i < quantityCurrency; i++) {
            currencyDao.save(currencies[i]);
        }

        log.info("---Currency data has been initialized---");
    }

    @Scheduled(fixedRate = fixedRate)
    private void initData(){
        insertCurrencies();
    }
}