package controller;

import model.*;
import util.CsvManager;
import view.VerwaltungView;

import javax.swing.*;
import java.io.File;

public class VerwaltungController {

    private VerwaltungView view;
    private FragenPool pool;

    public VerwaltungController(FragenPool pool) {
        this.pool = pool;
        view = new VerwaltungView();
        view.setVisible(true);

        refresh();

        // ===== Begriff hinzufügen =====
        view.btnBegriffAdd.addActionListener(e -> {
            if (view.tfBegriff.getText().isEmpty()) return;

            pool.getBegriffe().add(
                    new Fachbegriff(
                            view.tfBegriff.getText(),
                            view.tfBeschreibung.getText(),
                            view.tfKategorie.getText(),
                            (int) view.spSchwierigkeit.getValue()
                    )
            );
            clearBegriffInput();
            refresh();
        });

        // ===== Begriff löschen =====
        view.btnBegriffLoeschen.addActionListener(e -> {
            Fachbegriff b =
                    (Fachbegriff) view.begriffListe.getSelectedValue();
            if (b != null) {
                pool.getBegriffe().remove(b);
                refresh();
            }
        });

        // ===== Frage hinzufügen =====
        view.btnFrageAdd.addActionListener(e -> {
            if (view.tfFrageInhalt.getText().isEmpty()) return;

            pool.getFragen().add(
                    new Frage(
                            (String) view.cbFragetyp.getSelectedItem(),
                            view.tfFrageInhalt.getText(),
                            view.tfAntwort.getText()
                    )
            );
            clearFrageInput();
            refresh();
        });

        // ===== Frage löschen =====
        view.btnFrageLoeschen.addActionListener(e -> {
            Frage f =
                    (Frage) view.fragenListe.getSelectedValue();
            if (f != null) {
                pool.getFragen().remove(f);
                refresh();
            }
        });

        // ===== CSV speichern =====
        view.btnSpeichern.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
                try {
                    CsvManager.speichern(fc.getSelectedFile(), pool);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            view, "Fehler beim Speichern!"
                    );
                }
            }
        });

        // ===== CSV laden =====
        view.btnLaden.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
                try {
                    CsvManager.laden(fc.getSelectedFile(), pool);
                    refresh();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            view, "Fehler beim Laden!"
                    );
                }
            }
        });
    }

    // ===== Anzeige aktualisieren =====
    private void refresh() {
        view.begriffListe.setListData(
                pool.getBegriffe().toArray()
        );
        view.fragenListe.setListData(
                pool.getFragen().toArray()
        );
    }

    private void clearBegriffInput() {
        view.tfBegriff.setText("");
        view.tfBeschreibung.setText("");
        view.tfKategorie.setText("");
        view.spSchwierigkeit.setValue(1);
    }

    private void clearFrageInput() {
        view.tfFrageInhalt.setText("");
        view.tfAntwort.setText("");
        view.cbFragetyp.setSelectedIndex(0);
    }
}
