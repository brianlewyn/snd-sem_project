package view;

import controller.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StoreMenu {
    // controller
    private Clients clients;
    private Products products;
    private Providers providers;

    // others
    private LocalDate date = LocalDate.now();
    private Scanner sc = new Scanner(System.in);

    public StoreMenu() {
    }

    public void addControllers(Clients clients, Products products, Providers providers) {
        this.clients = clients;
        this.products = products;
        this.providers = providers;
    }

    public void displayMenu() {
        boolean Exit = false;

        do {
            isMinimumStock();
            System.out.println("\nSelect an option:" +
                    "\n1) Clients \n2) Providers \n3) Products \n4) Exit\n");

            try {
                switch (readOption()) {
                    case 1:
                        displayClientMenu();
                        break;
                    case 2:
                        displayProviderMenu();
                        break;
                    case 3:
                        displayProductMenu();
                        break;
                    case 4:
                        Exit = true;
                        break;
                    default:
                        throw new OutOfRangeException();
                }

            } catch (InputMismatchException e2) {
                System.out.println("Ups, something has ocurred " + e2);
                sc.nextLine();
            } catch (OutOfRangeException e1) {
                System.err.println("Ups, something has ocurred " + e1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (!Exit);
        System.out.println("Come back soon :3");
    }

    private void isMinimumStock() {
        if (products.isMinimum()) {
            System.out.println("Order done. Stock restored\n" + products.listProductMinimum());
        }
    }

    private int readOption() throws Exception {
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private void isEmpty(ArrayController controller, int start, int option, int end) throws Exception {
        if (start < option && option < end && controller.isEmpty()) {
            throw new Exception("The " + controller.type() + "'s list is empty");
        }
    }

    private void isFull(ArrayController controller) throws Exception {
        if (controller.isFull()) {
            throw new Exception("The " + controller.type() + "'s list is full");
        }
    }

    // Clients Menu

    public void displayClientMenu() {
        boolean Exit = false;
        int option;

        do {
            System.out.println("\nWhat would you like to do?" +
                    "\n1) Add client" +
                    "\n2) Remove client" +
                    "\n3) Consult every client information" +
                    "\n4) Consult a specific client information" +
                    "\n5) Modify a specific client information" +
                    "\n6) Sort Clients by Alphabet" +
                    "\n7) Exit\n");

            try {
                option = readOption();
                isEmpty(clients, 1, option, 7);

                switch (option) {
                    case 1:
                        // addClient();
                        ClientsGraphic g = new ClientsGraphic(clients);
                        break;
                    case 2:
                        remove(clients);
                        break;
                    case 3:
                        consultAll(clients);
                        break;
                    case 4:
                        consultType(clients);
                        break;
                    case 5:
                        modifyClient();
                        break;
                    case 6:
                        sortByAlphabet(clients);
                        break;
                    case 7:
                        Exit = true;
                        break;
                    default:
                        throw new OutOfRangeException();
                }

            } catch (InputMismatchException e2) {
                System.out.println("Ups, something has ocurred " + e2);
                sc.nextLine();
            } catch (OutOfRangeException e1) {
                System.out.println("Ups, something has ocurred " + e1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (!Exit);
    }

    private String read(String message) throws Exception {
        System.out.println(message);
        return sc.nextLine();
    }

    private int readInt(String message) throws Exception {
        System.out.println(message);
        return sc.nextInt();
    }

    private long readLong(String message) throws Exception {
        System.out.println(message);
        return sc.nextLong();
    }

    private float readFloat(String message) throws Exception {
        System.out.println(message);
        return sc.nextFloat();
    }

    private void addClient() throws Exception {
        isFull(clients);
        String name = read("\nSet the name of the client:");
        String email = read("\nSet the email of the client:");
        String address = read("\nSet the address of the client:");
        String rfc = read("\nSet the RFC of the client:");
        verifyAddMethod(clients.add(name, email, address, rfc), clients.type());
    }

    private void verifyAddMethod(boolean answer, String type) throws Exception {
        if (!answer) {
            throw new Exception("Couldn't add the " + type + ", try again");
        }
        System.out.println("\nThe " + type + " has been added");
    }

    private void verifyRemoveMethod(boolean answer, String type) throws Exception {
        if (!answer) {
            throw new Exception("Couldn't remove the " + type + ", try again");
        }
        System.out.println("\nThe " + type + " has been removed");
    }

    private void remove(SubjectController controller) throws Exception {
        System.out.println("Write down the name of the " + controller.type() + " that you would like to remove: ");
        verifyRemoveMethod(controller.remove(sc.nextLine()), controller.type());
    }

    private void consultAll(ArrayController controller) {
        System.out.print(controller.consultAll());
    }

    private void consultType(SubjectController controller) throws Exception {
        System.out.println("\nWrite down the name of the " + controller.type() + " that you would like to consult: ");
        String name = sc.nextLine();

        String info = controller.consult(name);
        if (info == null) {
            throw new Exception("\nThe " + controller.type() + " doesn't exist");
        }
        System.out.println(info);
    }

    private void consultProduct() throws Exception {
        System.out.println("\nWrite down the code of the " + products.type() + " that you would like to consult: ");
        long code = sc.nextLong();

        String info = products.consult(code);
        if (info == null) {
            throw new Exception("\nThe " + products.type() + " doesn't exist");
        }
        System.out.println(info);
    }

    private void sortByAlphabet(ArrayController controller) {
        System.out.println(controller.sortByAlphabet());
    }

    private void contains(SubjectController controller, String name) throws Exception {
        if (!controller.contains(name)) {
            throw new Exception("\nThe " + controller.type() + " doesn't exist");
        }
    }

    private void containsProduct(long code) throws Exception {
        if (!products.contains(code)) {
            throw new Exception("\nThe " + products.type() + " doesn't exist");
        }
    }

    private void modifyClient() {
        boolean Exit = false, nonOption = true;
        String name;

        do {

            do {
                try {
                    switch (read("\nDo you want to modify a client's information? write down yes or no: ")) {
                        case "yes", "Yes", "YES":
                            nonOption = false;
                            break;
                        case "no", "No", "NO":
                            return;
                        default:
                            System.out.println("Choose \"Yes\" or \"No\"");
                    }
                } catch (NoSuchElementException e1) {
                    System.out.println("An error has ocurred");
                } catch (IllegalStateException e2) {
                    System.out.println("An error has ocurred");
                } catch (Exception e) {
                    System.out.println("An error has ocurred");
                }

            } while (nonOption);

            try {
                System.out.println("\nWrite down the name of the client that you would like to modify: ");
                name = sc.nextLine();

                contains(clients, name);
                System.out.println("\nwhat would you like to modify?" +
                        "\n1) Name \n2) Email \n3) Address \n4) RFC \n5) Exit\n");

                switch (readOption()) {
                    case 1:
                        clients.modify(name).setName(read("\nWrite down the new name of the client:"));
                        System.out.println("\nName has been correctly updated");
                        break;
                    case 2:
                        clients.modify(name).setEmail(read("\nWrite down the new email of the client:"));
                        System.out.println("\nEmail has been correctly updated");
                        break;
                    case 3:
                        clients.modify(name).setAddress(read("\nWrite down the new Address of the client:"));
                        System.out.println("\nAddress has been correctly updated");
                        break;
                    case 4:
                        clients.modify(name).setRfc(read("\nWrite down the new RFC of the client:"));
                        System.out.println("\nRFC has been correctly updated");
                        break;
                    case 5:
                        Exit = true;
                        break;
                    default:
                        throw new OutOfRangeException();
                }

            } catch (InputMismatchException e2) {
                System.out.println("Ups, something has ocurred" + e2);
                sc.nextLine();
            } catch (OutOfRangeException e1) {
                System.out.println("Ups, something has ocurred" + e1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (!Exit);
    }

    // Providers Menu

    public void displayProviderMenu() {
        boolean Exit = false;
        int option;

        do {
            System.out.println("\nWhat would you like to do?" +
                    "\n1) Add provider" +
                    "\n2) Remove provider" +
                    "\n3) Consult every provider information" +
                    "\n4) Consult a specific provider information" +
                    "\n5) Modify a specific provider information" +
                    "\n6) Sort providers by Alphabet" +
                    "\n7) Exit\n");

            try {
                option = readOption();
                isEmpty(providers, 1, option, 7);

                switch (option) {
                    case 1:
                        // addProvider();
                        ProvidersGraphic g = new ProvidersGraphic(providers);
                        break;
                    case 2:
                        remove(providers);
                        break;
                    case 3:
                        consultAll(providers);
                        break;
                    case 4:
                        consultType(providers);
                        break;
                    case 5:
                        modifyProvider();
                        break;
                    case 6:
                        sortByAlphabet(providers);
                        break;
                    case 7:
                        Exit = true;
                        break;
                    default:
                        throw new OutOfRangeException();
                }

            } catch (InputMismatchException e2) {
                System.out.println("Ups, something has ocurred " + e2);
                sc.nextLine();
            } catch (OutOfRangeException e1) {
                System.out.println("Ups, something has ocurred " + e1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (!Exit);
    }

    private void addProvider() throws Exception {
        isFull(providers);
        String name = read("\nSet the name of the provider:");
        String email = read("\nSet the email of the provider:");
        String phone = read("\nSet the Phone of the provider:");
        verifyAddMethod(providers.add(name, email, phone), providers.type());
    }

    private void modifyProvider() {
        boolean Exit = false, nonOption = true;
        String name = "";

        do {
            do {
                try {
                    switch (read("\nDo you want to modify a provider's information? Write down Yes or No: ")) {
                        case "yes", "Yes", "YES":
                            nonOption = false;
                            break;
                        case "no", "No", "NO":
                            return;
                        default:
                            System.out.println("Choose \"Yes\" or \"No\"");
                    }
                } catch (NoSuchElementException e1) {
                    System.out.println("An error has ocurred");
                } catch (IllegalStateException e2) {
                    System.out.println("An error has ocurred");
                } catch (Exception e) {
                    System.out.println("An error has ocurred");
                }

            } while (nonOption);

            try {
                contains(providers, name);
                System.out.println("\nWhat would you like to modify?" +
                        "\n1) Name \n2) Email \n3) Phone \n4) Exit\n");

                switch (readOption()) {
                    case 1:
                        providers.modify(name).setName(read("\nWrite down the new name of the provider:"));
                        System.out.println("\nName has been correctly updated");
                        break;
                    case 2:
                        providers.modify(name).setEmail(read("\nWrite down the new email of the provider:"));
                        System.out.println("\nEmail has been correctly updated");
                        break;
                    case 3:
                        providers.modify(name).setPhone(read("\nWrite down the new Phone of the provider:"));
                        System.out.println("\nPhone has been correctly updated");
                        break;
                    case 4:
                        Exit = true;
                        break;
                    default:
                        throw new OutOfRangeException();
                }

            } catch (InputMismatchException e2) {
                System.out.println("Ups, something has ocurred \n" + e2);
                sc.nextLine();
            } catch (OutOfRangeException e1) {
                System.out.println("Ups, something has ocurred \n" + e1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (!Exit);
    }

    // Product Menu

    public void displayProductMenu() {
        boolean Exit = false;

        do {
            try {
                System.out.println("\nWhat would you like to do?" +
                        "\n1) Add Product" +
                        "\n2) Remove Product" +
                        "\n3) Consult every Product information" +
                        "\n4) Consult a specific Product information" +
                        "\n5) Modify a specific Product information" +
                        "\n6) Sort Products by Alphabet" +
                        "\n7) Exit\n");

                int option = readOption();
                isEmpty(products, 1, option, 7);

                switch (option) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        removeProduct();
                        break;
                    case 3:
                        consultAll(products);
                        break;
                    case 4:
                        consultProduct();
                        break;
                    case 5:
                        modifyProduct();
                        break;
                    case 6:
                        sortByAlphabet(products);
                        break;
                    case 7:
                        Exit = true;
                        break;
                    default:
                        throw new OutOfRangeException();
                }

            } catch (InputMismatchException e2) {
                System.out.println("Ups, something has ocurred " + e2);
                sc.nextLine();
            } catch (OutOfRangeException e1) {
                System.out.println("Ups, something has ocurred " + e1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (!Exit);
    }

    private void addProduct() throws Exception {
        if (providers.isEmpty()) {
            throw new Exception("\nCannot add product because the provider's list is empty");
        }

        isFull(products);
        boolean Exit = false;

        do {
            System.out.println("\nSelect an option:" +
                    "\n1) Electrnonic Product \n2) Non Electrnonic Product \n3) Exit\n");

            try {
                switch (readOption()) {
                    case 1:
                        // addElectronicProduct();
                        ElectronicProductGraphic g = new ElectronicProductGraphic(products, providers);
                        break;
                    case 2:
                        // addNonElectronicProduct();
                        NonElectronicProductGraphic h = new NonElectronicProductGraphic(products, providers);
                        break;
                    case 3:
                        Exit = true;
                        break;
                    default:
                        throw new OutOfRangeException();
                }

            } catch (InputMismatchException e2) {
                System.out.println("Ups, something has ocurred \n" + e2);
            } catch (OutOfRangeException e1) {
                System.out.println("Ups, something has ocurred \n" + e1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (!Exit);
    }

    private void addElectronicProduct() throws Exception {
        String name = read("\nSet the name of the product:");
        int stock = readInt("\nSet the number stock of the product:");
        long code = readLong("\nSet the number code of the product:");
        float price = readFloat("\nSet the price of the product:");
        float discount = readFloat("\nSet the discount of the product:");
        sc.nextLine();
        String description = read("\nSet the description of the product:");
        String provider = read("\nSet the provider of the product:");
        contains(providers, provider);

        long serial = readLong("\nSet the serial of the product:");

        verifyAddMethod(products.addElectronicProduct(name, stock, code, price, discount,
                description, date, providers.modify(provider), serial), products.type());
    }

    private void addNonElectronicProduct() throws Exception {
        String name = read("\nSet the name of the product:");
        int stock = readInt("\nSet the number stock of the product:");
        long code = readLong("\nSet the number code of the product:");
        float price = readFloat("\nSet the price of the product:");
        float discount = readFloat("\nSet the discount of the product:");
        sc.nextLine();
        String description = read("\nSet the description of the product:");
        String provider = read("\nSet the provider of the product:");
        contains(providers, provider);

        verifyAddMethod(products.addNonElectronicProduct(name, stock, code, price, discount,
                description, date, providers.modify(provider)), products.type());
    }

    private void removeProduct() throws Exception {
        System.out.println("\nWrite down the code of the product that you would like to remove:");
        verifyRemoveMethod(products.removeProduct(sc.nextLong()), products.type());
    }

    private void modifyProduct() {
        boolean Exit = false, isElectronic = false, nonOption = true;
        long code;
        int option;

        do {
            do {
                try {
                    switch (read("\nDo you want to modify a product's information? write down yes or no: ")) {
                        case "yes", "Yes", "YES":
                            nonOption = false;
                            break;
                        case "no", "No", "NO":
                            return;
                        default:
                            System.out.println("Choose \"Yes\" or \"No\"");
                    }
                } catch (NoSuchElementException e1) {
                    System.out.println("An error has ocurred");
                } catch (IllegalStateException e2) {
                    System.out.println("An error has ocurred");
                } catch (Exception e) {
                    System.out.println("An error has ocurred");
                }
            } while (nonOption);

            try {
                code = readLong("\nWrite down the code of the product that you would like to modify:");

                containsProduct(code);
                System.out.println("\nWhat would you like to modify?" +
                        "\n1) Name \n2) Code \n3) Price \n4) Discount \n5) Description");

                if (isElectronic = products.isElectronic(code)) {
                    System.out.println("6) Serial Number");
                    System.out.println("7) Exit\n");
                } else {
                    System.out.println("6) Exit\n");
                }

                switch ((option = readOption())) {
                    case 1:
                        products.modify(code).setName(read("\nWrite down the new Name of the product:"));
                        System.out.println("\nName has been correctly updated");
                        break;
                    case 2:
                        products.modify(code).setCode(readLong("\nWrite down the new Code of the product:"));
                        System.out.println("\nCode has been correctly updated");
                        break;
                    case 3:
                        products.modify(code).setPrice(readFloat("\nWrite down the new Price of the product:"));
                        System.out.println("\nPrice has been correctly updated");
                        break;
                    case 4:
                        products.modify(code).setDiscount(readFloat("\nWrite down the new Discount of the product:"));
                        System.out.println("\nDiscount has been correctly updated");
                        break;
                    case 5:
                        products.modify(code).setDescription(read("\nWrite down the new Description of the product:"));
                        System.out.println("\nDescription has been correctly updated");
                        break;
                    default:
                        if (isElectronic) {
                            switch (option) {
                                case 6:
                                    products.modifyElectronic(code)
                                            .setSerial(readLong("\nWrite down the new SerialNumber of the product:"));
                                    System.out.println("\nSerialNumber has been correctly updated");
                                    break;
                                case 7:
                                    Exit = true;
                                    break;
                                default:
                                    throw new OutOfRangeException();
                            }

                        } else {
                            if (option == 6) {
                                Exit = true;
                            } else {
                                throw new OutOfRangeException();
                            }
                        }
                }

            } catch (InputMismatchException e2) {
                System.out.println("Ups, something has ocurred " + e2);
                sc.nextLine();
            } catch (OutOfRangeException e1) {
                System.out.println("Ups, something has ocurred " + e1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (!Exit);
    }
}