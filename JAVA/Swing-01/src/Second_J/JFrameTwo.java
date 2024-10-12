package Second_J;
import javax.swing.*;

public class JFrameTwo {
	
	private JFrame frame;
	
	public JFrameTwo()
	{
		initialize();
	}
	
	public void initialize()
	{
		//create JFRame
	    frame = new JFrame();
	    
	    //	    reference private insatnce
	  this.frame.setTitle("JFrameTwo");
	  this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  this.frame.setSize(500,400);
	  this.frame.setLocationRelativeTo(null);
	  this.frame.setVisible(true);
		
	}

}
