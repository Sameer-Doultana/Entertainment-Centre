import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.nio.*;
public class Play extends JFrame{
	Movies m = new Movies();
	JTextField t1 = new JTextField();
	String genre;
	public String getGenre()
	{
		return genre;
	}
	
	public Play(String genre){
		this.genre = genre;
		setSize(500, 5000);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JTextArea ta1 = new JTextArea();
		JScrollPane pane = new JScrollPane(ta1);
		//this.add(new JTextArea(showData()));
		//ta1.append(showData());
		JLabel l1 = new JLabel("Enter movie name");
		JButton b1 = new JButton("Play");
		JButton b2 = new JButton("Back");
		t1.setSize(5, 10);
		l1.setSize(5, 10);
		b1.setSize(5, 10);
		//ta1.setSize(10, 20);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		if(genre.equals("Comedy")){
			try{
				ArrayList<Comedy> list = m.getDataOfComedy();
				for (Comedy  act: list) {
					String a = ("Title: "+act.getTitle()+"\nDescription: "+act.getDescription()+"\n");
					ta1.append(a);
				}
			}
			catch(NullPointerException e){

			}
		}
		else if(genre.equals("Action")){
			try{
				ArrayList<Action> list = m.getDataOfAction();
				for (Action  act: list) {
					String a = ("Title: "+act.getTitle()+"\nDescription: "+act.getDescription()+"\n");
					ta1.append(a);
				}
			}
			catch(NullPointerException e){

			}
		}
		else if(genre.equals("Adventure")){
			try{
				ArrayList<Adventure> list = m.getDataOfAdventure();
				for (Adventure  act: list) {
					String a = ("Title: "+act.getTitle()+"\nDescription: "+act.getDescription()+"\n");
					ta1.append(a);
				}
			}
			catch(NullPointerException e){
				
			}
		}
		
		//pane.add(ta1);
		this.add(pane);
		//showData();
		this.add(l1);
		this.add(t1);
		this.add(b1);
		this.add(b2);
		setVisible(true);
	}
	public void playMethod(String path) {
		try
		{


			//JOptionPane.showMessageDialog(null, "Method entered");
			Desktop.getDesktop().open(new File(path));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public String getPath()
	{
		if (getGenre().equals("Action")) 
		{
			ArrayList<Action> list = m.getDataOfAction();
			String title = t1.getText();
			for (Action  act: list) 
			{
				if (act.getTitle().equals(title)) 
				{
					return act.getLocation();
				}
			}
		}
		else if (getGenre().equals("Adventure")) 
		{
			ArrayList<Adventure> list = m.getDataOfAdventure();
			String title = t1.getText();
			for (Adventure  adv: list) 
			{
				if (adv.getTitle().equals(title)) 
				{
					return adv.getLocation();
				}
			}
		}
		else if (getGenre().equals("Comedy")) 
		{
			ArrayList<Comedy> list = m.getDataOfComedy();
			String title = t1.getText();
			for (Comedy  com: list) 
			{
				if (com.getTitle().equals(title)) 
				{
					return com.getLocation();
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(new JFrame(), "Data Not FOUND!!");
		}
		return null;
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getActionCommand().equals("Play")){

			String strPath = getPath();
			if (strPath != null) 
			{
				playMethod(strPath);
			}
			else{
			JOptionPane.showMessageDialog(null, "Enter name correctly");
			}
		}
		else if(ae.getActionCommand().equals("Back")){
			new MenuG();
		}
	}
}
}