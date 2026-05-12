package leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubString {

        public static List<List<String>> ans;
        public  boolean checkPalindrome(String input) {

            int left = 0;
            int right = input.length() - 1;

            while (left < right) {
                if (input.charAt(left) != input.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
        public void formListString(String s,int st,int e,List<String> temp){
            if(st==e){
                ans.add(new ArrayList<>(temp));
            }

            for(int i=1;i<=e-st;i++){
                String tempS=s.substring(st,st+i);
                if(checkPalindrome(tempS)){
                    temp.add(tempS);
                    formListString(s,st+i,e,temp);
//                    temp.removeAll();
                }
            }
        }
        public List<List<String>> partition(String s) {
            ans = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            formListString(s, 0, s.length(), temp);
            return ans;

        }

        public static  void main(String[] args){
            PalindromicSubString palindromicSubString=new PalindromicSubString();
            palindromicSubString.partition("a");
            for(List<String> s:ans){
                for(String st:s){
                    System.out.print(st+" ");
                }
                System.out.println();

            }


    }
}
