package controller;

import model.*;

public class Providers implements NonModifier{
   private Provider[] providerArray = new Provider[10];
   private int nProvider;

   public boolean add(Provider p){
      if (nProvider < providerArray.length){
         providerArray[nProvider] = p;
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

      String all = "";

      for (int i=0; i<nProvider; i++){
         all += "\n"+providerArray[i].toString()+"\n";
      }
      
      return all;
	}

	public Object[] sortByAlphabet(){
      Provider[] clone = providerArray.clone(); 
		Provider provider;

        for (int i = 0; i < nProvider; i++) {
            for (int j = i + 1; j < nProvider; j++) {
                if (clone[i].getName().compareTo(clone[j].getName()) > 0) {
                    provider = clone[i];
                    clone[i] = clone[j];
                    clone[j] = provider;
                }
            }
		}
      
      return clone;
	}

	public int length(){
		return nProvider;
	}

   public boolean isFull(){
		return nProvider == providerArray.length;
	}
}