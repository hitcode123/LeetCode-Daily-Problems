package A2ZSheet;

public class MaximumProductSubArray {
        public int maxProduct(int[] nums) {

            int n=nums.length;
            int ansMax=Integer.MIN_VALUE;
            int curPositive=1;
            int curNegative=1;
            for(int i=0;i<n;i++){
                if(nums[i]>0){
                    curNegative=Math.min(curNegative*nums[i],nums[i]);
                    curPositive=Math.max(curPositive*nums[i],nums[i]);
                }else{

                    curNegative=Math.min(curPositive*nums[i],nums[i]);
                    curPositive=Math.max(curNegative*nums[i],nums[i]);
                }
                ansMax=Math.max(Math.max(curPositive,curNegative),ansMax);
            }

            return ansMax;

        }

        public static void main(String[] args){
            MaximumProductSubArray maximumProductSubArray=new MaximumProductSubArray();
            maximumProductSubArray.maxProduct(new int[]{-2,0,-1});
        }

}
