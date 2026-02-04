package A2ZSheet;
import java.util.*;
 class sortStackUsingRecursion{
    public static  void sortStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }

        int top=st.peek();
        st.pop();
        sortStack(st);
        Stack<Integer> tempStack=new Stack<>();
        while(!st.isEmpty()&&top<st.peek()){
            tempStack.push(st.peek());
            st.pop();
        }
        st.push(top);
        while(!tempStack.isEmpty()) {
            st.push(tempStack.peek());
            tempStack.pop();
        }
    }
    public static void main(String[] args){
         Stack<Integer> st=new Stack<>();
         int counter;
         Scanner sc=new Scanner(System.in);
         counter=sc.nextInt();

         while(counter>0){
             int tempNumber=sc.nextInt();
             st.push(tempNumber);
             counter--;
         }

         sortStack(st);
         while(!st.isEmpty()){
             System.out.print(st.peek()+" ");
             st.pop();
         }
    }
}
