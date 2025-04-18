import java.util.Arrays;
import java.util.Scanner;

public class countThePizzas {


    public static long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        long sum=0;
        int count=pizzas.length-1;
        int oc,ec;
        if(((count+1)/4)%2==1) {
            oc = (count + 1) / 8 + 1;
            ec = (count + 1) / 8;
        }else{
            ec = (count + 1) / 8;
            oc = (count + 1) / 8;
        }

        while(oc>0) {
            sum+=pizzas[count];
            count--;
            oc--;
        }
        while(ec>0) {
            sum+=pizzas[count-1];
            count-=2;
            ec--;
        }
        return sum;

    }
    public static void main(String [] args)
    {
//          int n;
//          Scanner sc = new Scanner(System.in);
//          n=sc.nextInt();
          int[] arr={2,1,1,1,1,1,1,1};


//                  {2,2,3,5};
//                  {1,2,3,4,5,6,7,8,9,10,11,12};

//                  {3,4,2,4,2,4,2,2,4,5,3,2,1,2,1,1};

//        new int[n];
//          for(int i=0;i<n;i++)
//          {
//              int value=sc.nextInt();
//              arr[i]=value;
//          }
          //[3,4,2,4,2,4,2,2,4,5,3,2,1,2,1,1]
          long ans=maxWeight(arr);
          System.out.println("Our answer for the pizza pronlem is:"+ ans);
    }
}
