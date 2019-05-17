package app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gui.MainPanel;

public class Main {
	private Frame mainFrame = null;
	
	public Main() {
		mainFrame = new Frame("First App");
		//mainFrame.setSize(300,400);
		mainFrame.setLayout( new BorderLayout());
		//create and add components
		MainPanel mp = new MainPanel();
		
		mp.getOkButton().addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e) {
				System.out.println("Button Ok Pressed");
			}
		});
		
		mp.getCancelButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e) {
				System.exit(0);
			}
		});
		
		Choice ch = mp.getChoice();
		
		for( int i = 0 ; i < 5; i++ ) {
			ch.add("Item " + i);
		}
		
		mainFrame.add(mp);
		
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
