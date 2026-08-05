import java.util.ArrayList;
import java.util.Arrays;

class SecondLargest{
    public static void main(String[] args){
        ArrayList<Integer>lst = new ArrayList<>(Arrays.asList(10, 20, 20, 30, 30, 40, 50, 50));
        int maxVal = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE;
        for(Integer ele : lst){
            if(ele >= maxVal){
                secMax = maxVal;
                maxVal = ele;
            }
        }
        System.out.println("Second largest element is: " + secMax);
    }
}