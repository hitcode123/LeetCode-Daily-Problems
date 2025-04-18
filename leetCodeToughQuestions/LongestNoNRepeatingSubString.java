package leetCodeToughQuestions;
import java.util.*;


class Solution {
    int lengthOfLongestSubstring(String s) {

        if(s.length()==0){
            return s.length();
        }
        Map<Character, Integer> charMap = new HashMap<>();
        int low=0;
        int high=0;
        int calMaxLength= Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(charMap.containsKey(s.charAt(i))){

                while(s.charAt(i)!=s.charAt(low)){
                    charMap.put(s.charAt(low),0);
                    low++;
                }
                charMap.put(s.charAt(low),0);
                low++;
            }
            charMap.put(s.charAt(i),1);
            high=i;
            calMaxLength=Math.max(high-low+1,calMaxLength);

        }
        if(calMaxLength== Integer.MIN_VALUE){
            return 0;
        }
        return calMaxLength;

    }
}



public class LongestNoNRepeatingSubString {
    public static void main(String[] args) {

        Solution out=new Solution();
        System.out.println(out.lengthOfLongestSubstring("tmmzuxt"));

    }
}
