package gribiwe.controller;

import gribiwe.entity.ShippingEntity;
import gribiwe.exception.RecipientExistsException;
import gribiwe.service.RecipientService;
import gribiwe.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

   @PostMapping("/register")
   public String register(String name, String address, String phone) {
      String toReturn;
      try {
         recipientService.registerNew(name, address, phone);
         toReturn = "done";

      } catch (RecipientExistsException e) {
         toReturn = "";
         if (e.isNameExists()) {
            toReturn+="1";
         } else {
            toReturn+="0";
         }
         if (e.isPhoneExists()) {
            toReturn+="1";
         } else {
            toReturn+="0";
         }
      }
      System.out.println("toretr: "+toReturn);
      return toReturn;
   }

   @PostMapping("/login")
   public String login(String name, String phone) {
      String toReturn;

      if (recipientService.isExistsName(name) && recipientService.isExistsPhone(phone)) {
         toReturn = "done";
      } else {
         toReturn = "err";
      }

      return toReturn;
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
