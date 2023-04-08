import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddMovieG extends JFrame{
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	public AddMovieG(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel l1 = new JLabel("Genre");
		JLabel l2 = new JLabel("Movie Title");
		JLabel l3 = new JLabel("Location");
		JLabel l4 = new JLabel("Description");
		JButton b1 = new JButton("Submit");
		JButton b2 = new JButton("Back");
		l1.setSize(10, 10);
		l2.setSize(10, 10);
		l3.setSize(10, 10);
		l4.setSize(10, 10);
		t1.setSize(10, 10);
		t2.setSize(10, 10);
		t3.setSize(10, 10);
		t4.setSize(10, 10);
		b1.setSize(10, 10);
		b2.setSize(10, 10);
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
		this.add(b1);
		this.add(b2);
		setVisible(true);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Submit")){
			String gen = t1.getText();
			String movieTitle = t2.getText();
			String loc = t3.getText();
			String des = t4.getText();
			if(gen.equals("Action")){
				Action a = new Action(gen, movieTitle, loc, des);
				FileOperations<Action> f = new FileOperations<Action>(new File("Movies.ser"));
				f.dataWriting(a,true); 
				JOptionPane.showMessageDialog(null, "Successful");
				AdminSectionG ag = new AdminSectionG();
				dispose();
			}
			else if(gen.equals("Adventure")){
				Adventure ad = new Adventure(gen, movieTitle, loc, des);
				FileOperations<Adventure> f = new FileOperations<Adventure>(new File("Movies.ser"));
				f.dataWriting(ad,true); 
				JOptionPane.showMessageDialog(null, "Successful");
				AdminSectionG ag = new AdminSectionG();
				dispose();
			}
			else if(gen.equals("Comedy")){
				Comedy c = new Comedy(gen, movieTitle, loc, des);
				FileOperations<Comedy> f = new FileOperations<Comedy>(new File("Movies.ser"));
				f.dataWriting(c,true);
				JOptionPane.showMessageDialog(null, "Successful");
				AdminSectionG ag = new AdminSectionG();
				dispose();
			}
		}
		else if(ae.getActionCommand().equals("Back")){
			AdminSectionG as = new AdminSectionG();
			dispose();
		}
	}
}
}