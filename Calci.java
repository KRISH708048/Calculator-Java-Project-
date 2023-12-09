import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class Calci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorA c=new CalculatorA();
	}

}

class CalculatorA extends JFrame implements ActionListener{
	ArrayList<JButton> b;
	static int op1=-1;
	static int op2=-1;
	static float res;
	static String c;
	JLabel result;
	public CalculatorA() {
		
		JPanel pa = new JPanel();
		pa.setLayout(new GridLayout(4,4));
		b=new ArrayList<>();
		String num="789X456/123-0C=+";
		for(int i=0;i<num.length();i++) {
			b.add(new JButton(String.valueOf(num.charAt(i))));
			pa.add(b.get(i));
			b.get(i).addActionListener(this);
		}
		
		result = new JLabel(String.valueOf(res),JLabel.RIGHT);
		result.setFont( new Font( "Courier", Font.BOLD, 24 ) );
		setVisible(true);
		setSize(300,300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add("North",result);
		add("Center",pa);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		int f=0;
		Iterator<JButton> i=b.iterator();
		while(i.hasNext()) {
			JButton cur = i.next();
			if(e.getSource() == cur) {
				if(cur.getText().matches("[0-9]")) {
					if(op1 == -1) {
						op1 = Integer.parseInt(cur.getText());
						res = op1;
					}
					else
					{
						op2=Integer.parseInt(cur.getText());
						res =op2;
					}
				}
				else if(cur.getText().equals("=")) {
					if(c.equals("X")) {
						res = op1*op2;
					}
					else if(c.equals("/")) {
						res = (float)(op1/op2);
					}
					else if(c.equals("+")) {
						res = op2+op1;
					}
					else if(c.equals("-")) {
						res = op1-op2;
					}
					
				}
				else if(cur.getText().equals("C")) {
					res =0;
					op1=-1;
					op2=-1;
					c=null;
					System.out.println(op1);
					System.out.println(op2);
					System.out.println(c);
				}
				else {
					c = cur.getText();
					f=1;
				}
				break;
			}
		}
		if(f == 1) {
			result.setText(c);
			f=0;
		}
		else
			result.setText(String.valueOf(res));
	}
}
