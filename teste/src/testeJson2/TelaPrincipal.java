package testeJson2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		System.out.println("Endereço:"+buscar.getRua());
		
		txtEnd.setText(buscar.getRua()+" Bairro: "+buscar.getBairro()+" Estado: "+buscar.getEstado()+" CEP: "+buscar.getCep());
	}
}
