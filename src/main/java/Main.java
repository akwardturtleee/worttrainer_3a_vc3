import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import io.MainFrame;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.setProperty("flatlaf.animation", "true");
        UIManager.put("Component.arc", 18);
        UIManager.put("Button.arc", 18);
        UIManager.put("TextComponent.arc", 18);
        UIManager.put("Component.focusWidth", 1);

        SwingUtilities.invokeLater(MainFrame::new);
    }
}
