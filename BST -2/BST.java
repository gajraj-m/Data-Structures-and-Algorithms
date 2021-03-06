/*

Implement the BST class which includes following functions -
1. search
Given an element, find if that is present in BST or not. Return true or false.
2. insert -
Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.
3. delete -
Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
4. printTree (recursive) -
Print the BST in ithe following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.

*/

// My BST class
class BinaryTreeNode<T> { 
    T data; 
    BinaryTreeNode<T> left; 
    BinaryTreeNode<T> right;
    public BinaryTreeNode(T data) 
    { 
        this.data = data; 
    }
}

public class BST {
    private BinaryTreeNode<Integer> root;

    public void insert(int data) {
        root = insertHelper(root, data);
	}

    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data){    
        if(root == null){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
            return newNode;
        }
        if(data <= root.data) root.left = insertHelper(root.left, data);
        else root.right = insertHelper(root.right, data);
        return root;
    }
	
	public void remove(int data) {
		root =removeHelper(root, data);
	}
	
    private static BinaryTreeNode<Integer> removeHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null) return null;
        if(root.data > data) root.left = removeHelper(root.left, data);
        if(root.data < data) root.right = removeHelper(root.right, data);
        if(root.data == data){

            if(root.left == null && root.right == null) return null;
            if(root.left == null && root.right != null) return root.right;
            if(root.left != null && root.right == null) return root.left;
            if(root.left != null && root.right != null){
                root.data = minElementRightSubtree(root.right);
                root.right = removeHelper(root.right, root.data);       // delete the node whose value we just found
            }
        }
        return root;
    }

    private static int minElementRightSubtree(BinaryTreeNode<Integer> root){
        if(root.left == null) return root.data;
        return minElementRightSubtree(root.left);

    }

	public void printTree() {
		printHelper(root);
	}

    private static void printHelper(BinaryTreeNode<Integer> root){
        if(root == null) return;
        System.out.print(root.data + ":");
        if(root.left != null) System.out.print("L:" + root.left.data + ",");
        if(root.right != null ) System.out.print("R:" + root.right.data);
        System.out.println();

        printHelper(root.left);
        printHelper(root.right);
    }
	
	public boolean search(int data) {
		return searchHelper(root, data);
	}
    private static boolean searchHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null) return false;
        if(root.data == data) return true;
        if(root.data > data) return searchHelper(root.left, data);
        return searchHelper(root.right, data);
    }
}
