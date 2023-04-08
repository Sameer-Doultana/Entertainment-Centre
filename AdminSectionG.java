import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminSectionG extends JFrame{
	AccountData ad = new AccountData();
	public AdminSectionG(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton b1 = new JButton("Add movie");
		JButton b2 = new JButton("Delete movie");
		JButton b3 = new JButton("View Subscribers");
		JButton b4 = new JButton("Logout");
		JButton b5 = new JButton("Add Song");
		JButton b6 = new JButton("Delete Song");
		
		b1.setSize(10, 5);
		b2.setSize(10, 5);
		b3.setSize(10, 5);
		b4.setSize(10, 5);
		b5.setSize(10, 5);
		b6.setSize(10, 5);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		b3.addActionListener(al);
		b4.addActionListener(al);
		b5.addActionListener(al);
		b6.addActionListener(al);
		this.add(b1);
		this.add(b2);
		this.add(b5);
		this.add(b6);
		this.add(b3);
		this.add(b4);
		setVisible(true);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Add movie")){
			AddMovieG am = new AddMovieG();
			dispose();
		}
		else if(ae.getActionCommand().equals("Delete movie")){
			deleteMovieG d = new deleteMovieG();
			dispose();
		}
		else if(ae.getActionCommand().equals("Add Song")){
			AddSong as = new AddSong();
			dispose();
		}
		else if(ae.getActionCommand().equals("Delete Song")){
			new DeleteSongG();
			dispose();
		}
		else if(ae.getActionCommand().equals("View Subscribers")){
			new ViewSubscribers();
			dispose();
			
		}
		else if(ae.getActionCommand().equals("Logout")){
			AdminLoginG m = new AdminLoginG();
			dispose();
		}
	}
}
}