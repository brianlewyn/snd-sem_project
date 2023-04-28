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
    public void setName(String n){
        this.name=n;
    }
    public void setAddress(String a){
        this.address=a;
    }
}