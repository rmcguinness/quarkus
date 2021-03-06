package io.quarkus.tika.runtime;

import java.util.Optional;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

/**
 * Tika parser configuration
 */
@ConfigRoot(phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
public class TikaConfiguration {
    /**
     * The resource path within the application artifact to the {@code tika-config.xml} file.
     */
    @ConfigItem
    public Optional<String> tikaConfigPath;

    /**
     * Comma separated list of the parsers which must be supported.
     * <p>
     * Most of the document formats recognized by Apache Tika are supported by default but it affects
     * the application memory and native executable sizes. One can list only the required parsers in
     * {@code tika-config.xml} to minimize a number of parsers loaded into the memory, but using this
     * property is recommended to achieve both optimizations.
     * <p>
     * Either the abbreviated or full parser class names can be used.
     * At the moment only PDF parser can be listed using a reserved 'pdf' abbreviation.
     * Custom class name abbreviations have to be used for all other parsers.
     * For example:
     * 
     * <pre>
     * // Only PDF parser is required:
     * tika-parsers = pdf
     * // Only PDF and Java class parsers are required:
     * tika-parsers = pdf,classparser
     * classparser = org.apache.tika.parser.asm.ClassParser
     * </pre>
     * 
     * This property will have no effect if the `tikaConfigPath' property has been set.
     */
    @ConfigItem
    public Optional<String> parsers;

    /**
     * Controls how the content of the embedded documents is parsed.
     * By default it is appended to the master document content.
     * Setting this property to false makes the content of each of the embedded documents
     * available separately.
     */
    @ConfigItem(defaultValue = "true")
    public boolean appendEmbeddedContent;
}
