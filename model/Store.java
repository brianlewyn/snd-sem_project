public class Store{
    private String name;
    private String address;

    public Store(String n, String a){
        name = n;
        address = a;
    }

    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }

    public String toString(){
        return "STORE:\nName: "+name+"\nAddress: "+address;
    }

    // STORE: 
    // Name:  SORIANA 
    // Address: Av. Xalapa #53
}