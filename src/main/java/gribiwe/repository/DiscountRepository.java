package gribiwe.repository;

import gribiwe.entity.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiscountRepository extends JpaRepository<RecipientEntity, UUID> {
}
