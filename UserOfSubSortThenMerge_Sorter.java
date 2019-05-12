import java.util.ArrayList;
import java.util.Arrays;

public class UserOfSubSortThenMerge_Sorter{
    
    public static void main(String[] commandLine) {
        ArrayList< String> cards = new ArrayList< String>(
          /* Java's Arrays.asList provides a perspicuous
             way to build a Collection from literals,
             suitable for constructing an ArrayList */
          Arrays.asList(
              // data to be ignored; see README
              "A", "C"  // descending order
              
              // one sorted sub-list
            , "G", "I", "L"

             // the other sorted sub-list
            , "B", "D", "E", "L"
            
              // more data to be ignored
            , "M", "S", "W"  // descending order
            ));

        oneTest( "card decks"
               , cards, 0, 6, 12 );
    }

    
    /** 
     Run one test
     */
    private static void oneTest(
        String description
      , ArrayList<String> mergeMe
        // indexes of sub-list boundaries; see README
      , int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1

                               ) {

        System.out.println( 
            System.lineSeparator()
          + description + System.lineSeparator()
          + "before: " + mergeMe
          );
		SubSortThenMerge_Sorter	subSortMerged = new SubSortThenMerge_Sorter(mergeMe);
		subSortMerged.subSortThenMerge_Sorter();
        System.out.println( "after:  " + subSortMerged.getUsersData());
        System.out.println(
            "sorted: "
          + subSortMerged.isSorted( start0, nItems));
	}
}

