import javax.swing.*;
import controller.DashboardController;
import view.DashboardView;
import model.FragenPool;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FragenPool pool = new FragenPool();
            DashboardView view = new DashboardView();
            new DashboardController(view, pool);
            view.setVisible(true);
        });
    }
}
