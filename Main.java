import controller.*;
import view.*;

public class Main {
    public static void main(String[] args){
        Menu view = new Menu();
        view.addControllers(new Clients(), new Products(), new Providers());
        view.displayMenu();
    }
}
