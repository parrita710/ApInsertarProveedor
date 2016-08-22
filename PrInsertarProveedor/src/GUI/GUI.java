package GUI;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI {

    private PanelLogin panelLogin;
    private PanelInicio panelInicio;

    public GUI() {
        //panelLogin = new PanelLogin();
        //panelLogin.mostrarGUI();

        JFrame frame = new JFrame("Card Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        panelInicio = new PanelInicio(contentPane);
        panelLogin = new PanelLogin(contentPane);
        contentPane.add(panelInicio, "Panel Inicio");
        contentPane.add(panelLogin, "Panel Login");
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
