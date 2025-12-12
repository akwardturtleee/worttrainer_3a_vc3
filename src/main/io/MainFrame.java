package io;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayout);

    public MainFrame() {
        setTitle("ITP Deutsch-Fachbegriffe");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Rounded + shadow
        cardPanel.putClientProperty("JComponent.roundRect", true);
        cardPanel.putClientProperty("JComponent.shadowType", "drop");
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panels
        cardPanel.add(new QuizPanel(), "QUIZ");
        cardPanel.add(new TermsPanel(), "TERMS");
        cardPanel.add(new SettingsPanel(this), "SETTINGS"); // Pass frame reference

        // Navigation
        JPanel navigation = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        navigation.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        navigation.putClientProperty("JComponent.roundRect", true);
        navigation.putClientProperty("JComponent.shadowType", "none");

        JButton quizBtn = new JButton("Quiz");
        JButton termsBtn = new JButton("Fachbegriffe");
        JButton settingsBtn = new JButton("Einstellungen");

        quizBtn.addActionListener(e -> cardLayout.show(cardPanel, "QUIZ"));
        termsBtn.addActionListener(e -> cardLayout.show(cardPanel, "TERMS"));
        settingsBtn.addActionListener(e -> cardLayout.show(cardPanel, "SETTINGS"));

        navigation.add(quizBtn);
        navigation.add(termsBtn);
        navigation.add(settingsBtn);

        add(navigation, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
