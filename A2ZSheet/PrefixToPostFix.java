package A2ZSheet;

import java.util.Stack;

public class PrefixToPostFix {
    public String convertPrefixToPostFix(String exp){
        Stack<String> st=new Stack<>();
        int n=exp.length();
        for(int i=n-1;i>=0;i--){
            char temp=exp.charAt(i);
            if(Character.isLetterOrDigit(temp)){
                st.add(String.valueOf(temp));
            }else{
                String s1=st.pop();
                String s2=st.pop();
                st.add(s1+s2+temp);
            }
        }
        return st.peek();
    }
    public static void main(String[] args){
        String givenString="*+ab-cd";
        PrefixToPostFix ptp=new PrefixToPostFix();
        String ans=ptp.convertPrefixToPostFix(givenString);
        System.out.println(ans);

    }
}
