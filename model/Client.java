import java.time.LocalDate;

public class Client extends Person{ 
   private String address; 
   private String rfc;
   private LocalDate date;
   private ShoppingCart shoppingCart;

   public Client(String n, String e, String a, String r){
      super(n, e);
      address=a;
      rfc=r;
      shoppingCart = new ShoppingCart();
   }

   // getters
   public String getAddress(){
      return address;
   }
   
   public String getRfc(){
      return rfc;
   }
   
   public LocalDate getDate(){
      return date;
   }

   public ShoppingCart getShoppingCart(){
      return shoppingCart;
   }
   
   // setters
   public void setAddress(String a){
      this.address=a;
   }  
   
   public void setRfc(String r){
      this.rfc=r;
   }
   
   public void setDate(LocalDate date){
      this.date = date;
   }

   public String toString(){
      return "Client["+name+"]:\nAddress: "+address+"\nRFC: "+rfc+"\nEmail: "+email;
   }
}