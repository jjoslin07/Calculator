import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton;
	JPanel panel;

	Font myFont = new Font("Herculanum", Font.BOLD, 30);

	double num1 = 0, num2 = 0, result = 0;
	char operator;

	Calculator() {

	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
