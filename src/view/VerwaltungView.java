package view;

import javax.swing.*;
import java.awt.*;

public class VerwaltungView extends JFrame {

    // ===== Begriffe =====
    public JList begriffListe = new JList();
    public JTextField tfBegriff = new JTextField();
    public JTextField tfBeschreibung = new JTextField();
    public JTextField tfKategorie = new JTextField();
    public JSpinner spSchwierigkeit =
            new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

    public JButton btnBegriffAdd = new JButton("Begriff hinzufügen");
    public JButton btnBegriffLoeschen = new JButton("Begriff löschen");

    // ===== Fragen =====
    public JList fragenListe = new JList();
    public JComboBox<String> cbFragetyp =
            new JComboBox<>(new String[]{"TEXT", "BILD"});
    public JTextField tfFrageInhalt = new JTextField();
    public JTextField tfAntwort = new JTextField();

    public JButton btnFrageAdd = new JButton("Frage hinzufügen");
    public JButton btnFrageLoeschen = new JButton("Frage löschen");

    // ===== Datei =====
    public JButton btnLaden = new JButton("CSV laden");
    public JButton btnSpeichern = new JButton("CSV speichern");

    public VerwaltungView() {
        setTitle("Verwaltung – Lernpaket");
        setSize(1000, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== LINKS: Begriffe =====
        JPanel begriffePanel = new JPanel(new BorderLayout());
        begriffePanel.add(new JLabel("Begriffe"), BorderLayout.NORTH);
        begriffePanel.add(new JScrollPane(begriffListe), BorderLayout.CENTER);

        JPanel begriffInput = new JPanel(new GridLayout(5, 2));
        begriffInput.add(new JLabel("Begriff:"));
        begriffInput.add(tfBegriff);
        begriffInput.add(new JLabel("Beschreibung:"));
        begriffInput.add(tfBeschreibung);
        begriffInput.add(new JLabel("Kategorie:"));
        begriffInput.add(tfKategorie);
        begriffInput.add(new JLabel("Schwierigkeit (1–5):"));
        begriffInput.add(spSchwierigkeit);
        begriffInput.add(btnBegriffAdd);
        begriffInput.add(btnBegriffLoeschen);

        begriffePanel.add(begriffInput, BorderLayout.SOUTH);

        // ===== RECHTS: Fragen =====
        JPanel fragenPanel = new JPanel(new BorderLayout());
        fragenPanel.add(new JLabel("Fragen"), BorderLayout.NORTH);
        fragenPanel.add(new JScrollPane(fragenListe), BorderLayout.CENTER);

        JPanel frageInput = new JPanel(new GridLayout(4, 2));
        frageInput.add(new JLabel("Fragetyp:"));
        frageInput.add(cbFragetyp);
        frageInput.add(new JLabel("Frage (Text oder Bild-URL):"));
        frageInput.add(tfFrageInhalt);
        frageInput.add(new JLabel("Richtige Antwort:"));
        frageInput.add(tfAntwort);
        frageInput.add(btnFrageAdd);
        frageInput.add(btnFrageLoeschen);

        fragenPanel.add(frageInput, BorderLayout.SOUTH);

        // ===== UNTEN: Datei =====
        JPanel dateiPanel = new JPanel();
        dateiPanel.add(btnLaden);
        dateiPanel.add(btnSpeichern);

        add(begriffePanel, BorderLayout.WEST);
        add(fragenPanel, BorderLayout.CENTER);
        add(dateiPanel, BorderLayout.SOUTH);
    }
}
