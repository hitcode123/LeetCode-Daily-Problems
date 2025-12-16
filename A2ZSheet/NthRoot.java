package A2ZSheet;

public class NthRoot {

    public int calN(int n ,int k){

        if(k==0){
            return 1;
        }
        int x=calN(n,k/2);
        if(k%2==1){
            return n*x*x;
        }else{
           return x*x;
        }
    }
    public int NRoot(int n,int k){
        int low=1;
        int high=n;
        while(low<=high){
            int mid=(low+high)/2;
            int currentK=calN(mid,k);
            if(currentK==n){
                return mid;
            } else if(currentK>n){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        NthRoot nthRoot=new NthRoot();
        int x= nthRoot.NRoot(69,4);
        System.out.println("hence the answer is "+x);
    }
}
