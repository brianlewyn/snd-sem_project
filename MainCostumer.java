
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

// Motorola[5]: 25,000
// Mabe[2]: 10,000
// Papitas[3]: 78
// SubTotal: 35,078
// Total: $40,690.48

/*
 * BILL
Date: 2023-05-14

STORE:
Name: UV JDK
Address: Av.Xalpa

CLIENT
Name: Yael
Email: yael@gmail.com
Address: Av. Xalapa
RFC: A12DF345H7

Cantidad[5, 2, 3]
Producto[Motorola, Mabe, Papitas]
Codigo[55555, 50596, 33333]
PrecioUni[5000.0, 5000.0, 26.0]
DescuentoUni[0.0, 0.0, 0.0]

SubTotal: $35078.0
IVA: $5612.48
Total $40690.48

Thank you for your trust, have a good one! <3
 */