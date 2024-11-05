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
        //Skapar en facit lista
        for (int i = 1; i <= 15; i++) {
            buttonAnswer.add(Integer.toString(i));
        }
        buttonAnswer.add(" ");

        // Skapar GUI för spelet
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

    // Kontrollerar om listorna är likadana
    public boolean isSolved(){
        for (int i = 0; i < buttons.size(); i++) {
            if (!buttons.get(i).getText().equals(buttonAnswer.get(i))) {
                return false;
            }
        }
        return true;
    }

    // Skapar knappar random i spelet
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

    // Skapar knappar så att spelet blir löst
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
        // Klickar på start knapp och metoden createbuttons utförs
        JButton buttonAction = (JButton) e.getSource();
        if (buttonAction.getText().equals("Nytt spel")) {
            this.createButtons();
            panel.repaint();
            panel.revalidate();
            pack();
            // Klickar på facit och facitmetoden görs
        } else if (buttonAction.getText().equals("Facit")) {
            this.showFacit();
        }

        for (int i = 0; i < buttons.size(); i++) { // kollar ifall knapparna i närheten finns och ifall de är tomma. byter plats om tom
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
                panel.removeAll(); //tömmer spelplanen
                for (JButton button : buttons) {
                    panel.add(button); //itererar genom den nya listan och skapar upp knappar
                }
                panel.revalidate(); //sätter knapparna i den nya ordningen
                panel.repaint(); //gör ändringarna synliga på spelplanen

                // Kontrollerar om spelet är löst och skrivet ut "Du har vunnit"
                if (isSolved()){
                    JOptionPane.showMessageDialog(this, "Du har vunnit");
                }

                break;


            }
            }
        }

    }