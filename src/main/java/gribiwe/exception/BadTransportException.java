package gribiwe.exception;

public class BadTransportException extends Exception{
   private boolean weightToBig;
   private boolean capacityToBig;

   public BadTransportException(String message, boolean weightToBig, boolean capacityToBig) {
      super(message);
      this.weightToBig = weightToBig;
      this.capacityToBig = capacityToBig;
   }

   public boolean isWeightToBig() {
      return weightToBig;
   }

   public boolean isCapacityToBig() {
      return capacityToBig;
   }
}
