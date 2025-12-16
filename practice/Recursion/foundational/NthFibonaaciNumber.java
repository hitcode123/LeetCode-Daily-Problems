package practice.Recursion.foundational;


/*

so the recurrence relation will be
f(n)  { 0 or 1 --> n
        n>1 f(n-1)+f(n-2)
 */
public class NthFibonaaciNumber {

    int calFibonacciSeries(int n){
        if(n==1||n==0){
            return n;
        }

        return calFibonacciSeries(n-1)+calFibonacciSeries(n-2);
    }

//    0 1 1 2 3 5 8 13
    public static void main(String[] args){
        NthFibonaaciNumber nthFibonaaciNumber=new NthFibonaaciNumber();
        int result=nthFibonaaciNumber.calFibonacciSeries(7);
        System.out.println("Since the result of nth fibonnaci number is "+result);

    }
}
