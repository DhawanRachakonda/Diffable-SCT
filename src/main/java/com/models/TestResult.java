package com.models;

import com.utils.DiffInstance;

import java.util.HashMap;
import java.util.Map;

public class TestResult implements DiffInstance {

    private Long resultValue;

    public Long getResultValue() {
        return resultValue;
    }

    public void setResultValue(Long resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public Map<String, String> diffInstance() {
        Map<String, String> diffInstance = new HashMap<>();
        diffInstance.put("resultValue", String.valueOf(resultValue));
        return diffInstance;
    }
}
