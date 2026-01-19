package view;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SpielView extends JFrame {

    public JLabel wortAnzeige = new JLabel("", SwingConstants.CENTER);
    public JPanel buchstabenPanel = new JPanel(new GridLayout(3, 9));
    public GalgenPanel galgenPanel = new GalgenPanel();

    public Map<Character, JButton> buttons = new HashMap<>();

    public SpielView() {
        setTitle("Hangman");
        setSize(700, 400);
        setLayout(new BorderLayout());

        wortAnzeige.setFont(new Font("Monospaced", Font.BOLD, 24));

        for (char c = 'A'; c <= 'Z'; c++) {
            JButton b = new JButton(String.valueOf(c));
            buttons.put(c, b);
            buchstabenPanel.add(b);
        }

        add(wortAnzeige, BorderLayout.NORTH);
        add(buchstabenPanel, BorderLayout.SOUTH);
        add(galgenPanel, BorderLayout.CENTER);
    }
}
