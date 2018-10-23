package gribiwe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "transport_table")
public class TransportEntity {

   @Id
   @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
   @GeneratedValue(generator = "uuid-gen")
   @Column(name = "transport_id", nullable = false, updatable = false)
   private UUID id;

   @Column(name = "name", nullable = false)
   private String name;

   @Column(name = "price", nullable = false)
   private Double price;

   @Column(name = "max_weight", nullable = false)
   private Double maxWeight;

   @Column(name = "max_capacity", nullable = false)
   private Double maxCapacity;

   public TransportEntity() {
   }

   public void setId(UUID id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public void setMaxWeight(Double maxWeight) {
      this.maxWeight = maxWeight;
   }

   public void setMaxCapacity(Double maxCapacity) {
      this.maxCapacity = maxCapacity;
   }

   public UUID getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public Double getPrice() {
      return price;
   }

   public Double getMaxWeight() {
      return maxWeight;
   }

   public Double getMaxCapacity() {
      return maxCapacity;
   }
}
