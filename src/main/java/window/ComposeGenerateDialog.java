package window;

import javax.swing.*;

public class ComposeGenerateDialog extends JDialog {
    private JPanel wholeJPanel;
    private JPanel selectLabel;
    private JRadioButton DefaultMode;
    private JRadioButton EasyMode;
    private JFormattedTextField formattedTextField1;
    private JPanel FunctionLabel;
    private JPanel ComposeScreenLabel;
    private JCheckBox folder;
    private JCheckBox useScreenCheckBox;
    private JCheckBox useDirectionsCheckBox;
    private JCheckBox useViewModelCheckBox;
    private JButton cancelButton;
    private JButton confirmButton;

    public ComposeGenerateDialog() {
        setContentPane(wholeJPanel);
        setModal(true);

        // 确认
        confirmButton.addActionListener(e -> {

        });

        //取消
        cancelButton.addActionListener(e -> {

        });

        //DefaultMode
        DefaultMode.addActionListener(e -> {

        });

        //EasyMode
        EasyMode.addActionListener(e -> {

        });
    }

    public void setWholeJPanel(JPanel wholeJPanel) {
        this.wholeJPanel = wholeJPanel;
    }
}