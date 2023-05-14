package controller;

import model.*;

public class ShoppingCart{
	private Product[] productArray;
    private int nProduct = 0;

    public ShoppingCart(){
        productArray = new Product[10];
    }

    public ShoppingCart(int size){
        productArray = new Product[size];
    }

	public boolean isEmpty(){
		return nProduct == 0;
	}

    public Product getProduct(int i){
        return productArray[i];
    }

	// if returns true, then substracts one to the stock from the actual list 
    public boolean addProduct(Product reference){
        for (int i=0; i<nProduct; i++){
            if (productArray[i] == reference){
                return true;
            }
        }
		
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

        String list = "";
        for (int i=0; i<nProduct; i++){
            list += "\n"+productArray[i].toString()+"\n";
        }
        
        return list;
	}

    public String showList(){
        String list ="";
        
        Product product;
        for (int i=0; i<nProduct; i++){
            product = productArray[i];
            list += (i+1)+") "+product.getName()+ "  ["+product.getNumStockCart()+"]\n";
        }
        
        return list;
    }

	public int length(){ 
        return nProduct; 
    }
}