package compose

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.guessProjectDir
import window.ComposeGenerateDialog
import java.io.File
import java.nio.charset.Charset

class ComposeX : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {

        val parentDirectory =
            event.dataContext.getData("VCS_VIRTUAL_FILES").toString().removePrefix("[file://").removeSuffix("]")

        val dialog = ComposeGenerateDialog()
        dialog.setOnClickListener { defaultMode, easyMode, useFolder, useDirections, useScreen, useViewModel, composeName ->
            onConfirm(
                parentDirectory,
                defaultMode,
                easyMode,
                useFolder,
                useDirections,
                useScreen,
                useViewModel,
                composeName
            )
            //刷新项目
            event.project?.guessProjectDir()?.refresh(false, true)
        }
        dialog.setLocationRelativeTo(null)
        dialog.pack()
        dialog.isVisible = true
    }

    private fun onConfirm(
        parentDirectory: String,
        defaultMode: Boolean,
        easyMode: Boolean,
        useFolder: Boolean,
        useDirections: Boolean,
        useScreen: Boolean,
        useViewModel: Boolean,
        composeName: String
    ) {
        var targetDirectoryPath = parentDirectory
        val packageName = targetDirectoryPath.replace("/", ".").substringAfter("java.")
        val composeRoute = composeName.lowercase()
        if (useFolder) {//创建文件夹
            targetDirectoryPath = "$parentDirectory/$composeRoute"
            if (!File(targetDirectoryPath).exists()) {
                File(targetDirectoryPath).mkdirs()
            }
        }
        if (useDirections) {
            val inputStream = this.javaClass.getResourceAsStream("/template/ScreenDirections.txt")
            val directionsContent = inputStream?.readBytes()?.toString(Charset.defaultCharset())
            directionsContent?.let { content ->
                val newContent =
                    content.replace("\${Compose}", composeName).replace("\${Route}", composeRoute)
                        .replace("\${PACKAGE_NAME}", packageName)
                val directionsFile = File("$targetDirectoryPath/${composeName}ScreenDirections.kt")
                if (!directionsFile.exists()) {
                    directionsFile.createNewFile()
                    directionsFile.writeText(newContent)
                }
            }
        }
        if (useScreen) {
            val inputStream = this.javaClass.getResourceAsStream("/template/Screen.txt")
            val screenContent = inputStream?.readBytes()?.toString(Charset.defaultCharset())
            screenContent?.let { content ->
                val newContent =
                    content.replace("\${Compose}", composeName).replace("\${Route}", composeRoute)
                        .replace("\${PACKAGE_NAME}", packageName)
                val screenFile = File("$targetDirectoryPath/${composeName}Screen.kt")
                if (!screenFile.exists()) {
                    screenFile.createNewFile()
                    screenFile.writeText(newContent)
                }
            }
        }
        if (useViewModel) {
            val inputStream = this.javaClass.getResourceAsStream("/template/ScreenViewModel.txt")
            val viewModelContent = inputStream?.readBytes()?.toString(Charset.defaultCharset())
            viewModelContent?.let { content ->
                val newContent =
                    content.replace("\${Compose}", composeName).replace("\${Route}", composeRoute)
                        .replace("\${PACKAGE_NAME}", packageName)
                val viewModelFile = File("$targetDirectoryPath/${composeName}ScreenViewModel.kt")
                if (!viewModelFile.exists()) {
                    viewModelFile.createNewFile()
                    viewModelFile.writeText(newContent)
                }
            }
        }
    }
}