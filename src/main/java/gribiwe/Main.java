package gribiwe;

import gribiwe.entity.DiscountEntity;
import gribiwe.entity.RecipientEntity;
import gribiwe.entity.ShippingEntity;
import gribiwe.entity.TransportEntity;
import gribiwe.service.DiscountService;
import gribiwe.service.RecipientService;
import gribiwe.service.ShippingService;
import gribiwe.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Main implements CommandLineRunner {

   private final TransportService transportService;
   private final DiscountService discountService;
   private final RecipientService recipientService;
   private final ShippingService shippingService;

   @Autowired
   public Main(TransportService transportService, DiscountService discountService, RecipientService recipientService, ShippingService shippingService) {
      this.transportService = transportService;
      this.discountService = discountService;
      this.recipientService = recipientService;
      this.shippingService = shippingService;
   }


   public static void main(String[] args) {
      SpringApplication.run(Main.class, args);
   }

   @Override
   public void run(String... strings) throws Exception {
      TransportEntity t1 = transportService.saveTransport("Фура", 5D, 100D, 100D);
      TransportEntity t2 = transportService.saveTransport("Большая фура", 50D, 1000D, 1000D);

      DiscountEntity d1 = discountService.addNew(999D, 100D, 5D);
      DiscountEntity d2 = discountService.addNew(4999D, 1000D, 10D);
      DiscountEntity d3 = discountService.addNew(5000D, Double.MAX_VALUE, 15D);

      RecipientEntity r1 = recipientService.registerNew("Никита Гриб", "улица Пушкина дом калатушкина", "89005553535");

      ShippingEntity s1 = shippingService.addNew(r1, t2, 270D, 50D, 500D, 3D);
      System.out.println(s1.getId());
      System.out.println(s1.getTransport().getName());
      System.out.println(s1.getRecipient().getName());
      System.out.println(s1.getShipmentCapacity());
      System.out.println(s1.getShipmentWeight());
      System.out.println(s1.getDiscount().getAmount()+ " %");
      System.out.println(s1.getDistance());
      System.out.println(s1.getExtras());
      System.out.println(s1.getPayment());
      System.out.println(s1.getDate());
   }
}
