import pwo.lab08.engine.Engine;
import pwo.seq.SeqType;
import pwo.utils.SequenceTools;

import javax.swing.*;
import java.awt.*;

public class Lab08Gui extends JFrame {
    private static final String APP_NAME = "Lab08 GUI Application ";
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;

    private JLabel buildLabel(String text) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setSize(100, 60);
        return label;
    }

    private JTextField buildField() {
        JTextField textField = new JTextField();
        textField.setSize(100, 60);
        return textField;
    }

    private JComboBox<String> buildComboBox(String[] items) {
        JComboBox<String> box = new JComboBox<>(items);
        return box;
    }

    private JButton buildButton(String text) {
        JButton button = new JButton();
        button.setText(text);
        return button;
    }

    private void init() {
        setTitle(APP_NAME + Engine.getVersion());
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(4, 4);
        setLayout(layout);

        String[] types = {
                "fib",
                "luc",
                "tri"
        };

        JTextField fromField = buildField();
        JTextField resultField = buildField();
        JTextField toField = buildField();
        JComboBox<String> typesBox = buildComboBox(types);
        JButton evaluateButton = buildButton("Evaluate");
        evaluateButton.addActionListener(e -> {
            SeqType type = SeqType.fromString((String) typesBox.getSelectedItem());
            int from = Integer.parseInt(fromField.getText());
            int to = Integer.parseInt(toField.getText());
            String result = SequenceTools.getTermsAsColumn(type.getGenerator(), from, to);
            resultField.setText(result);
        });

        add(buildLabel("From"));
        add(fromField);
        add(buildLabel("To"));
        add(toField);
        add(buildLabel("Type"));
        add(typesBox);
        add(evaluateButton);
        add(resultField);
    }

    private void start() {
        setVisible(true);
    }

    public static void main(String[] args) {
        Lab08Gui gui = new Lab08Gui();
        gui.init();
        gui.start();
    }
}
