package gribiwe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "shipping_table")
public class ShippingEntity {

   @Id
   @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
   @GeneratedValue(generator = "uuid-gen")
   @Column(name = "shipping", nullable = false, updatable = false)
   private UUID id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "transport", nullable = false)
   private TransportEntity transport;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "discount", nullable = false)
   private DiscountEntity discount;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "recipient", nullable = false)
   private RecipientEntity recipient;

   @Column(name = "shipment_capacity", nullable = false)
   private Double shipmentCapacity;

   @Column(name = "shipment_weight", nullable = false)
   private Double shipmentWeight;

   @Column(name = "distance", nullable = false)
   private Integer distance;

   @Column(name = "extras", nullable = false)
   private Double extras;

   @Column(name = "payment", nullable = false)
   private Double payment;

   @Column(name = "date", nullable = false)
   private Timestamp date;
}
