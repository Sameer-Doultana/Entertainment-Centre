import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class SearchSinger extends JFrame{
	JTextField t1 = new JTextField();
	public SearchSinger(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel l1 = new JLabel("Enter Singer");
		JButton b2 = new JButton("Back");
		JButton b1 = new JButton("Search");
		b1.setSize(10, 5);
		b2.setSize(10, 5);
		l1.setSize(10, 5);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		this.add(l1);
		this.add(t1);
		this.add(b1);
		this.add(b2);
		setVisible(true);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		boolean flag = false;
		String showsongs = "";
		if(ae.getActionCommand().equals("Search")){
			ArrayList<Songs> list = s.readInFile();
				for(Songs song: list){
					if(t1.getText().equals(song.getSinger())){
						//playMethod(song.getLocation());
						showsongs += song.getSinger()+"\n";
						flag = true;
					}
				}
				if( flag == false){
					JOptionPane.showMessageDialog(null, "Song not found");
				}
		}
		// if(flag = false){
		// 	JOptionPane.showMessageDialog(null, "Not Found");
		// 	Search sch = new Search();
		// }
		else if(ae.getActionCommand().equals("Back")){
			Search sch = new Search();
			dispose();
		}
	}
}

public void playMethod(String path) {
		try
		{
			Desktop.getDesktop().open(new File(path));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}