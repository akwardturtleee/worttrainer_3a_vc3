import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FachbegriffModel model = new FachbegriffModel();
            DashboardView view = new DashboardView();
            new DashboardController(view, model);
            view.setVisible(true);
        });
    }
}