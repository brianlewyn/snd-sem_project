import java.time.LocalDate;

public class NonElectronicProduct extends Product{
   public NonElectronicProduct(String n, int st, long c, float p, float di,String de, LocalDate da, Provider r){
      super(n, st, c, p, di, de, da, r);
   }

   public NonElectronicProduct getCopy(){
      return new NonElectronicProduct(name, 1, code, price, discount, description, date, providerReference);
   }
}