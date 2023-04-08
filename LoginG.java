import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class LoginG extends JFrame{
	AccountData ad = new AccountData();
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	public LoginG(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JLabel l1 = new JLabel("UserName");
		JLabel l2 = new JLabel("Password");
		JButton b1 = new JButton("Submit");
		JButton b2 = new JButton("Back");
		t1.setSize(40, 40);
		t2.setSize(40, 40);
		b1.setSize(10, 10);
		b2.setSize(10, 10);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		this.add(l1);
		this.add(t1);
		this.add(l2);
		this.add(t2);
		this.add(b1);
		this.add(b2);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		boolean flag = false;
		if(ae.getActionCommand().equals("Submit")){
			try{
				ArrayList<AccountData> list = ad.readInFile();
				for(AccountData a: list){
					if(t1.getText().equals(a.getUsername())&&t2.getText().equals(a.getPassword())){
						JOptionPane.showMessageDialog(null, "Entered");
						MenuG mg = new MenuG();
						dispose();
						flag = true;
					}	
				}
			}
			catch(NullPointerException e){
				
			}
			if(flag == false){
				JOptionPane.showMessageDialog(null, "Details are wrong! Try Again.");
				LoginG lg = new LoginG();
			 	dispose();
			}
		}
		else if(ae.getActionCommand().equals("Back")){
			MainMenuG m = new MainMenuG();
			dispose();
		}
	}
}
}