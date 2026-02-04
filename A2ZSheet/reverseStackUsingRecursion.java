package A2ZSheet;

import java.util.Scanner;
import java.util.Stack;

public class reverseStackUsingRecursion {


    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int top=st.peek();
        st.pop();
        reverseStack(st);
        putNumberAtEnd(st,top);
    }

    private static void putNumberAtEnd(Stack<Integer> st, int top) {
        if(st.isEmpty()){
            st.push(top);
        }
        int peek=st.peek();
        st.pop();
        putNumberAtEnd(st,top);
        st.push(peek);
    }

    public static void main(String[] args){
        Stack<Integer> st=new Stack<>();

        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of input");
        int counter=sc.nextInt();

        while(counter>0){
            int temp=sc.nextInt();
            st.push(temp);
            counter--;
        }


        System.out.println("Hence the Output is now as follows:");

        while (!st.isEmpty()){
            System.out.print(st.peek()+ " ");
            st.pop();
        }
    }
}
