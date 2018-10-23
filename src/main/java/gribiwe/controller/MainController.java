package gribiwe.controller;

import gribiwe.entity.ShippingEntity;
import gribiwe.service.RecipientService;
import gribiwe.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

   private final RecipientService recipientService;
   private final ShippingService shippingService;

   @Autowired
   public MainController(RecipientService recipientService, ShippingService shippingService) {
      this.recipientService = recipientService;
      this.shippingService = shippingService;
   }

   @GetMapping("/users_count")
   public String usersCount() {
      return recipientService.getRecipients().size()+"";
   }

   @GetMapping("/shipping_number")
   public String shippingNumber() {
      return shippingService.getShippings().size()+"";
   }

   @GetMapping("/kilometers_number")
   public String kilometersNumber() {
      int toReturn = 0;
      for (ShippingEntity shipping : shippingService.getShippings()) {
         toReturn += shipping.getDistance();
      }
      return toReturn+"";
   }
}
