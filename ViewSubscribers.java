import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class ViewSubscribers extends JFrame{
	AccountData ad = new AccountData();
	public ViewSubscribers(){
		setSize(400, 400);
		setLayout(new GridLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton b1 = new JButton("Back");
		JTextArea ta1 = new JTextArea();
		JScrollPane pane = new JScrollPane(ta1);
		MyActionListener al = new MyActionListener();
		b1.addActionListener(al);
		b1.setSize(10, 5);
		ta1.setSize(40, 10);
		try{
			ArrayList<AccountData> list = ad.readInFile();
			for(AccountData act: list){
				String a = ("Name: "+act.getName()+"\nUsername: "+act.getUsername()+"\nPassword: "+act.getPassword()+"\nContact: "+act.getContact()+"\n");
				ta1.append(a);
			}
		}
		catch(NullPointerException e){
			
		}
		this.add(pane);
		this.add(b1);
		setVisible(true);
	}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Back")){
			AdminSectionG ag = new AdminSectionG();
			dispose();
		}
	}
}
}