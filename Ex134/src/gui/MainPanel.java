package gui;

import java.awt.Panel;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class MainPanel extends Panel {
	private Button btnOk;
	private Button btnCancel;
	private Checkbox chkAgree;
	private Choice choice;

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setPreferredSize(new Dimension(320, 200));
		setLayout(null);
		
		btnOk = new Button("OK");
//		btnOk.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Button Ok Pressed");
//			}
//		});
		btnOk.setBounds(120, 133, 86, 23);
		add(btnOk);
		
		btnCancel = new Button("Cancel");
		btnCancel.setBounds(212, 133, 86, 23);
		add(btnCancel);
		
		chkAgree = new Checkbox("I Agree with ...");
		chkAgree.setBounds(31, 94, 137, 23);
		add(chkAgree);
		
		choice = new Choice();
		choice.setBounds(31, 10, 267, 21);
		add(choice);

	}
	
	public Button getCancelButton() {
		return btnCancel;
	}
	
	public Button getOkButton() {
		return btnOk;
	}
	
	public void addCancelListener( ActionListener l) {
		btnCancel.addActionListener(l);
	}
	
	public Choice getChoice() {
		return choice;
	}
	
}
