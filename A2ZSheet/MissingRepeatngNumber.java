package A2ZSheet;

public class MissingRepeatngNumber {

    public static int RepeatingNumber(int[] arr){
        int rM=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            rM^=arr[i];
            rM^=i+1;
        }

        int findRightMost=rM&-rM;
        int repeating=0;
        int missing=0;
        n=arr.length;
        for(int i=0;i<n;i++){
            if((findRightMost&arr[i])!=0){
                repeating^=arr[i];
            }else{
                missing^=arr[i];
            }
            int x=i+1;
            if ((findRightMost & x) != 0) {
                repeating ^= (i + 1);
            } else {
                missing ^= (i + 1);
            }

        }
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==repeating){
                count++;
            }
        }
        if(count==0){
            return missing;
        }else{
            return repeating;
        }
    }

    public  static void main(String[] args){

        int[] arr=new int[]{2,2};
        RepeatingNumber(arr);

    }
}
