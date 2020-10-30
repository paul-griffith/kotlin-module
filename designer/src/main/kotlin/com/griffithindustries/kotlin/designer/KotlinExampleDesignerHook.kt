package com.griffithindustries.kotlin.designer

import com.griffithindustries.kotlin.common.*
import com.inductiveautomation.ignition.common.licensing.*
import com.inductiveautomation.ignition.designer.model.*

/**
 * This is the Designer-scope module hook.  The minimal implementation contains a startup method.
 */
class KotlinExampleDesignerHook : AbstractDesignerModuleHook() {
    @Throws(Exception::class)
    override fun startup(context: DesignerContext, activationState: LicenseState) {
        KotlinExampleModule.MODULE_ID
    }

}
