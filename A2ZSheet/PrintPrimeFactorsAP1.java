package A2ZSheet;

import java.util.ArrayList;
import java.util.*;

public class PrintPrimeFactorsAP1 {
    public static List<Integer> tempList;
    public List<Integer> countPrimeFactors(int n){
        tempList=new ArrayList<>();
        while(n%2==0){
            n/=2;
            tempList.add(2);
        }

        for(int i=3;i*i<n;i+=2){
            while(n%i==0){
                n/=i;
                tempList.add(i);
            }
        }

        if(n>2){
            tempList.add(n);
        }
        return tempList;
    }
    public static void main(String[] args){
        PrintPrimeFactorsAP1 obj=new PrintPrimeFactorsAP1();
        obj.countPrimeFactors(4650);
        for(Integer i: tempList){
            System.out.println(i+ " ");
        }
        System.out.println();
    }

}
