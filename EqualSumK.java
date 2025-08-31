import java.util.ArrayList;
import java.util.List;

public class EqualSumK {
        public boolean canPartitionKSubsets(int[] nums, int k) {

            int sum = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }

            int perSum = sum / k;
            List<Integer> track = new ArrayList<>();
            while (k > 0) {
                int bitMask = perSum;
                for (int i = 0; i < n; i++) {
                    if (!track.contains(i)) {
                        int temp = bitMask;
                        bitMask = bitMask - nums[i];
                        if (bitMask < temp) {
                            track.add(i);
                            if (bitMask == 0) {
                                break;
                            }
                        } else {
                            bitMask = temp;
                        }
                    }
                }

                if (bitMask != 0) {
                    return false;
                }
                k -= 1;
            }

            return true;


        }

        public static void main(String[] args){
            EqualSumK equalSumK=new EqualSumK();
            equalSumK.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1},4);

        }
}
