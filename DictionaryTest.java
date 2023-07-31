import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DictionaryTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
                    | IllegalAccessException ex) {
                ex.printStackTrace();
            }
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        var dictionaryFrame = new DictionaryFrame();
        dictionaryFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dictionaryFrame.setSize(1280, 720);
        dictionaryFrame.setLocationByPlatform(true);
        dictionaryFrame.setVisible(true);
    }

}
