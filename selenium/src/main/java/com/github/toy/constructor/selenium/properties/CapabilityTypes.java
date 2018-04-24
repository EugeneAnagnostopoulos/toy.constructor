package com.github.toy.constructor.selenium.properties;

import com.github.toy.constructor.core.api.PropertySupplier;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

import java.util.List;
import java.util.ServiceLoader;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.ArrayUtils.contains;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

public enum CapabilityTypes implements PropertySupplier<Capabilities> {
    /**
     * Capabilities for the starting of {@link org.openqa.selenium.remote.RemoteWebDriver}
     */
    REMOTE("remote") {
        private Capabilities toBeReturned;

        /**
         * Creates {@link Capabilities} with following properties:
         * <p>
         *     <p>{@code web.driver.capability.browserName} to define browser. This is the necessary property</p>
         *     <p>{@code web.driver.capability.platformName} to define name of a supported platform.
         *     Windows, Linux etc. This is not the necessary property. @see org.openqa.selenium.Platform</p>
         *     <p>{@code web.driver.capability.javascriptEnabled} to enable or to disable js. Possible values are
         *     {@code true} or {@code false}. By default js is enabled. This is not the necessary property.</p>
         *     <p>{@code web.driver.capability.browserVersion} to define a vaersion of browser. This is not the necessary
         *     property.</p>
         *     <p>{@code remote.capability.suppliers} to define additional capabilities. It is comma-separated string
         *     which should contain names of suppliers.
         *     @see CapabilitySupplier
         *     @see AdditionalCapabilitiesFor </p>
         * </p>
         *
         * @return built {@link Capabilities}
         */
        @Override
        public Capabilities get() {
            toBeReturned = ofNullable(toBeReturned).orElseGet(() -> {
                if (CommonCapabilityProperties.BROWSER_NAME.get() == null ||
                        isBlank(String.valueOf(CommonCapabilityProperties.BROWSER_NAME.get()))) {
                    throw new IllegalArgumentException(format("The property %s should be defined",
                            CommonCapabilityProperties.BROWSER_NAME.getPropertyName()));
                }
                return super.get();
            });
            return toBeReturned;
        }
    },

    /**
     * Capabilities for the starting of {@link org.openqa.selenium.chrome.ChromeDriver}
     */
    CHROME("chrome") {
        private Capabilities toBeReturned;

        /**
         * Creates {@link Capabilities} with following properties:
         * <p>
         *     <p>{@code web.driver.capability.platformName} to define name of a supported platform.
         *     Windows, Linux etc. This is not the necessary property. @see org.openqa.selenium.Platform</p>
         *     <p>{@code web.driver.capability.javascriptEnabled} to enable or to disable js. Possible values are
         *     {@code true} or {@code false}. By default js is enabled. This is not the necessary property.</p>
         *     <p>{@code web.driver.capability.browserVersion} to define a vaersion of browser. This is not the necessary
         *     property.</p>
         *     <p>{@code remote.capability.suppliers} to define additional capabilities. It is comma-separated string
         *     which should contain names of suppliers.
         *     @see CapabilitySupplier
         *     @see AdditionalCapabilitiesFor </p>
         * </p>
         *
         * @return built {@link ChromeOptions}
         */
        @Override
        public Capabilities get() {
            toBeReturned = ofNullable(toBeReturned).orElseGet(() -> new ChromeOptions().merge(super.get()));
            return toBeReturned;
        }
    },

    /**
     * Capabilities for the starting of {@link org.openqa.selenium.edge.EdgeDriver}
     */
    EDGE("edge") {
        private Capabilities toBeReturned;

        /**
         * Creates {@link Capabilities} with following properties:
         * <p>
         *     <p>{@code web.driver.capability.platformName} to define name of a supported platform.
         *     Windows, Linux etc. This is not the necessary property. @see org.openqa.selenium.Platform</p>
         *     <p>{@code web.driver.capability.javascriptEnabled} to enable or to disable js. Possible values are
         *     {@code true} or {@code false}. By default js is enabled. This is not the necessary property.</p>
         *     <p>{@code web.driver.capability.browserVersion} to define a vaersion of browser. This is not the necessary
         *     property.</p>
         *     <p>{@code remote.capability.suppliers} to define additional capabilities. It is comma-separated string
         *     which should contain names of suppliers.
         *     @see CapabilitySupplier
         *     @see AdditionalCapabilitiesFor </p>
         * </p>
         *
         * @return built {@link EdgeOptions}
         */
        @Override
        public Capabilities get() {
            toBeReturned = ofNullable(toBeReturned).orElseGet(() -> new EdgeOptions().merge(super.get()));
            return toBeReturned;
        }
    },

