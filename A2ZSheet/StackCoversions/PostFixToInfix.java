package A2ZSheet.StackCoversions;

import java.util.Stack;

public class PostFixToInfix {
    public static void main(String[] args){
        String exp="ab+c*";
        String ans=findSolutionForPostFixToInfix(exp);

        System.out.println("hence the output for the given question is"+ans.toString());
    }

    private static String findSolutionForPostFixToInfix(String exp) {
        int n=exp.length();
        Stack<String> st=new Stack<>();

        for(int i=0;i<n;i++){
            char present=exp.charAt(i);
            if(Character.isLetterOrDigit(present)){
                st.add(String.valueOf(present));
            }else {
                String first = st.pop();
                String second = st.pop();
                st.add("(" + second + String.valueOf(present) + first + ")");
            }
        }



        return st.peek();
    }
}
