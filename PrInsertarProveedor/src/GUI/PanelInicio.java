package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class PanelInicio extends JPanel {

    private JPanel contentPane;

    public PanelInicio(JPanel panel) {
        
        contentPane = panel;
        
        setSize(400, 300);
        setOpaque(true);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JButton login = new JButton("Login");
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa 1 columna.
        constraints.gridheight = 1; // El área de texto ocupa 1 fila.
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.01;

        login.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });

        add(login, constraints);
        constraints.weighty = 0.0;

        JButton consulta = new JButton("Consutar proveedores");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.01;
        add(consulta, constraints);
        constraints.weighty = 0.0;

        JButton insertar = new JButton("Insertar proveedores");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.01;
        add(insertar, constraints);
        constraints.weighty = 0.0;

        JButton modificar = new JButton("Modificar proveedores");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.01;
        add(modificar, constraints);
        constraints.weighty = 0.0;

        JButton borrar = new JButton("Borrar proveedores");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.01;
        add(borrar, constraints);
        constraints.weighty = 0.0;

    }

    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(500, 500));
    }
}
