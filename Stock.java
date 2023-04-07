import java.time.LocalDate;

public class Stock implements Modifier, ProductSet{
    private Product[] productArray = new Product[10];
    private int nProduct;
    private ProviderSet providersReference;
    private ClientSet clientsReference;

    /**
     * Stock return a intance
     * @param p  a ProviderSet
     * @param c  a ClientSet
     */
    public Stock(ProviderSet p, ClientSet c){
        providersReference = p;
        clientsReference = c;
    }

    //Getters
    public ClientSet getClientsReference(){
        return clientsReference;
    }

    public ProviderSet getProvidersReference(){
        return providersReference;
    }

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
    public Product modify(int i){
        if (0<=i && i < nProduct){
            return productArray[i];
        }
        return null;
    }

    //A specific product is remove
    public boolean remove(int i){
        if(i<0 || nProduct<=i){
            return false;
        }

        for(int j = i; j<nProduct-1; j++){
            productArray[j] = productArray[j+1];
        }

        productArray[nProduct-1] = null;
        nProduct--;
        return true;
    }

    public String consult(int i){
        if (0<=i && i<nProduct){
            return productArray[i].toString();
        }
        return null;
    }

    public String consultAll(){
        String temp = "";

        for (int i=0; i<nProduct; i++){
            temp += "\n"+productArray[i].toString()+"\n";
        }

        if (temp != "") {
            return temp;
        }
        
        return null;
    }

    public Object[] sortByAlphabet(){
        Product temp;
        Product[] clone = productArray.clone(); 

        for (int i = 0; i < nProduct; i++) {
            for (int j = i + 1; j < nProduct; j++) {
                if (clone[i].getName().compareTo(clone[j].getName()) > 0) {
                    temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;
                }
            }
		}
        return clone;
    }

    public Object[] sortByDate(){
        Product temp;
        Product[] clone = productArray.clone();

        for (int i = 0; i < nProduct; i++) {
            for (int j = i + 1; j < nProduct; j++) {
                if (clone[i].getDate().isBefore(clone[j].getDate())) {
                    temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;
                }
            }
		}
        return clone;
    }

    public int length(){
        return nProduct;
    }

    public String relateClientToProduct(int ic, int ip, LocalDate date){
        return "";
    }

    public String relateProviderToProduct(int ic, int ip, LocalDate date){
        return "";
    }    
}