package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.BuscaCep;
import model.Contato;
import model.ContatoDao;
import model.GravarDados;

//Programa utilizado para salvar usu�rios em um banco de dados.
//Versao 7 - 
//IMPLEMENTADO E FUNCIONANDO Salvando no banco de dados os campos nome,email,unidade,telefone,telefonealternativo,cep, dados capturados na lista do JComboBox,
//IMPLEMENTADO E FUNCIONANDO Limitar o campo do CEP para 8 digitos e quando digitar os 8 numeros fazer a busca automatica de cep..
//IMPLEMENTADO E FUNCIONANDO De acordo com o JSON , retornar o endere�o e preencher o Jtextfield 
//IMPLEMENTADO E FUNCIONANDO - Adicionar um JAreaText e um bot�o para transferir todos os dados para l� 
//A implementar- Salvar em um bloco de notas. 
//NAO IMPLEMENTADO - Permitir que somente numeros sejam digitados em um JTEXTFIELD( Telefone, TelefoneAlternativo e CEP) 

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtUnidade;
	private JTextField txtCep;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtTelefone2;
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
	 * 
	 * @throws ParseException
	 */
	public TelaPrincipal() throws ParseException {

		setTitle("TELA DE CADASTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(90, 36, 217, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 39, 102, 14);
		contentPane.add(lblNome);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(190, 298, 80, 23);
		contentPane.add(btnLimpar);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 69, 102, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(90, 66, 217, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel = new JLabel("Unidade:");
		lblNewLabel.setBounds(10, 99, 102, 14);
		contentPane.add(lblNewLabel);

		txtUnidade = new JTextField();
		txtUnidade.setBounds(90, 96, 217, 20);
		contentPane.add(txtUnidade);
		txtUnidade.setColumns(10);

		JList list = new JList();
		list.setBounds(141, 152, 77, -12);
		contentPane.add(list);

		// MELHORAR UTILIZANDO LISTA NO JCOMBOBOX
		// JComboBox comboBox = new JComboBox();
		JComboBox comboBox = new JComboBox(new String[] { "Sede", "Regional", "Unidade Operacional" });
		comboBox.setBounds(90, 126, 217, 20);
		contentPane.add(comboBox);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 129, 102, 14);
		contentPane.add(lblTipo);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 159, 102, 14);
		contentPane.add(lblTelefone);

		JLabel lblTelefoneAlternativo = new JLabel("Telefone Alter");
		lblTelefoneAlternativo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefoneAlternativo.setBounds(10, 189, 123, 14);
		contentPane.add(lblTelefoneAlternativo);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 219, 46, 14);
		contentPane.add(lblCep);

		// Implementar uma forma do keypressed contar o numero de caracteres com o
		// jformatedfield
		// txtCep = new javax.swing.JFormattedTextField(setMascara("#####-###"));

		txtCep = new javax.swing.JFormattedTextField();
		txtCep.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String numCaracteres = txtCep.getText();
				int numero = numCaracteres.length();
				System.out.println("Numero de caracteres: " + numero);

				if (numero == 8) {
					System.out.println("Deu 8 caracteres!");
					String cep = txtCep.getText();
					System.out.println("cep:" + cep);
					buscar(cep);
				}

			}
		});
		txtCep.setBounds(90, 216, 217, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		txtTelefone = new javax.swing.JFormattedTextField(setMascara("(##) ####-####"));
		txtTelefone.setBounds(90, 156, 217, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		txtTelefone2 = new javax.swing.JFormattedTextField(setMascara("(##) ####-####"));
		txtTelefone2.setBounds(90, 186, 217, 20);
		contentPane.add(txtTelefone2);
		txtTelefone2.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 249, 60, 14);
		contentPane.add(lblEndereo);

		txtEnd = new JTextField();
		txtEnd.setBounds(90, 246, 217, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);

		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(340, 34, 574, 235);
		contentPane.add(txtArea);
		

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar(JTextArea txtArea);
			}
		});
		btnSalvar.setBounds(10, 298, 80, 23);
		contentPane.add(btnSalvar);

		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setIcon(new ImageIcon("C:\\Users\\Computador\\eclipse-workspace\\Projeto8\\seta.png"));
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				moverTexto(txtArea, comboBox);
				// mostrar(comboBox);
			}
		});
		btnMostrar.setBounds(280, 281, 40, 40);
		contentPane.add(btnMostrar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();
			}
		});
		btnAlterar.setBounds(100, 298, 80, 23);
		contentPane.add(btnAlterar);

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

	// Metodo para mostrar todos os dados na tela

	/*
	 * protected void mostrar(JComboBox comboBox) { System.out.println("Nome: " +
	 * txtNome.getText()); System.out.println("Email: " + txtEmail.getText());
	 * System.out.println("Unidade: " + txtUnidade.getText()); String
	 * itemSelecionado = comboBox.getSelectedItem().toString();
	 * System.out.println("Unidade: " + itemSelecionado);
	 * System.out.println("Telefone: " + txtTelefone.getText());
	 * System.out.println("Telefone: " + txtTelefone2.getText());
	 * System.out.println("CEP: " + txtCep.getText());
	 * System.out.println("Endere�o: " + txtEnd.getText());
	 * 
	 * }
	 */
	protected void limpar() {
		txtNome.setText("");
		txtNome.setText("");
		txtEmail.setText("");
		txtUnidade.setText("");
		txtTelefone.setText("");
		txtTelefone2.setText("");
		txtCep.setText("");
		txtEnd.setText("");

	}

	protected void alterar() {
		System.out.printf("Usu�rio alterado com sucesso.");
	}

	protected void salvar(String txtArea) {
		
		JTextArea

		InputStream is = new FileInputStream(txtArea);
		// decodificador de bytes
		InputStreamReader isr = new InputStreamReader(is);
		// Buffer para fo
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		br.close();
		System.out.println(s);

		/*
		 * //SALVANDO NO BANCO DE DADOS
		 * 
		 * Contato contato = new Contato();
		 * 
		 * contato.setNome(txtNome.getText()); contato.setEmail(txtEmail.getText());
		 * contato.setUnidade(txtUnidade.getText());
		 * contato.setTelefone(txtTelefone.getText());
		 * contato.setTelefoneAlter(txtTelefone2.getText());
		 * contato.setCep(txtCep.getText());
		 * 
		 * ContatoDao dao = new ContatoDao();
		 * 
		 * dao.adicionar(contato); System.out.println("Contato adicionado."); /*
		 * 
		 * List<Contato> contatos = dao.getLista();
		 * 
		 * for (Contato contato1 : contatos) { System.out.println("Nome: " +
		 * contato1.getNome()); System.out.println("Email: " + contato1.getEmail());
		 * System.out.println("Endere�o: " + contato1.getEndereco());
		 * System.out.println("Data de Nascimento: " +
		 * contato1.getDataNascimento().getTime() + "\n"); } }
		 * 
		 */

		System.out.printf("Usu�rio salvo com sucesso.");
	}

	protected void buscar(String cep) {
		// String cep = txtCep.getText();
		System.out.println("CEP:" + cep);

		BuscaCep busca = new BuscaCep();
		BuscaCep buscar = busca.buscarCep(Integer.parseInt(cep));
		System.out.println("Endere�o:" + buscar.getRua());

		txtEnd.setText(buscar.getRua() + " Bairro: " + buscar.getBairro() + " Estado: " + buscar.getEstado() + " CEP: "
				+ buscar.getCep());
	}

	protected void moverTexto(JTextArea txtArea, JComboBox comboBox) {
		txtArea.setText("Nome: " + txtNome.getText() + "\nEmail: " + txtEmail.getText() + "\nUnidade: "
				+ txtUnidade.getText() + "\nTipo: " + comboBox.getSelectedItem().toString() + "\nTelefone: "
				+ txtTelefone.getText() + "\nTelefone Alternativo: " + txtTelefone2.getText() + "\nCep: "
				+ txtCep.getText() + "\nEndere�o: " + txtEnd.getText());

	}
}
