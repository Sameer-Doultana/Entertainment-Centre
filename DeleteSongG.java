import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DeleteSongG extends JFrame implements Serializable{
	Songs m = new Songs();
	JTextField t1 = new JTextField();
	public DeleteSongG() throws Exception{
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel l1 = new JLabel("Enter song name");
		JButton b1 = new JButton("Delete");
		JButton b2 = new JButton("Back");
		JTextArea ta1 = new JTextArea();
		JScrollPane pane = new JScrollPane(ta1);
		b1.setSize(10, 5);
		b2.setSize(10, 5);
		l1.setSize(10, 5);
		t1.setSize(10, 5);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b2.addActionListener(al);
		try{
			ArrayList<Songs> list = m.readInFile();
			for(Songs ss: list){
				String a = ("Song: "+ss.getTitle()+"\n");
				ta1.append(a);
			}
		}
		catch(NullPointerException e){

		}
		this.add(pane);
		this.add(l1);
		this.add(t1);
		this.add(b1);
		this.add(b2);
		setVisible(true);
	}
	public void delete(String name){
		try{
			ArrayList<Songs> s = m.readInFile();
			for (int i = 0; i < s.size(); i++){
				if (s.get(i).getTitle().equals(name)) {
				s.remove(i);
				}
			}
			FileOperations<Songs> del = new FileOperations<Songs>(new File("Songs.ser"));
			if(del.deleteFile()){
				for (Songs song: s){
					del.dataWriting(song, true);
				}
				JOptionPane.showMessageDialog(null, "Song Deleted SuccessfullY");
			}
			else{
				System.out.print("File Deletion Failed");
			}
		}
		catch(NullPointerException e){

		}
 	}


class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Delete")){
			//FileOperations<Songs> f = new FileOperations<Songs>(new File("Songs.ser"));
			delete(t1.getText());
			//JOptionPane.showMessageDialog(null, "Successful");
			AdminSectionG as = new AdminSectionG();
			dispose();
		}
		else if(ae.getActionCommand().equals("Back")){
			AdminSectionG as = new AdminSectionG();
			dispose();
		}
	}
}
}