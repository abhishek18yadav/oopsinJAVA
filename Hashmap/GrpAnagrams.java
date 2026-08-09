import java.util.*;

class GrpAnagrams{
    public static void main(String[] args){
        String[] words = {"tan", "nat", "bat", "tab", "eat", "tea"};
        Map<String, List<String>> map = new HashMap<>();
        for(String w: words){
            char[] ch = w.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            map.merge(key , new ArrayList<>(Arrays.asList(w)),(oldValue, newValue)->{oldValue.addAll(newValue); return oldValue;});

        }
        System.out.println(map);
    }
}