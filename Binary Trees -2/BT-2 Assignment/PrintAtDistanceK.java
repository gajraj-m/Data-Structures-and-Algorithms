import java.util.*;

public class PrintAtDistanceK {

/* Hint Video 2nd method */

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        print(root,node,k);
	}
    
    private static int print(BinaryTreeNode<Integer> root, int node, int k)
    {
        //If tree is empty return -1
        if (root==null)
            return -1;
        
        if (root.data==node)
        {
            printNodesAtDistanceK(root, k);
            return 0;
        }
        
        int leftSubTreeDist=0,rightSubTreeDist=0;
        
        leftSubTreeDist = print(root.left,node,k);
        if (leftSubTreeDist!=-1) {
            if(leftSubTreeDist+1==k) System.out.println(root.data);

            else
            {
                rightSubTreeDist=k-(leftSubTreeDist+1)-1;
                printNodesAtDistanceK(root.right, rightSubTreeDist);    // if node found on the left side.. call eight side
            }
            return leftSubTreeDist+1;
        }
        
        rightSubTreeDist = print(root.right,node,k);
        if (rightSubTreeDist!=-1) {
            if(rightSubTreeDist+1==k) System.out.println(root.data);

            else
            {
                leftSubTreeDist=k-(rightSubTreeDist+1)-1;
                printNodesAtDistanceK(root.left, leftSubTreeDist);
            }
            return rightSubTreeDist+1;
        }
        return -1;
    }
    
    private static void printNodesAtDistanceK(BinaryTreeNode<Integer> root, int k)
    {
        if (root==null || k<0)
        	return;
        
        if (k == 0)  
        { 
            System.out.println(root.data); 
            return; 
        }
        
        printNodesAtDistanceK(root.left,k-1);
        printNodesAtDistanceK(root.right,k-1);
    }

    /* Hint Video 1st method... didn't work for last 2 test cases */

//  private static class Pair{         // static because i don't want to call PrintAtDistanceK.Pair everytime.
//     BinaryTreeNode<Integer> node;
//     char direction;
//     public Pair(BinaryTreeNode<Integer> node, char direction){
//         this.node = node;
//         this.direction = direction;
//     }
// }

//     public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
// 	    Queue <Pair> path = new LinkedList<>();
//         boolean isNodePresent = rootToNodePath(root, node, path);
//         int c=1;
//         if(isNodePresent){
//             while(!path.isEmpty()){
//             Pair obj = path.poll();
//             if(k==1 && (obj.direction == 'L' || obj.direction == 'R')) printAtDistanceK(obj.node, 0);
//             if(obj.direction == 'L') printAtDistanceK(obj.node.right, k - c++ - 1);
//             else if(obj.direction == 'R') printAtDistanceK(obj.node.left, k - c++ - 1);
//             else if(obj.direction == 'B') printAtDistanceK(obj.node, k);
//         }
//     }
// 	}


//     private static boolean rootToNodePath (BinaryTreeNode<Integer> root, int node, Queue<Pair> path){
//         if(root == null) return false;
//         if(root.data == node){
//             path.add(new Pair(root, 'B'));
//             return true;
//         }

//         boolean leftOutput = rootToNodePath(root.left, node, path);
//         if(leftOutput) {
//             path.add(new Pair(root, 'L'));
//             return true;
//         }
//         boolean rightOutput = rootToNodePath(root.right, node, path);
//         if(rightOutput) {
//             path.add(new Pair(root, 'R'));
//             return true;
//         }
//         return false;
//     }

//     private static void printAtDistanceK(BinaryTreeNode<Integer> node, int k){
//         if(node == null || k<0) return;
//         if(k==0){
//             System.out.println(node.data);
//             return;
//         } 

//         printAtDistanceK(node.left, k-1);
//         printAtDistanceK(node.right, k-1);
//     }
}