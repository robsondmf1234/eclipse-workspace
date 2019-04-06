package testeLogineSenha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtLogin2;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(49, 36, 46, 14);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setBounds(144, 33, 217, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(49, 74, 46, 14);
		contentPane.add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logar();
			}
		});
		btnEntrar.setBounds(51, 117, 89, 23);
		contentPane.add(btnEntrar);

		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			limpar();
			}
		});
		btnNewButton_1.setBounds(176, 117, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNome2 = new JLabel("Login");
		lblNome2.setBounds(49, 171, 46, 14);
		contentPane.add(lblNome2);

		txtLogin2 = new JTextField();
		txtLogin2.setBounds(144, 168, 217, 20);
		contentPane.add(txtLogin2);
		txtLogin2.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(49, 214, 46, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(144, 211, 217, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblEmai = new JLabel("Email");
		lblEmai.setBounds(49, 262, 46, 14);
		contentPane.add(lblEmai);

		txtEmail = new JTextField();
		txtEmail.setBounds(144, 257, 217, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(144, 71, 217, 20);
		contentPane.add(txtSenha);
	}

	public void logar() {
		if (txtLogin.getText().equals("") || txtSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Login ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			
		Contato contato = new Contato();
		contato.setLogin(txtLogin.getText());
		contato.setSenha(txtSenha.getText());
		
		ContatoDao dao = new ContatoDao();
		
		Contato contatoRetorno = dao.buscaRefinada(contato);
		txtLogin2.setText(contatoRetorno.getLogin());
		txtNome.setText(contatoRetorno.getNome());
		txtEmail.setText(contatoRetorno.getEmail());
		
			
		}
	}
	
	public void limpar() {
		txtLogin.setText("");
		txtSenha.setText("");
		txtLogin2.setText("");
		txtNome.setText("");
		txtEmail.setText("");
		
	}
}
