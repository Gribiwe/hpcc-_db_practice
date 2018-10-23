package gribiwe.service;

import gribiwe.entity.DiscountEntity;
import gribiwe.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DiscountService {

   private final DiscountRepository discountRepository;

   @Autowired
   public DiscountService(DiscountRepository discountRepository) {
      this.discountRepository = discountRepository;
   }

   public DiscountEntity addNew(Double upperThreshold, Double lowerThreshold, Double amount) {
      DiscountEntity discountEntity = new DiscountEntity();
      discountEntity.setId(UUID.randomUUID());
      discountEntity.setAmount(amount);
      discountEntity.setUpperThreshold(upperThreshold);
      discountEntity.setLowerThreshold(lowerThreshold);
      discountRepository.save(discountEntity);
      return discountEntity;
   }
}
