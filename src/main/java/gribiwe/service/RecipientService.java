package gribiwe.service;

import gribiwe.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipientService {

   private final RecipientRepository recipientRepository;

   @Autowired
   public RecipientService(RecipientRepository recipientRepository) {
      this.recipientRepository = recipientRepository;
   }

}
