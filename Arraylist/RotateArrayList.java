import java.util.*;
class RotateArrayList {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(1,2,3,4,4,5,5));
        lst.add(6);
        int n = lst.size();
        int k = 19;
        k = k% n;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i<n; i++){
            temp.add(lst.get((i-k+n)%n));
            // for anticlockwise rotation, use (i+k)%n instead of (i-k+n)%n
        }
        for(Integer ele : temp){
            System.out.print(ele + " ");
        }
    }
}