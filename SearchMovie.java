import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class SearchMovie extends JFrame{
	Movies m = new Movies();
	JTextField t1 = new JTextField();
	public SearchMovie(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel l1 = new JLabel("Enter title");
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
		if(ae.getActionCommand().equals("Search")){
			ArrayList<Adventure> list2 = m.getDataOfAdventure();
			ArrayList<Action> list = m.getDataOfAction();
			ArrayList<Comedy> list3 = m.getDataOfComedy();
			for(Adventure adv: list2){
				String a = adv.getTitle();
				if(a.equals(t1.getText())){
					JOptionPane.showMessageDialog(null, "Movie found in Adventure");
					flag = true;
					break;
				}
			}
			for(Action act: list){
				String b = act.getTitle();
				if(b.equals(t1.getText())){
					JOptionPane.showMessageDialog(null, "Movie found in Action");
					flag = true;
					break;
			}
			for(Comedy com: list3){
				String c = com.getTitle();
				if(c.equals(t1.getText())){
					JOptionPane.showMessageDialog(null, "Movie found in Action");
					flag = true;
					break;
			}
				
				if( flag == false){
					JOptionPane.showMessageDialog(null, "Song not found");
				}
		}
		
	}
}
else if(ae.getActionCommand().equals("Back")){
			Search sch = new Search();
			dispose();
		}
}

}
}