package A2ZSheet;

public class XorCountK {

    public int countXorSubSequence(int[] arr,int k){
        //first approach
        int n=arr.length;
        int xorSum=0;

        for(int i=0;i<n;i++){
            int curXor=0;
            for(int j=i;j<n;j++){
                curXor^=arr[j];
                if(curXor==k){
                    xorSum++;
                }
            }
        }

        return xorSum;
    }
    public static void main(String[] args){
        XorCountK xorCountK=new XorCountK();
        int ans=xorCountK.countXorSubSequence(new int[]{
                5, 6, 7, 8, 9        },5);
        System.out.println(ans);
    }
}
