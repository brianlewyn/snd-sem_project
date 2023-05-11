package model;

import java.time.LocalDate;

public class ElectronicProduct extends Product{
    private long serial;

    public ElectronicProduct(String n, int st, long c, float p, float di, String de, LocalDate da, Provider pr,  long se){
        super(n, st, c, p, di, de, da, pr);
        serial = se;
    }

    public long getSerial(){
        return serial;
    }

    public void setSerial(long serial){
        this.serial = serial;
    }

    public String toString(){
        return super.toString() +"\nSerial: "+serial;
    }
}