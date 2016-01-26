package com.breskeby.gradle.docme.plugins
import org.asciidoctor.gradle.AsciidoctorTask
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

/**
 * Created by Rene on 26/01/16.
 */
class DocMePluginTest extends Specification {

    def "adds documentation task"() {
        given:
        Project project = ProjectBuilder.builder().build()
        when:
        project.plugins.apply(DocMePlugin)
        def docTask = project.tasks.findByName(DocMePlugin.GENERATE_PLUGIN_DOCS_TASK)
        then:
        docTask != null
        docTask instanceof AsciidoctorTask
        ProjectBuilder.builder().build()
    }
}
