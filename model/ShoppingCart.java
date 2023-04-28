public class ShoppingCart{
   private int nProduct = 0;
   private Product[] productArray = new Product[10];

   public ShoppingCart(){}

	public boolean isEmpty(){
		return nProduct == 0;
	}

   public int getNumProduct(){ 
      return nProduct; 
   }

   public Product getProduct(int i){
      return productArray[i];
   }

	// if returns true, then substracts one to the stock from the actual list 
    public boolean addProduct(Product reference){
		if (nProduct < productArray.length){
			
			for (int i=0; i<nProduct; i++){
				if (productArray[i] == reference){
					reference.addStock();
					return true;
				}
			}

			if (reference instanceof NonElectronicProduct) {
				NonElectronicProduct temp = (NonElectronicProduct)reference;
				productArray[nProduct] = temp.getCopy();	
			} else{
				ElectronicProduct temp = (ElectronicProduct)reference;
				productArray[nProduct] = temp.getCopy();
			}
			
			nProduct++;
			return true;
		}
		
		return false;
    }

	 // if returns true, then adds one to the actual stock
    public boolean removeProduct(long code){
		boolean flag = false;
		
		for (int i=0; i<nProduct-1; i++){
			if (productArray[i].getCode() == code){
				if (productArray[i].getNumStock() > 1){
					productArray[i].removeStock();
				} else {
					productArray[i] = productArray[i+1];
				}
				flag = true;
			}
		}

		if (flag) {
			productArray[nProduct] = null;
			nProduct--;
			return true;
		}
		
		return false;
    }

    public boolean purchaseList(boolean b){
		if (b) {
			for (int i=0; i<nProduct; i++) {
				productArray[i].removeStock();
			}

			return true;
		}

		return true; 
    }

	public String toString(){
		String str = "Product List:";

		if (nProduct == 0) {
			return str +" null";
		}

		for (int i=0; i<nProduct; i++){
			str += "\n"+productArray[i].getName()+
			" ["+ productArray[i].getNumStock() +"]";
		}
		
		return str;
	}
}