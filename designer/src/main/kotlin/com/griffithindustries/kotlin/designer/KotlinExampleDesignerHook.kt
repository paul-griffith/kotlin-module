package com.griffithindustries.kotlin.designer

import com.griffithindustries.kotlin.common.*
import com.inductiveautomation.ignition.common.licensing.*
import com.inductiveautomation.ignition.common.script.*
import com.inductiveautomation.ignition.common.script.hints.*
import com.inductiveautomation.ignition.designer.model.*

class KotlinExampleDesignerHook : AbstractDesignerModuleHook() {
    override fun initializeScriptManager(manager: ScriptManager) {
        manager.addScriptModule("system.excel", FastExcelWrapper, PropertiesFileDocProvider())
    }
}
