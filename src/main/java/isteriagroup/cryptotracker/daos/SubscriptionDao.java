package isteriagroup.cryptotracker.daos;

import isteriagroup.cryptotracker.entities.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDao extends CrudRepository<Subscription, Long> {
}