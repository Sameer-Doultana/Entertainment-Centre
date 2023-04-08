import java.util.*;
import java.io.*;
public class Movies implements Serializable {
	private String title;
	private String genre;
	//Subscription s = new Subscription();
	public void setTitle(String title){
		this.title = title;
	}
	public void setGenre(String genre){
		this.genre = genre;
	}
	public String getTitle(){
		return title;
	}
	public String getGenre(){
		return genre;
	}
	public Movies(){}
	public Movies(String genre, String title){
		this.title = title;
		this.genre = genre;
	}
	public ArrayList<Action> getDataOfAction()
	{
		ArrayList<Movies> listMovie = readInFile();
		ArrayList<Action> listComedy = new ArrayList<>();
		for(int i = 0; i < listMovie.size(); i++)
		{
			if (listMovie.get(i) instanceof Action) 
			{
				Action c = (Action) listMovie.get(i);
				listComedy.add(c);
			}
		}
		return listComedy;
	}
	public ArrayList<Adventure> getDataOfAdventure()
	{
		ArrayList<Movies> listMovie = readInFile();
		ArrayList<Adventure> listComedy = new ArrayList<>();
		for(int i = 0; i < listMovie.size(); i++)
		{
			if (listMovie.get(i) instanceof Adventure) 
			{
				Adventure c = (Adventure) listMovie.get(i);
				listComedy.add(c);
			}
		}
		return listComedy;
	}
	public ArrayList<Comedy> getDataOfComedy()
	{
		ArrayList<Movies> listMovie = readInFile();
		ArrayList<Comedy> listComedy = new ArrayList<>();
		for(int i = 0; i < listMovie.size(); i++)
		{
			if (listMovie.get(i) instanceof Comedy) 
			{
				Comedy c = (Comedy) listMovie.get(i);
				listComedy.add(c);
			}
		}
		return listComedy;
	}
	ObjectInputStream read;
	public ArrayList<Movies> readInFile()
	{
		ArrayList<Movies> list = new ArrayList<>();
		try
		{
			File file = new File("Movies.ser");
			read = new ObjectInputStream(new FileInputStream(file));

			while(true)
			{
				list.add((Movies) read.readObject());
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

}