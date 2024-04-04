import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        //calls the recursive function to search for a number
        return search(root, val);
    }
    private boolean search(BSTNode node, int val)
    {
        if (node == null) {
            //base case if no node is detected (returns not true)
            return false;
        }
        if (node.getVal() == val)
        {
            //second base case for if the element is in tree
            return true;
        }
        else if (val < node.getVal())
        {
            //other case for if the val is to the left of the node
            //in that case it returns left
            return search(node.getLeft(), val);
        }
        else
        {
            //other case for if the val is to the right of the node
            //in that case it returns right
            return search(node.getRight(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        //blank arraylist created to hold the order from Left, root, right
        ArrayList<BSTNode> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(BSTNode node, ArrayList<BSTNode> result) {
        if (node != null) {
            inorderTraversal(node.getLeft(), result);
            result.add(node);
            inorderTraversal(node.getRight(), result);
        }
    }
    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;

    }
    private void preorderTraversal(BSTNode node, ArrayList<BSTNode> result) {
        if (node != null) {
            result.add(node);
            preorderTraversal(node.getLeft(), result);
            preorderTraversal(node.getRight(), result);
        }
    }
    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }
    private void postorderTraversal(BSTNode node, ArrayList<BSTNode> result) {
        if (node != null) {
            postorderTraversal(node.getLeft(), result);
            postorderTraversal(node.getRight(), result);
            result.add(node);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        root = insertNode(root, val);
    }
    private BSTNode insertNode(BSTNode node, int val) {
        // If the tree is empty, create a new node as the root
        if (node == null) {
            return new BSTNode(val);
        }

        // If the value is less than the current node's value, go left
        if (val < node.getVal()) {
            node.setLeft(insertNode(node.getLeft(), val));
        }
        // If the value is greater than the current node's value, go right
        else if (val > node.getVal()) {
            node.setRight(insertNode(node.getRight(), val));
        }
        // If the value is already in the tree, do nothing
        return node;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
