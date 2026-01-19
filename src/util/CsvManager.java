package util;

import model.*;
import java.io.*;

public class CsvManager {

    public static void speichern(File f, FragenPool p) throws IOException {
        PrintWriter w = new PrintWriter(new FileWriter(f));
        w.println("TYPE;BEGRIFF;BESCHREIBUNG;KATEGORIE;SCHWIERIGKEIT;FRAGETYP;FRAGE;ANTWORT");

        for (Fachbegriff b : p.getBegriffe())
            w.println("BEGRIFF;" + b.getBegriff() + ";" + b.getBeschreibung() + ";" +
                    b.getKategorie() + ";" + b.getSchwierigkeit() + ";;;");

        for (Frage q : p.getFragen())
            w.println("FRAGE;;;;;" + q.getTyp() + ";" + q.getInhalt() + ";" + q.getRichtigeAntwort());

        w.close();
    }

    public static void laden(File f, FragenPool p) throws IOException {
        p.clear();
        BufferedReader r = new BufferedReader(new FileReader(f));
        r.readLine();
        String l;
        while ((l = r.readLine()) != null) {
            String[] s = l.split(";");
            if (s[0].equals("BEGRIFF"))
                p.getBegriffe().add(new Fachbegriff(s[1], s[2], s[3], Integer.parseInt(s[4])));
            if (s[0].equals("FRAGE"))
                p.getFragen().add(new Frage(s[5], s[6], s[7]));
        }
        r.close();
    }
}
