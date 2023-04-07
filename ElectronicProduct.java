import java.time.LocalDate;

public class ElectronicProduct extends Product{
    private long serial = 0;

    public ElectronicProduct(String n, long c, float p, float di, String de, LocalDate da, Provider r,  long s){
        super(n, c, p, di, de, da, r);
        serial = s;
    }

    public long getSerial(){
        return serial;
    }

    public void setSerial(long s){
        serial = s;
    }

    public String toString(){
        return name
        +"\n\tProduct code: " +code 
        +"\n\tSerial number: " +serial
        +"\n\tProduct price: " +price
        +"\n\tDiscount: " +discount
        +"\n\tDescription: \n\t" +description
        +"\n\tAdded in " +date;
    }
}