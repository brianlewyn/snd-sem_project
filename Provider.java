import java.time.LocalDate;

public class Provider{
	protected String name;
	protected String phone;
	protected String email;
	protected LocalDate date;
	private int nProductReference;
	private Product[] productArrayReference = new Product[10];

	public Provider(String n, String p, String e, LocalDate d){
		name = n;
		phone = p;
		email = e;
		date = d;
	}

	//Getters
	public String getName(){
		return name;
	}

	public String getPhone(){
		return phone;
	}

	public String getEmail(){
		return email;
	}

	public LocalDate getDate(){
		return date;
	}
    
	//Setters
	public void setName(String name){
		this.name = name;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public void setEmail(String email){
		this.email = email;
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

   public int getNumProductReference(){
      return nProductReference;
   }

	public String toStringProductArray(){
      String temp =  "Provier ["+name+"]:";

      if (nProductReference == 0){
         return temp+"\n\tNo products yet";
      }

      for (int i=0; i<nProductReference; i++){
         temp = "\n"+i+1+".-"+productArrayReference[i].getName();
      }
      
      return temp;
   }

	public String toString(){
		return "Provider["+name+"]:\nPhone: " + phone + "\nEmail: " + email;
	}
}