import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DictionaryFrame extends JFrame {
    private static final long serialVersionUID = 5999238925371797638L;
    private static final String DEFAULTSTR = "No descriptions about this.";

    public DictionaryFrame() {
        super("Dictonary");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        var dictionaryMap = parseDictionary();

        var textField = new JTextField(40);
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 20, 5, 20);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        add(textField, c);

        var button = new JButton("Search");
        c.weightx = 0.1;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.PAGE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 20, 5, 20);
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        add(button, c);

        var textArea = new JTextArea(50, 50);
        textArea.setEditable(false);
        textArea.setVisible(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 260;
        c.weightx = 1;
        c.insets = new Insets(5, 20, 20, 20);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        add(textArea, c);

        button.addActionListener(e -> {
            String searchWord = textField.getText().trim().toLowerCase();
            if (dictionaryMap.containsKey(searchWord)) {
                textArea.setText(dictionaryMap.get(searchWord));
            } else {
                textArea.setText(DEFAULTSTR);
            }
        });

    }

    private static Map<String, String> parseDictionary() {
        Map<String, String> newMap = new HashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get("Dictionary.txt"))) {
            lines.forEach(n -> newMap.put((n.split("-"))[0], (n.split("-"))[1]));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return newMap;
    }

}