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
}

