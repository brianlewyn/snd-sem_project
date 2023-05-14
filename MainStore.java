import controller.*;
import view.*;

public class MainStore {
    public static void main(String[] args){
        StoreMenu view = new StoreMenu();
        view.addControllers(new Clients(10), new Products(10), new Providers(10));
        view.displayMenu();
    }
}
