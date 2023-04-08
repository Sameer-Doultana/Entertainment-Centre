import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Delete extends JFrame implements Serializable{
	Movies m = new Movies();
	JTextField t1 = new JTextField();
	String genre;
	public String getGenre()
	{
		return genre;
	}
	public Delete(String genre){
		
		this.genre = genre;
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JTextArea ta1 = new JTextArea();
		JScrollPane pane = new JScrollPane(ta1);
		JLabel l1 = new JLabel("Enter movie name");
		JButton b1 = new JButton("Delete");
		JButton b2 = new JButton("Back");
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		if(genre.equals("Comedy")){
		
				ArrayList<Comedy> list = m.getDataOfComedy();
				for (Comedy  act: list) {
					String a = ("Title: "+act.getTitle()+"\nDescription: "+act.getDescription()+"\n");
					ta1.append(a);
				}
			
		}	
		else if(genre.equals("Action")){
		
				ArrayList<Action> list = m.getDataOfAction();
				for (Action  act: list) {
					String a = ("Title: "+act.getTitle()+"\nDescription: "+act.getDescription()+"\n");
					ta1.append(a);
				}
			
		}
		else if(genre.equals("Adventure")){
				ArrayList<Adventure> list = m.getDataOfAdventure();
				for (Adventure  act: list) {
					String a = ("Title: "+act.getTitle()+"\nDescription: "+act.getDescription()+"\n");
					ta1.append(a);
				}
		}
		pane.setSize(10, 50);
		l1.setSize(10, 5);
		t1.setSize(10, 5);
		b1.setSize(10, 5);
		b2.setSize(10, 5);
		this.add(pane);
		this.add(l1);
		this.add(t1);
		this.add(b1);
		this.add(b2);
		setVisible(true);
		
	}
	

class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		try{
			if(getGenre().equals("Action")){
				Action a = new Action();
				if(ae.getActionCommand().equals("Delete")){
				// FileOperations<Action> f = new FileOperations<Action>(new File("Action.txt"));
				a.delete(t1.getText());
				AdminSectionG as = new AdminSectionG();
				dispose();
				}
			}
			if(getGenre().equals("Comedy")){
				Comedy c = new Comedy();
				if(ae.getActionCommand().equals("Delete")){
				//FileOperations<Action> f = new FileOperations<Action>(new File("Action.txt"));
				c.delete(t1.getText());
				AdminSectionG as = new AdminSectionG();
				dispose();
				}
			}
			if(getGenre().equals("Adventure")){
				Adventure ad = new Adventure();
				if(ae.getActionCommand().equals("Delete")){
			//FileOperations<Action> f = new FileOperations<Action>(new File("Action.txt"));
				ad.delete(t1.getText());
				AdminSectionG as = new AdminSectionG();
				dispose();
				}
			}
			else if(ae.getActionCommand().equals("Back")){
				AdminSectionG as = new AdminSectionG();
				dispose();
			}
		}
		catch(NullPointerException e){

		}
	}
}
}