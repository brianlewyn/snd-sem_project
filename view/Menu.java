package view;

import controller.*;
import model.ElectronicProduct;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Clients clients;
    Products products; 
    Providers providers;
    
    LocalDate date = LocalDate.now();
    Scanner sc = new Scanner(System.in);

    public Menu(){}

    public void addControllers(Clients clients, Products products, Providers providers){
        this.clients = clients;
        this.products = products;
        this.providers = providers;
    }

   
    public void displayMenu(){
        boolean loop = true;
        
        do{
            System.out.println("Select an option: ");
            System.out.println("1: Clients");
            System.out.println("2: Providers");
            System.out.println("3: Products");
            System.out.println("4: Exit\n");
            
            try{                
                switch(sc.nextInt()){
                    case 1: // Clients
                        displayClientMenu();
                    break;
                    case 2: // Providers
                        displayProviderMenu();
                    break;
                    case 3: // Products
                        displayProductMenu();
                    break;
                    case 4: // Exit
                        loop = false; 
                    break;
                    default:
                        throw new OutOfRangeException();
                }
            
            } catch(OutOfRangeException e2){
                System.err.println(e2.getMessage());
            } catch(InputMismatchException e1){
                System.err.println("invalid value" + e1.getMessage());
            } catch(Exception e){
                System.err.println(e.getMessage());
            }

        } while(loop);
        
        System.out.println("Come back soon :3");
    }
    
    // Clients Menu
    
    public void displayClientMenu(){
        boolean loop = true;

        do{
            System.out.println("What would you like to do?");
            System.out.println("1) Add client");
            System.out.println("2) Remove client");                    
            System.out.println("3) Consult every client information");
            System.out.println("4) Consult a specific client information");
            System.out.println("5) Modify a specific client information");
            System.out.println("6) Sort Clients by Alphabet");
            System.out.println("7) Exit\n");
            
            try{
                switch(sc.nextInt()){
                    case 1: // Add Client
                        addClient();
                    break;
                    case 2: // Remove Client
                        removeClient();
                    break;
                    case 3: // Show Every Clients
                        showAllClients();
                    break;
                    case 4: // Show Client
                        showClient();
                    break;
                    case 5: // Specific Modify
                        modifyClient();
                    break;          
                    case 6: // Sort by Alphabet
                        sortAllClients();
                    break;
                    case 7: // Exit
                        loop = false;
                    break;
                    default:
                        throw new OutOfRangeException();
                }
            
            }catch(InputMismatchException e2){
                System.out.println("Ups, something has ocurred \n" +e2);
            }catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred \n" +e1);
            } catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        } while(loop);
            
   }

    private void addClient() throws Exception {
        // Client newClient = new Client(null, null, null, null);
        String name, email, address, rfc;

        System.out.println("Set the name of the client: ");
        name = sc.nextLine();

        System.out.println("Set the email of the client: ");
        email = sc.nextLine();

        System.out.println("Set the adress of the client: ");
        address = sc.nextLine();

        System.out.println("Set the RFC of the client: ");
        rfc = sc.nextLine();

        // controller.addClient(name, email, address, rfc);
        System.out.println("the client has been added");
    }

    private void removeClient() throws Exception {
        System.out.println("Write down the name of the client that you would like to remove: ");
        String name = sc.nextLine();
        // controller.removeClient(name);
        System.out.println("the client has been removed");
    }

    private void showAllClients() throws Exception {        
        // String list = controller.showAllClients();
        // System.out.print(list);
    }

    private void showClient() throws Exception {        
        System.out.println("Write down the name of the client that you would like to consult: ");
        String name = sc.nextLine();
        // String info = controller.infoClient(name);
        // System.out.println(infoClient);
    }

    private void sortAllClients() throws Exception{
        // String list = controller.sortAllClients();
        // System.out.println(list);   
    }

    private void modifyClient(){
        boolean loop = true;
        String name;
        
        do{
            try{
                System.out.println("Write down the name of the client that you would like to modify: ");
                name = sc.nextLine();
                
                System.out.println("what would you like to modify?");
                System.out.println("1) Name");
                System.out.println("2) Email");
                System.out.println("3) Phone");
                System.out.println("5) Exit\n");

                switch(sc.nextInt()){
                    case 1: 
                        System.out.println("Write down the new name of the client: ");
                        String newName = sc.nextLine();
                        // controller.modifyClient(name).setName(newName);
                        System.out.println("Name has been correctly updated");
                        break;
                        case 2: 
                        System.out.println("Write down the new email of the client: ");
                        String email = sc.nextLine();
                        // controller.modifyClient(name).setEmail(email);
                        System.out.println("Email has been correctly updated");
                        break;
                        case 3: 
                        System.out.println("Write down the new Phone of the client: ");
                        String Phone = sc.nextLine();
                        // controller.modifyClient(name).setPhone(Phone);
                        System.out.println("Phone has been correctly updated");
                        break;
                        case 4: 
                        System.out.println("Write down the new RFC of the client: ");
                        String rfc = sc.nextLine();
                        // controller.modifyClient(name).setRFC(rfc);
                        System.out.println("RFC has been correctly updated");
                    break;
                    case 5:
                        loop = false;
                        break;
                    default:
                        throw new OutOfRangeException();
                }
            
            }catch(InputMismatchException e2){
                System.out.println("Ups, something has ocurred \n" +e2);
            }catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred \n" +e1);
            } catch(Exception e){
                System.err.println(e.getMessage());
            }

        }while(loop);
    } 
    
    //Providers Menu
    
    public void displayProviderMenu(){
        int option = 0; 
        boolean loop = true;

        do{
            System.out.println("What would you like to do?");
            System.out.println("1) Add provider");
            System.out.println("2) Remove provider");
            System.out.println("3) Consult every provider information");
            System.out.println("4) Consult a specific provider information");
            System.out.println("5) Modify a specific provider information");
            System.out.println("6) Sort providers by Alphabet");
            System.out.println("7) Exit\n");    
            
            try{
                switch(sc.nextInt()){
                    case 1: // Add Provider
                        addProvider();
                        break;
                    case 2: // Remove Provider
                        removeProvider();
                        break;
                    case 3: // Show Every Providers
                        showAllProviders();
                        break;
                    case 4: // Sepecific Consult
                        showProvider();
                        break;
                    case 5: // Specific Modify
                        modifyProvider();
                        break;
                    case 6: // Sort By Alphabet
                        sortAllProviders();
                        break;
                    case 7: // Exit
                        loop = false;
                        break;
                    default:
                        throw new OutOfRangeException();
                }

            }catch(InputMismatchException e){
                System.out.println("Ups, something has ocurred " +e);
            }catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred \n" +e1);
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        } while(loop);
   }
    
    private void addProvider() throws Exception {
        // Provider newProvider = new Provider(null, null, null, null);
        String name, email, phone;

        System.out.println("Set the name of the provider: ");
        name = sc.nextLine();

        System.out.println("Set the email of the provider: ");
        email = sc.nextLine();

        System.out.println("Set the Phone of the provider: ");
        phone = sc.nextLine();

        // controller.NewProvider(name, email, phone);
        System.out.println("the provider has been added");
    }
    
    private void removeProvider() throws Exception{
        System.out.println("Write down the name of the provider that you would like to remove: ");
        String name = sc.nextLine();
        // controller.removeProvider(name);
        System.out.println("the provider has been removed");
    }
    
    private void showAllProviders() throws Exception {
        // String list = controller.showAllProviders();
        // System.out.print(list);
    }

    private void showProvider() throws Exception{
        System.out.println("Write down the name of the provider that you would like to consult: ");
        String name = sc.nextLine();
        // String info = controller.infoProvider(name);
        // System.out.println(infoProvider);
    }

    private void modifyProvider(){
        boolean loop=true;
        String name;
        
        do{
            try{
                System.out.println("Write down the name of the provider that you would like to modify: ");
                name = sc.nextLine();
                
                System.out.println("what would you like to modify?");
                System.out.println("1) Name");
                System.out.println("2) Email");
                System.out.println("3) Phone");
                System.out.println("4) Exit\n");

                switch(sc.nextInt()){
                    case 1: 
                        System.out.println("Write down the new name of the provider: ");
                            String newName = sc.nextLine();
                            // controller.modifyProvider(name).setName(newName);
                            System.out.println("Name has been correctly updated");
                        break;
                        case 2: 
                            System.out.println("Write down the new email of the provider: ");
                            String email = sc.nextLine();
                            // controller.modifyProvider(name).setEmail(email);
                            System.out.println("Email has been correctly updated");
                        break;
                        case 3: 
                            System.out.println("Write down the new Phone of the provider: ");
                            String phone = sc.nextLine();
                            // controller.modifyProvider(name).setPhone(phone);
                            System.out.println("Phone has been correctly updated");
                    break;
                    case 4:
                        loop = false;
                        break;
                    default:
                        throw new OutOfRangeException();
                }
            
            }catch(InputMismatchException e2){
                System.out.println("Ups, something has ocurred \n" +e2);
            }catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred \n" +e1);
            } catch(Exception e){
                System.err.println(e.getMessage());
            }

        }while(loop);
    }

    private void sortAllProviders() throws Exception{
        // String list = controller.sortAllProviders();
        // System.out.println(list);
    }
    
    //Product Menu
    
    public void displayProductMenu(){
        boolean loop = true;

        do{
            try{
                System.out.println("What would you like to do?");
                System.out.println("1) Add Product");
                System.out.println("2) Remove Product");
                System.out.println("3) Consult every Product information");
                System.out.println("4) Consult a specific Product information");
                System.out.println("5) Modify a specific Product information");
                System.out.println("6) Sort Products by Alphabet");
                System.out.println("7) Exit\n");
                
                switch(sc.nextInt()){
                    case 1: // Add Product
                        addProduct();
                    break;
                    case 2: // Remove Product
                        removeProduct();
                    break;
                    case 3: // Show Every Products
                        showAllProducts();
                    break;
                    case 4: // Show Product
                        showProduct();
                    break;
                    case 5: // Specific Modify
                        modifyProduct();
                    break;          
                    case 6: // Sort by Alphabet
                        // sortAllProducts();
                    break;
                    case 7: // Exit
                        loop = false;
                    break;
                    default:
                        throw new OutOfRangeException();
                }
            
            } catch(InputMismatchException e2){
                System.out.println("Ups, something has ocurred " +e2);
            } catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred \n" +e1);
            } catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        } while(loop);
    }
    
    private void addProduct() throws Exception {
        boolean loop = true;

        do {
            System.out.println("Select an option: ");
            System.out.println("1) Electrnonic Product");
            System.out.println("2) Non Electrnonic Product");
            System.out.println("3) Exit\n");
            
            try{

                switch(sc.nextInt()){
                case 1:
                    addElectronicProduct();
                break;
                case 2:
                    addNonElectronicProduct();
                break;
                case 3:
                    loop = false;
                break;
                default:
                    throw new OutOfRangeException();
                }

            }catch(InputMismatchException e2){
                System.out.println("Ups, something has ocurred \n" +e2);
            }catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred \n" +e1);
            } catch(Exception e){
                System.err.println(e.getMessage());
            }

        } while(loop);



        // Product newProduct = new Product(null, null, null, null);
        // String name, email, phone;

        // System.out.println("Set the name of the product: ");
        // name = sc.nextLine();

        // System.out.println("Set the email of the product: ");
        // email = sc.nextLine();

        // System.out.println("Set the Phone of the product: ");
        // phone = sc.nextLine();

        // controller.NewProduct(name, email, phone);
        // System.out.println("the product has been added");
    }

    private void addElectronicProduct() throws Exception {
        System.out.println("Set the name of the product: ");
        String name = sc.nextLine();

        System.out.println("Set the number stock of the product: ");
        int stock = sc.nextInt();

        System.out.println("Set the number code of the product: ");
        long code = sc.nextInt();

        System.out.println("Set the price of the product: ");
        float price = sc.nextFloat();

        System.out.println("Set the discount of the product: ");
        float discount = sc.nextFloat();

        System.out.println("Set the description of the product: ");
        String description = sc.nextLine();

        System.out.println("Set the provider of the product: ");
        String provider = sc.nextLine();

        System.out.println("Set the serial of the product: ");
        String serial = sc.nextLine();

        // controller.addElectronicProduct(name, stock, code, price, discount, description, date, provider, serial);
    }

    private void addNonElectronicProduct() throws Exception {
        System.out.println("Set the name of the product: ");
        String name = sc.nextLine();

        System.out.println("Set the number stock of the product: ");
        int stock = sc.nextInt();

        System.out.println("Set the number code of the product: ");
        long code = sc.nextInt();

        System.out.println("Set the price of the product: ");
        float price = sc.nextFloat();

        System.out.println("Set the discount of the product: ");
        float discount = sc.nextFloat();

        System.out.println("Set the description of the product: ");
        String description = sc.nextLine();

        System.out.println("Set the provider of the product: ");
        String provider = sc.nextLine();

        // controller.addNonElectronicProduct(name, stock, code, price, discount, description, date, provider);
    }
    
    private void removeProduct() throws Exception{
        System.out.println("Write down the code of the product that you would like to remove: ");
        long code = sc.nextLong();
        // controller.removeProduct(code);
        System.out.println("the product has been removed");
    }
    
    private void showAllProducts() throws Exception {
        // String list = controller.showAllProducts();
        // System.out.print(list);
    }

    private void showProduct() throws Exception{
        System.out.println("Write down the code of the product that you would like to consult: ");
        long code = sc.nextLong();
        // String info = controller.infoProduct(code);
        // System.out.println(infoProduct);
    }
    
    private void modifyProduct(){
        int option = 0;
        boolean loop = true;
        boolean isElectronic = false;
        long code = 0;
        
        do{
            try{
                System.out.println("Write down the code of the product that you would like to modify: ");
                code = sc.nextLong();

                if (products.modify(code) instanceof ElectronicProduct){
                    isElectronic = true;
                }
                
                System.out.println("What would you like to modify?");
                System.out.println("1) Name");
                System.out.println("2) Code");
                System.out.println("3) Price");
                System.out.println("4) Discount");
                System.out.println("5) Description");

                if (isElectronic) {
                    System.out.println("6) Serial Number");
                    System.out.println("7) Exit\n");    
                } else {
                    System.out.println("6) Exit\n");    
                }

                option = sc.nextInt();
                switch(option){
                    case 1: 
                        System.out.println("Write down the new Name of the product: ");
                        String name = sc.nextLine();
                        products.modify(code).setName(name);
                        System.out.println("Name has been correctly updated");
                    break;
                    case 2: 
                        System.out.println("Write down the new Code of the product: ");
                        long newCode = sc.nextLong();
                        products.modify(code).setCode(newCode);
                        System.out.println("Code has been correctly updated");
                    break;
                    case 3: 
                        System.out.println("Write down the new Price of the product: ");
                        float price = sc.nextFloat();
                        products.modify(code).setPrice(price);
                        System.out.println("Price has been correctly updated");
                    break;
                    case 4: 
                        System.out.println("Write down the new Discount of the product: ");
                        float discount = sc.nextFloat();
                        products.modify(code).setDiscount(discount);
                        System.out.println("Discount has been correctly updated");
                    break;
                    case 5:
                        System.out.println("Write down the new Description of the product: ");
                        String description = sc.nextLine();
                        products.modify(code).setDescription(description);
                        System.out.println("SerialNumber has been correctly updated");
                    break;
                    default:
                        if (isElectronic){
                            
                            if (option == 6) {
                                System.out.println("Write down the new SerialNumber of the product: ");
                                long serial = sc.nextLong();
                                ((ElectronicProduct)products.modify(code)).setSerial(serial);
                                System.out.println("SerialNumber has been correctly updated");
                    
                            } else if (option == 7){
                                loop = false;
                            } else {
                                throw new OutOfRangeException();
                            }
                                
                        } else {
                            if (option == 6){
                                loop = false;
                            } else {
                                throw new OutOfRangeException();
                            }
                        }
                    }
            
            }catch(InputMismatchException e2){
                System.out.println("Ups, something has ocurred \n" +e2);
            }catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred \n" +e1);
            } catch(Exception e){
                System.err.println(e.getMessage());
            }

        }while(loop);
    } 
}