package model;

public class Provider extends Person{
	protected String phone;

	public Provider(String n, String e, String p){
		super(n, e);
		phone = p;
	}

	public String getPhone(){
		return phone;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String toString(){
		return "PROVIDER\n"+super.toString()+"\nPhone: "+phone;
	}

	// PROVIDER: 
   // Name: Yael Salazar 
   // Email: random@gmail.com
   // Phone: 123456789
}