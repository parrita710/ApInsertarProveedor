package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class PanelLogin extends JPanel {
    
    private JPanel contentPane;

    public PanelLogin(JPanel panel) {
        
        contentPane = panel;
        //JPanel ventana = new JPanel();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ventana.setSize(400, 300);
        //ventana.setLayout(new GridBagLayout());
        setSize(400, 300);
        setOpaque(true);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JTextField textoDominio = new JTextField("Dirección de la base de datos: ");
        textoDominio.setEditable(false);
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa 1 columna.
        constraints.gridheight = 1; // El área de texto ocupa 1 fila.
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(textoDominio, constraints);
        constraints.weighty = 0.0;

        JTextField textoPuerto = new JTextField("Puerto de la base de datos: ");
        textoPuerto.setEditable(false);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(textoPuerto, constraints);
        constraints.weighty = 0.0;

        JTextField textoBD = new JTextField("Nombre de la base de datos: ");
        textoBD.setEditable(false);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(textoBD, constraints);
        constraints.weighty = 0.0;

        JTextField textoCuenta = new JTextField("Usuario de la base de datos: ");
        textoCuenta.setEditable(false);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(textoCuenta, constraints);
        constraints.weighty = 0.0;

        JTextField textoPass = new JTextField("Contraseña del usuario: ");
        textoPass.setEditable(false);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(textoPass, constraints);
        constraints.weighty = 0.0;

        JTextField entradaDominio = new JTextField();
        constraints.gridx = 1; // El área de texto empieza en la columna 1.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa 1 columna.
        constraints.gridheight = 1; // El área de texto ocupa 1 fila.
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(entradaDominio, constraints);
        constraints.weighty = 0.0;

        JTextField entradaPuerto = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(entradaPuerto, constraints);
        constraints.weighty = 0.0;

        JTextField entradaBD = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(entradaBD, constraints);
        constraints.weighty = 0.0;

        JTextField entradaCuenta = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(entradaCuenta, constraints);
        constraints.weighty = 0.0;

        JPasswordField entradaPass = new JPasswordField(15);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.15;
        add(entradaPass, constraints);
        constraints.weighty = 0.0;

        JButton login = new JButton("Login");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.01;
        add(login, constraints);
        constraints.weighty = 0.0;

        JButton atras = new JButton("Atrás");
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.01;
        
        atras.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });
        
        add(atras, constraints);
        constraints.weighty = 0.0;
        setVisible(true);

    }

    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(500, 500));
    }
}
