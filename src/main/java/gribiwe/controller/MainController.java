package gribiwe.controller;

import gribiwe.entity.RecipientEntity;
import gribiwe.entity.ShippingEntity;
import gribiwe.entity.TransportEntity;
import gribiwe.exception.BadTransportException;
import gribiwe.exception.RecipientExistsException;
import gribiwe.service.RecipientService;
import gribiwe.service.ShippingService;
import gribiwe.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class MainController {

   private final RecipientService recipientService;
   private final ShippingService shippingService;
   private final TransportService transportService;

   @Autowired
   public MainController(RecipientService recipientService, ShippingService shippingService, TransportService transportService) {
      this.recipientService = recipientService;
      this.shippingService = shippingService;
      this.transportService = transportService;
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

   @PostMapping("/find")
   public List<TransportEntity> find(String weight, String capacity) {
      return transportService.getTransportEntities(Double.parseDouble(weight), Double.parseDouble(capacity));
   }

   @PostMapping("/makeShip")
   public String makeShip(String weight, String capacity, String distance, String transport, String recName) {

      UUID transportID = UUID.fromString(transport);
      Double weightD = Double.parseDouble(weight);
      Double capacityD = Double.parseDouble(capacity);
      Double distanceD = Double.parseDouble(distance);

      RecipientEntity recipient = recipientService.getRecipient(recName);
      TransportEntity transportEntity = transportService.getTransport(transportID);

      String payment;
      try {
         payment = shippingService.addNew(recipient, transportEntity, capacityD, weightD, distanceD, 60D).getPayment()+"";
      } catch (BadTransportException e) {
         e.printStackTrace();
         payment = "err";
      }
      return payment;
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
