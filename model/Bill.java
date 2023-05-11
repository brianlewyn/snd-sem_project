package model;

import java.time.LocalDate;

public class Bill{
	private static final float IVA = 0.16F;
	private Client client; // reference
	private Store store; // reference
	private LocalDate date; 

   public Bill(Client c, Store s, LocalDate da){
      client = c;
      store = s;
      date = da;
   }

	public String toStringHeader() {
		String bill = "";
		bill = "BILL\nDate: "+date.toString()+"\n\n";
		bill += store.toString();
		bill += client.toString();
		return bill;
	}

	public String toStringFooter() {
		return "Thank you for your trust, have a good one! <3";
	}
}

// !HEADER
// BILL
// Date: xx/xx/xx
// 
// Store:
// NAME: AbarrotesJDK 
// Address: c.random Av.randow
// 
// CLIENT: 
// Name: Yael Salazar 
// Email: random@gmail.com
// Address: random. av. randow
// RFC: 12DFGH6789JKL
// 
// !BODY
// Cantidad [2, 1, 5, 1]
// Product [Papitas, Refri, Pez, Helado]
// Code [11234, 4567, 4567, 5678]
// PrecioUni [$20.00, $10000.00, $20.00, $50.00]
// DescuentoUni [-18%, -10%, -15%, -5%]
// 
// SubTotal: $9123.00
// IVA: $567.00
// Total: $9800.00
// 
// !FOOTER
// ¡Gracias por su compra! tenga buen día <3 