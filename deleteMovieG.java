import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class deleteMovieG extends JFrame{

	public deleteMovieG(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton b1 = new JButton("Action");
		JButton b2 = new JButton("Adventure");
		JButton b3 = new JButton("Comedy");
		b1.setSize(10, 10);
		b2.setSize(10, 10);
		b3.setSize(10, 10);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		b3.addActionListener(al);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		setVisible(true);
	}

class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Action")){
			new Delete("Action");
			dispose();
		}
		else if(ae.getActionCommand().equals("Adventure")){
			new Delete("Adventure");
			dispose();
		}
		else if(ae.getActionCommand().equals("Comedy")){
			new Delete("Comedy");
			dispose();
		}
		else if(ae.getActionCommand().equals("Back")){
			AdminSectionG as = new AdminSectionG();
			dispose();
		}
	}
}
}