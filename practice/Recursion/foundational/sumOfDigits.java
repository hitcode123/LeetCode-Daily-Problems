package practice.Recursion.foundational;

public class sumOfDigits {
    /*
    Recurrence Relation
               {
    f(n) ---->   n==0 -> 0
                 nth digit + f(n/10)
               }

     where f(n) is the function for calculating for f(n) number
     */
    public int calSumOfDigits(int n){
        if(n==0){
            return 0;
        }

        return n%10+calSumOfDigits(n/10);
    }
    public static void main(String[] args){
         sumOfDigits sumOfDigits=new sumOfDigits();
         int result=sumOfDigits.calSumOfDigits(345);
         System.out.println("hence the output for the addition of digits of a number is "+result);
    }
}
