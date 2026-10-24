
package A2ZSheet.BST;

public class LargestBST {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
        }
    }

    class Track {
        int min, max, size;

        Track(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    // YOUR ORIGINAL LOGIC:
    // Incorrect sentinel values for an invalid subtree.
    public Track findSolutionWrong(Node root) {
        if (root == null) {
            return new Track(
                    Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            );
        }

        Track left = findSolutionWrong(root.left);
        Track right = findSolutionWrong(root.right);

        if (root.data > left.max && root.data < right.min) {
            return new Track(
                    left.min, right.max,
                    left.size + right.size + 1
            );
        }

        return new Track(
                Integer.MIN_VALUE, Integer.MAX_VALUE,
                Math.max(left.size, right.size)
        );
    }

    // CORRECTED LOGIC:
    public Track findSolutionRight(Node root) {
        if (root == null) {
            return new Track(
                    Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            );
        }

        Track left = findSolutionRight(root.left);
        Track right = findSolutionRight(root.right);

        if (root.data > left.max && root.data < right.min) {
            return new Track(
                    left.min, right.max,
                    left.size + right.size + 1
            );
        }

        return new Track(
                Integer.MIN_VALUE, Integer.MAX_VALUE,
                Math.max(left.size, right.size)
        );
    }

    public int largestBSTWrong(Node root) {
        return findSolutionWrong(root).size;
    }

    public int largestBSTRight(Node root) {
        return findSolutionRight(root).size;
    }

    static Node test1() {
        // Entire tree is a BST: answer 3
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        return root;
    }

    static Node test2() {
        // Root 5 is invalid because its right child is 4.
        // Largest BST is 2 -> {1, 2, 3}, size 3.
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        return root;
    }

    static Node test3() {
        // Invalid root 10; largest BST is {7, 8, 9}, size 3.
        Node root = new Node(10);
        root.left = new Node(15);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        return root;
    }

    static Node test4() {
        // Root 10 has an invalid left subtree rooted at 12.
        // Right subtree 5 -> {3, 7} is a valid BST of size 3.
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(5);
        root.right.left = new Node(3);
        root.right.right = new Node(7);
        return root;
    }

    public static void main(String[] args) {
        LargestBST solution = new LargestBST();

        Node[] tests = {
                test1(), test2(), test3(), test4()
        };

        int[] expected = {3, 3, 3, 3};

        for (int i = 0; i < tests.length; i++) {
            int wrong = solution.largestBSTWrong(tests[i]);
            int right = solution.largestBSTRight(tests[i]);

            System.out.println("Test case " + (i + 1));
            System.out.println("Expected     : " + expected[i]);
            System.out.println("Your logic   : " + wrong);
            System.out.println("Correct logic: " + right);
            System.out.println();
        }
    }
}
