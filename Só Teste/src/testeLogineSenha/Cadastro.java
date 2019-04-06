package testeLogineSenha;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private MaskFormatter telefoneFormatado;
	private JPasswordField txtSenha;
	private JTextField txtNome;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public Cadastro() throws ParseException {
		setTitle("TELA DE CADASTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(51, 36, 102, 14);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setToolTipText("Digite o login");
		txtLogin.setBounds(126, 32, 217, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(51, 86, 102, 14);
		contentPane.add(lblSenha);

		try {
			telefoneFormatado = new MaskFormatter("(##)#####-####");
			telefoneFormatado.setPlaceholderCharacter('_');

		} catch (Exception e) {
			// TODO: handle exception
		}

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnSalvar.setBounds(67, 240, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(223, 240, 89, 23);
		contentPane.add(btnLimpar);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(126, 84, 217, 20);
		contentPane.add(txtSenha);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(51, 136, 46, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(126, 136, 217, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(51, 186, 46, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(126, 188, 217, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

	}

	protected void limpar() {
		txtLogin.setText("");
		txtSenha.setText("");

		System.out.printf("Botão LIMPAR pressionadO.");
	}

	@SuppressWarnings("deprecation")
	protected void salvar() {

		Contato contato = new Contato();

		contato.setLogin(txtLogin.getText());
		contato.setSenha(txtSenha.getText());
		contato.setNome(txtNome.getText());
		contato.setEmail(txtEmail.getText());

		ContatoDao dao = new ContatoDao();

		dao.adicionar(contato);
		System.out.println("Contato adicionado.");
		/*
		 * 
		 * List<Contato> contatos = dao.getLista();
		 * 
		 * for (Contato contato1 : contatos) { System.out.println("Nome: " +
		 * contato1.getNome()); System.out.println("Email: " + contato1.getEmail());
		 * System.out.println("Endereço: " + contato1.getEndereco());
		 * System.out.println("Data de Nascimento: " +
		 * contato1.getDataNascimento().getTime() + "\n"); } }
		 */

		System.out.printf("Usuário salvo com sucesso.");
	}
}
