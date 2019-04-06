package jComboBoxComJComboBox;

//PROGRAMA QUE DEMONSTRA O USO DE UM JCOMBOBOX ANINHADO COM OUTRO JCOMBOBOX 

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	Cidades cidades = new Cidades();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] estados = { "Estados", "AM", "SP", "MG", "RJ", "RO" };
		
		JComboBox comboBoxEstados = new JComboBox(estados);
		comboBoxEstados.setBounds(90, 59, 63, 20);
		contentPane.add(comboBoxEstados);

		JLabel lblEstados = new JLabel("Estados");
		lblEstados.setBounds(33, 62, 46, 14);
		contentPane.add(lblEstados);

		JComboBox comboBoxCidades = new JComboBox();
		comboBoxCidades.setBounds(163, 59, 150, 20);
		contentPane.add(comboBoxCidades);

		comboBoxEstados.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {

					if (comboBoxEstados.getSelectedIndex() > 0) {
						comboBoxCidades.setModel(new DefaultComboBoxModel(
								cidades.getCidades(comboBoxEstados.getSelectedItem().toString())));
					}
				}
			}
		});

	}
}
