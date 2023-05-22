package model;

import java.time.LocalDate;
import java.io.Serializable;

public abstract class Product implements Serializable {
   protected String name;
   protected int stock = 0;
   protected int stockCart = 0;
   protected long code;
   protected float price;
   protected float discount;
   protected String description;
   protected LocalDate date;
   protected Provider provider; // reference

   public Product(String n, int st, long c, float p, float di, String de, LocalDate da, Provider pr) {
      name = n;
      stock = st;
      code = c;
      price = p;
      discount = di;
      description = de;
      date = da;
      provider = pr;
   }

   public String getName() {
      return name;
   }

   public int getNumStock() {
      return stock;
   }

   public int getNumStockCart() {
      return stockCart;
   }

   public void addStockCart(int num) {
      stockCart += num;
   }

   public void removeStockCart(int num) {
      stockCart += num;
   }

   public long getCode() {
      return code;
   }

   public float getPrice() {
      return price;
   }

   public float getDiscount() {
      return discount;
   }

   public String getDescription() {
      return description;
   }

   public LocalDate getDate() {
      return date;
   }

   public Provider getProvider() {
      return provider;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setNumStock(int num) {
      stock = num;
   }

   public void setCode(long code) {
      this.code = code;
   }

   public void setPrice(float price) {
      this.price = price;
   }

   public void setDiscount(float discount) {
      this.discount = discount;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setDate(LocalDate date) {
      this.date = date;
   }

   public void setProvider(Provider reference) {
      provider = reference;
   }

   public void addFromStockToStockCart(int nItem) {
      stockCart += nItem;
      stock -= nItem;
   }

   public void mixStockWithStockCart() {
      stock += stockCart;
      stockCart = 0;
   }

   public void resetStockCart() {
      stockCart = 0;
   }

   public String toString() {
      return "PRODUCT:" +
            "\nName: " + name +
            "\nStock: " + stock +
            "\nCode: " + code +
            "\nPrice: $" + price +
            "\nDiscount: " + discount +
            "\nDescription: " + description +
            "\nDate: " + date +
            "\nProvider: " + provider.name;
   }

   // PRODUCT:
   // Name: Dove
   // Stock: 5
   // Code: 1234
   // Price: 35 // $35
   // Discount: 0.135 // = 13.5%
   // Description: description...
   // Date: 07/04/2023
}
