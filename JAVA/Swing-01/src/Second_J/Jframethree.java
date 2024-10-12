package Second_J;
import javax.swing.*;


public class Jframethree {
	
	private JFrame frame;
	
	public Jframethree()
	{
		initialize();
		
	}
	
	public  void initialize()
	{
		
		frame = new JFrame();

		this.frame.setTitle("this is 3 rd Frame");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setSize(500,400);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		
	}

	
//	//create JFRame
//    frame = new JFrame();
//    
//    //	    reference private insatnce
//  this.frame.setTitle("JFrameTwo");
//  this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//  this.frame.setSize(500,400);
//  this.frame.setLocationRelativeTo(null);
//  this.frame.setVisible(true);
}
