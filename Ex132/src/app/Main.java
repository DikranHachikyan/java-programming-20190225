package app;

import java.awt.BorderLayout;
import java.awt.Button;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	private Frame mainFrame = null;
	
	public Main() {
		mainFrame = new Frame("First App");
		//mainFrame.setSize(300,400);
		mainFrame.setLayout( new BorderLayout());
		//create and add components
		Button button1 = new Button("Click Me");
		Button button2 = new Button("Second Button");
		Button button3 = new Button("Third Button");
		
		Button button4 = new Button("South");
		Button button5 = new Button("East");
		
		mainFrame.add(button1, BorderLayout.CENTER);
		mainFrame.add(button2, BorderLayout.NORTH);
		mainFrame.add(button3, BorderLayout.WEST);
		mainFrame.add(button4, BorderLayout.SOUTH);
		//mainFrame.add(button3, BorderLayout.SOUTH);
		mainFrame.add(button5, BorderLayout.EAST);
		
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
