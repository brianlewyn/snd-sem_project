import java.time.LocalDate;

public class Provider extends Person{
	protected String phone;
	private Product[] productArray = new Product[10];
	private int nProduct = 0;

	public Provider(String n, String e, String p, LocalDate da){
		super(n, e, da);
		phone = p;
	}

	public String getPhone(){
		return phone;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public boolean addProduct(Product reference){
      if (nProduct < productArray.length){
         productArray[nProduct] = reference;
         nProduct++;
         return true;
      }
      return false;
   }

   public Product getProduct(int i){
      if (0<=i && i < nProduct){
         return productArray[i];
      }
      return null;
   }

   public boolean removeProduct(int i){
      if (i<0 || nProduct<=i){
         return false;
      }
      
      for (int j=i; j<productArray.length-1; j++){
         productArray[j] = productArray[j+1];
      }
      
      productArray[nProduct-1] = null;
      nProduct--;
      return true;
   }

   public int getNumProduct(){
      return nProduct;
   }

	public String toStringProductArray(){
      String temp =  "Provier ["+name+"]:";

      if (nProduct == 0){
         return temp+"\n\tNo products yet";
      }

      for (int i=0; i<nProduct; i++){
         temp = "\n"+i+1+".-"+productArray[i].getName();
      }
      
      return temp;
   }

	public String toString(){
		return "Provider["+name+"]:\nPhone: " + phone + "\nEmail: " + email;
	}
}