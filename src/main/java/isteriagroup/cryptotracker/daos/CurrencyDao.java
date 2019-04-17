package isteriagroup.cryptotracker.daos;

import isteriagroup.cryptotracker.entities.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyDao extends CrudRepository<Currency, Long> {

    @Query("SELECT p FROM Currency p")
    List<Currency> findAllBy();
}