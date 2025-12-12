package io;

import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class SettingsPanel extends JPanel {

    public SettingsPanel(JFrame parentFrame) {
        // Rounded + shadow
        putClientProperty("JComponent.roundRect", true);
        putClientProperty("JComponent.shadowType", "drop");
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title
        JLabel title = new JLabel("Einstellungen", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));

        // Sound checkbox
        JCheckBox sound = new JCheckBox("Ton aktivieren");

        // Dark Mode toggle
        JCheckBox darkMode = new JCheckBox("Dunkles Theme");
        darkMode.setSelected(true); // Dark theme default

        // Center alignment
        title.setAlignmentX(CENTER_ALIGNMENT);
        sound.setAlignmentX(CENTER_ALIGNMENT);
        darkMode.setAlignmentX(CENTER_ALIGNMENT);

        // Theme toggle listener
        darkMode.addActionListener(e -> {
            try {
                if (darkMode.isSelected()) {
                    // Dark theme
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                    resetAllColors(parentFrame);
                } else {
                    // Light theme
                    UIManager.setLookAndFeel(new FlatLightLaf());

                    // Optional: green accent for Light theme
                    UIManager.put("Component.focusColor", new Color(0, 128, 0));
                    UIManager.put("Button.arc", 18);
                }

                // Apply changes
                SwingUtilities.updateComponentTreeUI(parentFrame);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Add components
        add(title);
        add(Box.createVerticalStrut(20));
        add(sound);
        add(Box.createVerticalStrut(10));
        add(darkMode);
    }

    /**
     * Recursively reset all component backgrounds and foregrounds to null
     * so that FlatLaf can correctly apply the selected theme.
     */
    private void resetAllColors(Component comp) {
        comp.setBackground(null);
        comp.setForeground(null);

        if (comp instanceof Container) {
            for (Component child : ((Container) comp).getComponents()) {
                resetAllColors(child);
            }
        }
    }
}
