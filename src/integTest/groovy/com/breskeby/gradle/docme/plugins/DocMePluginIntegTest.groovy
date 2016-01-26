package com.breskeby.gradle.docme.plugins

import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class DocMePluginIntegTest extends Specification {

    @Rule
    final TemporaryFolder testProjectDir = new TemporaryFolder()
    File buildFile
    File settingsFile
    List<File> pluginClasspath

    def setup() {
        buildFile = testProjectDir.newFile('build.gradle')
        settingsFile = testProjectDir.newFile('settings.gradle')

        def pluginClasspathResource = getClass().classLoader.findResource("plugin-classpath.txt")
        if (pluginClasspathResource == null) {
            throw new IllegalStateException("Did not find plugin classpath resource, run `integTestClasses` build task.")
        }

        pluginClasspath = pluginClasspathResource.readLines().collect { new File(it) }

        settingsFile << """
        rootProject.name = "test-project"
        """

        buildFile << """
            plugins {
                id 'com.breskeby.gradle.docme'
            }
        """
    }

    def "plugin behaves well"() {
        when:
        GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('-q', 'tasks')
                .withPluginClasspath(pluginClasspath)
                .build()

        then:
        ! new File(testProjectDir.root, "build").exists()
    }
}
