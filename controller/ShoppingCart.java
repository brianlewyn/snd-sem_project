package controller;

import java.util.Arrays;

import model.*;

public class ShoppingCart{
    private static final float IVA = 0.16F;
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

    public String generateBill(Store s, Client c){
        Bill bill = new Bill(s, c);
        String info = bill.toStringHeader()+"\n";

        int[] pieces = new int[nProduct];
		String[] names = new String[nProduct]; 
		long[] codes = new long[nProduct];
		float[] prices = new float[nProduct];
		float[] discounts = new float[nProduct];
		float[] totals = new float[nProduct];

        for (int i=0; i<nProduct; i++) {
            Product product = productArray[i];

            pieces[i] = product.getNumStockCart();
            names[i] = product.getName();
            codes[i] = product.getCode();
            prices[i] = product.getPrice();
            discounts[i] = product.getDiscount();

            if (product.getDiscount() != 0) {
                float price = product.getPrice() * product.getNumStockCart();
                price -= price * product.getDiscount(); // discount= 2.00
                totals[i] = price;
            } else {
                totals[i] =  product.getPrice() * product.getNumStockCart();
            }
        }

        // String.for
		info += "\nCantidad"+Arrays.toString(pieces);
		info += "\nProducto"+Arrays.toString(names);
		info += "\nCodigo"+Arrays.toString(codes);
		info += "\nPrecioUni"+Arrays.toString(prices);
		info += "\nDescuentoUni"+Arrays.toString(discounts);

		float subTotal = calculateSubTotal(prices, pieces);
		info += "\n\nSubTotal: $"+subTotal;
		
		float iva = subTotal*IVA;
		info += "\nIVA: $"+iva;
		info += "\nTotal $"+(subTotal+iva);


        info += "\n\n"+bill.toStringFooter();
        return info;
    }

	public int length(){ 
        return nProduct; 
    }
     
    private float calculateSubTotal(float[] prices, int[] pieces){
		float total = 0;
		for (int i=0; i<prices.length; i++){
			total += prices[i]*pieces[i];
		}
		return total;
	}
}