package A2ZSheet.BinaryTree;

import java.util.*;

public class MorrisInorderTraversal {

    // ==========================================
    // TreeNode
    // ==========================================

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


    // ==========================================
    // YOUR TASK
    // ==========================================

    public static List<Integer> morrisInorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        TreeNode current=root;
        while(current!=null){
             TreeNode prev=current.left;
            if(prev==null){
                result.add(current.val);
                current=current.right;
            }else{
                while(prev.right!=null&&prev.right!=current){
                    prev=prev.right;
                }

                if(prev.right==null){
                    prev.right=current;
                    current=current.left;
                }else{
                    prev.right=null;
                    result.add(current.val);
                    current=current.right;
                }
            }
        }



        return result;
    }


    // ==========================================
    // TEST CASES
    // ==========================================

    public static void main(String[] args) {

        // ------------------------------------------
        // Test Case 1
        //
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        //
        // Inorder:
        // 4 2 5 1 3
        // ------------------------------------------

        TreeNode root1 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3));

        runTest(
                "Test 1",
                root1,
                Arrays.asList(4, 2, 5, 1, 3)
        );


        // ------------------------------------------
        // Test Case 2
        //
        //        1
        //       /
        //      2
        //     /
        //    3
        //
        // Inorder:
        // 3 2 1
        // ------------------------------------------

        TreeNode root2 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3),
                                null),
                        null);

        runTest(
                "Test 2",
                root2,
                Arrays.asList(3, 2, 1)
        );


        // ------------------------------------------
        // Test Case 3
        //
        //    1
        //     \
        //      2
        //       \
        //        3
        //
        // Inorder:
        // 1 2 3
        // ------------------------------------------

        TreeNode root3 = new TreeNode(1);

        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);

        runTest(
                "Test 3",
                root3,
                Arrays.asList(1, 2, 3)
        );


        // ------------------------------------------
        // Test Case 4
        //
        //        1
        //       / \
        //      2   3
        //
        // Inorder:
        // 2 1 3
        // ------------------------------------------

        TreeNode root4 =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3));

        runTest(
                "Test 4",
                root4,
                Arrays.asList(2, 1, 3)
        );


        // ------------------------------------------
        // Test Case 5
        //
        // Single node
        //
        //        1
        //
        // Inorder:
        // 1
        // ------------------------------------------

        TreeNode root5 = new TreeNode(1);

        runTest(
                "Test 5",
                root5,
                Arrays.asList(1)
        );


        // ------------------------------------------
        // Test Case 6
        //
        // Empty tree
        // ------------------------------------------

        TreeNode root6 = null;

        runTest(
                "Test 6",
                root6,
                Arrays.asList()
        );


        // ------------------------------------------
        // Test Case 7
        //
        //          10
        //         /  \
        //        5    15
        //       / \     \
        //      2   7     20
        //
        // Inorder:
        // 2 5 7 10 15 20
        // ------------------------------------------

        TreeNode root7 =
                new TreeNode(10,
                        new TreeNode(5,
                                new TreeNode(2),
                                new TreeNode(7)),
                        new TreeNode(15,
                                null,
                                new TreeNode(20)));

        runTest(
                "Test 7",
                root7,
                Arrays.asList(2, 5, 7, 10, 15, 20)
        );
    }


    // ==========================================
    // TEST RUNNER
    // ==========================================

    private static void runTest(
            String testName,
            TreeNode root,
            List<Integer> expected) {

        List<Integer> actual =
                morrisInorderTraversal(root);

        System.out.println(testName);
        System.out.println("Expected: " + expected);
        System.out.println("Actual  : " + actual);

        if (expected.equals(actual)) {
            System.out.println("PASS ✅");
        } else {
            System.out.println("FAIL ❌");
        }

        System.out.println("--------------------------------");
    }
}