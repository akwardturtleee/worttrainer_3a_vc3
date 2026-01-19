package view;

import javax.swing.*;
import java.awt.*;

public class QuizView extends JFrame {

    public JLabel frageLabel = new JLabel("", SwingConstants.CENTER);
    public JTextField antwort = new JTextField(15);
    public JButton ok = new JButton("Antwort prüfen");

    public QuizView() {
        setTitle("Quiz");
        setSize(500, 350);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Antwort:"));
        bottom.add(antwort);
        bottom.add(ok);

        add(frageLabel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }
}
