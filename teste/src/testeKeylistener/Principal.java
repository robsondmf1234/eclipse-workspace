package testeKeylistener;

//PROGRAMA CRIADO PARA RETORNAR  O CODIGO DA TECLA DIGITADA

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Principal extends JFrame {

	public Principal() {

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int codigo = e.getKeyCode();
				System.out.println("Código da tecla: " + codigo);
			}
		});
		
		//setando o tamando da tela
		setSize(500, 400);
		//setando a janela no meio do display(monitor)
		setLocationRelativeTo(this);
		//janela visivel ou nao 
		setVisible(true);
		//metodo ao fechar a janela
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		//criando a classe
		new Principal();

	}

}
