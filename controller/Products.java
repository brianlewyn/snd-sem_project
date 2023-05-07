public class Products implements NonModifier{
    private Product[] productArray = new Product[10];
    private int nProduct;

    //Product is added
    public boolean add(Product p){
        if(nProduct < productArray.length){
            productArray[nProduct] = p; 
            nProduct++;
            return true;
        }
        return false;
    }

    //A specific product is modified
    public Product modify(long code){
        for (int i=0; i<nProduct; i++) {
            if (productArray[i].getCode() == code){
                return productArray[i];
            }
        }
        return null;
    }

    //A specific product is remove
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

    public String consult(long code){
        for (int i=0; i<nProduct; i++) {
            if (productArray[i].getCode() == code){
                return productArray[i].toString();
            }
        }
        return null;
    }

    public String consultAll(){
        if (nProduct == 0) {
            return null;
        }

        String all = "";
        
        for (int i=0; i<nProduct; i++){
            all += "\n"+productArray[i].toString()+"\n";
        }
        
        return all;
    }

    public Object[] sortByAlphabet(){
        Product[] clone = productArray.clone(); 
        Product product;

        for (int i = 0; i < nProduct; i++) {
            for (int j = i + 1; j < nProduct; j++) {
                if (clone[i].getName().compareTo(clone[j].getName()) > 0) {
                    product = clone[i];
                    clone[i] = clone[j];
                    clone[j] = product;
                }
            }
		}
        
        return clone;
    }

    public Object[] sortByDate(){
        Product[] clone = productArray.clone();
        Product product;

        for (int i = 0; i < nProduct; i++) {
            for (int j = i + 1; j < nProduct; j++) {
                if (clone[i].getDate().isBefore(clone[j].getDate())) {
                    product = clone[i];
                    clone[i] = clone[j];
                    clone[j] = product;
                }
            }
		}
        
        return clone;
    }

    public int length(){
        return nProduct;
    }
}