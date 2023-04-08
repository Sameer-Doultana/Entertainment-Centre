import java.io.*;
import java.util.*;
public class Songs implements Serializable{
	private String title;
	private String location;
	private String singer;
	public Songs(){}
	public Songs(String title, String location, String singer){
		this.title = title;
		this.location = location;
		this.singer = singer;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setLocation(String location){
		this.location = location;
	}
	public void setSinger(String singer){
		this.singer = singer;
	}
	public String getTitle(){
		return title;
	}
	public String getLocation(){
		return location;
	}
	public String getSinger(){
		return singer;
	}
	
	ObjectInputStream read;
	public ArrayList<Songs> readInFile(){
		ArrayList<Songs> list = new ArrayList<>();
		try
		{
			File file = new File("Songs.ser");
			read = new ObjectInputStream(new FileInputStream(file));

			while(true)
			{
				list.add((Songs) read.readObject());
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