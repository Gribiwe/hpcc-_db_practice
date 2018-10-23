package gribiwe.service;

import gribiwe.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

   private final ShippingRepository shippingRepository;

   @Autowired
   public ShippingService(ShippingRepository shippingRepository) {
      this.shippingRepository = shippingRepository;
   }
}
