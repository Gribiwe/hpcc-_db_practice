package gribiwe.service;

import gribiwe.entity.RecipientEntity;
import gribiwe.exception.RecipientExistsException;
import gribiwe.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipientService {

   private final RecipientRepository recipientRepository;

   @Autowired
   public RecipientService(RecipientRepository recipientRepository) {
      this.recipientRepository = recipientRepository;
   }

   public RecipientEntity registerNew(String name, String address, String phone) throws RecipientExistsException {
      boolean phoneExists = isExistsPhone(address);
      boolean nameExists = isExistsName(name);
      if (!(phoneExists || nameExists)) {
         RecipientEntity recipientEntity = new RecipientEntity();
         recipientEntity.setId(UUID.randomUUID());
         recipientEntity.setAddress(address);
         recipientEntity.setName(name);
         recipientEntity.setPhone(phone);
         return recipientRepository.save(recipientEntity);
      } else {
         throw new RecipientExistsException("Recipient with this name and phone is already exists", phoneExists, nameExists);
      }
   }

   public List<RecipientEntity> getRecipients() {
      return recipientRepository.findAll();
   }

   public RecipientEntity getRecipient(UUID uuid) {
      return recipientRepository.findOne(uuid);
   }

   public boolean isExistsPhone(String address) {
      return recipientRepository.existsRecipientEntitiesByPhone(address);
   }

   public boolean isExistsName(String name) {
      return recipientRepository.existsRecipientEntitiesByName(name);
   }
}
