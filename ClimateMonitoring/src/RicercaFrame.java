import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RicercaFrame extends JFrame{
    private JPanel RicercaPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JList list1;
    private JButton button3;

    public RicercaFrame() {
      setContentPane(RicercaPanel);
      setVisible(true);
      setTitle("Frame di Ricerca");
      setSize(600,400);
      setLocationRelativeTo(null);
    }

}

