// 1. Remove duplicates from an ArrayList while preserving order
import java.util.*;
class RemoveDuplicateswithoutChange{
    public static void main(String[] args){
        ArrayList<Integer>lst = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 1, 5));
        HashSet<Integer>st = new HashSet<>();
        ArrayList<Integer>res = new ArrayList<>();
        for(Integer ele : lst){
            if(st.contains(ele))continue;
            st.add(ele);
            res.add(ele);
        }
        for(Integer ele : res){
            System.out.print(ele + " ");
        }
    }
}