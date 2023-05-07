public class ShoppingCart{
	private Product[] productArray = new Product[10];
   private int nProduct = 0;

	public boolean isEmpty(){
		return nProduct == 0;
	}

   public Product getProduct(int i){
      return productArray[i];
   }

	// if returns true, then substracts one to the stock from the actual list 
    public boolean addProduct(Product reference){
		if (nProduct < productArray.length){
         productArray[nProduct] = reference;
         nProduct++;
         return true;
		}
		return false;
    }

	 // if returns true, then adds one to the actual stock
    public boolean removeProduct(long code){
		int index = -1;

        for (int i=0; i<nProduct; i++) {
            if (productArray[i].getCode() == code){
                index = i;
                break;
            } 
        }

        if (index != -1) {
            for(int j = index; j<nProduct-1; j++){
                productArray[j] = productArray[j+1];
            }
            
            productArray[nProduct-1] = null;
            nProduct--;
            return true;
        }

        return false;
    }

	public String toString(){
		if (nProduct == 0) {
         return null;
     }

      String all = "";

      for (int i=0; i<nProduct; i++){
         all += "\n"+productArray[i].toString()+"\n";
      }
      
      return all;
	}

	public int length(){ 
      return nProduct; 
   }
}