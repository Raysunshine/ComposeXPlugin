package compose

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import window.ComposeGenerateDialog

class ComposeX : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getData(PlatformDataKeys.PROJECT)

        println("Click this buttons")
        val dialog = ComposeGenerateDialog()
        dialog.setLocationRelativeTo(dialog)
        dialog.pack()
        dialog.isVisible = true
    }
}