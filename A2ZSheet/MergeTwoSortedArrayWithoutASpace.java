package A2ZSheet;

public class MergeTwoSortedArrayWithoutASpace {
    public void findSolutionForSorting(int[] arr1,int[] arr2){
        int m=arr1.length;
        int n=arr2.length;

        int gap= (m+n)/2+(m+n)%2;
        while(gap>0){
            int i=0;
            int j=i+gap;
            while(j<m+n){
                if(i<m&&j>=m){
                   swapIfGreater(arr1,arr2,i,j-m);

                }else if(i>=m&&j>=m){
                    swapIfGreater(arr2,arr2,i-m,j-m);

                }else{
                    swapIfGreater(arr1,arr1,i,j);
                }
                i++;
                j++;
            }
            if(gap==1) break;
            gap=gap/2+gap%2;
        }

    }

    private void swapIfGreater(int[] arr1, int[] arr2, int i, int i1) {
        if(arr1[i]>arr2[i1]){
            int temp=arr1[i];
            arr1[i]=arr2[i1];
            arr2[i1]=temp;
        }
    }

    public static void main(String[] args){

        MergeTwoSortedArrayWithoutASpace mergeTwoSortedArrayWithoutASpace=new MergeTwoSortedArrayWithoutASpace();
        int[] arr1=new int[]{
                4,5,6,8,11,12
        };
        int[] arr2=new int[]{
                1,2,3
        };
        mergeTwoSortedArrayWithoutASpace.findSolutionForSorting(arr1,arr2);

        for(int  i=0;i<6;i++){
            System.out.print(arr1[i]+" ");
        }
        for(int  i=0;i<3;i++){
            System.out.print(arr2[i]+" ");
        }

        System.out.println();


    }
}
