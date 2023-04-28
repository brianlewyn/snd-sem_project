import java.time.LocalDate;

public class Client extends Person{ 
   private String address; 
   private String rfc;
   private ShoppingCart shoppingCart;

   public Client(String n, String e, String a, String r, LocalDate da){
      super(n, e, da);
      address = a;
      rfc = r;
      date = da;
      shoppingCart = new ShoppingCart();
   }

   public String getAddress(){
      return address;
   }
   
   public String getRfc(){
      return rfc;
   }

   public ShoppingCart getShoppingCart(){
      return shoppingCart;
   }
   
   public void setAddress(String a){
      this.address=a;
   }  
   
   public void setRfc(String r){
      this.rfc=r;
   }

   public String toString(){
      return "Client["+name+"]:\nAddress: "+address+"\nRFC: "+rfc+"\nEmail: "+email;
   }
}