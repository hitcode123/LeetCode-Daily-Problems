package leetcodeQuestions;

class CountingBitsSolution {
    public int[] countBits(int n) {
        int dp[]= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            if((i&i-1)==0){
                dp[i]=1;
            }else{
                dp[i]=1+dp[(int)(i-Math.pow(2,(int)(Math.log(i)/Math.log(2))))];
            }

        }
        return dp;
    }
}

public class CountingBits{
     public static  void main(String[] args){
         int arr[]=new int[]{

         };
         CountingBitsSolution solution= new CountingBitsSolution();
         System.out.println(solution.countBits(5));


     }
}
