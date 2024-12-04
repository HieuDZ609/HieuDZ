package BT;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RegistrationForm extends JFrame{
	private JFrame 		frame;
	private JLabel 		form, name, mobile, gender ,dob, address, nofi;
	private JTextField 	nametxt, mobiletxt;
	private JTextArea 	addresstxt, detail;
	private JRadioButton male, female;
	private JComboBox 	days, months, years;
	private JCheckBox	accept;
	private JButton 	submit, reset;
	private ButtonGroup group;
	public RegistrationForm() {
		frame = new JFrame("Registration Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 525);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		// ---------North------------
		JPanel north = new JPanel(new FlowLayout()); 
		form = new JLabel("Registration Form"); 
		form.setFont(new Font("Arial", Font.BOLD, 24));
		north.add(form);
		frame.add(north, BorderLayout.NORTH);
		
		// ---------Center-----------
		JPanel center	 = new JPanel(new GridLayout(1, 2, 10 ,10));
		JPanel left 	 = new JPanel(); left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		JPanel right 	 = new JPanel(new FlowLayout()); 
		center.add(left); center.add(right);
		frame.add(center, BorderLayout.CENTER);
		// ---------WEST------------- (for beautiful lol)
		JPanel west 	 = new JPanel(new FlowLayout());
		west.setPreferredSize(new Dimension(50, 0));
		frame.add(west, BorderLayout.WEST);
		// ------------------left-----------------
		// label
		name 	= new JLabel("Name");
		mobile  = new JLabel("Mobile");
		gender  = new JLabel("Gender");
		dob  	= new JLabel("DOB");
		address = new JLabel("Address");
		nofi 	= new JLabel("");
		nofi.setFont(new Font("Arial", Font.BOLD, 16));
		// text field + area
		nametxt 	= new JTextField(15);
		mobiletxt   = new JTextField(10);
		addresstxt  = new JTextArea(5, 20);
		// gender button
		JPanel gens = new JPanel(new FlowLayout());
		male 	= new JRadioButton("Male");
		female  = new JRadioButton("Female");
		group 	= new ButtonGroup();
		group.add(male); group.add(female);
		gens.add(male); gens.add(female);
		add(gens); 
		// date (combo box)
		JPanel dobbox = new JPanel(new FlowLayout());
		String[] day = new String[31];
		for (int i = 1;i <= 31;i++)
			day[i-1] = String.valueOf(i);
		days = new JComboBox<String>(day);
		String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		String[] year = new String[41];
		for (int i = 1; i<= 41; i++)   
			year[i-1] = String.valueOf(i+1984);
		months 	= new JComboBox<String>(month);
		years 	= new JComboBox<String>(year);
		dobbox.add(days); dobbox.add(months); dobbox.add(years);
		// check box
		accept 	= new JCheckBox("Accept Terms and Conditions.");
		// button
		submit  = new JButton("Submit");
		submit.addActionListener(e -> addDetail());
		reset 	= new JButton("Reset");
		reset.addActionListener(e -> resetDetail());
		// --- add panel -> left
		JPanel NMGDA = new JPanel(new GridLayout(4, 2, 5, 30));
			NMGDA.add(name); NMGDA.add(nametxt);
			NMGDA.add(mobile); NMGDA.add(mobiletxt);
			NMGDA.add(gender); NMGDA.add(gens); 
			NMGDA.add(dob); NMGDA.add(dobbox);
		JPanel NMGDA2 = new JPanel(new GridLayout(1, 2, 5, 30));
			NMGDA2.add(address); NMGDA2.add(addresstxt);
		NMGDA.setPreferredSize(new Dimension(10, 300)); 
		addresstxt.setPreferredSize(new Dimension(10, 50)); 
		JPanel checkboxs 	= new JPanel(new FlowLayout());	checkboxs.add(accept);
		JPanel buttons 		= new JPanel(new FlowLayout()); 	   	buttons.add(submit); buttons.add(reset);
		JPanel nofications  = new JPanel(new FlowLayout()); 	nofications.add(nofi);
		left.add(NMGDA); left.add(NMGDA2);
		left.add(checkboxs); left.add(buttons); left.add(nofications);
		//--------------right------------------
		// Text area
		detail = new JTextArea(20,20);
		// --- add panel -> right
		JPanel details = new JPanel(new FlowLayout()); details.add(detail);
		right.add(details);		
		frame.setVisible(true);
	}
	private void addDetail() {
		if (!accept.isSelected()) {
			nofi.setText("The Accept is Not Selected !");
			return;
		}
		else if (nametxt.getText().isEmpty()) {
			nofi.setText("The Name is Not Empty !");
			return;
		}
		else if (mobiletxt.getText().isEmpty()) {
			nofi.setText("The Mobile is Not Empty !");
			return;
		}
		else if (!male.isSelected() && !female.isSelected()) {
			nofi.setText("The Gender is Not Empty !");
			return;
		}
		else {
			String name   = nametxt.getText();
			String mobile = mobiletxt.getText();
			String gender;
			if (male.isSelected()) gender = "Male";
			else gender   = "Female";
			
			String date   = (String)days.getSelectedItem() + "/" + (String)months.getSelectedItem() + "/" + (String)years.getSelectedItem(); 
			
			String address = addresstxt.getText();
			detail.setText(detail.getText()+"*******************\nName : "+name+"\nMoblie : "+mobile+"\nGender : "+gender+"\nDate : "+date+"\nAddress : "+address+"\n");			
			nofi.setText("Registration Successfully !");
		}
	}
	private void resetDetail() {
		nametxt.setText("");
		mobiletxt.setText("");
		addresstxt.setText("");
		group.clearSelection();
		accept.setSelected(false);
		
	}
	public static void main(String[] args) {
		RegistrationForm form = new RegistrationForm();
    	
    }
}
