package isteriagroup.cryptotracker.daos;

import isteriagroup.cryptotracker.entities.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyDao extends CrudRepository<Currency, Long> {
}