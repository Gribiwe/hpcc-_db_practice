package gribiwe.repository;

import gribiwe.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiscountRepository extends JpaRepository<DiscountEntity, UUID> {
}
