import java.util.Scanner;
import java.io.*;

// "Global" Variable used for counting node visits
class visited
{
   static int visit = 0;
}


public class AVL {
     // Creates the arrays for the data for the sorted file
     static int[] idsx = new int[1000];
     static String[] namesx = new String[1000];
     static double[] gpasx = new double[1000];
     
     // Creates the arrays for the data for the sorted file
     static int[] idsy = new int[1000];
     static String[] namesy = new String[1000];
     static double[] gpasy = new double[1000];



     static int loop = 0;
     
	  private static Scanner x;
	  private static Scanner y;
   
   // Opens files to be read
	public static void openFile() {
		try {
			x = new Scanner(new File("SampleData1.txt"));
			y = new Scanner(new File("SampleData2.txt"));
		}
      // Handles when file is not present/cannot open file 
		catch(Exception e) {
			System.out.println("could not find file");
		}
	}
   // Gets input 
	public static void readFile() {
		while(x.hasNext()) {
			String a = x.next();
         int a1 = Integer.parseInt(a);
         idsx[loop] = a1;
         
			String b = x.next();
         String b1 = b;
         namesx[loop] = b1;
         
			String c = x.next();
         double c1 = Double.parseDouble(c);
         gpasx[loop] = c1;
			
         loop++;
			
		}
      loop = 0;
		while(y.hasNext()) {
			String d = y.next();
         int d1 = Integer.parseInt(d);
         idsy[loop] = d1;
         
			String e = y.next();
         String e1 = e;
         namesy[loop] = e1;
         
			String f = y.next();
         double f1 = Double.parseDouble(f);
         gpasy[loop] = f1;
			
         loop++;			
			
		}
	}
	
	public static void closeFile() {
		x.close();
		y.close();
	}
	
	   public static void create(){
      openFile();
		readFile();
		closeFile();
	}

}


class Main
{
   
  

    public static void main (String[] args)
    {
      // Reads the files
      AVL.create();
      //Creates the Trees for the first file
      AVLTree Tree = new AVLTree();
      BSTree BTree = new BSTree();
      //Creates the Trees for the second file
      AVLTree Tree2 = new AVLTree();
      BSTree BTree2 = new BSTree();

      // loads valus into all 4 trees
      // Runs 999 times since that number of lines in each file
      for (int i = 0; i < 998; i++)
      {
         
         Tree.insert(AVL.namesx[i], AVL.idsx[i], AVL.gpasx[i]);
         BTree.insert(AVL.namesx[i], AVL.idsx[i], AVL.gpasx[i]);
         
         Tree2.insert(AVL.namesy[i], AVL.idsy[i], AVL.gpasy[i]);
         BTree2.insert(AVL.namesy[i], AVL.idsy[i], AVL.gpasy[i]);

      }
      // Displays menu to user and gets their input
      System.out.println("1. Would you like to search a student?");
		System.out.println("2. Would you like to find student info with minimum id?");
		System.out.println("3. Would you like to find student info with maximum id?");
      Scanner input = new Scanner(System.in);
		int choice = input.nextInt();

		switch(choice) {
      // User wants to search for an id
		case 1: 
            System.out.println("Which id would you like to search?");
				int id = input.nextInt();
            System.out.print("AVL Sorted: ");
				AVLNode m = Tree.search(id);
            if (m.name == "Null")
            {
               System.out.print("Id Not Found.");
            }
            else
               m.print();
             System.out.printf("   Visited: %d\n", visited.visit);
             visited.visit = 0;
   
               
            System.out.print("AVL Random: ");
            m = Tree2.search(id);
            if (m.name == "Null")
               System.out.print("Id Not Found.");
            else
               m.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;
   
               
               
               
            System.out.print("BST Sorted: ");
            BSTNode m1 = BTree.search(id);
            if (m1.name == "Null")
               System.out.print("Id Not Found.");
            else
               m1.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;
   
               
               
            System.out.print("BST Random: ");    
            m1 = BTree2.search(id);
            if (m1.name == "Null")
               System.out.print("Id Not Found.");
            else
               m1.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;
   
               
               
               
               
				break;
      // Users wants to display minimum id
		case 2: 
            System.out.print("AVL Sorted: ");
            AVLNode n = Tree.minimum();
            n.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;


            System.out.print("AVL Random: ");
            n = Tree2.minimum();
            n.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;
            
            System.out.print("BST Sorted: ");
            BSTNode n1 = BTree.minimum();
            n1.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;

            System.out.print("BST Random: ");
            n1 = BTree2.minimum();
            n1.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;
            
				break;
            
      // Users wants to display maximum id      
		case 3: 
            // displays information for the AVL tree using the sorted file
				System.out.print("AVL Sorted: ");
            AVLNode no = Tree.maximum();
            no.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;
            
            // displays information for the AVL tree using the random id file
            System.out.print("AVL Random: ");
            no = Tree2.maximum();
            no.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;

            // displays information for the BST tree using the sorted file
            System.out.print("BST Sorted: ");
            BSTNode no1 = BTree.maximum();
            no1.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;

            // displays information for the BST tree using the random id file
            System.out.print("BST Random: ");
            no1 = BTree2.maximum();
            no1.print();
            System.out.printf("   Visited: %d\n", visited.visit);
            visited.visit = 0;

				break;
            
      // Users does not enter a valid option
		default: 
         System.out.println("Invalid Choice. Try Again.");     
    }
         }
}



