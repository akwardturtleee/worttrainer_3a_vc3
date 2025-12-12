package io;

import model.TermManager;

import java.io.*;

public class TermIO {

    public static void exportToFile(File file) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter(file));
        for (var t : TermManager.getInstance().getTerms()) {
            w.write(t.getBegriff() + ";" + t.getDefinition());
            w.newLine();
        }
        w.close();
    }

    public static void importFromFile(File file) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(file));
        TermManager.getInstance().getTerms().clear();
        String line;
        while ((line = r.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length == 2) {
                TermManager.getInstance().addTerm(parts[0], parts[1]);
            }
        }
        r.close();
    }
}
