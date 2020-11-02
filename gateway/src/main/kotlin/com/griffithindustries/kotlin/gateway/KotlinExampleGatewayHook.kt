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

    /**
     * Called to initialize the module. Will only be called once. Persistence interface is available, but only in
     * read-only mode.
     */
    override fun startup(activationState: LicenseState) {}

    /**
     * Called to shutdown this module. Note that this instance will never be started back up - a new one will be created
     * if a restart is desired
     */
    override fun shutdown() {

    }

    /**
     * @return `true` if this is a "free" module, i.e. it does not participate in the licensing system. This is
     * equivalent to the now defunct FreeModule attribute that could be specified in module.xml.
     */
    override fun isFreeModule(): Boolean = true

    override fun isMakerEditionCompatible() = true

}
