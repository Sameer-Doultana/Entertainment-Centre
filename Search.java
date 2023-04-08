import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Search extends JFrame{
	public Search(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton b1 = new JButton("Search Song");
		JButton b2 = new JButton("Search Movie");
		JButton b3 = new JButton("Back");
		b1.setSize(10, 5);
		b2.setSize(10, 5);
		b3.setSize(10, 5);
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
		if(ae.getActionCommand().equals("Search Song")){
			new SearchMethod();
			dispose();
		}
		else if(ae.getActionCommand().equals("Search Movie")){
			new SearchMovie();
			dispose();
		}
		else if(ae.getActionCommand().equals("Back")){
			MenuG mm = new MenuG();
			dispose();
		}
	}
}
}