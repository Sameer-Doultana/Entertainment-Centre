import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.awt.*;
public class FileOperations<T>{
	private File file;
	public void setFile(File file)
	{
		this.file = file;
	}

	public File getFile()
	{
		return  file;
	}
	FileOperations(File file)
	{
		this.file = file;
	}
	public void dataWriting(T obj, boolean append){
		try{
			File f = getFile();
			if(f.exists()){
				MyObjectOutputStream writer = new MyObjectOutputStream(new FileOutputStream(f, append));
				writer.writeObject(obj);
				writer.close();
			}
			else{
				ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(f));
				writer.writeObject(obj);
				writer.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
 	public boolean deleteFile()
 	{
 		if (getFile().delete()) 
 		{
 			return true;
 		}
 		return false;
 	}
	

	// public String showAllMovies(){
	// 	ObjectInputStream ois;
	// public ArrayList<Action> readData(){
	// 	ArrayList<Action> list = new ArrayList<>();
	// 	try{
	// 		ois = new ObjectInputStream(new FileInputStream("Action.ser"));
	// 			while(true){
	// 				System.out.print("1");
	// 				list.add((Action) ois.readObject());
	// 			}
			
	// 	}
	// 	catch(Exception e){
	// 		try
	// 		{	
	// 			ois.close();
	// 		}
	// 		catch(IOException p)
	// 		{

	// 		}

	// 		return list;
	// 	}
	// }
	//}
	// public void readData(){
	// 	try{
	// 		ObjectInputStream reader = new ObjectInputStream(new FileInputStream("Userdata.txt"));
	// 		try{
	// 			while(true){
	// 				AccountData ad = (AccountData) reader.readObject();
	// 				System.out.println(ad.getName());
	// 				System.out.println(ad.getUsername());
	// 				System.out.println(ad.getPassword());
	// 				System.out.println(ad.getContact());
	// 			}
	// 		}
	// 		catch(ClassNotFoundException e){

	// 		}
	// 		catch(EOFException e){
	// 			reader.close();
	// 		}
	// 	}
	// 	catch(Exception e){

	// 	}
	// }
	// public void dataWriting2(Adventure a){
	// 	try{
	// 		File f = new File("Adventure.text");
	// 		if(f.exists()){
	// 			MyObjectOutputStream writer = new MyObjectOutputStream(new FileOutputStream(f, true));
	// 			writer.writeObject(a);
	// 			writer.close();
	// 		}
	// 	}
	// 	catch(Exception e){
	// 		e.printStackTrace();
	// 	}
	// }
	// public void dataWriting3(Action act){
	// 	try{
	// 		File f = new File("Action.text");
	// 		if(f.exists()){
	// 			MyObjectOutputStream writer = new MyObjectOutputStream(new FileOutputStream(f, true));
	// 			writer.writeObject(act);
	// 			writer.close();
	// 		}
	// 	}
	// 	catch(Exception e){
	// 		e.printStackTrace();
	// 	}
	// }
	// public void dataWriting4(Comedy c){
	// 	try{
	// 		File f = new File("Comedy.text");
	// 		if(f.exists()){
	// 			MyObjectOutputStream writer = new MyObjectOutputStream(new FileOutputStream(f, true));
	// 			writer.writeObject(c);
	// 			writer.close();
	// 		}
	// 	}
	// 	catch(Exception e){
	// 		e.printStackTrace();
	// 	}
	// }
	// public void adminDataWriting(AdminLogin al){
	// 	try{
	// 		File f = new File("Admin.text");
	// 		MyObjectOutputStream write = new MyObjectOutputStream(new FileOutputStream(f));
	// 		write.writeObject(al);
	// 		writer.close();
	// 	}
	// 	catch(Exception e){
	// 		e.printStackTrace();
	// 	}
	// }
}