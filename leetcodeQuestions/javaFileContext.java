package leetcodeQuestions;

import java.util.Set;


import  java.util.*;
class SolutionContest{

    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int xorCal=0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0,j=i+1;i<nums.length-2&&j<nums.length-1;){


            for(int k=j+1;k<nums.length;k++){

                xorCal=nums[i]^nums[j]^nums[k];
                set.add(xorCal);
            }
            if(j==nums.length-2){
                i++;
                j=i+1;
            }else{
                j++;

            }

        }

        return set.size();
    }
}

public class javaFileContext {
    public static void main(String[] args){
        int arr[]= new int[]{503,161,1144,279,513};
        SolutionContest solutionContest=new
                SolutionContest();
        int a=solutionContest.uniqueXorTriplets(arr);
        System.out.println(a);

    }
}
