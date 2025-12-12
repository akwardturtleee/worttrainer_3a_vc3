package io;

import javax.swing.*;
import java.awt.*;

public class QuizPanel extends JPanel {

    private final JLabel frageLabel;
    private final JTextField antwortField;
    private final JButton prüfenButton;
    private final JLabel resultLabel;

    public QuizPanel() {
        putClientProperty("JComponent.roundRect", true);
        putClientProperty("JComponent.shadowType", "drop");
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout(20, 20));

        frageLabel = new JLabel("Drücke 'Nächste Frage' um zu starten.", SwingConstants.CENTER);
        frageLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        antwortField = new JTextField();
        prüfenButton = new JButton("Antwort prüfen");
        resultLabel = new JLabel("", SwingConstants.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        bottom.setBorder(BorderFactory.createEmptyBorder(10, 150, 20, 150));

        // Center all components horizontally
        antwortField.setAlignmentX(CENTER_ALIGNMENT);
        prüfenButton.setAlignmentX(CENTER_ALIGNMENT);
        resultLabel.setAlignmentX(CENTER_ALIGNMENT);

        antwortField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        bottom.add(antwortField);
        bottom.add(Box.createVerticalStrut(10));
        bottom.add(prüfenButton);
        bottom.add(Box.createVerticalStrut(12));
        bottom.add(resultLabel);

        add(frageLabel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }
}
