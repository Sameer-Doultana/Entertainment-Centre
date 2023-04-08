import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuG extends JFrame{
	public MenuG(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		JButton b1 = new JButton("Action Movies");
		JButton b2 = new JButton("Adventure Movies");
		JButton b3 = new JButton("Comedy Movies");
		JButton b5 = new JButton("Songs");
		JButton b6 = new JButton("Search");
		JButton b4 = new JButton("Logout");
		JButton b7 = new JButton("Search by Singer");
		b1.setSize(10, 5);
		b2.setSize(10, 5);
		b3.setSize(10, 5);
		b4.setSize(10, 5);
		b5.setSize(10, 5);
		b6.setSize(10, 5);
		b7.setSize(10, 5);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		b3.addActionListener(al);
		b4.addActionListener(al);
		b5.addActionListener(al);
		b6.addActionListener(al);
		b7.addActionListener(al);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b5);
		this.add(b6);
		this.add(b4);
		this.add(b7);
		setVisible(true);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Action Movies")){
			Play p = new Play("Action");
			dispose();
		}
		else if(ae.getActionCommand().equals("Adventure Movies")){
			Play p = new Play("Adventure");
			dispose();
		}
		else if(ae.getActionCommand().equals("Comedy Movies")){
			Play p = new Play("Comedy");
			dispose();
		}
		else if(ae.getActionCommand().equals("Songs")){
			DisplayClass dc = new DisplayClass();
			dispose();
		}
		else if(ae.getActionCommand().equals("Search")){
			Search sc = new Search();
			dispose();
		}
		else if(ae.getActionCommand().equals("Logout")){
			MainMenuG mm = new MainMenuG();
			dispose();
		}
		else if(ae.getActionCommand().equals("Search by Singer")){
			new SingerName();
			dispose();
		}
	}
}
}