    /**
     * Capabilities for the starting of {@link org.openqa.selenium.firefox.FirefoxDriver}
     */
    FIREFOX("firefox") {
        private Capabilities toBeReturned;

        /**
         * Creates {@link Capabilities} with following properties:
         * <p>
         *     <p>{@code web.driver.capability.platformName} to define name of a supported platform.
         *     Windows, Linux etc. This is not the necessary property. @see org.openqa.selenium.Platform</p>
         *     <p>{@code web.driver.capability.javascriptEnabled} to enable or to disable js. Possible values are
         *     {@code true} or {@code false}. By default js is enabled. This is not the necessary property.</p>
         *     <p>{@code web.driver.capability.browserVersion} to define a vaersion of browser. This is not the necessary
         *     property.</p>
         *     <p>{@code remote.capability.suppliers} to define additional capabilities. It is comma-separated string
         *     which should contain names of suppliers.
         *     @see CapabilitySupplier
         *     @see AdditionalCapabilitiesFor </p>
         * </p>
         *
         * @return built {@link FirefoxOptions}
         */
        @Override
        public Capabilities get() {
            toBeReturned = ofNullable(toBeReturned).orElseGet(() -> new FirefoxOptions().merge(super.get()));
            return toBeReturned;
        }
    },

    /**
     * Capabilities for the starting of {@link org.openqa.selenium.ie.InternetExplorerDriver}
     */
    IE("ie") {
        private Capabilities toBeReturned;

        /**
         * Creates {@link Capabilities} with following properties:
         * <p>
         *     <p>{@code web.driver.capability.platformName} to define name of a supported platform.
         *     Windows, Linux etc. This is not the necessary property. @see org.openqa.selenium.Platform</p>
         *     <p>{@code web.driver.capability.javascriptEnabled} to enable or to disable js. Possible values are
         *     {@code true} or {@code false}. By default js is enabled. This is not the necessary property.</p>
         *     <p>{@code web.driver.capability.browserVersion} to define a vaersion of browser. This is not the necessary
         *     property.</p>
         *     <p>{@code remote.capability.suppliers} to define additional capabilities. It is comma-separated string
         *     which should contain names of suppliers.
         *     @see CapabilitySupplier
         *     @see AdditionalCapabilitiesFor </p>
         * </p>
         *
         * @return built {@link InternetExplorerOptions}
         */
        @Override
        public Capabilities get() {
            toBeReturned = ofNullable(toBeReturned).orElseGet(() -> new InternetExplorerOptions().merge(super.get()));
            return toBeReturned;
        }
    },

    /**
     * Capabilities for the starting of {@link org.openqa.selenium.opera.OperaDriver}
     */
    OPERA("opera") {
        private Capabilities toBeReturned;

        /**
         * Creates {@link Capabilities} with following properties:
         * <p>
         *     <p>{@code web.driver.capability.platformName} to define name of a supported platform.
         *     Windows, Linux etc. This is not the necessary property. @see org.openqa.selenium.Platform</p>
         *     <p>{@code web.driver.capability.javascriptEnabled} to enable or to disable js. Possible values are
         *     {@code true} or {@code false}. By default js is enabled. This is not the necessary property.</p>
         *     <p>{@code web.driver.capability.browserVersion} to define a vaersion of browser. This is not the necessary
         *     property.</p>
         *     <p>{@code remote.capability.suppliers} to define additional capabilities. It is comma-separated string
         *     which should contain names of suppliers.
         *     @see CapabilitySupplier
         *     @see AdditionalCapabilitiesFor </p>
         * </p>
         *
         * @return built {@link OperaOptions}
         */
        @Override
        public Capabilities get() {
            toBeReturned = ofNullable(toBeReturned).orElseGet(() -> new OperaOptions().merge(super.get()));
            return toBeReturned;
        }
    },

    /**
     * Capabilities for the starting of {@link org.openqa.selenium.safari.SafariDriver}
     */
    SAFARI("safari") {
        private Capabilities toBeReturned;

        /**
         * Creates {@link Capabilities} with following properties:
         * <p>
         *     <p>{@code web.driver.capability.platformName} to define name of a supported platform.
         *     Windows, Linux etc. This is not the necessary property. @see org.openqa.selenium.Platform</p>
         *     <p>{@code web.driver.capability.javascriptEnabled} to enable or to disable js. Possible values are
         *     {@code true} or {@code false}. By default js is enabled. This is not the necessary property.</p>
         *     <p>{@code web.driver.capability.browserVersion} to define a vaersion of browser. This is not the necessary
         *     property.</p>
         *     <p>{@code remote.capability.suppliers} to define additional capabilities. It is comma-separated string
         *     which should contain names of suppliers.
         *     @see CapabilitySupplier
         *     @see AdditionalCapabilitiesFor </p>
         * </p>
         *
         * @return built {@link Capabilities} for {@link org.openqa.selenium.phantomjs.PhantomJSDriver}
         */
        @Override
        public Capabilities get() {
            toBeReturned = ofNullable(toBeReturned).orElseGet(() -> new SafariOptions().merge(super.get()));
            return toBeReturned;
        }
    },

