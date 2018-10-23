package gribiwe.service;

import gribiwe.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

   private final DiscountRepository discountRepository;

   @Autowired
   public DiscountService(DiscountRepository discountRepository) {
      this.discountRepository = discountRepository;
   }
}
