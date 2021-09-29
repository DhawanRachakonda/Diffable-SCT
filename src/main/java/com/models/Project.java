package com.models;

import com.utils.DiffInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project implements DiffInstance {

    private String projectName;
    private List<Sample> samples;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Sample> getSamples() {
        return samples;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }

    @Override
    public Map<String, String> diffInstance() {
        Map<String, String> diffInstance = new HashMap<>();
        diffInstance.put("projectName", this.getProjectName());

        // build samples diff instance
        Map<String, String> samplesDiffInstance = new HashMap<>();
        this.getSamples().forEach(eachSample -> {
            samplesDiffInstance.putAll(eachSample.diffInstance());
        });
        diffInstance.putAll(samplesDiffInstance);

        return diffInstance;
    }
}
