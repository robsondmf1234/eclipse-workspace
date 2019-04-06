package keylistener;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TesteKeylistener extends JFrame {
	private JTextField txtCampo;

	public TesteKeylistener() {
		
		setSize(354,129);
		setLocationRelativeTo(this);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTeste = new JLabel("TESTE:");
		lblTeste.setBounds(38, 31, 46, 14);
		getContentPane().add(lblTeste);
		
		txtCampo = new JTextField();
		txtCampo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String numCaracteres = txtCampo.getText();
				int numero = numCaracteres.length()+1;
				System.out.println("Numero de caracteres: "+numero);
				if (numero==8) {
					System.out.println("Deu 8 caracteres!");
				}
			}
		});
		txtCampo.setBounds(88, 28, 199, 20);
		getContentPane().add(txtCampo);
		txtCampo.setColumns(10);
	}
	
	
	public static void main(String[] args) {
		new TesteKeylistener();

	}

}
