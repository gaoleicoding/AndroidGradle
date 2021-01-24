package com.java.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

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

