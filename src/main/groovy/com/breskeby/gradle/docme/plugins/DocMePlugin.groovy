package com.breskeby.gradle.docme.plugins

import org.asciidoctor.gradle.AsciidoctorTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration

class DocMePlugin implements Plugin<Project> {

    public static final String GENERATE_PLUGIN_DOCS_TASK = "generatePluginDocumentation"

    @Override
    void apply(Project project) {
        Configuration asciidoctorConfiguration = project.configurations.maybeCreate("asciidoctor")
        project.dependencies {
            asciidoctor("org.asciidoctor:asciidoctorj:1.5.0")
        }

        def genDocTask = project.tasks.create(GENERATE_PLUGIN_DOCS_TASK, AsciidoctorTask)
        genDocTask.classpath = asciidoctorConfiguration
    }
}
