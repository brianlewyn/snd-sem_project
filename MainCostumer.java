
import java.time.LocalDate;

import model.*;
import controller.*;
import view.*;

public class MainCostumer {
    public static void main(String[] args){
        Clients clients = new Clients(10);
        Products products = new Products(10);
        Providers providers =  new Providers(10);
        
        providers.add("Dylan", "dylan@gmail.com", "22813468");
        Provider Dylan = providers.modify("Dylan");
        LocalDate date = LocalDate.now();
        
        products.addElectronicProduct("Motorola", 10, 55555, 5000, 0, "", date, Dylan, 123456);
        products.addElectronicProduct("Samsung", 10, 55555, 5000, 0, "", date, Dylan, 123456);
        products.addElectronicProduct("Motorola", 10, 55555, 5000, 0, "", date, Dylan, 123456);
        products.addElectronicProduct("LG", 10, 334555, 5000, 0, "", date, Dylan, 123456);
        products.addElectronicProduct("Mabe", 10, 50596, 5000, 0, "", date, Dylan, 123456);
        products.addElectronicProduct("Apple", 8, 4444, 10000, 0, "", date, Dylan, 123456);
        products.addNonElectronicProduct("Papitas", 6, 33333, 26, 0, "", date, Dylan);

        clients.add("Yael", "yael@gmail.com", "Av. Xalapa", "A12DF345H7");

        CostumersMenu view = new CostumersMenu();
        view.addControllers(clients, products, new Store("UV JDK", "Av.Xalpa"));
        view.displayCustomersMenu();
    }
}
