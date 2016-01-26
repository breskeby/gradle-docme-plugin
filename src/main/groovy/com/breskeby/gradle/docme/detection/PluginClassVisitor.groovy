package com.breskeby.gradle.docme.detection
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Opcodes

/**
 * Created by Rene on 26/01/16.
 */
class PluginClassVisitor extends ClassVisitor {
    private boolean isAbstract;
    private String className;
    private String superClassName;

    PluginClassVisitor() {
        super(Opcodes.ASM5)
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.isAbstract = (access & Opcodes.ACC_ABSTRACT) != 0;
        this.className = name;
        this.superClassName = superName;
    }

}
