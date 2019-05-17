package app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main {
	
	private JFrame frame = null;
	private static Person [] people = {
			  new Person("John","Doe")
			, new Person("Anna","Smith")
			, new Person("Maria","Anders")
			, new Person("Markus","Wolf")
	};
	
	public Main() {
		frame = new JFrame("Swing App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<Person> p = new ArrayList<>( Arrays.asList(people));
		PersonComboBoxModel model = new PersonComboBoxModel(p);
		
		JComboBox<Person> combo = new JComboBox<>(model);
		JButton  button = new JButton("Show");
		JLabel   label  = new JLabel("Selected Item:None");
		
		button.addActionListener( (e)->{
			label.setText("Selected Item: " + model.getSelectedItem() );
			model.addElement( new Person("Florian", "Weiss"));
		});
		
		frame.add(combo, BorderLayout.NORTH);
		frame.add(label, BorderLayout.CENTER);
		frame.add(button, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException  {
		//1.
		Runnable runner = ()->{
			System.out.println("start app");
			new Main();			
		};
		
		//2.
		SwingUtilities.invokeLater(runner);
		//SwingUtilities.invokeAndWait(runner);
		System.out.println("After Invoke Method");
	}	
}
