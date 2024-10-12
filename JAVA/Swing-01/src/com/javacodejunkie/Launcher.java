package com.javacodejunkie;
import javax.swing.*;

public class Launcher {
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
				{
			
				public void run()
				{
					MainWindow main = new MainWindow();
					main.show();
					
				
				}
				});
		
	}

}
