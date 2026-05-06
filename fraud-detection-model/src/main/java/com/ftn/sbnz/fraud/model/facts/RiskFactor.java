package com.ftn.sbnz.fraud.model.facts;

import org.kie.api.definition.type.Position;

public class RiskFactor {

    @Position(0)
    private String id;

    @Position(1)
    private String customerId;

    @Position(2)
    private boolean satisfied;

    public RiskFactor(String id, String customerId, boolean satisfied) {
        this.id = id;
        this.customerId = customerId;
        this.satisfied = satisfied;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public boolean isSatisfied() { return satisfied; }
    public void setSatisfied(boolean satisfied) { this.satisfied = satisfied; }

    @Override
    public String toString() {
        return "RiskFactor{id='" + id + "', customerId='" + customerId + "', satisfied=" + satisfied + "}";
    }
}
