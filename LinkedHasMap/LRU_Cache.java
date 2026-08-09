import java.util.*;

class LRU_Cache{
    static void insert(HashMap<Integer, Character> map, int key, char value){
       if(map.size() >= 3){
           int firstKey = map.keySet().iterator().next();
           map.remove(firstKey);
       }
       map.put(key, value);
    }
    static void display(HashMap<Integer,Character>map){
        for(Map.Entry<Integer,Character> ele : map.entrySet()){
            System.out.print(ele.getKey() + " : " + ele.getValue() + " ");
        }
    }
    public static void main(String[] main){
        HashMap<Integer, Character> map = new HashMap<>(3);
        insert(map, 1, 'a');
        insert(map, 2, 'b');
        insert(map, 3, 'c');
        insert(map, 4, 'd');
        display(map);
    }
}