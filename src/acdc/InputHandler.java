package acdc;
import javax.swing.tree.DefaultMutableTreeNode;

public interface InputHandler
{
	// ---NEW CODE START---
	public void readInput(String inputStr, DefaultMutableTreeNode treeModel);
	// ---NEW CODE END---
	
	public void readRoot(String rootStr, DefaultMutableTreeNode treeModel);
}
