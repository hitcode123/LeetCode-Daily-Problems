package leetcodeQuestions;


public class SpecialSubStringK {

    public static  boolean hasSpecialSubstring(String s, int k) {

        int count=1;
        if(k==s.length())
        {

            for(int i=1;i<s.length();i++)
            {
                if(s.charAt(i)==s.charAt(i-1))
                {
                    count++;
                }
                else
                {
                    return false;
                }
            }

            if(count==k)
            {
                return true;
            }
        }
        else if(k==1&&s.charAt(0)!=s.charAt(1))
        {
            return true;
        }

        count=1;
        int low=0;
        boolean ans=false;

        //aaabaaa
        //bbacaa k=1

//aaaaababaaabbb
        for(int i=1;i<s.length();i++)
        {

            if(s.charAt(i-1)==s.charAt(i))
            {
                count++;
            }
            else
            {
                count=1;
                low=i;
            }
            if(count==k)
            {
                if(low>0&&i<s.length()-1)
                {
                    if(s.charAt(low)!=s.charAt(low-1)&&s.charAt(i)!=s.charAt(i+1))
                    {
                        ans=true;
                        break;
                    }
                }
                else if(low==0&&i<s.length()-1)
                {
                    if(s.charAt(i)!=s.charAt(i+1))
                    {
                        ans=true;
                        break;
                    }
                }
                else if(i==s.length()-1&&low>0)
                {
                    if(s.charAt(low)!=s.charAt(low-1))
                    {
                        ans=true;
                        break;
                    }
                }
            }

        }
        return ans;

    }
    public static  void main(String [] args){
       boolean ans= hasSpecialSubstring("aaaaababaaabbb",1);
       System.out.print(ans);

    }
}

