package com.gl.plugin

import com.android.build.gradle.AppExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
//在buildSrc下创建的plugin只能在该工程下的多个模块之间复用代码。
// 如果想要在多个项目之间复用这个插件，我们就需要在一个单独的工程中编写插件，
// 将编译后的jar包上传maven仓库。
class LifecyclePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        System.out.println(">>>>>> LifecyclePlugin");
        AppExtension appExtension = project.extensions.getByType(AppExtension)
        appExtension.registerTransform(new MethodTimeTransform())

        //注册方式2
        //project.android.registerTransform(new MethodTimeTransform())
    }

}
