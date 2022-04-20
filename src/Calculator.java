import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;

	Font myFont = new Font("Baskerville", Font.PLAIN, 35);
	Font myFont2 = new Font("Baskerville", Font.PLAIN, 65);

	double num1 = 0, num2 = 0, result = 0;
	char operator;

	Calculator() {

		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(310, 490);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(71, 73, 72));

		textField = new JTextField();
		textField.setBounds(0, 0, 310, 100);
		textField.setFont(myFont2);
		textField.setEditable(false);
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("÷");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("C");
		negButton = new JButton("( - )");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		for (int i = 0; i < functionButtons.length; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setForeground(Color.WHITE);

			if (functionButtons[i] != clrButton && functionButtons[i] != delButton && functionButtons[i] != decButton
					&& functionButtons[i] != negButton) {

				functionButtons[i].setBackground(new Color(253, 140, 0));
				functionButtons[i].setOpaque(true);
				functionButtons[i].setBorderPainted(false);
			} else {
				functionButtons[i].setBackground(new Color(164, 167, 172));
				functionButtons[i].setOpaque(true);
				functionButtons[i].setBorderPainted(false);

			}
			if (functionButtons[i] == decButton) {
				functionButtons[i].setBackground(new Color(164, 167, 172));
				functionButtons[i].setOpaque(true);
				functionButtons[i].setBorderPainted(false);
			}

		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(new Color(164, 167, 172));
			numberButtons[i].setOpaque(true);
			numberButtons[i].setBorderPainted(false);
			numberButtons[i].setForeground(Color.WHITE);
		}
		negButton.setBounds(5, 405, 98, 50);
		delButton.setBounds(105, 405, 98, 50);
		clrButton.setBounds(205, 405, 100, 50);

		panel = new JPanel();
		panel.setBounds(5, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 2, 2));
		panel.setBackground(new Color(71, 73, 72));

		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(equButton);
		panel.add(divButton);

		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textField);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}

		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = 'x';
			textField.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '÷';
			textField.setText("");
		}
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case 'x':
				result = num1 * num2;
				break;
			case '÷':
				result = num1 / num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clrButton) {
			textField.setText("");
		}
		if (e.getSource() == delButton) {
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}

		}
		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}

	}

}
