package A2ZSheet;

public class SearchInRotatedArray2 {
    boolean binarySearch(int low,int high,int[] nums,int k){

        //4, 5, 6, 7, 0, 1, 2--->0-->4
        //4, 5, 6, 7, 0, 1, 2-->3-->-1
        // 4, 5, 6, 7, 0, 1, 2-->5
        while(low<=high){
            int mid=(high+low)/2;
            if(nums[mid]==k){
                return true;
            }else if(nums[mid]>k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
    public boolean search(int[] nums, int k) {
        int n=nums.length;
        int current=nums[0];
        int index=-1;
        for(int i=1;i<n;i++){
            if(current>nums[i]){
                index=i;
                break;
            }else{
                current=nums[i];
            }
        }
        current=index;
        if(current==-1){
            current=n-1;
            return binarySearch(0,current,nums,k);
        }

        int low1=0;
        int high=current-1;
        boolean track=binarySearch(0,current-1,nums,k);
        if(!track){
            return binarySearch(current,n-1,nums,k);
        }else{
            return track;
        }
    }

    public static void main(String[] args) {
        SearchInRotatedArray2 solutionRotatedArray = new SearchInRotatedArray2();
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        solutionRotatedArray.search(nums, 0);
    }

}
