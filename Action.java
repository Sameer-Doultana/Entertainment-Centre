import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class Action extends Movies implements Serializable{
	private String description;
	private String location;
	public void setDescription(String description){
		this.description = description;
	}
	public void setLocation(String location){
		this.location = location;
	}
	public String getDescription(){
		return description;
	}
	public String getLocation(){
		return location;
	}
	public Action(){
		super();
	}
	public Action(String genre, String title, String location, String description)
	{
		super(genre, title);
		this.description = description;
		this.location = location;
	}
	public String toString()
	{
		return ("Movie Title: "+getTitle()+"\nGenre: "+getGenre()+"\nDescription: "+getDescription());
	}

	public ArrayList<Action> readInAction()
	{
		ArrayList<Action> list = new ArrayList<>();
		try
		{
			File file = new File("Movies.ser");
			read = new ObjectInputStream(new FileInputStream(file));

			while(true)
			{
				list.add((Action) read.readObject());
			}

		}
		catch (ClassNotFoundException e)
		{
			try{
				read.close();
			}
			catch(IOException b)
			{}
			return list;
		}
		catch (EOFException e)
		{
			try{
				read.close();
			}
			catch(IOException b)
			{}
			return list;
		}
		catch (Exception b)
		{
			try{
				read.close();
			}
			catch(IOException e)
			{}
			return list;
		}
	}
	public void delete(String name)
	{
		Action c = new Action();
		ArrayList<Action> s = c.readInAction();
		for (int i = 0; i < s.size(); i++) 
		{
			if (s.get(i).getTitle().equals(name)) 
			{
				s.remove(i);
			}
		}
		FileOperations<Action> del = new FileOperations<Action>(new File("Movies.ser"));
		if(del.deleteFile())
		{
			for (Action com: s) 
			{
				del.dataWriting(com, true);
			}
			JOptionPane.showMessageDialog(null, "Movie Deleted SuccessfullY");
		}
		else
		{
			System.out.print("File Deletion Failed");
		}
 	}
}