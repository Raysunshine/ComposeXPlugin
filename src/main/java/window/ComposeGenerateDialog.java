package window;

import com.intellij.openapi.ui.Messages;

import javax.swing.*;
import java.util.Objects;

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

    private onClickListener onClickListener;

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
            if (Objects.equals(composeName, "")) {
                Messages.showInfoMessage("Please input ComposeScreenName", "ComposeX");
                return;
            }
            onClickListener.onClick(defaultMode, easyMode, useFolder, useDirections, useScreen, useViewModel, composeName);
            dispose();
        });

        //取消
        cancelButton.addActionListener(e -> dispose());

        //defaultMode
        defaultMode.addActionListener(e -> easyMode.setSelected(false));

        //easyMode
        easyMode.addActionListener(e -> defaultMode.setSelected(false));
    }

    public void setOnClickListener(onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface onClickListener {
        void onClick(boolean defaultMode, boolean easyMode, boolean useFolder, boolean useDirections, boolean useScreen, boolean useViewModel, String composeName);
    }
}