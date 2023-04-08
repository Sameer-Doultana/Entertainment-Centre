import java.io.*;
import java.util.*;
public class AccountData implements Serializable{
	private String name;
	private String username;
	private String password;
	private String contact;
	
	public AccountData(){}
	public AccountData(String name, String username, String password, String contact){
		this.name = name;
		this.username = username;
		this.password = password;
		this.contact = contact;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setUserName(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setContact(String contact){
		this.contact = contact;
	}
	public String getName(){
		return name;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getContact(){
		return contact;
	}
	ObjectInputStream read;
	public ArrayList<AccountData> readInFile(){
		ArrayList<AccountData> list = new ArrayList<>();
		try
		{
			File file = new File("AccountData.ser");
			read = new ObjectInputStream(new FileInputStream(file));

			while(true)
			{
				list.add((AccountData) read.readObject());
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