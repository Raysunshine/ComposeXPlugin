package com.raysun.composex

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class ComposeX : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        println("Click this buttons")
    }
}