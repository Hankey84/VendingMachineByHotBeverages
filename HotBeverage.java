import java.util.Objects;

public abstract class HotBeverage extends Product {
   protected int volume;
   protected double temperature;

   public HotBeverage(String name, double price, int volume, double temperature) {
      super(name, price);
      this.volume = volume;
      this.temperature = temperature;
   }

   public int getVolume() {
      return volume;
   }

   public double getTemperature() {
      return temperature;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null || getClass() != obj.getClass())
         return false;
      HotBeverage other = (HotBeverage) obj;
      return Objects.equals(name, other.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name);
   }
}