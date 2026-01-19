package controller;
import view.*;
import model.*;

public class DashboardController {
    public DashboardController(DashboardView v, FragenPool p) {
        v.verwaltung.addActionListener(e -> new VerwaltungController(p));
        v.quiz.addActionListener(e -> new QuizController(p));
        v.spiel.addActionListener(e -> new SpielController(p));
    }
}
