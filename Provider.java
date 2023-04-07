import java.time.LocalDate;

public class Provider{
	protected String name;
	protected String phone;
	protected String email;
	protected LocalDate date;
	protected Product productReference;

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

	public Product getProductReference(){
		return productReference;
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
	
	public void setProductReference(Product reference){
		productReference = reference;
	}

	public void setDate(LocalDate date){
		this.date = date;
	}

	public String toString(){
		return "Provider: " + "\nName: " + name + "\nPhone: " + phone + "\nEmail: " + email;
	}
}