package leetcodeQuestions;

class SolutionForDivideAndConquer {

    int maxValue= Integer.MIN_VALUE;

    public int calulateMaxSubArray(int[] arr,int low,int high,int sum){

        if(high==low){
            return arr[low];
        }

        int right=0;
        int left=0;
        while(low<high){
            int mid=(low+high)/2;
            left=calulateMaxSubArray(arr,low,mid,sum);
            right=calulateMaxSubArray(arr,mid+1,high,sum);
            sum+=left;
            if(sum<0){
                sum=0;
            }
            sum+=right;
            if(sum<0){
                sum=0;
            }
            maxValue=Math.max(maxValue,sum);
            return sum;
        }


        sum+=left;
        if(sum<0){
            sum=0;
        }
        sum+=right;
        if(sum<0){
            sum=0;
        }
        maxValue=Math.max(maxValue,sum);
        return sum;



    }


    public int maxSubArray(int[] nums) {

        int val=calulateMaxSubArray(nums,0,nums.length-1,0);
        return maxValue != Integer.MIN_VALUE ? maxValue : val;
    }
}


public class MaximumSubArrayUsingMergeSort {

    public static void main(String[] args){

        int [] arr= new int[]{
                -2,1,-3,4,-1,2,1,-5,4
        };
        SolutionForDivideAndConquer a = new SolutionForDivideAndConquer();
        //print this
        System.out.println(a.maxSubArray(arr));


    }
}
