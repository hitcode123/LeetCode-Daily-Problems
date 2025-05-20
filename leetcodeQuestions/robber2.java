package leetcodeQuestions;

class SolutionRobber2 {
      int[] dp;
      int getMaxValueFromRob(int index,int [] vis,int [] nums,int sum,int[] dp,int end){
          if(index>=end||(vis[(index+1)%nums.length])!=-1){
              return sum;
          }
          if(dp[index]!=-1){
              return sum+dp[index];
          }
          int value1= Integer.MIN_VALUE;


          int value2=getMaxValueFromRob(index+1,vis,nums,sum,dp,end);
          if((vis[(index+1)%nums.length])==-1) {
              vis[index] = 1;
              value1 = getMaxValueFromRob(index + 2, vis, nums, sum + nums[index],dp,end);
              vis[index] = -1;

          }

          return dp[index]=Math.max(value2,value1);

      }
      public int rob(int[] nums) {
          int vis[]= new int[nums.length];
          dp=new int[nums.length];
          for(int i=0;i<nums.length;i++){
              vis[i]=-1;
              dp[i]=-1;
          }
          int [] nums1=new int[nums.length-1];
          int [] nums2=new int[nums.length-1];

          int max1= getMaxValueFromRob(0,vis,nums,0,dp,nums.length-1);
          int max2= getMaxValueFromRob(1,vis,nums,0,dp,nums.length);
          return Math.max(max1,max2);

      }


}

public   class robber2 {

    public static void main(String[] args){

        SolutionRobber2 solution= new SolutionRobber2();
        int[] arr={1,2,3};
        System.out.println(solution.rob(arr));


    }

}
