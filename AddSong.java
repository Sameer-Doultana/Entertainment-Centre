import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class AddSong extends JFrame implements Serializable{
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	public AddSong(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel l1 = new JLabel("Title");
		JLabel l2 = new JLabel("Location");
		JLabel l3 = new JLabel("Singer");
		JButton b1 = new JButton("Submit");
		JButton b2 = new JButton("Back");
		t1.setSize(40, 10);
		t2.setSize(40, 10);
		l1.setSize(40, 10);
		l2.setSize(40, 10);
		l3.setSize(40, 10);
		b1.setSize(10, 5);
		b2.setSize(10, 5);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		this.add(l1);
		this.add(t1);
		this.add(l2);
		this.add(t2);
		this.add(l3);
		this.add(t3);
		this.add(b1);
		this.add(b2);
		setVisible(true);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Submit")){
			String title = t1.getText();
			String location = t2.getText();
			String singer = t3.getText();
			Songs song = new Songs(title, location, singer);
			FileOperations<Songs> s = new FileOperations<Songs>(new File("Songs.ser"));
			s.dataWriting(song, true);
			JOptionPane.showMessageDialog(null, "Saved");
			new AdminSectionG();
			dispose();
		}
		else if(ae.getActionCommand().equals("Back")){
			AdminSectionG m = new AdminSectionG();
			dispose();
		}
	}
}
}