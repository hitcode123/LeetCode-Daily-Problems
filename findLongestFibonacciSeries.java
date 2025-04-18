import java.util.HashMap;
import java.util.Map;


 class  SolutionFindLongestFibonacciSeries{
    public int lenLongestFibSubseq(int[] arr) {

        int n=arr.length;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(arr[i],i);
        }
        int countLength=0;
        int maxCount=(int)-(1e8);
        int prevCount=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int count1=arr[i];
                int count2=arr[j];
                if(mp.containsKey(count1+count2)){
                    while(mp.containsKey(count1+count2)){
                        countLength++;
                        int temp=count2;
                        count2=arr[mp.get(count1+count2)];
                        count1=temp;
                    }

                }
                maxCount=Math.max(maxCount,countLength+1);
                countLength=0;

            }

        }
        return maxCount;


    }

}
public class findLongestFibonacciSeries {

    public static void main(String[] args){
    SolutionFindLongestFibonacciSeries obj= new SolutionFindLongestFibonacciSeries();
    int[] arr = {1,2,3,4,5,6,7,8};
    System.out.println(obj.lenLongestFibSubseq(arr));


    }
}
