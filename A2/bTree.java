//Name:Hanwen Wang       ID:260778557
public class bTree {
	bNode root;
	bTree left;
	bTree right;
	static Stack st =new Stack();
	public void addNode(String str)
	{
		if (root==null)
		{
			root=new bNode(str);
			left=new bTree();
			right=new bTree();
		}
		//comparison of two strings
		else if(str.compareToIgnoreCase(root.value)<0)
		{
			left.addNode(str);
		}
		else if(str.compareToIgnoreCase(root.value)>0)
		{
			right.addNode(str);
		}
	}
	//traversal in order
	public void inorder()
	{
		if(left.root!=null)
		{
			left.inorder();
			System.out.println("");
		}
			System.out.print(""+root.value);
			st.push(root.value);
		if(right.root!=null)
		{
			right.inorder();
		}
	}
}