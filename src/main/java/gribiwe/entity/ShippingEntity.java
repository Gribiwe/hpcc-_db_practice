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

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "transport", nullable = false)
   private TransportEntity transport;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "discount")
   private DiscountEntity discount;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "recipient", nullable = false)
   private RecipientEntity recipient;

   @Column(name = "shipment_capacity", nullable = false)
   private Double shipmentCapacity;

   @Column(name = "shipment_weight", nullable = false)
   private Double shipmentWeight;

   @Column(name = "distance", nullable = false)
   private Double distance;

   @Column(name = "extras", nullable = false)
   private Double extras;

   @Column(name = "payment", nullable = false)
   private Double payment;

   @Column(name = "date", nullable = false)
   private Timestamp date;

   public ShippingEntity() {
   }

   public void setId(UUID id) {
      this.id = id;
   }

   public void setTransport(TransportEntity transport) {
      this.transport = transport;
   }

   public void setDiscount(DiscountEntity discount) {
      this.discount = discount;
   }

   public void setRecipient(RecipientEntity recipient) {
      this.recipient = recipient;
   }

   public void setShipmentCapacity(Double shipmentCapacity) {
      this.shipmentCapacity = shipmentCapacity;
   }

   public void setShipmentWeight(Double shipmentWeight) {
      this.shipmentWeight = shipmentWeight;
   }

   public void setDistance(Double distance) {
      this.distance = distance;
   }

   public void setExtras(Double extras) {
      this.extras = extras;
   }

   public void setPayment(Double payment) {
      this.payment = payment;
   }

   public void setDate(Timestamp date) {
      this.date = date;
   }

   public UUID getId() {
      return id;
   }

   public TransportEntity getTransport() {
      return transport;
   }

   public DiscountEntity getDiscount() {
      return discount;
   }

   public RecipientEntity getRecipient() {
      return recipient;
   }

   public Double getShipmentCapacity() {
      return shipmentCapacity;
   }

   public Double getShipmentWeight() {
      return shipmentWeight;
   }

   public Double getDistance() {
      return distance;
   }

   public Double getExtras() {
      return extras;
   }

   public Double getPayment() {
      return payment;
   }

   public Timestamp getDate() {
      return date;
   }
}
