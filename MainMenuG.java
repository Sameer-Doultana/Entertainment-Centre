import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainMenuG extends JFrame{
	public MainMenuG() {
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// JTextArea a1 = new JTextArea("Hello");
		// JScrollPane s1 = new JScrollPane(a1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JLabel l1 = new JLabel("Welcome to Entertainment Centre");
		JButton b1 = new JButton("Create Account");
		JButton b2 = new JButton("Log In");
		//JButton b3 = new JButton("Admin Log In");
		JButton b4 = new JButton("Exit");
		l1.setSize(40, 40);
		b1.setSize(40, 40);
		b2.setSize(40, 40);
		//b3.setSize(40, 40);
		b4.setSize(40, 40);
		//a1.setSize(10, 20);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		//b3.addActionListener(al);
		b4.addActionListener(al);
		this.add(l1);
		this.add(b1);
		this.add(b2);
		//this.add(b3);
		this.add(b4);
		//this.add(s1);
		setVisible(true);
		
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Create Account")){
			AccountCreationG a = new AccountCreationG();
			dispose();
		}
		else if(ae.getActionCommand().equals("Log In")){
			LoginG l = new LoginG();
			dispose();
		}
		// else if(ae.getActionCommand().equals("Admin Log In")){
		// 	AdminLoginG al = new AdminLoginG();
		// 	dispose();
		// }
		else if(ae.getActionCommand().equals("Exit")){
			System.exit(1);
		}
	}
}
}
