package leetcodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionForThis {

    public static void sortByIndex(int [][] colMeet){
        Arrays.sort(colMeet,(a, b)->Integer.compare(a[0],b[0]));
    }
    public int countDays(int days, int[][] meetings) {
        sortByIndex(meetings);
        int n=meetings.length;
        int low=meetings[0][0];
        int high=meetings[0][1];
        List<List<Integer>> arrayLList=new ArrayList<>();

        for(int i=1;i<n;i++){
            if(high>=meetings[i][0]) {
                if(high<meetings[i][1]){
                high = meetings[i][1];
                }

            }else if(high<meetings[i][0]){
                arrayLList.add(Arrays.asList(low,high));
                low=meetings[i][0];
                high=meetings[i][1];
            }

        }
        arrayLList.add(Arrays.asList(low,high));



        int count=0;
        n=arrayLList.size();
        for(int i=0;i<n;i++){

            if(i==0){
                if(arrayLList.get(0).get(0)-1>0){
                    count+=arrayLList.get(0).get(0)-1;
                }

            }
            if(i<n-1){
                count+=arrayLList.get(i+1).get(0)-arrayLList.get(i).get(1)-1;
            }else{
                if((days-arrayLList.get(i).get(1))>=0){
                    count+=days-arrayLList.get(i).get(1);
                }
            }
        }

        return count;
    }
}

class SolutionMaxMeeting{
    public static void main(String[] args){
        SolutionForThis obj=new SolutionForThis();
//        [3,4],[4,8],[2,5],[3,8]
        int[][] arr= new int[][]{{5,7},{1,3},{9,10}};
        System.out.println(obj.countDays(10,arr));
    }
}


