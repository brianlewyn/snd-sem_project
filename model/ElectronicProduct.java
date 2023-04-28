import java.time.LocalDate;

public class ElectronicProduct extends Product{
    private long serial = 0;

    public ElectronicProduct(String n, int st, long c, float p, float di, String de, LocalDate da, Provider r,  long se){
        super(n, st, c, p, di, de, da, r);
        serial = se;
    }

    public Product getCopy(){
        return new ElectronicProduct(name,1,code,price,discount,description,date,providerReference, serial);
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