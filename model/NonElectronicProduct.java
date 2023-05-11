package model;

import java.time.LocalDate;

public class NonElectronicProduct extends Product{
   public NonElectronicProduct(String n, int st, long c, float p, float di,String de, LocalDate da, Provider pr){
      super(n, st, c, p, di, de, da, pr);
   }
}