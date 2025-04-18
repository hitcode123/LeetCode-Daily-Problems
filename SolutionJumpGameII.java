import java.util.Arrays;

class SolutionJumpGameAnswer {

    public int calculation(int [] nums,int j,int[] dp){

        int comp=Integer.MAX_VALUE;

        if(j==nums.length-1){
            return 0;
        }

        if( dp[j]!=-1){
            return dp[j];
        }

        for(int k=1;k<=nums[j];k++){

            if(j+k<nums.length){
                int val=calculation(nums,j+k,dp);
                if(val!=Integer.MAX_VALUE){
                comp=Math.min((1+val),comp);
                }
            }
        }
        return dp[j]=comp;
    }
    public int jump(int[] nums) {

        if(nums.length==1){
            return 0;
        }
        int dp[]= new int[nums.length+1];
        Arrays.fill(dp, -1);
        calculation(nums,0,dp);
        return dp[0];

    }
}


 public class SolutionJumpGameII {
    public static  void main(String[] args) {

        SolutionJumpGameAnswer obj=new SolutionJumpGameAnswer();
        int[] arr={2,3,0,1,4};
//        int[] arr={2,3,1,1,4};
//        int[] arr={1,2,1,1,1};
//        int[] arr={2,1};
        System.out.println(obj.jump(arr));

    }

}