import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Subscription extends JFrame{
	JTextField t1 = new JTextField();
	public Subscription(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JButton b1 = new JButton("Pay");
		JButton b2 = new JButton("Back");
		JLabel l1 = new JLabel("Account number");
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		this.add(l1);
		this.add(t1);
		this.add(b1);
		this.add(b2);
		//JOptionPane.showMessageDialog(null, "String", "Title", 1, );

	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Pay")){
			if(t1.getText()!=null){
				JOptionPane.showMessageDialog(null, "Successful");
				MenuG mg = new MenuG();
				dispose();
			}
			else{

			}
			//JOptionPane().showMessageDialog(null, String, "Title");
		}
		else if(ae.getActionCommand().equals("Back")){
			new SubscriptionG();
			dispose();
		}
	}
}
}