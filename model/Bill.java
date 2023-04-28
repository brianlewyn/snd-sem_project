import java.time.LocalDate;

public class Bill{
	private static final float IVA = 0.16F;
	private Client client; // reference
	private Store store; // reference
	private LocalDate date; 

   public Bill(Client c, Store s, LocalDate d){
      client = c;
      store = s;
      date = d;
   }

	private String infoStore(){
		return "STORE:\nDate: " + date + "\nName: " + store.getName() + 
		"\nAddress: " + store.getAddress();
	}

	private String infoClient(){
		return "CLIENT\nName: " + client.getName() + "\nEmail: " + client.getEmail() + 
		"\nAddress: " + client.getAddress() + "\nRFC: " + client.getRfc();
	}

	private float calculateSubTotal(float[] prices){
		float total = 0;
		for (int i=0; i<prices.length; i++){
			total += prices[i];
		}
		return total;
	}

	public String createBill(){
		String t = "Bill";
		ShoppingCart cart = client.getShoppingCart();
		
		if (cart.isEmpty()) {
			t = "Cannot create a bill over a null list";
		
		}else{
			int lenght = cart.getNumProduct();
			
			int[] pieces = new int[lenght];
			String[] names = new String[lenght]; 
			long[] codes = new long[lenght];
			float[] prices = new float[lenght];
			float[] discounts = new float[lenght];
			float[] totals = new float[lenght];

			for (int i=0; i<lenght; i++) {
				Product product = cart.getProduct(i);

				pieces[i] = product.getNumStock();
				names[i] = product.getName();
				codes[i] = product.getCode();
				prices[i] = product.getPrice();
				discounts[i] = product.getDiscount();

				if (product.getDiscount() != 0) {
					float price = product.getPrice() * product.getNumStock();
					price -= price * product.getDiscount(); // discount= 2.00
					totals[i] = price;
				} else {
					totals[i] =  product.getPrice() * product.getNumStock();
				}
			}

			t += "\n" + infoStore();
			t += "\n" + infoClient();
			t += "\nCantidad"+pieces;
			t += "\nProducto"+names;
			t += "\nCodigo"+codes;
			t += "\nPrecioUni"+prices;
			t += "\nDescuentoUni"+discounts;

			float subTotal = calculateSubTotal(prices);
			t += "\nSubTotal: $"+subTotal;
			
			float iva = subTotal*IVA;
			t += "\nIVA: $"+iva;
			t += "\nTotal $"+subTotal+iva;

			t+="\n\n\t\t\t¡Gracias por su compra! tenga buen día <3";
		}

		cart.flush();
		return t;
	}
}

// Factura
// 
// TIENDA:
// Fecha: xx/xx/xx
// NAME: AbarrotesJDK 
// Direccion: c.random Av.randow
// 
// CLIENTE: 
// Name: Yael Salazar 
// Email: random@gmail.com
// Direccion: random. av. randow
// RFC: 12DFGH6789JKL
// 
// Cantidad [2, 1, 5, 1]
// Producto [Papitas, Refri, Pez, Helado]
// Codigo [11234, 4567, 4567, 5678]
// PrecioUni [$20.00, $10000.00, $20.00, $50.00]
// DescuentoUni [-18%, -10%, -15%, -5%]
// 
// SubTotal: $9123.00
// IVA: $567.00
// Total: $9800.00
// 
// ¡Gracias por su compra! tenga buen día <3 