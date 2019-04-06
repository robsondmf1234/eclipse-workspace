package keylistener;

/*
  Este exemplo mostra como escrever uma classe
  que implementa a interface KeyListener.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Estudos extends JFrame {
	public Estudos() {
		super("Eventos do Mouse e Teclado");
		Container c = getContentPane();
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		c.setLayout(layout);
		Teclado teclado = new Teclado();
		this.addKeyListener(teclado);
		setSize(350, 250);
		setVisible(true);
	}

	public static void main(String args[]) {
		Estudos app = new Estudos();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

/*
 * Classe auxiliar usada para obter eventos do teclado. Como esta classe
 * implementa a interface KeyListener, ela dever� fornecer implementa��es para
 * os m�todos keyPressed, keyReleased e keyTyped
 */
class Teclado implements KeyListener {
	public void keyPressed(KeyEvent e) {
		JOptionPane.showMessageDialog(null, "Uma tecla foi pressionada!");
	}

	public void keyReleased(KeyEvent e) {
		// c�digo aqui
	}

	public void keyTyped(KeyEvent e) {
		// c�digo aqui
	}
}