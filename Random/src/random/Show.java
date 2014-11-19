package random;

import java.awt.Container;  
import java.awt.Point;  
import java.awt.Toolkit;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
import java.io.File;  
import java.sql.Time;

import javax.swing.JButton;  
import javax.swing.JFileChooser;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JTabbedPane;  
import javax.swing.JTextField;  




public class Show implements ActionListener {  
    JFrame frame = new JFrame("RANDOMNUMBER-show");
    JTabbedPane tabPane = new JTabbedPane();
    Container con = new Container();
    JLabel label1 = new JLabel("DATAfile");  
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JButton button1 = new JButton("choose output dir");
    JFileChooser jfc = new JFileChooser();  
    JButton button3 = new JButton("start");
    
   
    Show() {  
        jfc.setCurrentDirectory(new File("d://")); 
        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();  
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();  
        frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));  
        frame.setSize(500, 200);  
        frame.setContentPane(tabPane);  
        label1.setBounds(10, 10, 70, 20);  
        text1.setBounds(75, 10, 180, 20);  
        button1.setBounds(280, 10, 180, 20);  
        button3.setBounds(110, 55, 280, 20);  
        button1.addActionListener(this);  
        button3.addActionListener(this);  
        con.add(label1);  
        con.add(text1);  
        con.add(button1);  
        con.add(button3);  
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        tabPane.add("choose dir", con);
          
    	
    }  
      
    public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
        if (e.getSource().equals(button1)) {  
            jfc.setFileSelectionMode(1);  
            int state = jfc.showOpenDialog(null);  
            if (state == 1) {  
                return;  
            } else {  
                File f = jfc.getSelectedFile();  
                text1.setText(f.getAbsolutePath());  
            }  
        }  
        if (e.getSource().equals(button3)) { 
        	String url=text1.getText();
        	text1.setText("Task running!");
        	/*try {
				//Thread.sleep(3000);
				
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
        	Generate.run(url);
        	
        	text1.setText("Task completed!");
        	
        	
        }
         
    } 
    
    
    
    
    
    public static void main(String[] args) {  
        new Show();  
    } 
    
}
