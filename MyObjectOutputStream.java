import java.io.*;
public class MyObjectOutputStream extends ObjectOutputStream{
	public MyObjectOutputStream() throws IOException{
		super();
	}
	public MyObjectOutputStream(OutputStream outputStream) throws IOException{
		super(outputStream);
	}
	public void writeStreamHeader(){
		
	}
}