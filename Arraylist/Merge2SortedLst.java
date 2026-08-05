import java.util.*;

public class Merge2SortedLst{
    static ArrayList<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        int i =0, j=0;
        ArrayList<Integer> res = new ArrayList<>(list1.size() + list2.size());
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                res.add(list1.get(i++));
            }else{
                res.add(list2.get(j++));
            }
        }
        while(i < list1.size()){
            res.add(list1.get(i++));
        }        while(j < list2.size()){
            res.add(list2.get(j++));
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        
        ArrayList<Integer> mergedList = mergeSortedLists(list1, list2);
        
        System.out.println("Merged Sorted List: " + mergedList);
    }
}