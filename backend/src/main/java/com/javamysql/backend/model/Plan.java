package com.javamysql.backend.model;

import javax.persistence.*;
import java.util.Set;
import java.io.Serializable;

@Entity
@Table(name = "plans")
public class Plan implements Serializable {
    @Id
    @Column(name = "planId", unique = true, nullable = false, length = 40)
    private Integer planId;

    @Column(name = "planName", nullable = false, length = 40)
    private String planName;

    @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> user;

    public Plan() {

    }

    public Plan(Integer planId, String planName) {
        this.planId = planId;
        this.planName = planName;
    }

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
