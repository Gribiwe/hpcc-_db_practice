package gribiwe.repository;

import gribiwe.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface DiscountRepository extends JpaRepository<DiscountEntity, UUID> {
   DiscountEntity findFirstByLowerThresholdGreaterThanEqualOrLowerThresholdEqualsAndUpperThresholdLessThanEqualOrUpperThresholdEquals(Double lowerThreshold, Double lowerThreshold2, Double upperThreshold, Double upperThreshold2);
}
