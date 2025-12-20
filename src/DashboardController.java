import javax.swing.*;


public class DashboardController {


    private DashboardView view;
    private FachbegriffModel model;


    public DashboardController(DashboardView view, FachbegriffModel model) {
        this.view = view;
        this.model = model;


        view.verwaltenButton.addActionListener(e ->
                JOptionPane.showMessageDialog(view,
                        "Begriffsverwaltung (Prototyp)")
        );


        view.quizButton.addActionListener(e -> startQuiz());
    }


    private void startQuiz() {
        Fachbegriff f = model.getAlleBegriffe().get(0);
        String antwort = JOptionPane.showInputDialog(view,
                "Was bedeutet: " + f.getBegriff() + "?");


        if (antwort != null && antwort.toLowerCase().contains("abfolge")) {
            JOptionPane.showMessageDialog(view, "Richtig ✔");
        } else {
            JOptionPane.showMessageDialog(view,
                    "Falsch ❌\nRichtig: " + f.getErklaerung());
        }
    }
}