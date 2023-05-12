package view;

import controller.*;
import model.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    // controller
    Clients clients;
    Products products; 
    Providers providers;
    
    // others
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
            if (products.isMinimum()){
                System.out.println("Order done. Stock restored");
                System.out.println(products.listProductMinimum());
            }

            System.out.println("Select an option: ");
            System.out.println("1: Clients");
            System.out.println("2: Providers");
            System.out.println("3: Products");
            System.out.println("4: Exit\n");
            
            try{                
                int option = sc.nextInt();
                sc.nextLine();
                switch(option){
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
            
            } catch(InputMismatchException e2){
                System.out.println("Ups, something has ocurred " +e2);
                sc.nextLine();
            } catch(OutOfRangeException e1){
                System.err.println("Ups, something has ocurred "+e1);
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
                int option = sc.nextInt();
                sc.nextLine();
                
                switch(option){
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
                    sortByAlphabetClients();
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
        if(clients.isFull()){
            throw new Exception("the client's list is full");
        }

        System.out.println("Set the name of the client: ");
        String name = sc.nextLine();

        System.out.println("Set the email of the client: ");
        String email = sc.nextLine();

        System.out.println("Set the address of the client: ");
        String address = sc.nextLine();

        System.out.println("Set the RFC of the client: ");
        String rfc = sc.nextLine();

        if (clients.add(new Client(name, email, address, rfc))){
            System.out.println("The client has been added");
        } else {
            throw new Exception("Couldn't add the provider, try again");
        }
    }

    private void removeClient() throws Exception {
        if (clients.length() == 0){
            throw new Exception("The client's list is empty");
        }

        System.out.println("Write down the name of the client that you would like to remove: ");
        String name = sc.nextLine();
        
        if (clients.remove(name)){
            System.out.println("The client has been removed");
        } else {
            throw new Exception("Couldn't remove the client, try again");
        }
    }

    private void showAllClients() throws Exception {        
        String list = clients.consultAll();
        
        if (list != null) {
            System.out.print(list);
        } else {
            throw new Exception("The client's list is empty");
        }
    }

    private void showClient() throws Exception {        
        System.out.println("Write down the name of the client that you would like to consult: ");
        String name = sc.nextLine();
        String info = clients.consult(name);
        
        if (info != null) {
            System.out.println(info);
        } else {
            throw new Exception("The client doesn't exist");
        }
    }

    private void sortByAlphabetClients() throws Exception{
        Client[] list = (Client[])clients.sortByAlphabet();

        if (clients.length() != 0){
            for (int i=0; i<clients.length(); i++){
                System.out.println(list[i]+"\n");
            }
        } else {
            throw new Exception("The client's list is empty");
        }
    }

    private void modifyClient(){
        boolean loop = true;
        String name;
        
        do{
            try{
                System.out.println("Write down the name of the client that you would like to modify: ");
                name = sc.nextLine();

                if (clients.modify(name) == null){
                    throw new Exception("The client doesn't exist");
                }
                
                System.out.println("what would you like to modify?");
                System.out.println("1) Name");
                System.out.println("2) Email");
                System.out.println("3) Address");
                System.out.println("4) RFC");
                System.out.println("5) Exit\n");

                int option = sc.nextInt();
                sc.nextLine();
                switch(option){
                    case 1: 
                        System.out.println("Write down the new name of the client: ");
                        String newName = sc.nextLine();
                        clients.modify(name).setName(newName);
                        System.out.println("Name has been correctly updated");
                    break;
                    case 2: 
                        System.out.println("Write down the new email of the client: ");
                        String email = sc.nextLine();
                        clients.modify(name).setEmail(email);
                        System.out.println("Email has been correctly updated");
                    break;
                    case 3: 
                        System.out.println("Write down the new Address of the client: ");
                        String Address = sc.nextLine();
                        clients.modify(name).setAddress(Address);
                        System.out.println("Address has been correctly updated");
                    break;
                    case 4: 
                        System.out.println("Write down the new RFC of the client: ");
                        String rfc = sc.nextLine();
                        clients.modify(name).setRfc(rfc);
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
                int option = sc.nextInt();
                sc.nextLine();
                
                switch(option){
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
                    sortByAlphabetProviders();
                    break;
                case 7: // Exit
                    loop = false;
                    break;
                default:
                    throw new OutOfRangeException();
                }

            }catch(InputMismatchException e){
                System.out.println("Ups, something has ocurred " +e);
                sc.nextLine();
            }catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred \n" +e1);
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        } while(loop);
   }
    
    private void addProvider() throws Exception {
        if(providers.isFull()){
            throw new Exception("the provider's list is full");
        }

        System.out.println("Set the name of the provider: ");
        String name = sc.nextLine();

        System.out.println("Set the email of the provider: ");
        String email = sc.nextLine();

        System.out.println("Set the Phone of the provider: ");
        String phone = sc.nextLine();

        if(providers.add(new Provider(name, email, phone))){
            System.out.println("the provider has been added");
        } else {
            throw new Exception("Couldn't add the provider, try again");
        }
    }
    
    private void removeProvider() throws Exception{
        if (providers.length() == 0){
            throw new Exception("The provider's list is empty");
        } 
        
        System.out.println("Write down the name of the provider that you would like to remove: ");
        String name = sc.nextLine();
        
        if (providers.remove(name)){
            System.out.println("the provider has been removed");
        } else {
            throw new Exception("Couldn't remove the provider, try again");
        }
    }
    
    private void showAllProviders() throws Exception {
        String list = providers.consultAll();
        if (list != null) {
            System.out.print(list);
        } else {
            throw new Exception("The provider's list is empty");
        }
    }

    private void showProvider() throws Exception{
        System.out.println("Write down the name of the provider that you would like to consult: ");
        String name = sc.nextLine();
        String info = providers.consult(name);

        if (info != null) {
            System.out.println(info);
        } else {
            throw new Exception("The provider doesn't exist");
        }
    }

    private void sortByAlphabetProviders() throws Exception{
        Provider[] list = (Provider[])providers.sortByAlphabet();
        if (providers.length() != 0){
            for (int i=0; i<providers.length(); i++){
                System.out.println(list[i]+"\n");
            }
        } else {
            throw new Exception("The provider's list is empty");
        }
    }

    private void modifyProvider(){
        boolean loop=true;
        String name;
        
        do{
            try{
                System.out.println("Write down the name of the provider that you would like to modify: ");
                name = sc.nextLine();

                if (providers.modify(name) == null){
                    throw new Exception("The provider doesn't exist");
                }
                
                System.out.println("What would you like to modify?");
                System.out.println("1) Name");
                System.out.println("2) Email");
                System.out.println("3) Phone");
                System.out.println("4) Exit\n");

                int option = sc.nextInt();
                sc.nextLine();
                
                switch(option){
                case 1: 
                    System.out.println("Write down the new name of the provider: ");
                    String newName = sc.nextLine();
                    providers.modify(name).setName(newName);
                    System.out.println("Name has been correctly updated");
                break;
                case 2: 
                    System.out.println("Write down the new email of the provider: ");
                    String email = sc.nextLine();
                    providers.modify(name).setEmail(email);
                    System.out.println("Email has been correctly updated");
                break;
                case 3: 
                    System.out.println("Write down the new Phone of the provider: ");
                    String phone = sc.nextLine();
                    providers.modify(name).setPhone(phone);
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
                
                int option = sc.nextInt();
                sc.nextLine();
                
                switch(option){
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
                    sortByAlphabetProducts();
                break;
                case 7: // Exit
                    loop = false;
                break;
                default:
                    throw new OutOfRangeException();
                }
            
            } catch(InputMismatchException e2){
                System.out.println("Ups, something has ocurred "+e2);
                sc.nextLine();
            } catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred "+e1);
            } catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        } while(loop);
    }
    
    private void addProduct() throws Exception {
        if (providers.length() == 0){
            throw new Exception("Cannot add product because the provider's list is empty");
        }

        if (products.isFull()){
            throw new Exception("the product's list is full");
        }

        boolean loop = true;

        do {
            System.out.println("Select an option: ");
            System.out.println("1) Electrnonic Product");
            System.out.println("2) Non Electrnonic Product");
            System.out.println("3) Exit\n");
            
            try{
                int option = sc.nextInt();
                sc.nextLine();
                
                switch(option){
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
    }

    private void addElectronicProduct() throws Exception {
        System.out.println("Set the name of the product: ");
        String name = sc.nextLine();

        System.out.println("Set the number stock of the product: ");
        int stock = sc.nextInt();

        System.out.println("Set the number code of the product: ");
        long code = sc.nextLong();

        System.out.println("Set the price of the product: ");
        float price = sc.nextFloat();

        System.out.println("Set the discount of the product: ");
        float discount = sc.nextFloat(); sc.nextLine();

        System.out.println("Set the description of the product: ");
        String description = sc.nextLine();

        System.out.println("Set the provider of the product: ");
        String providerName = sc.nextLine();

        System.out.println("Set the serial of the product: ");
        long serial = sc.nextLong();

        Provider provider = providers.modify(providerName);
        if (provider != null){
            ElectronicProduct product;
            product = new ElectronicProduct(name, stock, code, price, discount, description, date, provider, serial);
            
            if (products.add(product)){
                System.out.println("the product has been added");
            }else{
                throw new Exception("Couldn't add the product, try again. Either is full or something is misswriten");
            }
        
        } else {
            throw new Exception("Provider not found ");
        }
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
        float discount = sc.nextFloat(); sc.nextLine();

        System.out.println("Set the description of the product: ");
        String description = sc.nextLine();

        System.out.println("Set the provider of the product: ");
        String providerName = sc.nextLine();

        Provider provider = providers.modify(providerName);
        if (provider != null){
            NonElectronicProduct product;
            product = new NonElectronicProduct(name, stock, code, price, discount, description, date, provider);
            
            if (products.add(product)){
                System.out.println("the product has been added");
            }else{
                throw new Exception("Couldn't add the product, try again. Either is full or something is misswriten");
            }
        
        } else {
            throw new Exception("Provider not found ");
        }
    }
    
    private void removeProduct() throws Exception{
        if (products.length() == 0){
            throw new Exception("The product's list is empty");
        }
        
        System.out.println("Write down the code of the product that you would like to remove: ");
        long code = sc.nextLong();
        
        if (products.removeProduct(code)){
            System.out.println("the product has been removed");
        } else {
            throw new Exception("Couldn't remove the product, try again");
        }
    }
    
    private void showAllProducts() throws Exception {
        String list = products.consultAll();
        if (list != null) {
            System.out.print(list);
        } else {
            throw new Exception("The product's list is empty");
        }
    }

    private void showProduct() throws Exception{
        System.out.println("Write down the code of the product that you would like to consult: ");
        long code = sc.nextLong();
        String info = products.consult(code);

        if (info != null) {
            System.out.println(info);
        } else {
            throw new Exception("The product doesn't exist");
        }
    }
    
    private void sortByAlphabetProducts() throws Exception{
        Product[] list = (Product[])products.sortByAlphabet();
        if (products.length() != 0){
            for (int i=0; i<products.length(); i++){
                System.out.println(list[i]+"\n");
            }
        } else {
            throw new Exception("The product's list is empty");
        }
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

                if (products.modify(code) == null){
                    throw new Exception("The product doesn't exist");
                }

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
                sc.nextLine();
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
                    System.out.println("Description has been correctly updated");
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
            
            } catch(InputMismatchException e2){
                System.out.println("Ups, something has ocurred "+e2);
                sc.nextLine();
            } catch(OutOfRangeException e1){
                System.out.println("Ups, something has ocurred "+e1);
            } catch(Exception e){
                System.err.println(e.getMessage());
            }

        }while(loop);
    }
}