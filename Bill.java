import java.time.LocalDate;

public class Bill{
	private LocalDate date;
	private Stock stock;

   public Bill(Stock stock, LocalDate date){
      this.stock = stock;
      this.date = date;
   }

	public String createBill(int indexClient){
		Client client = stock.getClientsReference().modify(indexClient);
		if (client == null) {
			return "The index doesn't exist";
		}
		return client.toStringBill(date);
	}

	public String soldProductInfo(int indexProduct){
      Product product = stock.modify(indexProduct);
      if(!product.isSold()){
         return "The index doesn't exist";
      }
		return product.toStringProduct();
   }
}

