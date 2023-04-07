public class ClientSet implements Modifier{
    private Client[] clientArray = new Client[10];
    private int nClient = 0;

    public ClientSet(){

    }

    public boolean add(Client c){
        if(nClient<clientArray.length){
            clientArray[nClient] = c; 
            nClient++;
            return true;
        }else
        return false;
    }

    // acts as get method, in order to get the client and then change a specific atribute

    public Client modify(int i){
        if (0<=i && i < nClient){
            return clientArray[i];
        }
        return null;
    }

    // i changed the "i" parameter to j,to avoid any confusions 

    public boolean remove(int i){
        if(i<0 || nClient<=i){
            return false;
        }

        for(int j = i; j<nClient-1; j++){
            clientArray[j] = clientArray[j+1];
        }

        clientArray[nClient-1] = null;
        nClient--;
        return true;
    }

    public String consult(int i){
        if (i>=0 && i < nClient){
        return clientArray[i].toString();
        }
        return null;
    }

    public String consultAll(){
        String temp = "";

        for (int i=0; i<nClient; i++){
            temp += "\n"+clientArray[i].toString()+"\n";
        }

        if (temp != "") {
            return null;
        }
        
        return temp;
    }

    
    
    public Object[] sortByAlphabet(){
        Client temp;
        Client[] clone = clientArray.clone(); 

        for (int i = 0; i < nClient; i++) {
            for (int j = i + 1; j < nClient; j++) {
                if (clone[i].getName().compareTo(clone[j].getName()) > 0) {
                    temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;
                }
            }
		}
        return clone;
    }

    public Object[] sortByDate(){
        Client temp;
        Client[] clone = clientArray.clone();
        for (int i = 0; i < nClient; i++) {
            for (int j = i + 1; j < nClient; j++) {
               if (clone[i].getDate().isBefore(clone[j].getDate())) {
                    temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;
                }
            }
		}

        return clone;
    }


	public int length(){
		return nClient;
	}

}