package gribiwe.repository;

import gribiwe.entity.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipientRepository extends JpaRepository<RecipientEntity, UUID> {

   boolean existsRecipientEntitiesByPhone(String phone);

   boolean existsRecipientEntitiesByName(String name);
}
