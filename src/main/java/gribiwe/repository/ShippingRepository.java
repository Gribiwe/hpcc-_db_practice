package gribiwe.repository;

import gribiwe.entity.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShippingRepository extends JpaRepository<ShippingEntity, UUID> {
}
