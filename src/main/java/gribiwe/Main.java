package gribiwe;

import gribiwe.entity.TransportEntity;
import gribiwe.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableJpaAuditing
public class Main implements CommandLineRunner {

   private final TransportService transportService;

   @Autowired
   public Main(TransportService transportService) {
      this.transportService = transportService;
   }

   public static void main(String[] args) {
      SpringApplication.run(Main.class, args);
   }

   @Override
   public void run(String... strings) throws Exception {
      TransportEntity e1 = new TransportEntity();
      e1.setId(UUID.randomUUID());
      e1.setMaxCapacity(100D);
      e1.setMaxWeight(100D);
      e1.setName("Фура");
      e1.setPrice(255D);
      transportService.saveTransport(e1);
      TransportEntity e2 = new TransportEntity();
      e2.setId(UUID.randomUUID());
      e2.setMaxCapacity(1000D);
      e2.setMaxWeight(1000D);
      e2.setName("Фура2");
      e2.setPrice(2550D);
      transportService.saveTransport(e2);

      System.out.println("=====");
      List<TransportEntity> transportEntities = transportService.getTrasportEntities();
      for (TransportEntity transportEntity : transportEntities) {
         System.out.println(transportEntity.getName());
      }
      System.out.println("=====");
      transportEntities = transportService.getTrasportEntities(50D,50D);
      for (TransportEntity transportEntity : transportEntities) {
         System.out.println(transportEntity.getName());
      }
      System.out.println("=====");
      transportEntities = transportService.getTrasportEntities(200D,200D);
      for (TransportEntity transportEntity : transportEntities) {
         System.out.println(transportEntity.getName());
      }

   }
}
