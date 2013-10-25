import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class that is responsible for all the events in the program.
 * It implements MouseListener and ActionListener
 */
public class MouseListen  implements MouseListener, ActionListener {
	General concord=new General();///////////////////////////////////////////////////
	private MenuClass menu;
	private boolean isEmpty=true;
	private String path;
	
	public MouseListen(MenuClass m){
		menu=m;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	/**
	 * Method responsible for all the events when a mouse
	 * is pressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		try {
			if (e.getSource()==menu.quitItem){
				System.exit(0); 
				}
			else if(e.getSource()==menu.loadItem){
				JFileChooser choose=new JFileChooser();
				int returnVal=choose.showOpenDialog(menu);
				if(returnVal==JFileChooser.APPROVE_OPTION) {
					File f=choose.getSelectedFile();
						concord.loadBook(f.getPath());
						path=f.getPath().toString();
						menu.isLoaded();
					}
				}
			}catch(Exception ex){
				ex.printStackTrace();	
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	/**
	 * Method responsible for all the events when an action is performed
	 * on a JButton or JMenuItem
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	if(path!=null){	
		
		
		if (isEmpty==true && e.getActionCommand().equals("Print Words With Line Numbers")) {
			menu.text.append(concord.getBookContent());
			isEmpty=false;
		}
		else if (isEmpty==false && e.getActionCommand().equals("Print Words With Line Numbers")) {
			menu.text.setText("");
			menu.text.append(concord.getBookContent());
			isEmpty=false;
		}
		else if (isEmpty==true && e.getActionCommand().equals("Search")){
			String word=menu.textField.getText();
			menu.text.append(concord.findWordInfo(word));
		    isEmpty=false;
	    }
		else if(isEmpty==false && e.getActionCommand().equals("Search")){	
			menu.text.setText("");
			String word=menu.textField.getText();
			menu.text.append(concord.findWordInfo(word));
			isEmpty=false;
		}
	}
	else{
		String message = "Load some book first";
		    menu.option.showMessageDialog(new JFrame(), message, "Dialog",
		        JOptionPane.ERROR_MESSAGE);
	}
	}
	
	}

