package A2ZSheet;

public class lowerBound {
    public int findLowerIndex(int [] arr,int k){
        int i=0;
        int j=arr.length-1;
        int n=arr.length;
        while(i<j){
            int mid=(i+j)/2;
           if(arr[mid]>=k){
               j=mid;
           }else if(arr[mid]<k) {
               i = mid + 1;
           }
        }
        return i;
    }
    public static void main(String[] args){
      int[] arr=new int[]{1,1,1,1,1};
      lowerBound  bound=new lowerBound();
      bound.findLowerIndex(arr,1);
    }
}
