package com.models;

import com.utils.DiffInstance;

import java.util.HashMap;
import java.util.Map;

public class Sample implements DiffInstance {
    private String sampleId;
    private String sampleName;
    private TestResult testResult;

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    @Override
    public Map<String, String> diffInstance() {
        Map<String, String> diffInstance = new HashMap<>();
        diffInstance.put(String.format("sampleId_%s", this.getSampleId()), this.getSampleId());
        diffInstance.put(String.format("sampleName_%s", this.getSampleId()), this.sampleName);
        diffInstance.putAll(this.testResult.diffInstance());
        return diffInstance;
    }
}
