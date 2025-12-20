import javax.swing.*;
import java.awt.*;


public class DashboardView extends JFrame {


    public JButton verwaltenButton;
    public JButton quizButton;


    public DashboardView() {
        setTitle("Deutsch Fachbegriffe");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        Color mint = new Color(120, 230, 190);


        JPanel header = new JPanel();
        header.setBackground(mint);
        header.setPreferredSize(new Dimension(800, 70));


        JLabel title = new JLabel("Deutsch Fachbegriffe");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        header.add(title);


        verwaltenButton = new JButton("Begriffe verwalten");
        quizButton = new JButton("QUIZ starten");


        styleButton(verwaltenButton, mint);
        styleButton(quizButton, mint);


        JPanel center = new JPanel(new GridLayout(2, 1, 20, 20));
        center.setBorder(BorderFactory.createEmptyBorder(60, 200, 60, 200));
        center.add(verwaltenButton);
        center.add(quizButton);


        add(header, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
    }


    private void styleButton(JButton button, Color color) {
        button.setBackground(Color.WHITE);
        button.setForeground(color);
        button.setFont(new Font("SansSerif", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(color, 2));
    }
}
