import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class SpelGUI extends JFrame implements ActionListener {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private ArrayList<String> buttonAnswer = new ArrayList<>();
    private JPanel panel;

    public SpelGUI() {
        //
        for (int i = 1; i <= 15; i++) {
            buttonAnswer.add(Integer.toString(i));
        }
        buttonAnswer.add(" ");

        setTitle("15-Spel");
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Nytt spel");
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startButton);
        startButton.addActionListener(this);

        JButton facit = new JButton("Facit");
        buttonPanel.add(facit);
        facit.addActionListener(this);



        add(buttonPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SpelGUI spel = new SpelGUI();
    }
    public boolean isSolved(){
        for (int i = 0; i < buttons.size(); i++) {
            if (!buttons.get(i).getText().equals(buttonAnswer.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void createButtons() {
        buttons.clear();
        panel.removeAll();
        ArrayList<String> numbers = new ArrayList<>(buttonAnswer);
        Collections.shuffle(numbers);
        for (String number : numbers) {
            JButton button = new JButton(number);
            button.addActionListener(this);
            if (number.equals(" ")) {
                button.setEnabled(false);
            }
            buttons.add(button);
            panel.add(button);

        }
        panel.repaint();
        panel.revalidate();
        pack();
        setLocationRelativeTo(null);
    }
    public void showFacit(){
        buttons.clear();
        panel.removeAll();
        ArrayList<String> numbers = new ArrayList<>(buttonAnswer);

        for (String number : numbers) {
            JButton button = new JButton(number);
            button.addActionListener(this);
            if (number.equals(" ")) {
                button.setEnabled(false);
            }
            buttons.add(button);
            panel.add(button);

        }
        panel.repaint();
        panel.revalidate();
        pack();
        setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonStart = (JButton) e.getSource();
        if (buttonStart.getText().equals("Nytt spel")) {
            this.createButtons();
            panel.repaint();
            panel.revalidate();
            pack();
        } else if (buttonStart.getText().equals("Facit")) {
            this.showFacit();
        }

        for (int i = 0; i < buttons.size(); i++) {
            if (e.getActionCommand().equals(buttons.get(i).getActionCommand())) {
                if (i - 4 >= 0 && buttons.get(i - 4).getActionCommand().equals(" ")) {
                    Collections.swap(buttons, i, i - 4);
                }
                if (i + 4 <= buttons.size() - 1 && buttons.get(i + 4).getActionCommand().equals(" ")) {
                    Collections.swap(buttons, i, i + 4);
                }
                if (i % 4 != 0 && buttons.get(i - 1).getActionCommand().equals(" ")) {
                    Collections.swap(buttons, i, i - 1);
                }
                if ((i + 1) % 4 != 0 && buttons.get(i + 1).getActionCommand().equals(" ")) {
                    Collections.swap(buttons, i, i + 1);
                }
                panel.removeAll();
                for (JButton button : buttons) {
                    panel.add(button);
                }
                panel.revalidate();
                panel.repaint();

                if (isSolved()){
                    JOptionPane.showMessageDialog(this, "Du har vunnit");
                }

                break;


            }
            }
        }

    }