import java.time.LocalDate;

public class Client{
   private String name; 
   private String address; 
   private String rfc;
   private String email;
   private LocalDate date;
   private Product productReference;

   /**
     * Client return a intance
     * @param n  a String
     * @param a  a String
     * @param r  a String
     * @param e  a String
     * @param da  a LocalDate
     * @param ref  a Product
     */
   public Client(String n, String a, String r, String e, LocalDate da){
      name=n;
      address=a;
      rfc=r;
      email=e;
      date=da;
   }

   public String getName(){
      return name;
   }

   public String getAddress(){
      return address;
   }

   public String getRfc(){
      return rfc;
   }

   public String getEmail(){
      return email;
   }

   public LocalDate getDate(){
      return date;
   }

   //get method for the product reference

   public Product getProductReference(){
         return productReference;
   }

   //setting the atributes 

   public void setName(String n){
      this.name=n;
   }

   public void setAddress(String a){
      this.address=a;
   }
      
   public void setRfc(String r){
      this.rfc=r;
   }

   public void setEmail(String e){
      this.email=e;
   }

   public void setDate(LocalDate date){
      this.date = date;
   }

   public void setProductReference(Product reference){
      productReference = reference;
   }

   //printing objects from Client

   public String toString(){
         return "\tClient name: " +name
      +"\n\t Address: " +address 
      +"\n\t RFC: " +rfc +"\t Email: " +email;
   }
}