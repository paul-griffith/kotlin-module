package com.griffithindustries.kotlin.gateway

import com.griffithindustries.kotlin.common.*
import com.inductiveautomation.ignition.common.licensing.*
import com.inductiveautomation.ignition.common.project.resource.adapter.*
import com.inductiveautomation.ignition.common.script.hints.*
import com.inductiveautomation.ignition.gateway.dataroutes.*
import com.inductiveautomation.ignition.gateway.model.*
import com.inductiveautomation.ignition.gateway.web.models.*
import com.inductiveautomation.ignition.gateway.web.pages.config.overviewmeta.*
import com.inductiveautomation.ignition.gateway.web.pages.status.overviewmeta.*
import org.python.core.*
import java.util.*
import javax.servlet.http.*

class KotlinExampleGatewayHook : AbstractGatewayModuleHook() {
    lateinit var context: GatewayContext
    /**
     * Called to before startup. This is the chance for the module to add its extension points and update persistent
     * records and schemas. None of the managers will be started up at this point, but the extension point managers will
     * accept extension point types.
     */
    override fun setup(context: GatewayContext) {
        this.context = context

        context.scriptManager.addScriptModule("system.excel", FastExcelWrapper, PropertiesFileDocProvider())
    }

    override fun startup(activationState: LicenseState) {}

    override fun shutdown() {}

    override fun isFreeModule(): Boolean = true

    override fun isMakerEditionCompatible() = true

}
