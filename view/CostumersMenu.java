package view;

import controller.*;
import model.Store;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CostumersMenu{
	// controllers
	Clients clients;
	Products products;
	Store store;
	
	// others
	ShoppingCart shoppingCart = new ShoppingCart();
	Scanner sc = new Scanner(System.in);

	public void addControllers(Clients clients, Products products, Store store){
		this.clients = clients;
		this.products = products;
		this.store = store;
	}

	public String customerAutentication(){
		String email = ""; 
		boolean Exit = false;
		
		if (products.isEmpty()){
			System.err.println("The product's list is empty");
			return null;
		}
		
		do {
			System.out.println("\nEnter your email: ");
			email = sc.nextLine();
			
			try{
				if (clients.getClient(email) == null){
					System.err.println("Client not found");
				} else {
					Exit = true;
				}
			} catch(InputMismatchException e1){
				System.err.println("Ups, wrong option, try again :) " +e1);
			} catch(Exception e){
				System.err.println(e.getMessage());
			}

		} while(!Exit);

		return email;
	}

	public void displayCustomersMenu(){ 
		boolean Exit = false, loopLv2 = true;
		String email, option;

		if ((email = customerAutentication()) == null){
			return;
		}

		System.out.println("\nWelcome to Miscelanea JDK . What would you like to get today? ");
		System.out.println(products.showList());

		do {
			try {
				System.out.println("\nSelect an option: ");
				System.out.println("A) Add Product to the cart");
				System.out.println("B) Show produts list");
				System.out.println("C) Show shopping list");
				System.out.println("D) Proceed with payment");
				System.out.println("E) Dismiss shopping cart\n");

				option = sc.nextLine();
				switch(option){
				case "A":

					do {
						System.out.println("\nSelect a product: ");
						int index = sc.nextInt();

						if (0 < index && index < products.length()+1){
							System.out.println("\nHow many items would you like to add?");							
							shoppingCart.addProduct(products.pullProduct(index-1, sc.nextInt()));
							loopLv2 = false;
						} else {
							throw new OutOfRangeException();
						}

						sc.nextLine();
					} while(loopLv2);

				break;
				case "B":
					System.out.println(products.showList());
				break;
				case "C":
					System.out.println(shoppingCart.showList());
				break;
				case "D":
					System.out.println("\nProduct List:\n"+products.showList());
					System.out.println("Shopping List:\n"+shoppingCart.showList());
					
					for (int i=0; i<shoppingCart.length(); i++){
						shoppingCart.getProduct(i).resetStockCart();
					}
					
					String info = shoppingCart.generateBill(store, clients.getClient(email));
					System.out.println(info);
					Exit = true;
				break;
				case "E":
					for (int i=0; i<shoppingCart.length(); i++){
						shoppingCart.getProduct(i).mixStockWithStockCart();
					}
					
					System.out.println("\nProduct List:\n"+products.showList());
					System.out.println("Shopping List:\n"+shoppingCart.showList());
					
					Exit = true;
				break;
				default:
					throw new OutOfRangeException();
				}
			
			} catch(InputMismatchException e2){
				System.err.println("Ups, wrong option, try again :) " +e2); sc.nextLine();
			} catch(OutOfRangeException e1){
				System.err.println("Ups, something has ocurred, you went too far or too low. Try again "+e1);
			} catch(Exception e){
				System.err.println(e.getMessage());
			}

		} while(!Exit);
	}
}
