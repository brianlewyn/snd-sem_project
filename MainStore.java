import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import controller.*;
import view.*;
import model.*;

public class MainStore {
    public static void main(String[] args) {
        StoreMenu view = new StoreMenu();

        Client[] clients = loadData(new Client[10]);
        Product[] products = loadData(new Product[10]);
        Provider[] providers = loadData(new Provider[10]);

        view.addControllers(new Clients(clients), new Products(products), new Providers(providers));
        view.displayMenu();

        saveData(clients, products, providers);
    }

    public static Client[] loadData(Client[] clients) {
        try {
            FileInputStream fisClients = new FileInputStream("./data/clients.obj");
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
            FileInputStream fisProducts = new FileInputStream("./data/products.obj");
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

    public static Provider[] loadData(Provider[] providers) {
        try {
            FileInputStream fisProviders = new FileInputStream("./data/providers.obj");
            ObjectInputStream oisProviders = new ObjectInputStream(fisProviders);
            providers = (Provider[]) oisProviders.readObject();
            oisProviders.close();
        } catch (FileNotFoundException fe) {
            System.err.println("Hold on, something has ocurred: " + fe);
        } catch (IOException e) {
            System.err.println("Hold on, something has ocurred: " + e);
        } catch (ClassNotFoundException e1) {
            System.err.println("Hold on, something has ocurred: " + e1);
        }
        return providers;
    }

    public static void saveData(Client[] clients, Product[] products, Provider[] providers) {
        try {
            FileOutputStream fosClients = new FileOutputStream("./data/clients.obj");
            FileOutputStream fosProducts = new FileOutputStream("./data/products.obj");
            FileOutputStream fosProviders = new FileOutputStream("./data/providers.obj");

            ObjectOutputStream oosClients = new ObjectOutputStream(fosClients);
            ObjectOutputStream oosProducts = new ObjectOutputStream(fosProducts);
            ObjectOutputStream oosProviders = new ObjectOutputStream(fosProviders);

            oosClients.writeObject(clients);
            oosProducts.writeObject(products);
            oosProviders.writeObject(providers);

            oosClients.close();
            oosProducts.close();
            oosProviders.close();
        } catch (IOException e) {
            System.err.println("Hold on, something has ocurred: " + e);
        }
    }
}
