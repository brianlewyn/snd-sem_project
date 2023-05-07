public class Client extends Person{ 
   private String address; 
   private String rfc;

   public Client(String n, String e, String a, String r){
      super(n, e);
      address = a;
      rfc = r;
   }

   public String getAddress(){
      return address;
   }
   
   public String getRfc(){
      return rfc;
   }
   
   public void setAddress(String address){
      this.address = address;
   }  
   
   public void setRfc(String rfc){
      this.rfc = rfc;
   }

   public String toString(){
      return "CLIENT"+super.toString()+"\nAddress: "+address+"\nRFC: "+rfc;
   }

   // CLIENT: 
   // Name: Yael Salazar 
   // Email: random@gmail.com
   // Address: random. av. randow
   // RFC: 12DFGH6789JKL
}