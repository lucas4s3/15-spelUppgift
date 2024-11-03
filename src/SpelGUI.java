import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpelGUI extends JFrame implements ActionListener {
    ArrayList<JButton> buttons = new ArrayList<>();
    private JPanel panel;

    public SpelGUI(){
        setTitle("15-Spel");
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        this.createButtons();

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
        this.pack();

    }

    public static void main(String[] args) {
        SpelGUI spel = new SpelGUI();
    }

    public void createButtons(){
        for(int n = 1; n <= 15; n++){
            JButton button = new JButton(Integer.toString(n));
            button.addActionListener(this);
            buttons.add(button);
            panel.add(button);
        }
        JButton emptyButton = new JButton(" ");
        panel.add(emptyButton);
        buttons.add(emptyButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}