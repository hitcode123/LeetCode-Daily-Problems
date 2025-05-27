package leetcodeQuestions;

import java.util.*;

public class MaximumNonInterSectingString {
    public int maxSubstrings(String s) {
        Deque<Integer>[] last = new LinkedList[26];
        for (int k = 0; k < 26; k++) {
            last[k] = new LinkedList<>();
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            dp[i + 1] = dp[i];
            for (int j : last[c]) {
                if (i - j + 1 >= 4) {
                    dp[i + 1] = Math.max(dp[i + 1], dp[j] + 1);
                }
            }
            last[c].addLast(i);
            if (last[c].size() > 4) {
                last[c].removeFirst();
            }
        }
        return dp[n];
//        int[] word=new int[26];
////        int n=words.length();
////        List<List<Integer>> list = new ArrayList<>();
////        for(int i=0;i<n-3;i++){
////            for(int j=i+3;j<n;j++){
////                if(words.charAt(i)==words.charAt(j)&&(j-i+1)>=4){
////                    List<Integer> temp=new ArrayList<>();
////                    temp.add(i);
////                    temp.add(j);
////                    list.add(temp);
////                }
////            }
////
////        }
////
////        list.sort(Comparator.comparingInt(l -> l.get(1)));
////        int start=0;
////        int ans=0;
////        int prev=-1;
////        for(List<Integer> l:list){
////            if(l.get(0)>prev){
////                ans++;
////                prev=l.get(1);
////            }
////        }
////
////        return ans;
////    }
    }
    public static void main(String[] args){
        MaximumNonInterSectingString maximumNonInterSectingString=new MaximumNonInterSectingString();
        System.out.println(maximumNonInterSectingString.maxSubstrings("abcdaefgheijkli"));
    }
}
