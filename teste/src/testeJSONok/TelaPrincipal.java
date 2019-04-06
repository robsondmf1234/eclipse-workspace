package testeJSONok;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Programa que busca o endere�o de acordo com o cep passado.
//IMPLEMENTAdo Programa busca o cep ap�s digitar o cep e pressionar o ENTER

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CEP:");
		lblNewLabel.setBounds(24, 30, 46, 14);
		contentPane.add(lblNewLabel);

		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

					String cep = txtCep.getText();
					BuscaCep busca = new BuscaCep();
					BuscaCep buscar = busca.buscarCep(Integer.parseInt(cep));
					System.out.println("Endere�o:" + buscar.getRua());

					txtEnd.setText(buscar.getRua() + " Bairro: " + buscar.getBairro() + " Estado: " + buscar.getEstado()
							+ " CEP: " + buscar.getCep());

				}
			}
		});
		txtCep.setBounds(59, 27, 161, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCep();
			}
		});
		btnNewButton.setBounds(230, 26, 54, 23);
		contentPane.add(btnNewButton);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(24, 103, 62, 14);
		contentPane.add(lblEndereo);

		txtEnd = new JTextField();
		txtEnd.setBounds(87, 100, 391, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);
	}

	protected void buscarCep() {
		String cep = txtCep.getText();
		BuscaCep busca = new BuscaCep();
		BuscaCep buscar = busca.buscarCep(Integer.parseInt(cep));
		System.out.println("Endere�o:" + buscar.getRua());

		txtEnd.setText(buscar.getRua() + " Bairro: " + buscar.getBairro() + " Estado: " + buscar.getEstado() + " CEP: "
				+ buscar.getCep());
	}
}
