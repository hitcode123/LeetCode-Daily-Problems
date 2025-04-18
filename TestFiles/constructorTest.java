package TestFiles;

public class constructorTest {


    constructorTest(int root) {
        if(root>2)
        {
            return;
        }
        new constructorTest(root+1);

        //you cannot call constructor in constructor because of infinite call possibilites ans
        //and second it violates the sense of creating object in constructor
    }
    public static  void main(String[] args)
    {
        constructorTest x= new constructorTest(0);
    }
}