/*
 *  Java Program to Implement BST Tree
   Modified from your Blackboard files
 */
 

 
 /* Class BSTNode */
 class BSTNode
 {    
     BSTNode left, right;
     int id;
     String name;
     double gpa;
     int height;
 
     /* Constructor */
     public BSTNode()
     {
         left = null;
         right = null;
         name = "";
         id = 0;
         gpa = 0;
         height = 0;

     }
     /* Constructor */
     public BSTNode(String n, int i, double g)
     {
         left = null;
         right = null;
         name = n;
         id = i;
         gpa = g;
         height = 0;
     }     
     public void print()
     {
         System.out.printf("%d %s %f", id, name, gpa);
     }
 }
 


/* Class BSTree */
 class BSTree
 {
     private BSTNode root;     
 
     /* Constructor */
     public BSTree()
     {
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         root = null;
     }
     /* Function to insert data */
     public void insert(String n, int i, double g)
     {
       
            root = rinsert(n, i, g, root);
     }
     /* Function to get height of node */
     private int height(BSTNode t )
     {
         return t == null ? -1 : t.height;
     }
     /* Function to max of left/right node */
     private int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     
     /* Function to return max id from the tree */
     public BSTNode maximum()
     {
         // counts number of nodes visited
         visited.visit = 0;
         BSTNode current = root;
         while (current.right != null)
         {
            visited.visit++;
            current = current.right;
         }
         
         return current;
     }
     
      /* Function to return min id from the tree */
     public BSTNode minimum()
     {
         // counts number of nodes visited
         visited.visit = 0;
         BSTNode current = root;
         while ((current.left != null))
         {
            visited.visit++;
            current = current.left;
         }
         return current;
     }
     /* Function to insert data recursively */
     private BSTNode rinsert(String n, int i, double g, BSTNode t)
     {
         if (t == null)
             t = new BSTNode(n, i, g);
         else if (i < t.id)
         {
             t.left = rinsert(n, i, g, t.left );
         }
         else if( i > t.id )
         {
             t.right = rinsert(n, i, g, t.right );
         }
         else
           ;  // Duplicate; do nothing
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
     
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     private int countNodes(BSTNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Functions to search for an element */
     public BSTNode search(int val)
     {
         visited.visit = 0;
         return search(root, val);
     }
     // Modified from https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     private BSTNode search(BSTNode r, int val)
     {
             
             visited.visit++;
             // Value is not in tree, returns node with name = "Null" to prevent crash
             if(r==null)
               return new BSTNode("Null", 0, 0);
             // Base case
             if (r.id==val) 
                 return r; 
              
             // val is greater than root's key 
             if (r.id > val) 
                return search(r.left, val); 
              
                // val is less than root's key 
                return search(r.right, val);      
      }
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.id +" ");
             inorder(r.right);
         }
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(BSTNode r)
     {
         if (r != null)
         {
             System.out.print(r.id +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(BSTNode r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.id +" ");
         }
     }     
 }
 








/*
 *  Java Program to Implement AVL Tree
   Modified from your Blackboard files
 */
 
  
 /* Class AVLNode */
 class AVLNode
 {    
     AVLNode left, right;
     int id;
     int height;
     String name;
     double gpa;
 
     /* Constructor */
     public AVLNode()
     {
         left = null;
         right = null;
         id = 0;
         height = 0;
     }
     /* Constructor */
     public AVLNode(String n, int i, double g)
     {
         left = null;
         right = null;
         name = n;
         id = i;
         gpa = g;
         height = 0;
     }     
     public void print()
     {
         System.out.printf("%d %s %f", id, name, gpa);
     }

 }
 
 
 
 
 /* Class AVLTree */
 class AVLTree
 {
     private AVLNode root;     
 
     /* Constructor */
     public AVLTree()
     {
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         root = null;
     }
     /* Function to insert data */
     public void insert(String n, int data, double g)
     {
         root = insert(n,data,g, root);
     }
     /* Function to get height of node */
     private int height(AVLNode t )
     {
         return t == null ? -1 : t.height;
     }
     /* Function to max of left/right node */
     private int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     /* Function to return max id from the tree */
     public AVLNode maximum()
     {
         visited.visit = 0;
         AVLNode current = root;
         while (current.right != null)
         {
            visited.visit++;
            current = current.right;
         }
         return current;
     }
     
      /* Function to return min id from the tree */
     public AVLNode minimum()
     {
         // counts number of nodes visited
         visited.visit = 0;
         AVLNode current = root;
         while (current.left != null)
         {
                visited.visit++;
                current = current.left;
         }
            
         return current;
     }
     
     
     /* Function to insert data recursively */
     private AVLNode insert(String n, int x, double g, AVLNode t)
     {
         if (t == null)
             t = new AVLNode(n, x, g);
         else if (x < t.id)
         {
             t.left = insert(n, x, g,t.left );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( x < t.left.id )
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
         }
         else if( x > t.id )
         {
             t.right = insert( n,x,g, t.right );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( x > t.right.id)
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
         }
         else
           ;  // Duplicate; do nothing
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
     /* Rotate binary tree node with left child */     
     private AVLNode rotateWithLeftChild(AVLNode k2)
     {
         AVLNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }
 
     /* Rotate binary tree node with right child */
     private AVLNode rotateWithRightChild(AVLNode k1)
     {
         AVLNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }
     /**
      * Double rotate binary tree node: first left child
      * with its right child; then node k3 with new left child */
     private AVLNode doubleWithLeftChild(AVLNode k3)
     {
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }
     /**
      * Double rotate binary tree node: first right child
      * with its left child; then node k1 with new right child */      
     private AVLNode doubleWithRightChild(AVLNode k1)
     {
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }    
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     private int countNodes(AVLNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Functions to search for an element */
     public AVLNode search(int val)
     {
         visited.visit = 0;
         return search(root, val);
     }
     private AVLNode search(AVLNode r, int val)
     {
       // Modified from https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
       
       visited.visit++;
       // Value is not in tree, returns node with name = "Null" to prevent crash
       if(r==null)
         return new AVLNode("Null", 0,0);
       // Base Case
       if (r.id==val)
            return r; 
              
       // val is greater than root's key 
             if (r.id > val) 
                return search(r.left, val); 
       // val is less than root's key 
                return search(r.right, val);      
      
     }
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(AVLNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.id +" ");
             inorder(r.right);
         }
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(AVLNode r)
     {
         if (r != null)
         {
             System.out.print(r.id +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(AVLNode r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.id +" ");
         }
     }     
 }
 








