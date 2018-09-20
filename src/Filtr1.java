import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//20-04-2018	*���������� ����������� � �����
public class Filtr1 {
	
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
		button.addActionListener(new But1());
		frame.add(text2, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

///////////////////ВСЕ ВЗАИМОДЕЙСТВИЕ НАЛЕПИЛ В ОДИН МЕТОД НА 150 СТРОК!!!///////
	
	static public void butt() {
		
		String s = text.getText();
		char[] sof = s.toCharArray();
		int x = 0;
												//по точкам считаем предложения!!!
		for(int i = 0; i < sof.length; i++) {
			String d = sof[i]+ "";
			if (d.equals(".")) {
				x = x+1;
			}
			
		}
		
//////////////////////�����///////////////////////////////////////////////////////////
		
		String[] text = s.split(" ");				//���������� �� ��������
		for(int i = 0; i < text.length; i++) {
			System.out.println(text[i]);
		}
													//�������� ���������
		String result = "";
		for(int i = 0; i < text.length; i++ ){
			result = result + " " + text[i];
			
		}
		
///////////////////////////////�����//////////////////////////////////////////////
//		for(int i = 0; i < sof.length; i++){
//		char h = sof[i];
//		String j = Character.toString(h);
//			if(sof[i] == '�' && sof[i+1] == '�' && sof[i+2] == '�' && sof[i+3] == '�'){
//				System.out.println("+++ZZZ+++");
//			
//		}
//			
//		}
//////////////////////////////LOWER/////////////////////////////////////////////////
		
String j = s;
String result2 = "";
		
		
		
///////////////////////////////////////////////////////////////////////////////////////////
		String[] text5 = s.split(" ");
		
		for(int i = 0; i < text5.length; i++) {
			System.out.println(text5[i]);
		}
		System.out.println(j);
		String lower = j.toLowerCase();
		System.out.println(lower + "I am LOWER");
		String [] kk = lower.split(" ");
		System.out.println("------------------------------");
		for(int i = 0; i < kk.length; i++) {
			System.out.println(kk[i]+" ooo");
			result2 = result2 + kk[i];
			
		}
		
//////////////////////////////////////////����� 222////////////////////////////////////////
		char[] mass = result2.toCharArray();
		int sir = 0;
		int rus = 0;
		int us = 0;
		int am = 0;
		
		for(int i = 0; i < mass.length; i++){
			//System.out.println("Im SYRIA");
			//�����
				if(mass[i] == '�' && mass[i+1] == '�' && mass[i+2] == '�' && mass[i+3] == '�'){
					System.out.println("+++ZZZ+++");
					sir++;
				
			}
				//������
				if(mass[i] == '�' && mass[i+1] == '�' && mass[i+2] == '�' && mass[i+3] == '�' && mass[i+4] == '�'){
					System.out.println("+++RRR+++");
					rus++;
				
			}
				//USA and America
				if(mass[i] == '�' && mass[i+1] == '�' && mass[i+2] == '�'){
					System.out.println("+++USA+++");
					us++;
				}
				
				if(mass[i] == '�' && mass[i+1] == '�' && mass[i+2] == '�' && mass[i+3] == '�' && mass[i+4] == '�'){
					System.out.println("+++AMER+++");
					am++;
				}
				
				
			}
		System.out.println("Russia: " + rus);
		System.out.println("Syria: " + sir);
		//String[] sss = 
		
		
/////////////////////////////////////////////TO CLEAR!!!//////////////////////////////////
		int index = 0;
		for(int i = 0; i < mass.length; i++){
			// ������ ������� 1999-2018
				if(mass[i] == '1' && mass[i+1] == '9' && mass[i+2] == '9' && mass[i+3] == '9'){
					System.out.println("I AM CLEAR, POINT: " + i);
					index = i;
					
				
			}
		}
		
		ArrayList list = new ArrayList();
		for(int i = 0; i < index; i++) {
			char c = mass[i];
			list.add(c);
		}
		String list2 = "";
		for(int i = 0; i < list.size(); i++) {
			char b = (Character) list.get(i);
			list2 = list2 + b;
			
		}
		System.out.println("****" + list2 + "***");
		//LIST2 ��� ��������� ������!!!
///////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("I am RESULT2 LOWER: " + result2);
		
		
//////////////////////////////////////////////////////////////////////////////////////
		
		String m = "���������� ��������: "+ sof.length +"\n" + "���������� �����������: "+ x + "\n" + "Syria: " + sir + "\n" + "Russia: " + rus +
				"\n" + "USA: " + us + "\n" + "America: " + am;
		System.out.println(s.length());
		System.out.println("Size array TEXT: " + text.length);
		
		System.out.println("--------------------------");
		System.out.println("I am RESULT: " + result);
		
		text2.setText(m);
		
	}

}

class But1 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("!!!");
		
		Filtr1.butt();
		
	}
	}
