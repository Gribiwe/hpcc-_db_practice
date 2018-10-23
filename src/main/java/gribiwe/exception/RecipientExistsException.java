package gribiwe.exception;

public class RecipientExistsException extends Exception {

   private boolean phoneExists;
   private boolean nameExists;

   public RecipientExistsException(String message, boolean phoneExists, boolean nameExists) {
      super(message);
      this.nameExists = nameExists;
      this.phoneExists = phoneExists;
   }

   public void setPhoneExists(boolean phoneExists) {
      this.phoneExists = phoneExists;
   }

   public void setNameExists(boolean nameExists) {
      this.nameExists = nameExists;
   }

   public boolean isPhoneExists() {
      return phoneExists;
   }

   public boolean isNameExists() {
      return nameExists;
   }
}
