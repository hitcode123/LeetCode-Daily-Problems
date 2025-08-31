package leetCodeContestQuestions;

public class CountEqualOperation {
        public boolean canMakeEqual(int[] nums, int k) {
            int countOne=0;
            int countMOne=0;
            int n=nums.length;
            for(int i=0;i<n;i++){
                if(nums[i]==-1){
                    countMOne++;
                }else{
                    countOne++;
                }
            }
            if(countOne%2==1&&countMOne%2==1){
                return false;
            }
            int countOp=0;
            int countOpN=0;
            int start1=-1;
            int start=-1;

            for(int i=0;i<n;i++){
                if(countOne%2==0){
                    if(nums[i]==1&&start1==-1){
                        start1=i;
                    }else if(nums[i]==1&&start1!=-1){
                        countOp+=(i-start1);
                        start1=-1;
                    }

                }
                if(countMOne%2==0){
                    if(nums[i]==-1&&start==-1){
                        start=i;
                    }else if(nums[i]==-1&&start!=-1){
                        countOpN+=(i-start);
                        start=-1;
                    }
                }
            }

            if(k>=countOp||k>=countOpN){
                if(k>=countOp&&countOne%2==0&&countOne!=0){
                    return true;
                }else if(k>=countOpN&&countMOne%2==0&&countMOne!=0){
                    return true;
                }
            }

            return false;

        }

        public static void main(String[] args){
            CountEqualOperation countEqualOperation=new CountEqualOperation();
            int[] arr= new int[]{-1,1,1,-1,-1,-1,1,1,-1,-1,1,1,1,1,-1,-1};
            countEqualOperation.canMakeEqual(arr,3);
        }
}
