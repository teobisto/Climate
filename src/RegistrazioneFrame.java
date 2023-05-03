import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneFrame extends JFrame {
    private JLabel lblIntestazione2;
    private JPanel RegistrazionePanel;
    private JButton btnClear;
    private JButton btnOK;
    private JLabel lblNome;
    private JLabel lblCognome;
    private JLabel lblEmail;
    private JLabel lblPwd;
    private JTextField tfUserID;
    private JTextField tfCF;
    private JTextField tfIndirizzo;
    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfCognome;
    private JLabel lblCf;
    private JLabel lblindirizzo;
    private JLabel lblUserid;
    private JPasswordField pwdFieldR;
    private JTextArea textArea1;
    private JLabel lblCheck;


    public RegistrazioneFrame() {
        setContentPane(RegistrazionePanel);
        setVisible(true);
        setTitle("Frame di Registrazione");
        setSize(800, 500);
        setLocationRelativeTo(null);
        textArea1.setLineWrap(true);
        textArea1.setEditable(false);



        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Utente utente = new Utente(tfNome.getText(), tfCognome.getText(), tfCF.getText(), tfIndirizzo.getText()
                                           , tfUserID.getText(), String.valueOf(pwdFieldR.getPassword()));

                if(utente.CampiVuoti()) {
                    lblCheck.setText("Inserire elementi validi nei campi!");
                    return;
                }

                if(utente.UserEsistente()) {
                    lblCheck.setText("UserID già esistente, cambialo!");
                    return;
                }

                if(!utente.CFvalido()) {
                    lblCheck.setText("Immettere un codice fiscale valido!");
                    return;
                }

                    String string1 = "Nome : " + tfNome.getText() + "\n"
                            + "Cognome : " + tfCognome.getText() + "\n"
                            + "Codcie Fiscale : " + tfCF.getText() + "\n"
                            + "Indirizzo : " + tfIndirizzo.getText() + "\n"
                            + "Email : " + tfEmail.getText() + "\n"
                            + "UserID : " + tfUserID.getText() + "\n"
                            + "Password : " + String.valueOf(pwdFieldR.getPassword()) + "\n";

                    textArea1.setText(string1);
                    lblCheck.setText("Regsitrazione avvenuta correttamente!");


                utente.Registrazione();
            }
        });


        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNome.setText("");
                tfCognome.setText("");
                tfCF.setText("");
                tfIndirizzo.setText("");
                tfEmail.setText("");
                tfUserID.setText("");
                pwdFieldR.setText("");

            }
        });
    }
}

