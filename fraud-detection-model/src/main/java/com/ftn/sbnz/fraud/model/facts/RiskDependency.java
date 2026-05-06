package com.ftn.sbnz.fraud.model.facts;

import org.kie.api.definition.type.Position;

public class RiskDependency {

    @Position(0)
    private String parentId;

    @Position(1)
    private String childId;

    public RiskDependency(String parentId, String childId) {
        this.parentId = parentId;
        this.childId = childId;
    }

    public String getParentId() { return parentId; }
    public void setParentId(String parentId) { this.parentId = parentId; }

    public String getChildId() { return childId; }
    public void setChildId(String childId) { this.childId = childId; }

    @Override
    public String toString() {
        return "RiskDependency{parentId='" + parentId + "', childId='" + childId + "'}";
    }
}
