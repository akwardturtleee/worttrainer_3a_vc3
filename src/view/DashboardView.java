package view;
import javax.swing.*;

public class DashboardView extends JFrame {
    public JButton verwaltung = new JButton("Verwaltung");
    public JButton quiz = new JButton("Quiz");
    public JButton spiel = new JButton("Spiel");

    public DashboardView() {
        setTitle("Deutsch Fachbegriffe");
        setSize(300,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        p.add(verwaltung); p.add(quiz); p.add(spiel);
        add(p);
    }
}
