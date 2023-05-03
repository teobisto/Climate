import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JLabel lblIntestazione;
    private JButton btnRicerca;
    private JButton btnRegistrazione;
    private JButton btnLogin;
    private JPanel mainPanel;

    public MainFrame() {
        setContentPane(mainPanel);
        setVisible(true);
        setTitle("Climate Monitoring");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        setLocationRelativeTo(null);


        btnRicerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RicercaFrame myFrame1 = new RicercaFrame();
            }
        });


        btnRegistrazione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrazioneFrame myFrame2 = new RegistrazioneFrame();


            }
        });


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInFrame myFrame3 = new LogInFrame();

            }
        });
    }
}
