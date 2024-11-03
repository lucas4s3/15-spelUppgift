import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpelGUI extends JFrame implements ActionListener {
    public SpelGUI(){
        setTitle("15-Spel");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Nytt spel");
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(panel,BorderLayout.CENTER);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        System.out.println("testing tets");

    }

    public static void main(String[] args) {
        SpelGUI spel = new SpelGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}