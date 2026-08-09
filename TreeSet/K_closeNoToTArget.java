import java.util.*;

class K_closeNoToTArget{

    public static void main(String[] args){
        TreeSet<Integer>st = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9));
        int target = 5;
        int k = 3;
        Integer lower = st.floor(target);
        Integer higher = st.ceiling(target);
        ArrayList<Integer> res = new ArrayList<>();
        while(res.size() < k){
            if(lower == null && higher == null){
                break;
            }
            else if(lower == null){
                res.add(higher);
                higher = st.higher(higher);
                System.out.println("Higher: " + higher);
            }else if(higher == null){
                res.add(lower);
                lower = st.lower(lower);
                System.out.println("Lower: " + lower);
            }else if(Math.abs(lower - target) <= Math.abs(higher - target)){
                res.add(lower);
                lower = st.lower(lower);
            }else {
                res.add(higher);
                higher = st.higher(higher);
                System.out.println("Higher: " + higher);
            }
        }
    }
}