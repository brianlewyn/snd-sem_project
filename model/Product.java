import java.time.LocalDate;

public abstract class Product {
   protected String name;
   protected int stock;
   protected long code;
   protected float price;
   protected float discount; // 0.16 == 16%
   protected String description;
   protected LocalDate date;
   protected Provider providerReference;
   
   public Product(String n, int st, long c, float p, float di,String de, LocalDate da, Provider r){
      name = n;
      stock = st;
      code = c;
      price = p;
      discount = di;
      description = de;
      date = da;
      providerReference = r;
   }

   public abstract Product getCopy();

   public String getName(){
      return name;
   }

   public int getNumStock(){
      return stock;
   }

   public void addStock(){
      stock++;
   }

   public void removeStock(){
      stock--;
   }

   public boolean isMinimumStock(){
      if (stock<5){
         return true;
      }
      return false;
   }
   
   public long getCode(){
      return code;
   }

   public float getPrice(){
      return price;
   }

   public float getDiscount(){
      return discount;
   }

   public String getDescription(){
      return description;
   }

   public LocalDate getDate(){
      return date;
   }

   public Provider getProviderReference(){
      return providerReference;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public void setCode(long code){
      this.code = code;
   }

   public void setPrice(float price){
      this.price = price;
   }

   public void setDiscount(float discount){
      this.discount = discount;
   }

   public void setDescription(String description){
      this.description = description;
   }

   public void setDate(LocalDate date){
      this.date = date;
   }

   public void setProviderReference(Provider reference){
      providerReference = reference;
   }

   public String toString(){
      return "Product ["+name+"]:\nCode: "+code+
      "\nPrice: "+price+"\nDiscount: "+discount+
      "\nDescription: "+description+"\nDate: "+date;
   }
}
