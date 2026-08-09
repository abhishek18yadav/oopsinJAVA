import java.util.*;

class Storing{
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("One", 1);
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Two", "Three","Four", "Four"));
        for(String key: list){
            map.merge(key,1,(oldValue , newValue)-> oldValue + newValue);
        }
        
        System.out.println("LinkedHashMap: " + map);
    }
}