package com.diffablepoc;

import com.models.Project;
import com.models.Sample;
import com.models.TestResult;
import com.utils.AuditLog;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiffablePOC {

    private static List<AuditLog> projects = new ArrayList<>();

    public static void setupData() {
        Project project1 = new Project();
        Sample project1Sample1 = new Sample();
        TestResult testResultSample1Project1 = new TestResult();
        testResultSample1Project1.setResultValue(10L);
        project1Sample1.setSampleId("project1Sample1");
        project1Sample1.setTestResult(testResultSample1Project1);

        Sample project1Sample2 = new Sample();
        TestResult testResultSample1Project2 = new TestResult();
        testResultSample1Project2.setResultValue(12L);
        project1Sample2.setSampleId("project1Sample2");
        project1Sample2.setTestResult(testResultSample1Project2);

        project1.setProjectName("MM Project");
        project1.setSamples(Arrays.asList(project1Sample1, project1Sample2));



        Project project1Update = new Project();
        Sample project1UpdateSample1 = new Sample();
        TestResult testResultSample1Project1Update = new TestResult();
        testResultSample1Project1Update.setResultValue(10L);
        project1UpdateSample1.setSampleId("project1UpdateSample1");
        project1UpdateSample1.setTestResult(testResultSample1Project1Update);

        Sample project1UpdateSample2 = new Sample();
        TestResult testResultSample1Project2Update = new TestResult();
        testResultSample1Project2Update.setResultValue(13L);
        project1UpdateSample2.setSampleId("project1UpdateSample2");
        project1UpdateSample2.setTestResult(testResultSample1Project2Update);

        project1Update.setProjectName("MM Test Project");
        project1Update.setSamples(Arrays.asList(project1UpdateSample1, project1UpdateSample2));

        AuditLog auditLog1 = new AuditLog();
        auditLog1.setEntityName("Project");
        auditLog1.setChanges(project1.diffInstance());

        AuditLog auditLog2 = new AuditLog();
        auditLog2.setEntityName("Project");
        auditLog2.setChanges(project1Update.diffInstance());

        projects.add(auditLog1);
        projects.add(auditLog2);
    }

    private static void printDiffResult() {
        AuditLog auditLog1 = projects.get(0);
        AuditLog auditLog2 = projects.get(1);

        DiffResult<AuditLog> diff = auditLog1.diff(auditLog2);

        for(Diff<?> d: diff.getDiffs()) {
            System.out.println(d.getFieldName()
                    + "= FROM[" + d.getLeft() + "] TO [" + d.getRight() + "]");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("It Works!");
        setupData();
        printDiffResult();
    }
}
