import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AccountCreationG extends JFrame{
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	public AccountCreationG(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel l1 = new JLabel("Name");
		JLabel l2 = new JLabel("UserName");
		JLabel l3 = new JLabel("Password");
		JLabel l4 = new JLabel("Contact Number");
		JButton b1 = new JButton("Back");
		JButton b2 = new JButton("Submit");
		t1.setSize(40, 10);
		t2.setSize(40, 10);
		t3.setSize(40, 10);
		t4.setSize(40, 10);
		b1.setSize(10, 5);
		b2.setSize(10, 5);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		this.add(l1);
		this.add(t1);
		this.add(l2);
		this.add(t2);
		this.add(l3);
		this.add(t3);
		this.add(l4);
		this.add(t4);
		this.add(b2);
		this.add(b1);
		setVisible(true);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Submit")){
			String name = t1.getText();
			String username = t2.getText();
			String password = t3.getText();
			String contact = t4.getText();
			AccountData ad = new AccountData(name, username, password, contact);
			FileOperations<AccountData> f = new FileOperations<AccountData>(new File("AccountData.ser"));
			f.dataWriting(ad, true);
			JOptionPane.showMessageDialog(null, "Saved");
			SubscriptionG s = new SubscriptionG();
			dispose();
		}
		else if(ae.getActionCommand().equals("Back")){
			MainMenuG m = new MainMenuG();
			dispose();
		}
	}
}
}
