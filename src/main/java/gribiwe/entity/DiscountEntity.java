package gribiwe.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "discount_table")
public class DiscountEntity {

   @Id
   @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
   @GeneratedValue(generator = "uuid-gen")
   @Column(name = "discount_id", nullable = false, updatable = false)
   private UUID id;

   @Column(name = "lower_threshold", nullable = false)
   private Double lowerThreshold;

   @Column(name = "upper_threshold", nullable = false)
   private Double upperThreshold;

   @Column(name = "amount", nullable = false)
   private Double amount;

   public void setId(UUID id) {
      this.id = id;
   }

   public void setLowerThreshold(Double lowerThreshold) {
      this.lowerThreshold = lowerThreshold;
   }

   public void setUpperThreshold(Double upperThreshold) {
      this.upperThreshold = upperThreshold;
   }

   public void setAmount(Double amount) {
      this.amount = amount;
   }

   public UUID getId() {
      return id;
   }

   public Double getLowerThreshold() {
      return lowerThreshold;
   }

   public Double getUpperThreshold() {
      return upperThreshold;
   }

   public Double getAmount() {
      return amount;
   }

   public DiscountEntity() {
   }
}
