public abstract class Person{
   protected String name;
   protected String email;

	public Person(String n, String e){
      name = n;
      email = e;
   }
	
	public String getName(){
		return name;
	}
	public String getEmail(){
		return email;
	}
	
	public void setName(String n){
		this.name = n;
	}
	public void setEmail(String e){
		this.email = e;
	}
   
	public abstract String toString();
}
