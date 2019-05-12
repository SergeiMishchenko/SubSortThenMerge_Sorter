/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Merger {

	ArrayList<String> usersData;
	ArrayList<String> copyData = new ArrayList<String>();

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
		//creates a copy of usersData 
		for (int i = 0; i < usersData.size(); i ++){
			copyData.add(usersData.get(i));
		}
    }

	public ArrayList<String> getUsersData(){
		return usersData;
	}

    /*

      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
		  int n1 = start0;
		  int n2 = start1;
		  for (int currentI = start0 ; currentI < nItems ; currentI++){
			  if (n1 == start1){
				  usersData.set(currentI, copyData.get(n2));
				  n2++;
			  }
			  else if (n2 == nItems){
				  usersData.set(currentI, copyData.get(n1));
				  n1++;
			  }
			  else if (copyData.get(n1).compareTo(copyData.get(n2)) < 0){
				  usersData.set(currentI, copyData.get(n1));
				  n1++;
			  }
			  else{
				  usersData.set(currentI, copyData.get(n2));
				  n2++;
			  }
		  }
	  }
    
    /**
      @return a string representation of the user's data
     */
	 
    public String toString() {
        return "" + usersData;     }

   
    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0)
				return false;
        return true;
    }
}