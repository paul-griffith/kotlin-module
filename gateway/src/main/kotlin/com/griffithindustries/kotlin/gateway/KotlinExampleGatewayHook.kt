package com.griffithindustries.kotlin.gateway

import com.inductiveautomation.ignition.common.licensing.*
import com.inductiveautomation.ignition.common.project.resource.adapter.*
import com.inductiveautomation.ignition.gateway.dataroutes.*
import com.inductiveautomation.ignition.gateway.model.*
import com.inductiveautomation.ignition.gateway.web.models.*
import com.inductiveautomation.ignition.gateway.web.pages.config.overviewmeta.*
import com.inductiveautomation.ignition.gateway.web.pages.status.overviewmeta.*
import java.util.*
import javax.servlet.http.*

/**
 * Class which is instantiated by the Ignition platform when the module is loaded in the gateway scope.
 */
class KotlinExampleGatewayHook : AbstractGatewayModuleHook() {
    /**
     * Called to before startup. This is the chance for the module to add its extension points and update persistent
     * records and schemas. None of the managers will be started up at this point, but the extension point managers will
     * accept extension point types.
     */
    override fun setup(context: GatewayContext) {}

    /**
     * Called to initialize the module. Will only be called once. Persistence interface is available, but only in
     * read-only mode.
     */
    override fun startup(activationState: LicenseState) {}

    /**
     * Called to shutdown this module. Note that this instance will never be started back up - a new one will be created
     * if a restart is desired
     */
    override fun shutdown() {}

    /**
     * A list (may be null or empty) of panels to display in the config section. Note that any config panels that are
     * part of a category that doesn't exist already or isn't included in [.getConfigCategories] will
     * *not be shown*.
     */
    override fun getConfigPanels(): List<IConfigTab>? {
        return null
    }

    /**
     * A list (may be null or empty) of custom config categories needed by any panels returned by  [ ][.getConfigPanels]
     */
    override fun getConfigCategories(): List<ConfigCategory>? {
        return null
    }

    /**
     * @return the path to a folder in one of the module's gateway jar files that should be mounted at
     * /res/module-id/foldername
     */
    override fun getMountedResourceFolder(): Optional<String> {
        return Optional.empty()
    }

    /**
     * Provides a chance for the module to mount any route handlers it wants. These will be active at
     * <tt>/main/data/module-id/ *</tt> See [RouteGroup] for details. Will be called after startup().
     */
    override fun mountRouteHandlers(routes: RouteGroup) {}

    /**
     * Used by the mounting underneath /res/module-id/ * and /main/data/module-id/ * as an alternate mounting path instead
     * of your module id, if present.
     */
    override fun getMountPathAlias(): Optional<String> {
        return Optional.empty()
    }

    /**
     * @return `true` if this is a "free" module, i.e. it does not participate in the licensing system. This is
     * equivalent to the now defunct FreeModule attribute that could be specified in module.xml.
     */
    override fun isFreeModule(): Boolean {
        return false
    }

    /**
     * Implement this method to contribute meta data to the Status section's Systems / Overview page.
     */
    override fun getStatusOverviewContributor(): Optional<OverviewContributor> {
        return Optional.empty()
    }

    /**
     * Implement this method to contribute meta data to the Configure section's Overview page.
     */
    override fun getConfigOverviewContributor(): Optional<ConfigOverviewContributor> {
        return Optional.empty()
    }

    /**
     * Register any [ResourceTypeAdapter]s this module needs with with `registry`.
     *
     *
     * ResourceTypeAdapters are used to adapt a legacy (7.9 or prior) resource type name or payload into a nicer format
     * for the Ignition 8.0 project resource system.Ã’ Only override this method for modules that aren't known by the
     * [ResourceTypeAdapterRegistry] already.
     *
     *
     * **This method is called before [.setup] or [.startup].**
     *
     * @param registry the shared [ResourceTypeAdapterRegistry] instance.
     */
    override fun initializeResourceTypeAdapterRegistry(registry: ResourceTypeAdapterRegistry) {}

    /**
     * Called prior to a 'mounted resource request' being fulfilled by requests to the mounted resource servlet serving
     * resources from /res/module-id/ (or /res/alias/ if [GatewayModuleHook.getMountPathAlias] is implemented). It
     * is called after the target resource has been successfully located.
     *
     *
     *
     * Primarily intended as an opportunity to amend/alter the response's headers for purposes such as establishing
     * Cache-Control. By default, Ignition sets no additional headers on a resource request.
     *
     *
     * @param resourcePath path to the resource being returned by the mounted resource request
     * @param response     the response to read/amend.
     */
    override fun onMountedResourceRequest(resourcePath: String, response: HttpServletResponse) {}
}
