
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.*;
import controller.*;
import view.*;

public class MainCostumer {
    public static void main(String[] args) {
        CostumersMenu view = new CostumersMenu();

        Client[] clients = loadData(new Client[10]);
        Product[] products = loadData(new Product[10]);

        view.addControllers(new Clients(clients), new Products(products), new Store("UV JDK", "Av.Xalpa"));
        view.displayCustomersMenu();

        saveData(clients, products);
    }

    public static Client[] loadData(Client[] clients) {
        try {
            FileInputStream fisClients = new FileInputStream("./Files/clients.obj");
            ObjectInputStream oisClients = new ObjectInputStream(fisClients);
            clients = (Client[]) oisClients.readObject();
            oisClients.close();
        } catch (FileNotFoundException fe) {
            System.err.println("Hold on, something has ocurred: " + fe);
        } catch (IOException e) {
            System.err.println("Hold on, something has ocurred: " + e);
        } catch (ClassNotFoundException e1) {
            System.err.println("Hold on, something has ocurred: " + e1);
        }
        return clients;
    }

    public static Product[] loadData(Product[] products) {
        try {
            FileInputStream fisProducts = new FileInputStream("./Files/products.obj");
            ObjectInputStream oisProducts = new ObjectInputStream(fisProducts);
            products = (Product[]) oisProducts.readObject();
            oisProducts.close();
        } catch (FileNotFoundException fe) {
            System.err.println("Hold on, something has ocurred: " + fe);
        } catch (IOException e) {
            System.err.println("Hold on, something has ocurred: " + e);
        } catch (ClassNotFoundException e1) {
            System.err.println("Hold on, something has ocurred: " + e1);
        }
        return products;
    }

    public static void saveData(Client[] clients, Product[] products) {
        try {
            FileOutputStream fosClients = new FileOutputStream("./Files/clients.obj");
            FileOutputStream fosProducts = new FileOutputStream("./Files/products.obj");

            ObjectOutputStream oosClients = new ObjectOutputStream(fosClients);
            ObjectOutputStream oosProducts = new ObjectOutputStream(fosProducts);

            oosClients.writeObject(clients);
            oosProducts.writeObject(products);

            oosClients.close();
            oosProducts.close();
        } catch (IOException e) {
            System.err.println("Hold on, something has ocurred: " + e);
        }
    }
}

// Motorola[5]: 25,000
// Mabe[2]: 10,000
// Papitas[3]: 78
// SubTotal: 35,078
// Total: $40,690.48

/*
 * BILL
 * Date: 2023-05-14
 * 
 * STORE:
 * Name: UV JDK
 * Address: Av.Xalpa
 * 
 * CLIENT
 * Name: Yael
 * Email: yael@gmail.com
 * Address: Av. Xalapa
 * RFC: A12DF345H7
 * 
 * Cantidad[5, 2, 3]
 * Producto[Motorola, Mabe, Papitas]
 * Codigo[55555, 50596, 33333]
 * PrecioUni[5000.0, 5000.0, 26.0]
 * DescuentoUni[0.0, 0.0, 0.0]
 * 
 * SubTotal: $35078.0
 * IVA: $5612.48
 * Total $40690.48
 * 
 * Thank you for your trust, have a good one! <3
 */