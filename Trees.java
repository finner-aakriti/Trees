package trees;

import java.util.Scanner;
class TreeNode
{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data)
	{
		this.data=data;
	}
}

public class Trees {

	
	public static int height(TreeNode root)
	{
		if(root == null)return 0;
		int leftNodes=height(root.left);
		int rightNodes=height(root.right);
		return 1+ Math.max(leftNodes, rightNodes);
	}
	public static int diameter(TreeNode root)
	{
		if(root==null)
		{
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		int d= left + right +1;
		int leftmax = diameter(root.left);
		int rightmax = diameter(root.right);
		return Math.max(Math.max(leftmax, rightmax), d);
		
	}
	public static TreeNode takeInput(boolean isRoot, int parentData, boolean isLeft)
	{
		if(isRoot)
		{
			System.out.print("Enter root's data");
		}
		else
		{
			if(isLeft)
			{
				System.out.print("Enter left child of "+parentData+":");
			}
			else
			{
				System.out.print("Enter right child of "+parentData+":");
			}
		}
		Scanner sc = new Scanner(System.in);
		int data=sc.nextInt();
		if(data==-1)
		{
			return null;
		}
		TreeNode root = new TreeNode(data);
		TreeNode rootLeft = takeInput(false,data,true);
		TreeNode rootRight = takeInput(false,data,false);
		 root.left=rootLeft;
		 root.right=rootRight;
		 return root;
	}
	public static void main(String args[])
	{
		TreeNode root =takeInput(true,-1,false);
		
		 System.out.println(diameter(root));
	}
}
public class Solution {
    public static int makeBeautiful(String str)
    {
    int n=0;
     for(int i=0;i<str.length()-1;i++)
     {
     int sum=Character.getNumericValue(str.charAt(i))+Character.getNumericValue(str.charAt(i+1));
       if(sum==1)continue;
       else
       {
       n++;
       if(str.charAt(i+1)=='0')
       {
           str = str.substring(0, i) + '1'
              + str.substring(i + 1);}
       if(str.charAt(i+1)=='1')
       {
          str = str.substring(0, i) + '0'
              + str.substring(i + 1);}
        }
        }
        return n;
    }
}
