package controller;

import model.*;
import view.*;

import javax.swing.*;
import java.util.Random;

public class SpielController {

    private String wort;
    private char[] anzeige;
    private int fehler = 0;

    public SpielController(FragenPool pool) {

        if (pool.getBegriffe().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Keine Begriffe vorhanden!");
            return;
        }

        Random rnd = new Random();
        int index = rnd.nextInt(pool.getBegriffe().size());
        wort = pool.getBegriffe().get(index).getBegriff().toUpperCase();

        anzeige = new char[wort.length()];
        for (int i = 0; i < anzeige.length; i++) anzeige[i] = '_';

        SpielView v = new SpielView();
        updateAnzeige(v);
        v.setVisible(true);

        v.buttons.forEach((buchstabe, button) -> {
            button.addActionListener(e -> {
                button.setEnabled(false);
                boolean gefunden = false;

                for (int i = 0; i < wort.length(); i++) {
                    if (wort.charAt(i) == buchstabe) {
                        anzeige[i] = buchstabe;
                        gefunden = true;
                    }
                }

                if (!gefunden) {
                    fehler++;
                    v.galgenPanel.setFehler(fehler);
                }

                updateAnzeige(v);

                if (fehler >= 6) {
                    JOptionPane.showMessageDialog(v,"Verloren! Wort war: " + wort);
                    v.dispose();
                }

                if (!new String(anzeige).contains("_")) {
                    JOptionPane.showMessageDialog(v,"Gewonnen!");
                    v.dispose();
                }
            });
        });
    }

    private void updateAnzeige(SpielView v) {
        v.wortAnzeige.setText(String.valueOf(anzeige));
    }
}