    /**
     * Capabilities for the starting of {@link org.openqa.selenium.phantomjs.PhantomJSDriver}
     */
    PHANTOM_JS("phantomJs") {
        private Capabilities toBeReturned;

        @Override
        public Capabilities get() {
            toBeReturned = ofNullable(toBeReturned).orElseGet(() -> {
                DesiredCapabilities capabilities = new DesiredCapabilities().merge(super.get());
                capabilities.setCapability(BROWSER_NAME, BrowserType.PHANTOMJS);
                return capabilities;
            });
            return toBeReturned;
        }
    };

    private static final String CAPABILITY_SUPPLIERS = "capability.suppliers";
    private final String name;

    CapabilityTypes(String name) {
        this.name = format("%s.%s", name, CAPABILITY_SUPPLIERS);
    }

    @Override
    public Capabilities get() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ofNullable(CommonCapabilityProperties.BROWSER_NAME.get()).ifPresent(o ->
                desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, o));

        ofNullable(CommonCapabilityProperties.PLATFORM_NAME.get()).ifPresent(o ->
                desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, o));

        desiredCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,
                CommonCapabilityProperties.SUPPORTS_JAVASCRIPT.get());

        ofNullable(CommonCapabilityProperties.BROWSER_VERSION.get()).ifPresent(o ->
                desiredCapabilities.setCapability(CapabilityType.BROWSER_VERSION, o));

        returnOptional()
                .map(s -> ServiceLoader.load(CapabilitySupplier.class)
                        .stream()
                        .map(ServiceLoader.Provider::get).collect(toList())
                        .stream().filter(capabilitySupplier -> {
                            AdditionalCapabilitiesFor additionalCapabilitiesFor;
                            return ((additionalCapabilitiesFor =
                                    capabilitySupplier.getClass().getAnnotation(AdditionalCapabilitiesFor.class)) != null
                                    && additionalCapabilitiesFor.type().equals(this)
                                    && contains(s.split(","), additionalCapabilitiesFor.supplierName().trim())
                            );
                        }).collect(toList()))
                .orElse(List.of()).forEach(capabilitySupplier -> desiredCapabilities.merge(capabilitySupplier.get()));
        return desiredCapabilities;
    }

    @Override
    public String getPropertyName() {
        return name;
    }

    public enum CommonCapabilityProperties implements PropertySupplier<Object> {
        /**
         * Reads property {@code web.driver.capability.browserName} and returns string value.
         * Should be the same as following:
         * <p>
         *     <p>{@link BrowserType#CHROME}</p>
         *     <p>{@link BrowserType#EDGE}</p>
         *     <p>{@link BrowserType#FIREFOX}</p>
         *     <p>{@link BrowserType#IEXPLORE}</p>
         *     <p>{@link BrowserType#OPERA_BLINK}</p>
         *     <p>{@link BrowserType#SAFARI}</p>
         *     <p>{@link BrowserType#PHANTOMJS}</p>
         * </p>
         */
        BROWSER_NAME(format("web.driver.capability.%s", CapabilityType.BROWSER_NAME)),

        /**
         * Reads property {@code web.driver.capability.platformName} and returns string value.
         * Should be the same as an item of {@link org.openqa.selenium.Platform}
         */
        PLATFORM_NAME(format("web.driver.capability.%s", CapabilityType.PLATFORM_NAME)),

        /**
         * Reads property {@code web.driver.capability.javascriptEnabled} and returns boolean value.
         * Should be {@code true} or {@code false}. By default it returns {@code true}.
         */
        SUPPORTS_JAVASCRIPT(format("web.driver.capability.%s", CapabilityType.SUPPORTS_JAVASCRIPT)) {
            @Override
                public Boolean get() {
                return returnOptional().map(Boolean::parseBoolean).orElse(true);
            }
        },

        /**
         * Reads property {@code web.driver.capability.browserVersion} and returns string value.
         */
        BROWSER_VERSION(format("web.driver.capability.%s", CapabilityType.BROWSER_VERSION));

        private final String name;

        CommonCapabilityProperties(String name) {
            this.name = name;
        }

        @Override
        public String getPropertyName() {
            return name;
        }

        @Override
        public Object get() {
            return returnOptional().orElse(null);
        }
    }
}
