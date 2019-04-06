package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.Contato;
import model.ContatoDao;

//Programa utilizado para salvar usuários em um banco de dados.
//Versao 5 - 
//IMPLEMENTADO E FUNCIONANDO Salvando no banco de dados os campos nome,email,unidade,telefone,telefonealternativo,cep, dados capturados na lista do JComboBox
//A IMPLEMENTAR - Limitar o campo do CEP para 8 digitos e quando digitar os 8 numeros fazer a busca automatica de cep..
//NÃO IMPLEMENTADO - De acordo com o JSON , retornar o endereço e preencher o Jtextfield 

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtUnidade;
	private JTextField txtcep;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtTelefone2;
	private JTextField txtRua;

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

		setTitle("TELA DE CADASTRO");
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

		txtUnidade = new JTextField();
		txtUnidade.setBounds(186, 119, 217, 20);
		contentPane.add(txtUnidade);
		txtUnidade.setColumns(10);

		JList list = new JList();
		list.setBounds(141, 152, 77, -12);
		contentPane.add(list);

		// MELHORAR UTILIZANDO LISTA NO JCOMBOBOX
		// JComboBox comboBox = new JComboBox();
		JComboBox comboBox = new JComboBox(new String[] { "Sede", "Regional", "Unidade Operacional" });
		comboBox.setBounds(186, 173, 217, 20);
		contentPane.add(comboBox);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(39, 176, 102, 14);
		contentPane.add(lblTipo);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(39, 230, 102, 14);
		contentPane.add(lblTelefone);

		JLabel lblTelefoneAlternativo = new JLabel("Telefone Alternativo:");
		lblTelefoneAlternativo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefoneAlternativo.setBounds(39, 284, 123, 14);
		contentPane.add(lblTelefoneAlternativo);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(39, 338, 46, 14);
		contentPane.add(lblCep);

		txtcep = new javax.swing.JFormattedTextField(setMascara("#####-###"));
		txtcep.setBounds(186, 335, 217, 20);
		contentPane.add(txtcep);
		txtcep.setColumns(10);

		txtTelefone = new javax.swing.JFormattedTextField(setMascara("(##) ####-####"));
		txtTelefone.setBounds(186, 227, 217, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		txtTelefone2 = new javax.swing.JFormattedTextField(setMascara("(##) ####-####"));
		txtTelefone2.setBounds(186, 281, 217, 20);
		contentPane.add(txtTelefone2);
		txtTelefone2.setColumns(10);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar(comboBox);
			}
		});
		btnMostrar.setBounds(367, 439, 89, 23);
		contentPane.add(btnMostrar);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(39, 382, 60, 14);
		contentPane.add(lblEndereo);
		
		txtRua = new JTextField();
		txtRua.setBounds(186, 379, 217, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);

	}

	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		return mask;
	}

	protected void mostrar(JComboBox comboBox) {
		System.out.println("Nome: " + txtNome.getText());
		System.out.println("Email: " + txtEmail.getText());
		System.out.println("Unidade: " + txtUnidade.getText());
		String itemSelecionado = comboBox.getSelectedItem().toString();
		System.out.println("Unidade: "+itemSelecionado);
		System.out.println("Telefone: " + txtTelefone.getText());
		System.out.println("Telefone: " + txtTelefone2.getText());
		System.out.println("CEP: " + txtcep.getText());
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
		contato.setUnidade(txtNome.getText());
		contato.setTelefone(txtTelefone.getText());
		contato.setTelefoneAlter(txtTelefone2.getText());
		contato.setCep(txtcep.getText());

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
