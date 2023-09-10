/*
 * This is a simple TicTacToe game that uses the Swing Framework.
 *
 * @author Nicholas Tylka
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * This is a simple TicTacToe game that uses the Swing Framework.
 *
 * @author Nicholas Tylka
 */

public class TicTacToe implements ActionListener {

	Random random = new Random();
	boolean playerOneTurn;
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];

	// constructor
	public TicTacToe() {
		// setup frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		// setup textField for the titlePanel
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Arial", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);

		// setup titlePanel
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);

		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));

		// setup each button to be blank and add them to the buttonsPanel
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		// add textField to titlePanel
		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel);

		firstTurn();
	}

	public void firstTurn() {

		// display title text for 2000/ms
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// set who's turn it is using random
		if (random.nextInt(2) == 0) {
			playerOneTurn = true;
			textField.setText("X Turn");
		} else {
			playerOneTurn = false;
			textField.setText("O Turn");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// loop through all buttons
		for (int i = 0; i < buttons.length; i++) {
			// check if current button is one being pressed
			if (e.getSource() == buttons[i]) {
				// if it's player one's turn, set this button to "X",
				// and change title to "O Turn"
				if (playerOneTurn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						playerOneTurn = false;
						textField.setText("O Turn");
						check();
					}
				} else { // do same for O player
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						playerOneTurn = true;
						textField.setText("X Turn");
						check();
					}
				}
			}

		}
	}

	public void check() {
		// check X win conditions
		// if top row are X's
		if ((buttons[0].getText() == "X")
				&& (buttons[1].getText() == "X")
				&& (buttons[2].getText() == "X")) {
			xWins(0, 1, 2);
			// else if middle row
		} else if ((buttons[3].getText() == "X")
				&& (buttons[4].getText() == "X")
				&& (buttons[5].getText() == "X")) {
			xWins(3, 4, 5);
			// else if bottom row
		} else if ((buttons[6].getText() == "X")
				&& (buttons[7].getText() == "X")
				&& (buttons[8].getText() == "X")) {
			xWins(6, 7, 8);
			// else if left column
		} else if ((buttons[0].getText() == "X")
				&& (buttons[3].getText() == "X")
				&& (buttons[6].getText() == "X")) {
			xWins(0, 3, 6);
			// else if middle column
		} else if ((buttons[1].getText() == "X")
				&& (buttons[4].getText() == "X")
				&& (buttons[7].getText() == "X")) {
			xWins(1, 4, 7);
			// else if right column
		} else if ((buttons[2].getText() == "X")
				&& (buttons[5].getText() == "X")
				&& (buttons[8].getText() == "X")) {
			xWins(2, 5, 8);
			// else if left top starting diagonal
		} else if ((buttons[0].getText() == "X")
				&& (buttons[4].getText() == "X")
				&& (buttons[8].getText() == "X")) {
			xWins(0, 4, 8);
			// else if right top starting diagonal
		} else if ((buttons[2].getText() == "X")
				&& (buttons[4].getText() == "X")
				&& (buttons[6].getText() == "X")) {
			xWins(2, 4, 6);
		}

		// check O win conditions
		// if top row are O's
		if ((buttons[0].getText() == "O")
				&& (buttons[1].getText() == "O")
				&& (buttons[2].getText() == "O")) {
			oWins(0, 1, 2);
			// else if middle row
		} else if ((buttons[3].getText() == "O")
				&& (buttons[4].getText() == "O")
				&& (buttons[5].getText() == "O")) {
			oWins(3, 4, 5);
			// else if bottom row
		} else if ((buttons[6].getText() == "O")
				&& (buttons[7].getText() == "O")
				&& (buttons[8].getText() == "O")) {
			oWins(6, 7, 8);
			// else if left column
		} else if ((buttons[0].getText() == "O")
				&& (buttons[3].getText() == "O")
				&& (buttons[6].getText() == "O")) {
			oWins(0, 3, 6);
			// else if middle column
		} else if ((buttons[1].getText() == "O")
				&& (buttons[4].getText() == "O")
				&& (buttons[7].getText() == "O")) {
			oWins(1, 4, 7);
			// else if right column
		} else if ((buttons[2].getText() == "O")
				&& (buttons[5].getText() == "O")
				&& (buttons[8].getText() == "O")) {
			oWins(2, 5, 8);
			// else if left top starting diagonal
		} else if ((buttons[0].getText() == "O")
				&& (buttons[4].getText() == "O")
				&& (buttons[8].getText() == "O")) {
			oWins(0, 4, 8);
			// else if right top starting diagonal
		} else if ((buttons[2].getText() == "O")
				&& (buttons[4].getText() == "O")
				&& (buttons[6].getText() == "O")) {
			oWins(2, 4, 6);
		}

	}

	public void xWins(int a, int b, int c) {
		// set the winning buttons to be green
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		// disable all buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(false);
		}

		// set text to show x won
		textField.setText("X WINS!!!");
	}

	public void oWins(int a, int b, int c) {
		// set the winning buttons to be green
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		// disable all buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(false);
		}

		// set text to show o won
		textField.setText("O WINS!!!");
	}
}
