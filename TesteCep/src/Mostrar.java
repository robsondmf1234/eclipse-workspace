import javax.swing.text.MaskFormatter;

/**
 * @author Wolmir
 */
public class Mostrar extends javax.swing.JFrame {

    public Mostrar() {
        initComponents();
    }

    // 
    private void initComponents() {

        jftFormatar = new javax.swing.JFormattedTextField(setMascara("(##) ####-####"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jftFormatar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jftFormatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// 

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mostrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JFormattedTextField jftFormatar;
    // End of variables declaration

    /** Tipo de formatações
        # = qualquer numero válido
        U = qualquer caractere, as letras minusculas são formatadas em maiuscula.
        L = qualquer caractere, as letras maiusculas são formatadas em minusculas.
        A = qualquer caractere ou numero.
     * @param mascara
     * @return
     */
    private MaskFormatter setMascara(String mascara){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter(mascara);
        }catch(java.text.ParseException ex){
            ex.printStackTrace();
        }
        return mask;
    }

    
}
