package compose

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import window.ComposeGenerateDialog

class ComposeX : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val dialog = ComposeGenerateDialog()
        dialog.setLocationRelativeTo(dialog)
        dialog.pack()
        dialog.isVisible = true
    }
}