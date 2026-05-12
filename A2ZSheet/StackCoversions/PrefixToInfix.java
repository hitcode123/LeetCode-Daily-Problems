package A2ZSheet.StackCoversions;

import java.util.Stack;

public class PrefixToInfix {
    public String convertPrefix(String test){
        String ans= "";
        int n=test.length();
        Stack<String> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            char current=test.charAt(i);
            if(Character.isLetterOrDigit(current)){
                st.add(String.valueOf(current));
            }else{
                String c1=st.pop();
                String c2=st.pop();
                st.add("("+c1+current+c2+")");
            }
        }
        return st.peek();
    }
    public static  void main(String[] args){
        String s="+A*BC";
        PrefixToInfix obj=new PrefixToInfix();
        String ans=obj.convertPrefix(s);
        System.out.println(ans);
    }
}
