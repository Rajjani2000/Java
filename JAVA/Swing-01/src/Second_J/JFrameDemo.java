package Second_J;
import javax.swing.*;

public class JFrameDemo {
	
	public static void main(String[] args)
	{

			SwingUtilities.invokeLater(new Runnable()
					{
					
					public void run()
					{
						JFrameOne frame1 = new JFrameOne();
						JFrameTwo frame2 = new JFrameTwo();
						Jframethree frame3= new Jframethree();
						JFrameFour frame4 = new JFrameFour();
								
						
					}				
					});
			
		
		
	}
}
