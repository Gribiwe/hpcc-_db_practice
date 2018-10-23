package gribiwe.service;

import gribiwe.entity.DiscountEntity;
import gribiwe.entity.RecipientEntity;
import gribiwe.entity.ShippingEntity;
import gribiwe.entity.TransportEntity;
import gribiwe.exception.BadTransportException;
import gribiwe.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ShippingService {

   private final ShippingRepository shippingRepository;
   private final DiscountService discountService;

   @Autowired
   public ShippingService(ShippingRepository shippingRepository, DiscountService discountService) {
      this.shippingRepository = shippingRepository;
      this.discountService = discountService;
   }

   public List<ShippingEntity> getShippings() {
      return shippingRepository.findAll();
   }

   public ShippingEntity addNew(RecipientEntity recipient, TransportEntity transport, Double capacity, Double weight, Double distance, Double extras) throws BadTransportException {
      ShippingEntity shippingEntity = new ShippingEntity();
      shippingEntity.setId(UUID.randomUUID());
      shippingEntity.setRecipient(recipient);
      boolean tooBigCapacity = transport.getMaxCapacity() < capacity;
      boolean tooBigWeight = transport.getMaxWeight() < weight;
      if (tooBigCapacity || tooBigWeight) {
         throw new BadTransportException("too big capacity or weight", tooBigWeight, tooBigCapacity);
      }
      shippingEntity.setTransport(transport);
      shippingEntity.setDate(Timestamp.from(Instant.now()));
      shippingEntity.setDistance(distance);
      shippingEntity.setExtras(extras);
      shippingEntity.setShipmentCapacity(capacity);
      shippingEntity.setShipmentWeight(weight);
      DiscountEntity discountEntity = discountService.getDiscount(distance);

      shippingEntity.setDiscount(discountEntity);
      Double discount = discountEntity == null ? 0 : discountEntity.getAmount();

      System.out.println("payment = "+ distance+" * "+weight+" * "+transport.getPrice()+" + "+extras);
      Double payment = distance * weight * transport.getPrice() + extras;
      System.out.println("payment = "+payment +" - "+payment+" * "+(discount / 100));
      System.out.println("payment = "+payment +" - "+(payment * discount / 100));
      payment = payment - payment * discount/ 100;

      shippingEntity.setPayment(payment);
      return shippingRepository.save(shippingEntity);
   }
}
