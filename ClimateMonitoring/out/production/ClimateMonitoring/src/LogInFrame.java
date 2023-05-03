import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInFrame extends JFrame {
    private JPasswordField passwordField1;
    private JTextField tfUserL;
    private JButton btnOKL;
    private JButton clearBtnL;
    private JLabel lblIntestazioneL;
    private JPanel LogInPanel;
    private JLabel lblcheck1;

    private JLabel lblPwdL;

    private JLabel userIDL;


    public LogInFrame() {
        setContentPane(LogInPanel);
        setVisible(true);
        setTitle("Frame di LogIn");
        setSize(300, 400);
        setLocationRelativeTo(null);


        btnOKL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Utente utente = new Utente(tfUserL.getText(), String.valueOf(passwordField1.getPassword()));

                if(utente.Login()) {
                    lblcheck1.setText("Login Effettuato!");

                    //RicercaFrame myFrame1 = new RicercaFrame();

                } else {
                    lblcheck1.setText("Login Fallito");
                }

            }
        });


        clearBtnL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfUserL.setText("");
                passwordField1.setText("");
                lblcheck1.setText("");
            }
        });


    }
}
