package com.utils;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;

public class AuditLog implements Diffable<AuditLog> {

    private String entityName;
    private Map<String, String> changes;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Map<String, String> getChanges() {
        return changes;
    }

    public void setChanges(Map<String, String> changes) {
        this.changes = changes;
    }

    @Override
    public DiffResult diff(AuditLog auditLog) {
        DiffBuilder<AuditLog> diffBuilder = new DiffBuilder<AuditLog>(this, auditLog, ToStringStyle.SHORT_PREFIX_STYLE);

        for(Map.Entry<String, String> change : this.changes.entrySet()) {
            diffBuilder.append(change.getKey(), change.getValue(), auditLog.getChanges().get(change.getKey()));
        }

        return diffBuilder.build();
    }
}
