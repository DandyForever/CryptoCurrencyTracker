package isteriagroup.cryptotracker.daos;

import isteriagroup.cryptotracker.entities.Subscription;
import isteriagroup.cryptotracker.entities.SubscriptionPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionDao extends CrudRepository<Subscription, SubscriptionPK> {

    @Query("SELECT p FROM Subscription p")
    List<Subscription> findAllBy();
}
