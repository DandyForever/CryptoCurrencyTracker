package isteriagroup.cryptotracker.daos;

import isteriagroup.cryptotracker.entities.Currency;
import isteriagroup.cryptotracker.entities.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionCurrencyDao extends CrudRepository<Subscription, Currency> {
}
