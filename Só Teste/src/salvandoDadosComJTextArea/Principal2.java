package salvandoDadosComJTextArea;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Principal2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 frame = new Principal2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTeste = new JLabel("Teste");
		lblTeste.setBounds(31, 30, 46, 14);
		contentPane.add(lblTeste);

		textField = new JTextField();
		textField.setBounds(117, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JTextArea txtrTestando = new JTextArea();
		txtrTestando.setText("testando");
		txtrTestando.setBounds(117, 80, 255, 179);
		contentPane.add(txtrTestando);
	}

	private void gravar(String txtrTestando, String txtArea) throws IOException {
		InputStream is = new FileInputStream(txtArea);
		InputStreamReader isr = new InputStreamReader(is);
		int c = isr.read();
		System.out.println(c);

	}
}
