import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class SingerName extends JFrame{
	Songs s = new Songs();
	JTextField t1 = new JTextField();
	public SingerName(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton b1 = new JButton("Search");
		JLabel l1 = new JLabel("Singer name");
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b1.setSize(10, 5);
		l1.setSize(10, 5);
		t1.setSize(10, 5);
		this.add(t1);
		this.add(b1);
		setVisible(true);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		//boolean flag = false;
		if(ae.getActionCommand().equals("Search")){
			//ArrayList<Songs> list = s.readInFile();
			new SearchSinger(t1.getText());
			dispose();
		}
		// if(flag = false){
		// 	JOptionPane.showMessageDialog(null, "Not Found");
		// 	Search sch = new Search();
		// }
	}
}
}