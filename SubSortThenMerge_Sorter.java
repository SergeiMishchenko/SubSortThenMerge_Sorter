/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;
import java.util.Arrays;

public class SubSortThenMerge_Sorter{
	public ArrayList<String> usersData;

    public SubSortThenMerge_Sorter( ArrayList<String> list) {
        usersData = list;
    }

	public ArrayList<String> getUsersData(){
		return usersData;
	}

	public ArrayList<String> subSortThenMerge_Sorter(){
		return subSortThenMerge_Sorter(usersData);
	}

	public ArrayList<String> subSortThenMerge_Sorter(ArrayList<String> unsorted){
		Merger merger;
		if(unsorted.size() == 1)
			return unsorted;
		else{
			ArrayList <String> part1 = subSortThenMerge_Sorter(partOfArrayList (unsorted, 0, unsorted.size()/2 - 1));
			System.out.println ("part1: " + part1);
			ArrayList <String> part2 = subSortThenMerge_Sorter(partOfArrayList (unsorted, unsorted.size()/2, unsorted.size() - 1));
			System.out.println ("part2: " + part2);
			merger = new Merger(addArrays(part1, part2));
			merger.merge(0, unsorted.size()/2, unsorted.size() );
			System.out.println ("merged: " + merger.getUsersData());
			}
		usersData = merger.getUsersData();
		return usersData;
	}
			
			
	public ArrayList<String> partOfArrayList(ArrayList<String> array, int beginning, int end){
		ArrayList<String> newArray = new ArrayList <String>();
		for (int i = beginning; i <= end; i ++){
			newArray.add(array.get(i));
		}		
		return newArray;
	}
	
	public ArrayList<String> addArrays (ArrayList<String> part1, ArrayList<String> part2){
		for (int i = 0; i < part2.size();i++)
			part1.add(part2.get(i));
		return part1;
	}
	
	    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0){
				System.out.println (usersData.get(i));
				return false;
			}
        return true;
    }
}