import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpelGUI extends JFrame implements ActionListener {
    public SpelGUI(){
        JPanel panel = new JPanel();
        setVisible(true);
        add(panel);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        SpelGUI spel = new SpelGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}