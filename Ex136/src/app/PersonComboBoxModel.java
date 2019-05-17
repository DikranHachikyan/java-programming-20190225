package app;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class PersonComboBoxModel extends DefaultComboBoxModel<Person> {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Person> people = null;
	private Person selectedPerson = new Person();
	
	public PersonComboBoxModel(ArrayList<Person> people) {
		super();
		this.people = people;
	}
	
	@Override
	public void addElement( Person newPerson) {
		int last = people.size()-1;
		people.add( newPerson );
		fireIntervalAdded(this, last, last);
	}
	
	@Override
	public Person getElementAt( int index ) {
		Person p = null;
		if( index >= 0 && index < people.size() ) {
			p = people.get(index);
		}
		return p;
	}
	
	@Override
	public void setSelectedItem( Object selectedPerson) {
		if ( selectedPerson != null && selectedPerson instanceof Person) {
			this.selectedPerson = (Person)selectedPerson;
		}
	}
	
	@Override
	public Object getSelectedItem() {
		return this.selectedPerson;
	}
	
	@Override
	public int getSize() {
		return people.size();
	}
}
