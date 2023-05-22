package controller;

import java.time.LocalDate;
import java.io.Serializable;
import model.*;

public class Products implements ArrayController, Serializable {
    private Product[] productArray;
    private int nProduct;

    public Products() {
        productArray = new Product[10];
    }

    public Products(Product[] productArray) {
        this.productArray = productArray;
        for (int i = 0; i < productArray.length; i++) {
            if (productArray[i] != null) {
                nProduct++;
            }
        }
    }

    public Products(int size) {
        productArray = new Product[size];
    }

    // Product is added
    public boolean addElectronicProduct(String n, int st, long c, float p, float di, String de, LocalDate da,
            Provider pr, long se) {
        if (nProduct < productArray.length) {
            productArray[nProduct] = new ElectronicProduct(n, st, c, p, di, de, da, pr, se);
            nProduct++;
            return true;
        }
        return false;
    }

    public boolean addNonElectronicProduct(String n, int st, long c, float p, float di, String de, LocalDate da,
            Provider pr) {
        if (nProduct < productArray.length) {
            productArray[nProduct] = new NonElectronicProduct(n, st, c, p, di, de, da, pr);
            nProduct++;
            return true;
        }
        return false;
    }

    // A specific product is modified
    public Product modify(long code) {
        for (int i = 0; i < nProduct; i++) {
            if (productArray[i].getCode() == code) {
                return productArray[i];
            }
        }
        return null;
    }

    public ElectronicProduct modifyElectronic(long code) {
        return (ElectronicProduct) modify(code);
    }

    // A specific product is remove
    public boolean removeProduct(long code) {
        int index = -1;

        for (int i = 0; i < nProduct; i++) {
            if (productArray[i].getCode() == code) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int j = index; j < nProduct - 1; j++) {
                productArray[j] = productArray[j + 1];
            }

            productArray[nProduct - 1] = null;
            nProduct--;
            return true;
        }

        return false;
    }

    public Product pullProduct(int index, int nItem) throws Exception {
        if (!(0 <= index && index < nProduct)) {
            return null;
        }

        Product product = productArray[index];
        if (!(0 < nItem && nItem <= product.getNumStock())) {
            throw new Exception("Sorry, you cannot exceed our items stock. Please choose a fitting number.");
        }

        product.addFromStockToStockCart(nItem);
        return product;
    }

    public String consult(long code) {
        for (int i = 0; i < nProduct; i++) {
            if (productArray[i].getCode() == code) {
                return productArray[i].toString();
            }
        }
        return null;
    }

    public String consultAll() {
        if (nProduct == 0) {
            return null;
        }

        String list = "";
        for (int i = 0; i < nProduct; i++) {
            list += "\n" + productArray[i].toString() + "\n";
        }

        return list;
    }

    public String sortByAlphabet() {
        Product product;

        for (int i = 0; i < nProduct; i++) {
            for (int j = i + 1; j < nProduct; j++) {
                if (productArray[i].getName().compareTo(productArray[j].getName()) > 0) {
                    product = productArray[i];
                    productArray[i] = productArray[j];
                    productArray[j] = product;
                }
            }
        }

        return consultAll();
    }

    public String sortByDate() {
        Product product;

        for (int i = 0; i < nProduct; i++) {
            for (int j = i + 1; j < nProduct; j++) {
                if (productArray[i].getDate().isBefore(productArray[j].getDate())) {
                    product = productArray[i];
                    productArray[i] = productArray[j];
                    productArray[j] = product;
                }
            }
        }

        return consultAll();
    }

    public int length() {
        return nProduct;
    }

    public boolean isFull() {
        return nProduct == productArray.length;
    }

    public boolean isMinimum() {
        for (int i = 0; i < nProduct; i++) {
            if (productArray[i].getNumStock() <= 5) {
                return true;
            }
        }
        return false;
    }

    public String listProductMinimum() {
        String list = "";

        for (int i = 0; i < nProduct; i++) {
            if (productArray[i].getNumStock() <= 5) {
                productArray[i].setNumStock(10);
                list += "Product: " + productArray[i].getName() + "\n";
            }
        }

        return list;
    }

    public boolean isElectronic(long code) {
        Product product = modify(code);

        if (product != null) {
            if (product instanceof ElectronicProduct) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return nProduct == 0;
    }

    public String showList() {
        String list = "";

        Product product;
        for (int i = 0; i < nProduct; i++) {
            product = productArray[i];
            list += (i + 1) + ") " + product.getName() + "  [" + product.getNumStock() + "]\n";
        }

        return list;
    }

    public String type() {
        return "product";
    }

    public boolean contains(long code) {
        for (int i = 0; i < nProduct; i++) {
            if (productArray[i].getCode() == code) {
                return true;
            }
        }
        return false;
    }
}