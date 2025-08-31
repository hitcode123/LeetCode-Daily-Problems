package leetCodeToughQuestions;

import java.util.ArrayList;
import java.util.List;

public class WildCardMatching {

    public boolean wildAns(String s1,String s2,int i,int j,int m, int n,List<List<Integer>> map){
        boolean ans1=true;
        boolean ans2=true;
        if(i==m&&j==n){
            return true;
        }else if(i<m&&j==n){
            if(s2.charAt(j-1)=='*'){
                return true;
            }else{
                return false;
            }
        }else if(i==m&&j<n){
            if(s2.charAt(n-1)=='*'){
                return true;
            }else{
                return false;
            }
        }

        if(s1.charAt(i)==s2.charAt(j)||s2.charAt(j)=='?'){
            ans1=wildAns(s1,s2,i+1,j+1,m,n,map);
        }else if(s2.charAt(j)=='*'){
            while(j<n&&s2.charAt(j)=='*'){
                j++;
            }
            if(j<n&&s2.charAt(j)-'a'>=0&&s2.charAt(j)-'a'<26){
                List<Integer> temp=j<n?map.get(s2.charAt(j)-'a'):new ArrayList<>();
                for(Integer tempInt:temp){
                    if(tempInt>=i){
                        ans2=wildAns(s1,s2,tempInt,j,m,n,map);
                    }
                }
            }else{
                while(i<m&&!wildAns(s1, s2, i, j, m, n, map)){
                    i++;
                }
            }

        }else if(s1.charAt(i)!=s2.charAt(j)){
            return false;
        }

        return ans1&&ans2;
    }
    public boolean isMatch(String s, String p) {
        List<List<Integer>> list = new ArrayList<>();

        // Initialize 26 empty lists
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
        }

        // Populate the lists with indices
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a'; // assuming lowercase letters only
            list.get(index).add(i);
        }

        return wildAns(s,p,0,0,s.length(),p.length(),list);



    }

    public static void main(String[] args){
        WildCardMatching wildCardMatching=new WildCardMatching();
        wildCardMatching.isMatch("","****"
        );
    }
}

