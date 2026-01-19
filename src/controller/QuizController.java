package controller;

import model.Frage;
import model.FragenPool;
import model.Statistik;
import view.QuizView;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class QuizController {

    private QuizView view;
    private FragenPool pool;
    private Statistik statistik = new Statistik();
    private int index = 0;

    public QuizController(FragenPool pool) {
        this.pool = pool;

        if (pool.getFragen().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Keine Fragen vorhanden!\nBitte zuerst ein Lernpaket laden."
            );
            return;
        }

        view = new QuizView();
        view.setVisible(true);

        zeigeFrage();

        view.ok.addActionListener(e -> pruefeAntwort());
    }

    // =============================
    // FRAGE ANZEIGEN (TEXT / BILD)
    // =============================
    private void zeigeFrage() {
        Frage f = pool.getFragen().get(index);

        view.frageLabel.setText("");
        view.frageLabel.setIcon(null);

        if (f.getTyp().equals("TEXT")) {
            view.frageLabel.setText(f.getInhalt());
        }

        if (f.getTyp().equals("BILD")) {
            try {
                URL url = new URL(f.getInhalt());
                ImageIcon icon = new ImageIcon(url);

                if (icon.getIconWidth() <= 0) {
                    view.frageLabel.setText("❌ Bild konnte nicht geladen werden");
                    return;
                }

                Image img = icon.getImage().getScaledInstance(
                        350, 220, Image.SCALE_SMOOTH
                );
                view.frageLabel.setIcon(new ImageIcon(img));

            } catch (Exception ex) {
                view.frageLabel.setText("❌ Ungültige Bild-URL");
            }
        }

        view.antwort.setText("");
    }

    // =============================
    // ANTWORT PRÜFEN
    // =============================
    private void pruefeAntwort() {
        Frage f = pool.getFragen().get(index);

        if (view.antwort.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Bitte Antwort eingeben!");
            return;
        }

        if (view.antwort.getText()
                .equalsIgnoreCase(f.getRichtigeAntwort())) {
            statistik.richtig();
            JOptionPane.showMessageDialog(view, "✅ Richtig!");
        } else {
            statistik.falsch();
            JOptionPane.showMessageDialog(
                    view,
                    "❌ Falsch!\nRichtige Antwort: " + f.getRichtigeAntwort()
            );
        }

        index++;

        if (index < pool.getFragen().size()) {
            zeigeFrage();
        } else {
            JOptionPane.showMessageDialog(
                    view,
                    "Quiz beendet!\n\n" +
                            "Richtig: " + statistik.getRichtig() + "\n" +
                            "Falsch: " + statistik.getFalsch()
            );
            view.dispose();
        }
    }
}
