package A2ZSheet;

import java.util.HashMap;
import java.util.Map;

public class XorCountK {

    public int countXorSubSequence(int[] arr,int k){
        //first approach
        int n=arr.length;
        int xorSum=0;

//        for(int i=0;i<n;i++){
//            int curXor=0;
//            for(int j=i;j<n;j++){
//                curXor^=arr[j];
//                if(curXor==k){
//                    xorSum++;
//                }
//            }
//        }

        //second way
        Map<Integer,Integer> mp=new HashMap<>();
        mp.putIfAbsent(0,1);
        int xorCurrent=0;
         for(int i=0;i<n;i++){
             xorCurrent^=arr[i];
             if(mp.containsKey(xorCurrent^k)){
                 xorSum+=mp.get(xorCurrent^k);
             }

             if(mp.containsKey(xorCurrent)){
                 mp.put(xorCurrent,mp.getOrDefault(xorCurrent,0)+1);

             }else{
                 mp.putIfAbsent(xorCurrent,1);
             }
         }

        return xorSum;
    }
    public static void main(String[] args){
        XorCountK xorCountK=new XorCountK();
        int ans=xorCountK.countXorSubSequence(new int[]{
                4, 2, 2, 6, 4       },6);
        System.out.println(ans);
    }
}
