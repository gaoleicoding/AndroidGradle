package com.java.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
//在buildSrc目录下编写插件，这样可以在多个模块之间复用该插件。
class MyPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        System.out.println("========================");
        System.out.println("hello gradle plugin!");
        System.out.println("========================");
    }

    private void println(String s) {
        System.out.println(s);
    }
}

