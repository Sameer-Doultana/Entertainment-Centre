import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SubscriptionG extends JFrame{
	public SubscriptionG(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		JLabel l1 = new JLabel("Monthly Package Includes:");
		JLabel l2 = new JLabel("30 Days unlimited streaming");
		JLabel l3 = new JLabel("Access to all movies and music");
		JLabel l4 = new JLabel("Only in Rs. 1000/month");
		JButton b1 = new JButton("Subscribe");
		JButton b2 = new JButton("Start free trial");
		JButton b3 = new JButton("Back");
		l1.setSize(40, 40);
		b1.setSize(10, 10);
		b2.setSize(10, 10);
		b3.setSize(10, 10);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		b3.addActionListener(al);
		this.add(l1);
		this.add(l2);
		this.add(l3);
		this.add(l4);
		this.add(b1);
		this.add(b2);
		this.add(b3);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Subscribe")){
			new Subscription();
			dispose();
		}
		else if(ae.getActionCommand().equals("Start free trial")){
			//AccountData ad = new AccountData();
			//ad.getContact();
			new MenuG();
			dispose();
		}
		else if(ae.getActionCommand().equals("Back")){
			MainMenuG m = new MainMenuG();
			dispose();
		}
	}
}
}