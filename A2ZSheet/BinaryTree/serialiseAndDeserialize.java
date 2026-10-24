package A2ZSheet.BinaryTree;

public class serialiseAndDeserialize {

    // ==============================
    // TreeNode
    // ==============================

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // ==============================
    // SERIALIZE
    // ==============================

    public static String serialize(TreeNode root) {

       if(root==null){
           return "NULL,";
       }

       return root.val+ ","+serialize(root.left)+serialize(root.right);
    }


    // ==============================
    // DESERIALIZE
    // ==============================


    public static TreeNode deserialize(String data) {
        String[] finalArray=data.split(",");
        return findSolution(finalArray);
        // WRITE YOUR CODE HERE
    }
static int i=0;
    private static TreeNode findSolution(String[] finalArray){
        if(serialiseAndDeserialize.i >=finalArray.length||finalArray[serialiseAndDeserialize.i].equalsIgnoreCase("NULL")){
            i++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(finalArray[serialiseAndDeserialize.i]));
        i++;
        TreeNode leftT=findSolution(finalArray);
        TreeNode rightT=findSolution(finalArray);
        root.left=leftT;
        root.right=rightT;
        return root;
    }


    // ==============================
    // PRINT TREE - INORDER
    // ==============================

    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }


    // ==============================
    // MAIN - TEST YOUR CODE
    // ==============================

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
                  / \
                 4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


        // ==============================
        // TEST SERIALIZE
        // ==============================

        String serialized = serialize(root);

        System.out.println("Serialized:");
        System.out.println(serialized);


        // ==============================
        // TEST DESERIALIZE
        // ==============================

        TreeNode newRoot = deserialize(serialized);

        System.out.println("\nInorder after Deserialize:");

        inorder(newRoot);

        System.out.println();
    }
}