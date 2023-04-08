import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class DisplayClass extends JFrame{
	Songs s = new Songs();
	JTextField t1 = new JTextField();
	public DisplayClass(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel l1 = new JLabel("Enter song name");
		JButton b1 = new JButton("Play");
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
			ArrayList<Songs> list = s.readInFile();
			for(Songs ss: list){
				String a = ("Song: "+ss.getTitle()+"\nSinger: "+ss.getSinger()+"\n");
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
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){	
		if(ae.getActionCommand().equals("Play")){
			try{
				ArrayList<Songs> list = s.readInFile();
				for(Songs song: list){
					if(t1.getText().equals(song.getTitle())){
						playMethod(song.getLocation());
					}
				}
			}
			catch(NullPointerException e){

			}
		}
		else if(ae.getActionCommand().equals("Back")){
			new MenuG();
		}
	}
}
public void playMethod(String path) {
		try
		{
			Desktop.getDesktop().open(new File(path));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}