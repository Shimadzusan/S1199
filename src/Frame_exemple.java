import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//19-04-2018
public class Frame_exemple {
	
	static JTextArea text = new JTextArea(10,10);
	static TextArea text2 = new TextArea(10, 10);
	static JFrame frame = new JFrame();
	static String s;
	public static void main(String[] args) {

		
		frame.setSize(800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(new FlowLayout ());
		JButton button = new JButton("START");
		JButton button2 = new JButton("Button2");
		
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		frame.add(new JScrollPane(text), BorderLayout.NORTH);
	    
//////////////////////////////////////////////////////////////////////////////////
		
		panel.add(button);
		//panel.add(button2);
		button.addActionListener(new But());
		frame.add(text2, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

///////////////////лндскэ ондяверю йнкхвеярбю яхлбнкнб х якнб/////////////////////
	
	static public void butt() {
		
		String s = text.getText();
		char[] sof = s.toCharArray();
		int x = 0;
												//яйнкэйн опнаекнб, ярнкэйн х якнб!!!
		for(int i = 0; i < sof.length; i++) {
			String d = sof[i]+ "";
			if (d.equals(" ")) {
				x = x+1;
			}
			
		}
		
		String m = "йНКХВЕЯРБН ЯХЛБНКНБ: "+ sof.length +"\n" + "йНКХВЕЯРБН ЯКНБ: "+ x;
		System.out.println(s.length());
		text2.setText(m);
		
	}

}

class But implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("!!!");
		
		Frame_exemple.butt();
		
	}
	}
