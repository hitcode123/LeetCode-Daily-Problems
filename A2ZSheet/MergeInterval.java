package A2ZSheet;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {

    public int[][] findInterval(int[][]  arr){
        int n=arr.length;
        int[] cur=arr[0];
        List<int[]> tempAns=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(cur[1]>=arr[i][0]){
                cur[1]=Math.max(cur[1],arr[i][1]);
            }else{
                tempAns.add(cur);
                cur=arr[i];
            }
        }
        tempAns.add(cur);
        return  tempAns.toArray(new int[tempAns.size()][]);
    }
    public static void main(String[] args){

        MergeInterval mergeInterval=new MergeInterval();
        int[][] ans=mergeInterval.findInterval(new int[][]{{1,3},{1,3},{1,3},{1,3},{2,6},{8,10},{15,18}});
        for(int[] one:ans){
            System.out.println(one[0]+ " "+one[1]);
        }
    }
}
