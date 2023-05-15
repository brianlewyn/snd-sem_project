package controller;

import model.*;

public class Providers implements ArrayController, SubjectController{
   private Provider[] providerArray;
   private int nProvider;

   public Providers(){
      providerArray = new Provider[10];
   }

   public Providers(int size){
      providerArray = new Provider[size];
   }

   public boolean add(String name, String email, String phone){
        if (nProvider < providerArray.length){
            providerArray[nProvider] = new Provider(name, email, phone);
            nProvider++;
            return true;
        }
        return false;
    }

    public Provider modify(String name){
        for (int i=0; i<nProvider; i++){
            if (providerArray[i].getName().equals(name)){
                return providerArray[i];
            }
        }
        return null;
    }

    public boolean remove(String name){
        int index = -1;

        for (int i=0; i<nProvider; i++) {
            if (providerArray[i].getName().equals(name)){
                index = i;
                break;
            } 
        }

        if (index != -1) {
            for(int j = index; j<nProvider-1; j++){
                providerArray[j] = providerArray[j+1];
            }
            
            providerArray[nProvider-1] = null;
            nProvider--;
            return true;
        }

        return false;
    }

    public String consult(String name){
        for (int i=0; i<nProvider; i++) {
            if (providerArray[i].getName().equals(name)){
                return providerArray[i].toString();
            }
        }
        return null;
    }

    public String consultAll(){
        if (nProvider == 0) {
            return null;
        }

        String list = "";
        for (int i=0; i<nProvider; i++){
            list += "\n"+providerArray[i].toString()+"\n";
        }
        
        return list;
    }

	public String sortByAlphabet(){
		Provider provider;

        for (int i = 0; i < nProvider; i++) {
            for (int j = i + 1; j < nProvider; j++) {
               if (providerArray[i].getName().compareTo(providerArray[j].getName()) > 0) {
                  provider = providerArray[i];
                  providerArray[i] = providerArray[j];
                  providerArray[j] = provider;
               }
            }
		}
      
      return consultAll();
	}

	public int length(){
		return nProvider;
	}

    public boolean isFull(){
        return nProvider == providerArray.length;
    }

    public boolean isEmpty(){
        return nProvider == 0;
    }

    public boolean contains(String name){
        for (int i=0; i<nProvider; i++){
            if (providerArray[i].getName().equals(name)){
            return true;
            }
        }
        return false;
    }

    public String type(){
        return "provider";
    }
}