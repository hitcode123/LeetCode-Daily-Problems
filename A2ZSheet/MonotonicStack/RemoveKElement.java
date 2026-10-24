package A2ZSheet.MonotonicStack;

import java.util.Stack;

public class RemoveKElement {
        public String removeKdigits(String num, int k) {
            int n=num.length();
            Stack<Integer> st=new Stack<>();
            int[] nearestMax=new int[n];
            int[] maxTillNow=new int[n];
            for(int i=0;i<n;i++){
                int current=(int)(num.charAt(i)-'0');
                while(!st.isEmpty()&&st.peek()<current){
                    st.pop();
                }
                nearestMax[i] = st.isEmpty() ? -1 : st.peek();
                st.add(current);
            }
            int maxi=Integer.MIN_VALUE;
            int ref=-1;
            int count=0;
            for(int i=0;i<n;i++){
                int current=(int)(num.charAt(i)-'0');
                if(maxi<current){
                    maxi=current;
                    ref=i;
                }
                maxTillNow[i]=ref;
            }
            int indexToIgnore=-1;
            for(int i=k;i<n-k;i++){
                if(nearestMax[i]!=-1){
                    indexToIgnore=maxTillNow[i];
                    break;
                }else{
                    continue;
                }
            }
            String ans="";

            for(int i=0;i<n;i++){
                if(indexToIgnore==i){
                    while(i<n&&(indexToIgnore==i||count<k)){
                        i++;
                        count++;
                    }
                    while(i<n&&num.charAt(i)=='0'){
                        i++;
                    }
                }
                if(i<n){
                    ans=ans+num.charAt(i);

                }
            }

            return ans;
        }
    public static void main(String[] args){
            String number="11541000892";
            RemoveKElement removeKElement=new RemoveKElement();
            removeKElement.removeKdigits(number,7);
    }
}
