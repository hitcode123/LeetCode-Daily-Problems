package A2ZSheet.StackCoversions;

import java.util.*;

public class PostFixToPreFix {
    public static void main(String[] args) {
            String exp="abc*+d-";
            String ans=findSolutionForPostFixToPreFix(exp);
            System.out.println("Hence the Output for the given question is"+ans);
    }

    private static String findSolutionForPostFixToPreFix(String exp) {
        Stack<String> st=new Stack<>();
        int n=exp.length();
        for(int i=0;i<n;i++){
            char present=exp.charAt(i);
            if(Character.isLetterOrDigit(present)){
                st.add(String.valueOf(present));
            }else{
                String later=st.pop();
                String first=st.pop();
                String finalString=String.valueOf(present)+first+later;
                st.push(finalString);
            }
        }

        return st.peek();
    }
}
