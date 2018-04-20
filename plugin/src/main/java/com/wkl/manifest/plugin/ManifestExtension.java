package com.wkl.manifest.plugin;


import com.wkl.manifest.ActivityConfig;
import com.wkl.manifest.ApplicationConfig;

import org.gradle.api.Action;
import org.gradle.api.Project;

import java.util.ArrayList;
import java.util.List;

import groovy.lang.Closure;

/**
 * Created by <a href="mailto:kunlin.wang@mtime.com">Wang kunlin</a>
 * <p>
 * On 2018-04-16
 */
public class ManifestExtension {

    private ApplicationConfig application;
    private List<ActivityConfig> mActivityConfigs = new ArrayList<>();
    private Project mProject;

    public ManifestExtension(Project project) {
        application = new ApplicationConfig();
        mProject = project;
    }

    public void application(Action<ApplicationConfig> action) {
        action.execute(application);
    }

    public ApplicationConfig getApplication() {
        return application;
    }

    public static ManifestExtension getConfig(Project project) {
        return project.getExtensions().getByType(ManifestExtension.class);
    }

    public List<ActivityConfig> getActivityConfigs() {
        return mActivityConfigs;
    }

    public void activity(Closure closure) {
        ActivityConfig config = new ActivityConfig();
        mProject.configure(config, closure);
        mActivityConfigs.add(config);
    }
}