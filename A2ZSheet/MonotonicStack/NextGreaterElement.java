package A2ZSheet.MonotonicStack;

import java.util.Stack;

public class NextGreaterElement {

    public  int[] findSolutionForNextGreaterElement(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            int current=arr[i];
            if(st.isEmpty()){
                res[i]=-1;
                st.add(arr[i]);
                continue;
            }else{
                if(current>st.peek()){
                    while(!st.isEmpty()&&current>st.peek()){
                        st.pop();
                    }
                }
                if(st.isEmpty()){
                    res[i]=-1;
                }else{
                    res[i]=st.peek();
                }
                st.add(current);
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr=new int[]{6, 8, 0, 1, 3};
        NextGreaterElement obj=new NextGreaterElement();
        int[] res=obj.findSolutionForNextGreaterElement(arr);
        System.out.println("Hence the Output Array");
        for(int a:res){
            System.out.print(a+" ");
        }

    }
}
