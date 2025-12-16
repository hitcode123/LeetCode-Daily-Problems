package A2ZSheet;

public class Count1Matrix {

    public int[] findIndexAndCount(int[][] arr){
        int m=arr.length;
        int n=arr[0].length;
        int ansInd=0;
        int finalCount=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
           int index=calculateFirstOccurence(arr[i]);
           if(n-index>finalCount){
               ansInd=i;
               finalCount=Math.max(finalCount,n-index);
           }

        }

        return new int[]{ansInd,finalCount};
    }

    private int  calculateFirstOccurence(int[] arr) {
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int mid=(high+low)/2;
            if(arr[mid]==0){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }

    public static void main(String[] args){
        int [][] arr=new int[][]{
                {0, 1},
                {1,1},
                {1,1}
        };

        Count1Matrix   count1Matrix= new Count1Matrix();
        int[] ans=count1Matrix.findIndexAndCount(arr);
        System.out.println("hence the answer is");
        for(int i:ans){
            System.out.println("index and count "+i+" ");

        }

    }
}
