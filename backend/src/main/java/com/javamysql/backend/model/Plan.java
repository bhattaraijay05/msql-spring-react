package com.javamysql.backend.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "plan")
public class Plan {
    @Id
    @Column(name = "planId", nullable = false, length = 40)
    private Integer planId;

    @Column(name = "planName", nullable = false, length = 40)
    private String planName;

    /**
     * @return Integer return the planId
     */
    public Integer getPlanId() {
        return planId;
    }

    /**
     * @param planId the planId to set
     */
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    /**
     * @return String return the planName
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * @param planName the planName to set
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

}
