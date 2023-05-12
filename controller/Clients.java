package controller;

import model.*;

public class Clients implements NonModifier{
    private Client[] clientArray = new Client[10];
    private int nClient = 0;

    public boolean add(Client c){
        if(nClient<clientArray.length){
            clientArray[nClient] = c; 
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

      String all = "";
      for (int i=0; i<nClient; i++){
         all += "\n"+clientArray[i].toString()+"\n";
      }
      
      return all;
    }
    
    public Object[] sortByAlphabet(){
       Client[] clone = clientArray.clone(); 
       Client client;

        for (int i = 0; i < nClient; i++) {
            for (int j = i + 1; j < nClient; j++) {
                if (clone[i].getName().compareTo(clone[j].getName()) > 0) {
                    client = clone[i];
                    clone[i] = clone[j];
                    clone[j] = client;
                }
            }
		}
        return clone;
    }

	public int length(){
		return nClient;
	}

    public boolean isFull(){
		return nClient == clientArray.length;
	}
}