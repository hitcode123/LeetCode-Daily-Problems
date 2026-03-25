package A2ZSheet.StackCoversions;

import java.util.Stack;

public class InfixToPostFix {

    public int precedence(char x){
        if(x=='^'){
            return 5;
        }
        else if(x=='*'||x=='/') {
            return 4;
        }else if(x=='+'||x=='-'){
            return 3;
        }
        return -1;
    }

    public String ans(String ans,String real){
        int n=real.length();
        Stack<Character> st=new Stack<>();
        StringBuilder ansBuilder = new StringBuilder(ans);
        for(int i = 0; i<n; i++){
            char present=real.charAt(i);
            if(Character.isLetterOrDigit((present))){
                ansBuilder.append(present);
            } else if(present==')'){
                while(st.peek()!='('){
                    ansBuilder.append(st.peek());
                    st.pop();
                }
                st.pop();
            }else if(present=='('){
                st.add('(');
            }else{
                while(!st.isEmpty()&&precedence(present)<=precedence(st.peek())){
                    ansBuilder.append(st.peek());
                    st.pop();
                }
                st.add(present);
            }


        }
        while (!st.isEmpty()) {
            ansBuilder.append(st.pop());
        }
        ans = ansBuilder.toString();
        return ans;
    }
    public static void main(String[] args){
        String infix="a+b*(c^d-e)^(f+g*h)-i";
        InfixToPostFix objResult=new InfixToPostFix();
        System.out.println(objResult.ans("",infix));
    }
}
