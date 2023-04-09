package window;

import javax.swing.*;

public class ComposeGenerateDialog extends JDialog {
    private JPanel wholeJPanel;
    private JPanel selectLabel;
    private JRadioButton defaultMode;
    private JRadioButton easyMode;
    private JFormattedTextField composeName;
    private JPanel FunctionLabel;
    private JPanel ComposeScreenLabel;
    private JCheckBox useFolder;
    private JCheckBox useScreen;
    private JCheckBox useDirections;
    private JCheckBox useViewModel;
    private JButton cancelButton;
    private JButton confirmButton;
    private JPanel BottomButtons;

    public ComposeGenerateDialog() {
        setTitle("ComposeX Template Code Produce");
        setContentPane(wholeJPanel);
        setModal(true);

        // 确认
        confirmButton.addActionListener(e -> {
            boolean defaultMode = this.defaultMode.isSelected();
            boolean easyMode = this.easyMode.isSelected();
            boolean useFolder = this.useFolder.isSelected();
            boolean useDirections = this.useDirections.isSelected();
            boolean useScreen = this.useScreen.isSelected();
            boolean useViewModel = this.useViewModel.isSelected();
            String composeName = this.composeName.getText();
            dispose();
        });

        //取消
        cancelButton.addActionListener(e -> {
            dispose();
        });

        //defaultMode
        defaultMode.addActionListener(e -> {
            easyMode.setSelected(false);
        });

        //easyMode
        easyMode.addActionListener(e -> {
            defaultMode.setSelected(false);
        });
    }
}