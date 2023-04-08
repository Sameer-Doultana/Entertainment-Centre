import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminLoginG extends JFrame{
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	public AdminLoginG(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel l1 = new JLabel("Admin ID");
		JLabel l2 = new JLabel("Password");
		JButton b1 = new JButton("Submit");
		JButton b2 = new JButton("Exit");
		t1.setSize(40, 10);
		t2.setSize(40, 10);
		b1.setSize(10, 5);
		b2.setSize(10, 5);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		this.add(l1);
		this.add(t1);
		this.add(l2);
		this.add(t2);
		this.add(b1);
		this.add(b2);
		setVisible(true);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Submit")){
			AdminLogin al = new AdminLogin();
			if(al.getId().equals(t1.getText())&&al.getPassword().equals(t2.getText())){
				AdminSectionG as = new AdminSectionG();
				dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "Wrong details! try again.");
				AdminLoginG ag = new AdminLoginG();
				dispose();
			}
			
		}
		else if(ae.getActionCommand().equals("Exit")){
			System.exit(1);
		}
	}
}
}