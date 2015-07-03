package ba.bitcamp.task02;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdjustableFontStzle extends JPanel{

	
	private static final long serialVersionUID = -6619949715874012366L;
	
	//Declaring variables
	private int font = Font.PLAIN;
	private JLabel text = new JLabel("Example");
	
	
	
	public AdjustableFontStzle(int width,int height){
		
		//Label settings
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setFont(new Font("Serif", font, 25));
		text.setPreferredSize(new Dimension(width, height/2));
		add(text);
		
		//Making two checkboxes
		JCheckBox bold = new JCheckBox("Bold");
		JCheckBox italic = new JCheckBox("Italic");
		bold.setPreferredSize(new Dimension(width, height/7));
		italic.setPreferredSize(new Dimension(width, height/7));
		
		
		//Button settings
		JButton apply = new JButton("Apply");
		apply.setPreferredSize(new Dimension(width-10, height/7-10));
		apply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == apply){
				if(bold.isSelected()  && italic.isSelected() ){
					font = Font.BOLD + Font.ITALIC;
				}else if(bold.isSelected()){
					font = Font.BOLD;
				}else if(italic.isSelected()){
					font = Font.ITALIC;
				}else{
					font = Font.PLAIN;
				}
				
				}text.setFont(new Font("Serif", font, 25));
			}
		});
		
		//Adding components on panel
		add(bold);
		add(italic);
		add(apply);
	}
	

	public static void main(String[] args) {
		
		//Declaring width and height
		 int width = 300;
		 int height = 500;
		
		 
		 //Creating window and panel
		JFrame window = new JFrame();
		JPanel container = new AdjustableFontStzle( width, height);
		
		//Adding panel to window
		window.add(container);
		
		//Window settings
		window.setTitle("Adjustable font style");
		window.setSize(width, height);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
