package com.breskeby.gradle.docme.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class SetupAsciiDoc extends DefaultTask {

    @OutputDirectory File outputDirectory

    @TaskAction void generate() {

//        URL resourceUrl = getClass().getResource("/templates/asciidoc/index.adoc")
//        new File(outputDirectory, resourceUrl.)
    }
}
