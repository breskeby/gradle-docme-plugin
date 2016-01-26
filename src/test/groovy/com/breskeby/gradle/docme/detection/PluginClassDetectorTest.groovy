package com.breskeby.gradle.docme.detection

import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class PluginClassDetectorTest extends Specification {

    @Rule TemporaryFolder temporaryFolder = new TemporaryFolder();

    def "generates empty plugin model for empty folder"() {
        given:
        File testClassFolder = temporaryFolder.newFolder()
        PluginClassDetector detector = new PluginClassDetector()
        detector.classesDir = testClassFolder
        when:
        def model = detector.detect()
        then:
        model != null
    }
}
