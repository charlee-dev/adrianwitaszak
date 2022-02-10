package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final KobwebLibraryAccessors laccForKobwebLibraryAccessors = new KobwebLibraryAccessors(owner);
    private final KobwebxLibraryAccessors laccForKobwebxLibraryAccessors = new KobwebxLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

    /**
     * Returns the group of libraries at kobweb
     */
    public KobwebLibraryAccessors getKobweb() { return laccForKobwebLibraryAccessors; }

    /**
     * Returns the group of libraries at kobwebx
     */
    public KobwebxLibraryAccessors getKobwebx() { return laccForKobwebxLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class KobwebLibraryAccessors extends SubDependencyFactory {
        private final KobwebSilkLibraryAccessors laccForKobwebSilkLibraryAccessors = new KobwebSilkLibraryAccessors(owner);

        public KobwebLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (com.varabyte.kobweb:kobweb-api)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("kobweb.api"); }

            /**
             * Creates a dependency provider for core (com.varabyte.kobweb:kobweb-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("kobweb.core"); }

        /**
         * Returns the group of libraries at kobweb.silk
         */
        public KobwebSilkLibraryAccessors getSilk() { return laccForKobwebSilkLibraryAccessors; }

    }

    public static class KobwebSilkLibraryAccessors extends SubDependencyFactory {
        private final KobwebSilkIconsLibraryAccessors laccForKobwebSilkIconsLibraryAccessors = new KobwebSilkIconsLibraryAccessors(owner);

        public KobwebSilkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (com.varabyte.kobweb:kobweb-silk)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("kobweb.silk.core"); }

        /**
         * Returns the group of libraries at kobweb.silk.icons
         */
        public KobwebSilkIconsLibraryAccessors getIcons() { return laccForKobwebSilkIconsLibraryAccessors; }

    }

    public static class KobwebSilkIconsLibraryAccessors extends SubDependencyFactory {

        public KobwebSilkIconsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for fa (com.varabyte.kobweb:kobweb-silk-icons-fa)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFa() { return create("kobweb.silk.icons.fa"); }

    }

    public static class KobwebxLibraryAccessors extends SubDependencyFactory {

        public KobwebxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for markdown (com.varabyte.kobwebx:kobwebx-markdown)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMarkdown() { return create("kobwebx.markdown"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final JetbrainsVersionAccessors vaccForJetbrainsVersionAccessors = new JetbrainsVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: kobweb (0.9.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKobweb() { return getVersion("kobweb"); }

            /**
             * Returns the version associated to this alias: kotlin (1.6.10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

        /**
         * Returns the group of versions at versions.jetbrains
         */
        public JetbrainsVersionAccessors getJetbrains() { return vaccForJetbrainsVersionAccessors; }

    }

    public static class JetbrainsVersionAccessors extends VersionFactory  {

        public JetbrainsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: jetbrains.compose (1.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompose() { return getVersion("jetbrains.compose"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final JetbrainsPluginAccessors baccForJetbrainsPluginAccessors = new JetbrainsPluginAccessors(providers, config);
        private final KobwebPluginAccessors baccForKobwebPluginAccessors = new KobwebPluginAccessors(providers, config);
        private final KobwebxPluginAccessors baccForKobwebxPluginAccessors = new KobwebxPluginAccessors(providers, config);
        private final KotlinPluginAccessors baccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of bundles at plugins.jetbrains
         */
        public JetbrainsPluginAccessors getJetbrains() { return baccForJetbrainsPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.kobweb
         */
        public KobwebPluginAccessors getKobweb() { return baccForKobwebPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.kobwebx
         */
        public KobwebxPluginAccessors getKobwebx() { return baccForKobwebxPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.kotlin
         */
        public KotlinPluginAccessors getKotlin() { return baccForKotlinPluginAccessors; }

    }

    public static class JetbrainsPluginAccessors extends PluginFactory {

        public JetbrainsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for jetbrains.compose to the plugin id 'org.jetbrains.compose'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getCompose() { return createPlugin("jetbrains.compose"); }

    }

    public static class KobwebPluginAccessors extends PluginFactory {

        public KobwebPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kobweb.application to the plugin id 'com.varabyte.kobweb.application'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getApplication() { return createPlugin("kobweb.application"); }

    }

    public static class KobwebxPluginAccessors extends PluginFactory {

        public KobwebxPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kobwebx.markdown to the plugin id 'com.varabyte.kobwebx.markdown'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getMarkdown() { return createPlugin("kobwebx.markdown"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlin.multiplatform to the plugin id 'org.jetbrains.kotlin.multiplatform'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getMultiplatform() { return createPlugin("kotlin.multiplatform"); }

    }

}
