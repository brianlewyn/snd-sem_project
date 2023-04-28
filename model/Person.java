import java.time.LocalDate;

public abstract class Person{
   protected String name;
   protected String email;
	protected LocalDate date;

	public Person(String n, String e, LocalDate da){
      name = n;
      email = e;
		date = da;
   }
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}

	public LocalDate getDate(){
      return date;
   }
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setEmail(String e){
		this.email = e;
	}

	public void setDate(LocalDate date){
      this.date = date;
   }
}
