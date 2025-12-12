package io;

import model.TermManager;
import javax.swing.*;
import java.awt.*;

public class TermsPanel extends JPanel {

    private final JList<String> list;
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final TermManager manager = TermManager.getInstance();

    public TermsPanel() {
        putClientProperty("JComponent.roundRect", true);
        putClientProperty("JComponent.shadowType", "drop");
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout(20, 20));

        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFont(new Font("SansSerif", Font.PLAIN, 15));

        refreshList();

        JScrollPane scrollPane = new JScrollPane(list);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton addBtn = new JButton("Hinzufügen");
        JButton editBtn = new JButton("Bearbeiten");
        JButton deleteBtn = new JButton("Löschen");
        JButton importBtn = new JButton("Importieren");
        JButton exportBtn = new JButton("Exportieren");

        addBtn.addActionListener(e -> {
            String term = JOptionPane.showInputDialog("Neuer Fachbegriff:");
            if (term != null && !term.isBlank()) {
                manager.addTerm(term, "Beschreibung fehlt");
                refreshList();
            }
        });

        editBtn.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index != -1) {
                String old = manager.getTerms().get(index).getBegriff();
                String neu = JOptionPane.showInputDialog("Bearbeiten:", old);
                if (neu != null && !neu.isBlank()) {
                    manager.getTerms().get(index).setBegriff(neu);
                    refreshList();
                }
            }
        });

        deleteBtn.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index != -1) {
                manager.removeTerm(manager.getTerms().get(index));
                refreshList();
            }
        });

        buttons.add(addBtn);
        buttons.add(editBtn);
        buttons.add(deleteBtn);
        buttons.add(importBtn);
        buttons.add(exportBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
    }

    private void refreshList() {
        listModel.clear();
        manager.getTerms().forEach(t -> listModel.addElement(t.getBegriff()));
    }
}
