package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {


	public static void printTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+":");
		if(root.left != null) {
			System.out.print("L"+root.left.data+", ");
		}
		if(root.right != null) {
			System.out.print("R"+root.right.data);
		}
		System.out.println();
		printTree(root.left);
		printTree(root.right);
	}
	
	public static void preOrder(BinaryTreeNode<Integer> root) {
	
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static BinaryTreeNode<Integer> takeInput(boolean isRoot, int parentData, boolean isLeft){
		if(isRoot) {
			System.out.println("Enter Root data");
		}else {
			if(isLeft) {
				System.out.println("Enter left child of "+parentData);
			}else {
				System.out.println("Enter right child of "+parentData);
			}
		}
		Scanner scan = new Scanner(System.in);
		int data = scan.nextInt();
		if(data == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
		BinaryTreeNode<Integer> left = takeInput(false, data, true);
		BinaryTreeNode<Integer> right = takeInput(false, data, false);
		root.left = left;
		root.right = right;
		return root;
		
	}
	
	public static BinaryTreeNode<Integer> takeInputLevel(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = scan.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> children = new LinkedList<BinaryTreeNode<Integer>>();
		children.add(root);
		while(!children.isEmpty()) {
			BinaryTreeNode<Integer> front = children.poll();
			System.out.println("Enter left child of "+front.data);
			int left = scan.nextInt();
			if(left != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
				front.left = leftChild;
				children.add(leftChild);
			}
			System.out.println("Enter right child of "+front.data);
			int right = scan.nextInt();
			if(right != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
				front.right = rightChild;
				children.add(rightChild);
			}
		}
		return root;
	}
	
	public static void printLevel(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> children = new LinkedList<BinaryTreeNode<Integer>>();
		children.add(root);
		while(!children.isEmpty()) {
			BinaryTreeNode<Integer> front = children.remove();
			System.out.print(front.data+":");
			if(front.left != null) {
				System.out.print("L:"+front.left.data);
				children.add(front.left);
			}else {
				System.out.print("L:"+-1);
			}
			if(front.right != null) {
				System.out.print(",R:"+front.right.data);
				children.add(front.right);
			}else {
				System.out.print(",R:"+-1);
			}
			System.out.println();
		}
		
	}
	
	public static int numNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftCount = numNodes(root.left);
		int rightCount = numNodes(root.right);
		return leftCount+rightCount+1;
	}
	
	public static int nodesSum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int sum=0;
		sum+=root.data;
		int leftSum = nodesSum(root.left);
		int rightSum = nodesSum(root.right);
		return sum+leftSum+rightSum;
	}
	
	public static int largestNode(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int leftLar = largestNode(root.left);
		int rightLar = largestNode(root.right);
		
		return Math.max(root.data, Math.max(leftLar, rightLar));
	}
	
	public static int greaterX(BinaryTreeNode<Integer> root, int x) {
		if(root == null) {
			return 0;
		}
		int count = 0;
		if(root.data > x) {
			count++;
		}
		int left = greaterX(root.left, x);
		int right = greaterX(root.right, x);
		
		
		return count+left+right;
		
	}
	
	public static int heightOfTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);
		
		return Math.max(left, right)+1;
	}
	
	public static int numLeaf(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		return numLeaf(root.left) + numLeaf(root.right);
		
	}
	
	public static void depthPrint(BinaryTreeNode<Integer> root, int k) {
		if(root == null || k < 0) {
			return;
		}
		if(k == 0) {
			System.out.print(root.data+" ");
			return;
		}
		depthPrint(root.left,k-1);
		depthPrint(root.right,k-1);
	}
	
	public static void replaceWithDepth(BinaryTreeNode<Integer> root, int level) {
		if(root == null) {
			return ;
		}
		root.data = level;
		replaceWithDepth(root.left, level+1);
		replaceWithDepth(root.right, level+1);
		
	}
	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		if(root == null) {
			return false;
		}
		if(root.data == x)
			return true;
	
		boolean left = isNodePresent(root.left, x);
		boolean right = isNodePresent(root.right, x);
		return left || right;
		
	}
	
	public static void noSibling(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return ;
		}
		if(root.left == null && root.right != null) {
			System.out.print(root.right.data+" ");
		}
		if(root.right == null && root.left != null) {
			System.out.print(root.left.data+" ");
		}
		noSibling(root.left);
		noSibling(root.right);
	}
	
	public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		if(root.left == null && root.right == null) {
			return null;
		}
		root.left = removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		return root;
	}
	
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return ;
		}
		if(root.left != null || root.right != null) {
			BinaryTreeNode<Integer> newNode = root.left;
			root.left = root.right;
			root.right = newNode;
		}
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
		
		
	}
	
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
		
		boolean isLeftBalanced = isBalanced(root.left);
		boolean isRightBalanced = isBalanced(root.right);
		
		return isLeftBalanced && isRightBalanced;
		
	}
	
	public static BalanceTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			int height = 0;
			boolean isBal = true;
			BalanceTreeReturn ans = new BalanceTreeReturn();
			ans.height = height;
			ans.isBalanced = isBal;
			return ans;
		}
		
		BalanceTreeReturn left = isBalancedBetter(root.left);
		BalanceTreeReturn right = isBalancedBetter(root.right);
		boolean isBal = true;
		int height = 1 + Math.max(left.height, right.height);
		
		if(Math.abs(left.height - right.height) > 1) {
			isBal = false;
		}
		if(!left.isBalanced || !right.isBalanced) {
			isBal = false;
		}
		BalanceTreeReturn ans = new BalanceTreeReturn();
		ans.height = height;
		ans.isBalanced = isBal;
		return ans;
		
	}
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int diameter = 0;
		if(root.left != null && root.right != null) {
			diameter = heightOfTree(root.left) + heightOfTree(root.right);
		}
		if(root.left != null && root.right == null) {
			diameter = heightOfTree(root.left);
		}
		if(root.right != null && root.left == null) {
			diameter = heightOfTree(root.right);
		}
		
		diameter(root.left);
		diameter(root.right);
		return diameter + 1;
	}
	
	public static BinaryTreeNode<Integer> builtTree(int preorder[], int inorder[], int startPre, int endPre, int startIn, int endIn){
		if(startPre>endPre) {
			return null;
		}
		int rootData = preorder[startPre];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);  
		int rootIndexInOrder = -1;
		// find index of root in inOrder
		for(int i=startIn; i<=endIn; i++) {
			if(inorder[i] == rootData) {
				rootIndexInOrder = i;
				break;
			}
		}
		//Assigning indexes for left inOrder subtree
		int sLeftIn = startIn;
		int eLeftIn = rootIndexInOrder-1;
		
		//Assigning indexes for left preOrder subtree
		int sLeftPre = startPre+1;
		int leftSubTreeLen = eLeftIn - sLeftIn + 1;
		int eLeftPre = sLeftPre + leftSubTreeLen - 1;
		
		//Assigning indexes for right inOrder subTree
		int sRightIn = rootIndexInOrder + 1;
		int eRightIn = endIn;
		
		//Assigning indexes for right preOrder subtree
		int sRightPre = eLeftPre + 1;
		int eRightPre = endPre;
		
		BinaryTreeNode<Integer> leftChild = builtTree(preorder, inorder, sLeftPre, eLeftPre, sLeftIn, eLeftIn );
		BinaryTreeNode<Integer> rightChild = builtTree(preorder, inorder, sRightPre, eRightPre, sRightIn, eRightIn);
		
		root.left = leftChild;
		root.right = rightChild;
		return root;
		
	}
	
	public static BinaryTreeNode<Integer> builtTree(int preOrder[], int inOrder[]){
//		if(inOrder.length == 0 || preOrder.length == 0) {
//			return null;
//		}
		BinaryTreeNode<Integer> root = builtTree(preOrder, inOrder, 0 ,preOrder.length-1, 0, inOrder.length-1);
    	return root;
		
		
	}
	
	public static BinaryTreeNode<Integer> buildTreeUsingPostIn(int post[], int in[], int spost, int epost, int sin, int ein){
		if(spost > epost) {
			return null;
		}
		int rootData = post[epost];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		int rootIndex = -1;
		for(int i=sin; i<=ein; i++) {
			if(in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}
		
		int sLeftin = sin;
		int eLeftin = rootIndex-1;
		
		int sLeftpost = spost;
		int leftSubTreeLen = eLeftin - sLeftin + 1;
		int eLeftpost = sLeftpost + leftSubTreeLen -1;
		
		
		int sRightpost = eLeftpost+1;
		int eRightpost = epost-1;
		
		int sRightin = rootIndex+1;
		int eRightin = ein;
		
		BinaryTreeNode<Integer> left = buildTreeUsingPostIn(post, in, sLeftpost, eLeftpost, sLeftin, eLeftin);
		BinaryTreeNode<Integer> right = buildTreeUsingPostIn(post, in, sRightpost, eRightpost, sRightin, eRightin);
		
		root.left = left;
		root.right = right;
		return root;
		
	}
	
	public static BinaryTreeNode<Integer> buildTree(int post[], int in[]){

		BinaryTreeNode<Integer> root = buildTreeUsingPostIn( post,  in,  0,  post.length-1,  0,  in.length-1);
		return root;
	}
	
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		int rootData = root.data;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> save = root.left;
		root.left = node;
		node.left = save;
		insertDuplicateNode(root.left.left);
		insertDuplicateNode(root.right);
		
	}
	
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		if(root == null) {
			int min = 0;
			int max = 0;
			Pair<Integer, Integer> ans = new Pair<>(min, max);
			return ans;
		}
		Pair<Integer, Integer> maxMin = new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE); 
		int data = root.data;
		int max = maxMin.maximum;
		
		if(data > max) {
			maxMin.maximum = root.data;
		}
		
		int min = maxMin.minimum;
		if(data < min) {
			maxMin.minimum = root.data;
		}
		
		Pair<Integer, Integer> left = getMinAndMax(root.left);
		Pair<Integer, Integer> right = getMinAndMax(root.right);
		
		Pair<Integer, Integer> ans = new Pair<>(Math.min(left.minimum, right.minimum), Math.max(left.maximum, right.maximum));
		
		
		return ans;
		
		
	}
	
	public static void printlevelwise(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return ;
		}
		Queue<BinaryTreeNode<Integer>> children  =new LinkedList<BinaryTreeNode<Integer>>();
		children.add(root);
		children.add(null);
		while(!children.isEmpty()) {
			BinaryTreeNode<Integer> front = children.remove();
			if(front == null) {
				if(children.isEmpty()) {
					break;
				}else {
				System.out.println();
				children.add(null);
				}
				
			}else{
				System.out.print(front.data+" ");
				if(front.left != null) {
					children.add(front.left);
				}
				if(front.right != null) {
					children.add(front.right);
				}
			}
		}
		
	}
	
	public static void rootToLeafPathSumToK(BinaryTreeNode<Integer> root, int k, String str) {
		if(root == null) {
			return ;
		}
		int data = root.data;
		str = str+data+" ";
		if(k == data && root.left == null && root.right == null) {
			System.out.println(str);
			return ;
		}
		
		
		rootToLeafPathSumToK(root.left, k-data, str);
		rootToLeafPathSumToK(root.right, k-data, str);
	}

	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		helperNodesAtDistanceK(root, node, k);
	}
	
	public static int helperNodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		if(root == null) {
			return -1;
		}
		int data = root.data;
		if(data == node) {
			depthPrint(root, k);
			return 0;
		}
		int leftSubTreeDis = 0, rightSubTreeDis = 0;
		leftSubTreeDis = helperNodesAtDistanceK(root.left,node,k);
		if(leftSubTreeDis != -1) {
			if(leftSubTreeDis + 1 ==  k) {
				System.out.println(root.data);
			}else {
				rightSubTreeDis = k-(leftSubTreeDis+1)-1;
				depthPrint(root.right, rightSubTreeDis);
			}
			return leftSubTreeDis+1;
		}
		
		rightSubTreeDis = helperNodesAtDistanceK(root.right, node, k);
		if(rightSubTreeDis != -1) {
			if(rightSubTreeDis + 1 == k) {
				System.out.println(root.data);
			}else {
				leftSubTreeDis = k-(rightSubTreeDis+1)-1;
				depthPrint(root.left, leftSubTreeDis);
			}
			return rightSubTreeDis + 1;
		}
		return -1;
	}
	
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root == null) {
			return false;
		}
		if(root.data == k) {
			return true;
		}
		if(k < root.data) {
			return searchInBST(root.left, k);
		}
		return searchInBST(root.right, k);
	}
	
	public static void printBetween(BinaryTreeNode<Integer> root, int k1, int k2) {
		if(root == null) {
			return ;
		}
		if(root.data > k1) {
			printBetween(root.right, k1, k2);
		}else if(root.data < k2) {
			printBetween(root.left, k1, k2);
		}else {
			System.out.print(root.data+" ");
			printBetween(root.right, k1, k2);
			printBetween(root.left, k1, k2);
		}
		
	}

	public static BinaryTreeNode<Integer> buildBST(int arr[], int n){
		
		BinaryTreeNode<Integer> root = buildBSThelper(arr, 0, n-1);
		return root;
		
	}
	
	public static BinaryTreeNode<Integer> buildBSThelper(int arr[], int start_index, int end_index){
		if(start_index > end_index) {
			return null;
		}
		int mid = (start_index + end_index) / 2;
		int data = arr[mid];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
		
		int left_start_index = start_index;
		int left_end_index = mid-1;
		
		int right_start_index = mid+1;
		int right_end_index = end_index;
		
		BinaryTreeNode<Integer> left = buildBSThelper(arr, left_start_index, left_end_index);
		BinaryTreeNode<Integer> right = buildBSThelper(arr, right_start_index, right_end_index);
		root.left = left;
		root.right = right;
		return root;
		
	}
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);
		return Math.min(root.data, Math.min(leftMin, rightMin));
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftMax = largestNode(root.left);
		if(leftMax >= root.data) {
			return false;
		}
		
		int rightMin = minimum(root.right);
		if(rightMin < root.data) {
			return false;
		}
		
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		
		return isLeftBST && isRightBST ;
	}
	
	public static BSTReturn isBST2(BinaryTreeNode<Integer> root) {
		if(root == null ) {
			BSTReturn ans = new BSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}
		
		BSTReturn leftAns = isBST2(root.left);
		BSTReturn rightAns = isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		if(leftAns.max >= root.data) {
			isBST = false;
		}
		if(rightAns.min < root.data) {
			isBST = false;
		}
		if(!leftAns.isBST) {
			isBST = false;
		}
		if(!rightAns.isBST) {
			isBST = false;
		}
		
		BSTReturn ans = new BSTReturn(min, max, isBST);
		return ans;
	}
	
	public static void main (String args[]) {
		int pre[] = {1,2,4,5,3,6,7};
		int in[] = {4,2,5,1,6,3,7};
		int post[] = {4,5,2,6,7,3,1};
		int arr[] = {1,2,3,4,5,7};
		int n = arr.length;
//		System.out.println(n);
//		BinaryTreeNode<Integer> root = buildTree(post, in);
//		BinaryTreeNode<Integer> root = takeInputLevel();
		BinaryTreeNode<Integer> root = buildBST(arr,n);
//		System.out.println(isBST(root));
		BSTReturn ans = isBST2(root);
		System.out.println("Min:- "+ans.min+" Max:- "+ans.max+" "+ans.isBST);
		
		
		
//		insertDuplicateNode(root);
		
//		BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
//		root.left = rootLeft;
//		root.right = rootRight;
//		System.out.print(in.length/2);
//		BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<>(5);
//		BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
//		rootLeft.right = twoRight;
//		rootRight.left  = threeLeft;
		printLevel(root);
//		printlevelwise(root);
//		String str = "";
//		rootToLeafPathSumToK(root, 13, str);
//		printBetween(root, 6, 10);
//		System.out.println(searchInBST(root, 9));
//		nodesAtDistanceK(root, 3, 1);
//		Pair<Integer, Integer> pair = getMinAndMax(root);
//		System.out.println(pair.minimum+" "+pair.maximum);
		
//		postOrder(root);
//		System.out.println(heightOfTree(root));
//		System.out.println(numLeaf(root));
//		depthPrint(root,2);
//		replaceWithDepth(root);
//		printTree(root);
//		System.out.println(isNodePresent(root, 5));
//		noSibling(root);
//		BinaryTreeNode<Integer> newRoot = removeLeaves(root);
//		mirrorBinaryTree(root);
//		System.out.println("Is tree balanced: "+isBalancedBetter(root).isBalanced);
//		System.out.println("Diameter is : "+diameter(root));
//		printTree(root);
//		System.out.println(nodesSum(root));
	}
}
