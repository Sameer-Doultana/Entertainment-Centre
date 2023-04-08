import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
public class Comedy extends Movies implements Serializable{
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
	public Comedy(){
		super();
	}
	public Comedy(String genre, String title, String location, String description)
	{
		super(genre, title);
		this.description = description;
		this.location = location;
	}
	public String toString()
	{
		return ("Movie Title: "+getTitle()+"\nGenre: "+getGenre()+"\nDescription: "+getDescription()+"\nLocation: "+getLocation());
	}

	
	// public static void main(String[] args) {
	// 	Movies m = new Movies();
	// 	ArrayList<Comedy> list = m.getDataOfComedy();
	// 	for(Comedy c : list){
	// 		System.out.println(c.toString());
	// 	}
	// }
	ObjectInputStream read;
	public ArrayList<Comedy> readInComedy() {
		ArrayList<Comedy> list = new ArrayList<>();
		try
		{
			File file = new File("Movies.ser");
			read = new ObjectInputStream(new FileInputStream(file));

			while(true)
			{
				list.add((Comedy) read.readObject());
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
	public void delete(String name){
		Comedy c = new Comedy();
		ArrayList<Comedy> s = c.readInComedy();
		for (int i = 0; i < s.size(); i++) 
		{
			if (s.get(i).getTitle().equals(name)) 
			{
				s.remove(i);
			}
		}
		FileOperations<Comedy> del = new FileOperations<Comedy>(new File("Movies.ser"));
		if(del.deleteFile())
		{
			for (Comedy com: s) 
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
	// public String readData(){
	// 	Comedy c = new Comedy();
	// 	String str = "";
	// 	try{
	// 		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Movies.txt"));
	// 		try{
	// 			while(true){
	// 				c = (Comedy)ois.readObject();
	// 				str += ("Title: "+c.getTitle()+"\nDescription: "+c.getDescription()+"\n");
	// 			}
	// 		}
	// 		catch(EOFException e){
	// 			ois.close();
	// 		}
			
	// 	}
	// 	catch(Exception e){

			
	// 	}
	// return str;
	// }
	// public String readTitle(){
	// 	Comedy c = new Comedy();
	// 	String title ="";
	// 	try{
	// 		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Movies.txt"));
	// 		try{
	// 			// while(true){
	// 				c = (Comedy)ois.readObject();
	// 				title += (c.getTitle());
	// 			// }
	// 		}
	// 		catch(EOFException e){
	// 			ois.close();
	// 		}
	// 	}
	// 	catch(Exception e){

	// 	}
	// 	return title;
	// }
	// public String readLocation(){
	// 	Comedy c = new Comedy();
	// 	String path ="";
	// 	try{
	// 		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Movies.ser"));
	// 		try{
	// 			while(true){
	// 				c = (Comedy)ois.readObject();
	// 				path += (c.getLocation());
	// 			}
	// 		}
	// 		catch(EOFException e){
	// 			ois.close();
	// 		}
	// 	}
	// 	catch(Exception e){

	// 	}
	// 	return path;
	// }
}