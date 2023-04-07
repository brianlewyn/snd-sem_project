import java.time.LocalDate;

public class Client{
   private String name; 
   private String address; 
   private String rfc;
   private String email;
   private LocalDate date;
   private int nProductReference;
   private Product[] productArrayReference = new Product[10];

   /**
     * Client return a intance
     * @param n  a String
     * @param a  a String
     * @param r  a String
     * @param e  a String
     */
   public Client(String n, String a, String r, String e){
      name=n;
      address=a;
      rfc=r;
      email=e;
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

   public boolean addProductReference(Product reference){
      if (nProductReference < productArrayReference.length){
         productArrayReference[nProductReference] = reference;
         nProductReference++;
         return true;
      }
      return false;
   }

   public Product getProductReference(int i){
      if (0<=i && i < nProductReference){
         return productArrayReference[i];
      }
      return null;
   }

   public boolean removeProductReference(int i){
      if (i<0 || nProductReference<=i){
         return false;
      }
      
      for (int j=i; j<productArrayReference.length-1; j++){
         productArrayReference[j] = productArrayReference[j+1];
      }
      
      productArrayReference[nProductReference-1] = null;
      nProductReference--;
      return true;
   }
   
   public void emptyProductArrayReference(){
      for (int i=0; i<nProductReference; i++){
         productArrayReference[i] = null;
         nProductReference--;
      }
   }

   public int getNumProductReference(){
      return nProductReference;
   }

   //printing objects from Client

   public String toStringBill(LocalDate date){
      String temp = "=========="+date+"==========\n";
      temp += toString()+"\n\nProducts:";

      if (nProductReference == 0){
         return temp+"\n\tNo products yet";
      }

      float total = 0F;
      for (int i=0; i<nProductReference; i++){
         temp = "\n\n"+i+1+".-"+productArrayReference[i].toString();
         total += productArrayReference[i].getPrice();
      }

      temp += String.format("\n\nTotal: $%.2f", total);
      return temp;
   }

   public String toStringProductArray(){
      String temp =  "Client ["+name+"]:";

      if (nProductReference == 0){
         return temp+"\n\tNo products yet";
      }

      for (int i=0; i<nProductReference; i++){
         temp = "\n"+i+1+".-"+productArrayReference[i].getName();
      }
      
      return temp;
   }

   public String toString(){
      return "Client["+name+"]:\nAddress: "+address+"\nRFC: "+rfc+"\nEmail: "+email;
   }
}