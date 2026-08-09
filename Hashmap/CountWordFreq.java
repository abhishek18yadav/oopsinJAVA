import java.util.*;

class CountWordFreq{
    public static void main(String[] args){
        String str = "This is a sample string. This string is for testing.";
        HashMap<String, Integer> wordCount = new HashMap<>();
        for(String word : str.toLowerCase().split("\\W+")){
            wordCount.merge(word,1,(oldValue , newValue)-> oldValue + newValue);
        }
        System.out.println(wordCount);
    }
}