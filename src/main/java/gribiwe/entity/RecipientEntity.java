package gribiwe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "recipient_table")
public class RecipientEntity {

   @Id
   @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
   @GeneratedValue(generator = "uuid-gen")
   @Column(name = "recipient_id", nullable = false, updatable = false)
   private UUID id;

   @Column(name = "name", nullable = false)
   private String name;

   @Column(name = "phone", nullable = false)
   private String phone;

   @Column(name = "address", nullable = false)
   private String address;

   public RecipientEntity() {
   }

   public void setId(UUID id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public UUID getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getPhone() {
      return phone;
   }

   public String getAddress() {
      return address;
   }
}
