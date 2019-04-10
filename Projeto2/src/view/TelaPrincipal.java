package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.Contato;
import model.ContatoDao;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 561, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(186, 11, 217, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 14, 102, 14);
		contentPane.add(lblNome);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();
			}
		});
		btnAlterar.setBounds(10, 439, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnSalvar.setBounds(129, 439, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnLimpar.setBounds(248, 439, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMostrar.setBounds(367, 439, 89, 23);
		contentPane.add(btnMostrar);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(39, 68, 102, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(186, 65, 217, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel = new JLabel("Unidade:");
		lblNewLabel.setBounds(39, 122, 102, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(186, 119, 217, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JList list = new JList();
		list.setBounds(141, 152, 77, -12);
		contentPane.add(list);
		
		//MELHORAR UTILIZANDO LISTA NO JCOMBOBOX
		// JComboBox comboBox = new JComboBox();
		JComboBox comboBox = new JComboBox(new Object[] { "Sede", "Regional", "Unidade Operacional" });
		comboBox.setBounds(186, 173, 217, 20);
		contentPane.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(39, 176, 102, 14);
		contentPane.add(lblTipo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(39, 230, 102, 14);
		contentPane.add(lblTelefone);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("(##)#########"));
		formattedTextField.setBounds(186, 227, 217, 20);
		contentPane.add(formattedTextField);
		
		JLabel lblTelefoneAlternativo = new JLabel("Telefone Alternativo:");
		lblTelefoneAlternativo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefoneAlternativo.setBounds(39, 284, 123, 14);
		contentPane.add(lblTelefoneAlternativo);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(new MaskFormatter("(##)#########"));
		formattedTextField_1.setBounds(186, 281, 217, 20);
		contentPane.add(formattedTextField_1);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(39, 338, 46, 14);
		contentPane.add(lblCep);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 335, 217, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

	}

	protected void excluir() {
		System.out.printf("Usu�rio excluido com sucesso.");
	}

	protected void alterar() {
		System.out.printf("Usu�rio alterado com sucesso.");
	}

	protected void salvar() {

		Contato contato = new Contato();

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
		 * System.out.println("Endere�o: " + contato1.getEndereco());
		 * System.out.println("Data de Nascimento: " +
		 * contato1.getDataNascimento().getTime() + "\n"); } }
		 */

		System.out.printf("Usu�rio salvo com sucesso.");
	}
}