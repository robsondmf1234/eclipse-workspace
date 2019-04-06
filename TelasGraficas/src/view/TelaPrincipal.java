package view;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Contato;
import model.ContatoDao;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JLabel lblIdade;
	private JTextField txtEmail;

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
	 * 
	 * @throws ParseException
	 */
	public TelaPrincipal() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(141, 61, 217, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(71, 64, 60, 14);
		contentPane.add(lblNome);

		txtIdade = new JTextField();
		txtIdade.setBounds(140, 95, 217, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);

		lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(71, 98, 60, 14);
		contentPane.add(lblIdade);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();
			}
		});
		btnAlterar.setBounds(30, 138, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnSalvar.setBounds(149, 138, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnExcluir.setBounds(268, 138, 89, 23);
		contentPane.add(btnExcluir);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarDados();
			}
		});
		btnMostrar.setBounds(387, 138, 89, 23);
		contentPane.add(btnMostrar);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(71, 28, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(140, 25, 217, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
	}

	protected void mostrarDados() {
		String nome = txtNome.getText();
		int idade = Integer.parseInt(txtIdade.getText());
		System.out.printf("O nome digitado foi : %s\nIdade: %d", nome,idade);

	}

	protected void excluir() {
		System.out.printf("Usuário excluido com sucesso.");
	}

	protected void alterar() {
		System.out.printf("Usuário alterado com sucesso.");
	}

	protected void salvar() {
		
		Contato contato = new Contato();

		contato.setNome(txtNome.getText());
		contato.setEmail(txtEmail.getText());
		contato.setIdade(Integer.parseInt(txtIdade.getText()));
		
		ContatoDao dao = new ContatoDao();

		dao.adicionar(contato);
		System.out.println("Contato adicionado.");
/*
		
		List<Contato> contatos = dao.getLista();

		for (Contato contato1 : contatos) {
			System.out.println("Nome: " + contato1.getNome());
			System.out.println("Email: " + contato1.getEmail());
			System.out.println("Endereço: " + contato1.getEndereco());
			System.out.println("Data de Nascimento: " + contato1.getDataNascimento().getTime() + "\n");
		}
	}
	*/
		
		System.out.printf("Usuário salvo com sucesso.");
	}
}
