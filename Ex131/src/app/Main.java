package app;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	private Frame mainFrame = null;
	
	public Main() {
		mainFrame = new Frame("First App");
		//mainFrame.setSize(300,400);
		mainFrame.setLayout( new FlowLayout());
		//create and add components
		Button button1 = new Button("Click Me");
		Button button2 = new Button("Second Button");
		Button button3 = new Button("Third Button");
		
		mainFrame.add(button1);
		mainFrame.add(button2);
		mainFrame.add(button3);
		
		mainFrame.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing( WindowEvent evt) {
				System.exit(0);
			}
		});
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args)  {
		new Main();
	}	
}
