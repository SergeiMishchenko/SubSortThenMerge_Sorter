/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;
import java.util.Arrays;

public class SubSortThenMerge_Sorter{

	public ArrayList<String> SubSortThenMerge_Sorter(ArrayList<String> unsorted){
		Merger merger;
		if(unsorted.size() == 1)
			return unsorted;
		else{
			ArrayList <String> part1 = SubSortThenMerge_Sorter(partOfArrayList (unsorted, 0, unsorted.size()/2 - 1));
			ArrayList <String> part2 = SubSortThenMerge_Sorter(partOfArrayList (unsorted, unsorted.size()/2, unsorted.size()));
			merger = new Merger(addArrays(part1, part2));
			merger.merge(0, unsorted.size()/2, unsorted.size() - 1);
		}
		return merger.getUsersData();
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
}