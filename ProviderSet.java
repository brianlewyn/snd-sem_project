public class ProviderSet implements Modifier{
   private Provider[] providerArray;
   private int nProvider;

	public ProviderSet(){}

   public boolean add(Provider p){
      if (nProvider < providerArray.length){
         providerArray[nProvider] = p;
         nProvider++;
         return true;
      }
      return false;
   }

   public Provider modify(int i){
      if (0<=i && i < nProvider){
         return providerArray[i];
      }
      return null;
   }

   public boolean remove(int i){
      if (i<0 || nProvider<=i){
         return false;
      }
      
      for (int j=i; j<providerArray.length-1; j++){
         providerArray[j] = providerArray[j+1];
      }
      
      providerArray[nProvider-1] = null;
      nProvider--;
      return true;
   }

   public String consult(int i){
      if (0<=i && i<nProvider){
         return providerArray[i].toString();
      }
      return null;
   }

   public String consultAll(){
      String temp = "";

      for (int i=0; i<nProvider; i++){
         temp += "\n"+providerArray[i].toString()+"\n";
      }

      if (temp != "") {
         return temp;
      }
      
      return null;
	}

	public Object[] sortByAlphabet(){
		Provider temp;
      Provider[] clone = providerArray.clone(); 

        for (int i = 0; i < nProvider; i++) {
            for (int j = i + 1; j < nProvider; j++) {
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
		Provider temp;
      Provider[] clone = providerArray.clone(); 

      for (int i = 0; i < nProvider; i++) {
         for (int j = i + 1; j < nProvider; j++) {
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
		return nProvider;
	}
}