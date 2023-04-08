import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
public class Adventure extends Movies implements Serializable{
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
	public Adventure(){
		super();
	}
	public Adventure(String genre, String title, String location, String description)
	{
		super(genre, title);
		this.description = description;
		this.location = location;
	}
	public String toString()
	{
		return ("Movie Title: "+getTitle()+"\nGenre: "+getGenre()+"\nDescription: "+getDescription());
	}
// public String readData(){
// 		Adventure ad = new Adventure();
// 		String str = "";
// 		try{
// 			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Movies.txt"));
// 			try{
// 				while(true){
// 					ad = (Adventure)ois.readObject();
// 					str += ("Title: "+ad.getTitle()+"\nDescription: "+ad.getDescription()+"\n");
// 				}
// 			}
// 			catch(EOFException e){
// 				ois.close();
// 			}
			
// 		}
// 		catch(Exception e){

			
// 		}
// 	return str;
// 	}
// 	public String readTitle(){
// 		Adventure a = new Adventure();
// 		String title ="";
// 		try{
// 			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Movies.txt"));
// 			try{
// 				while(true){
// 					a = (Adventure)ois.readObject();
// 					title += (a.getTitle());
// 				}
// 			}
// 			catch(EOFException e){
// 				ois.close();
// 			}
// 		}
// 		catch(Exception e){

// 		}
// 		return title;
// 	}
// 	public String readLocation(){
// 		Adventure a = new Adventure();
// 		String path ="";
// 		try{
// 			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Movies.txt"));
// 			try{
// 				while(true){
// 					a = (Adventure)ois.readObject();
// 					path += (a.getLocation());
// 				}
// 			}
// 			catch(EOFException e){
// 				ois.close();
// 			}
// 		}
// 		catch(Exception e){

// 		}
// 		return path;
// 	}
	public ArrayList<Adventure> readInAdventure()
	{
		ArrayList<Adventure> list = new ArrayList<>();
		try
		{
			File file = new File("Movies.ser");
			read = new ObjectInputStream(new FileInputStream(file));

			while(true)
			{
				list.add((Adventure) read.readObject());
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
		Adventure c = new Adventure();
		ArrayList<Adventure> s = c.readInAdventure();
		for (int i = 0; i < s.size(); i++) 
		{
			if (s.get(i).getTitle().equals(name)) 
			{
				s.remove(i);
			}
		}
		FileOperations<Adventure> del = new FileOperations<Adventure>(new File("Movies.ser"));
		if(del.deleteFile())
		{
			for (Adventure com: s) 
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