package gribiwe.repository;

import gribiwe.entity.TransportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransportRepository extends JpaRepository<TransportEntity, UUID> {
   List<TransportEntity> findTransportEntitiesByMaxCapacityIsGreaterThanEqualAndMaxWeightIsGreaterThanEqual(Double maxCapacity, Double maxWeight);

   TransportEntity
}
