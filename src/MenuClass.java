import java.awt.*;
import javax.swing.*;

/**
 * Class responsible for GUI. Creates a window and all its
 * elements with which a user interacts
 */


public class MenuClass extends JFrame  {
	
	MouseListen listen;
	JOptionPane option=new JOptionPane();
	JLabel Blabel1=new JLabel();
	
	JFrame parent = new JFrame();
	JMenu fileMenu=new JMenu("File");
	JMenu isloaded=new JMenu("Theres no loaded file");
	JMenuBar menuBar=new JMenuBar();
	JMenuItem quitItem=new JMenuItem("Quit");
	JMenuItem loadItem=new JMenuItem("Load");
	JScrollPane editorScrollPane=new JScrollPane();
	JPanel jPanel1=new JPanel();
	JPanel jPanel2=new JPanel();
	JPanel jPanel3=new JPanel();
	JTextArea text=new JTextArea();
	JTextField textField=new JTextField(30);
	
	JButton button1=new JButton();
	
	JButton button2=new JButton();
	
	/**
	 * Constructor of class MenuClass. Creates GUI
	 */
	public MenuClass(){
		  setTitle ("Assignment");
		  this.setResizable(false);
		  listen=new MouseListen(this);
		  
		  quitItem.addMouseListener(listen);
		  loadItem.addMouseListener(listen);
		  
		  this.setJMenuBar(menuBar);
		  menuBar.add(fileMenu);
		  menuBar.add(isloaded);
		  fileMenu.add(loadItem);
		  fileMenu.add(quitItem);
		 
		  button1=new JButton();
		  button2=new JButton();
		  button1.addActionListener(listen);
		  button2.addActionListener(listen);
		  button1.setText("Print Words With Line Numbers");
		  button2.setText("Search");
		  button1.setToolTipText("jestes debilem?");
		  button2.setToolTipText("jestes debilem?2");
		
		  Font newButtonFont=new Font(button1.getFont().getName(),button1.getFont().getStyle(),20);
		  button1.setFont(newButtonFont);
		  button1.setPreferredSize(new Dimension(980,80));
		
		  text.setBackground(Color.WHITE);
		  text.setEditable(false);
		  jPanel3.setBackground(Color.LIGHT_GRAY);
		 
		  JScrollPane editorScrollPane = new JScrollPane(text);
		  editorScrollPane.setPreferredSize(new Dimension(980, 476));
		 
		  jPanel1.add(editorScrollPane);   
		  jPanel2.setPreferredSize(new Dimension(1000,80));
		  jPanel3.setPreferredSize(new Dimension(1000,80));
		 
		  jPanel2.add(button1);
		  jPanel3.add(button2);
		  jPanel3.add(textField);
		  add(jPanel1, BorderLayout.CENTER);
		  add(jPanel2, BorderLayout.NORTH);
		  add(jPanel3, BorderLayout.SOUTH);
		 
		  setSize(1000, 700);
		  setVisible(true);
		  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   }
	
	/**
	 * Method used to inform that the file has been loaded
	 */
	 public void isLoaded(){
		 isloaded.setText("File has been Loaded");
	 }
	
}
