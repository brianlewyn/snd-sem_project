package controller;

import model.*;

public class Clients implements ArrayController, SubjectController{
    private Client[] clientArray;
    private int nClient = 0;

    public Clients(){
        clientArray = new Client[10];
    }

    public Clients(int size){
        clientArray = new Client[size];
    }

    public boolean add(String name,String  email, String address, String rfc){
        if(nClient<clientArray.length){
            clientArray[nClient] = new Client(name, email, address, rfc); 
            nClient++;
            return true;
        }
        return false;
    }

    // acts as get method, in order to get the client and then change a specific atribute

    public Client modify(String name){
        for (int i=0; i<nClient; i++){
            if (clientArray[i].getName().equals(name)){
               return clientArray[i];
            }
         }
        return null;
    }

    public Client getClient(String email){
        for (int i=0; i<nClient; i++){
            if (clientArray[i].getEmail().equals(email)){
               return clientArray[i];
            }
         }
        return null;
    }

    // i changed the "i" parameter to j,to avoid any confusions 
    public boolean remove(String name){
        int index = -1;

      for (int i=0; i<nClient; i++) {
         if (clientArray[i].getName().equals(name)){
               index = i;
               break;
         } 
      }

      if (index != -1) {
         for(int j = index; j<nClient-1; j++){
               clientArray[j] = clientArray[j+1];
         }
         
         clientArray[nClient-1] = null;
         nClient--;
         return true;
      }

      return false;
    }

    public String consult(String name){
      for (int i=0; i<nClient; i++) {
         if (clientArray[i].getName().equals(name)){
             return clientArray[i].toString();
         }
      }
      return null;
    }

    public String consultAll(){
        if (nClient == 0) {
            return null;
        }

        String list = "";
        for (int i=0; i<nClient; i++){
            list += "\n"+clientArray[i].toString()+"\n";
        }
      
        return list;
    }
    
    public String sortByAlphabet(){
        Client client;

        for (int i = 0; i < nClient; i++) {
            for (int j = i + 1; j < nClient; j++) {
                if (clientArray[i].getName().compareTo(clientArray[j].getName()) > 0) {
                    client = clientArray[i];
                    clientArray[i] = clientArray[j];
                    clientArray[j] = client;
                }
            }
		}

        return consultAll();
    }

	public int length(){
		return nClient;
	}

    public boolean isFull(){
		return nClient == clientArray.length;
	}

    public boolean isEmpty(){
        return nClient == 0;
    }

    public String type(){
        return "client";
    }

    public boolean contains(String name){
        for (int i=0; i<nClient; i++){
            if (clientArray[i].getName().equals(name)){
            return true;
            }
        }
        return false;
    }
}