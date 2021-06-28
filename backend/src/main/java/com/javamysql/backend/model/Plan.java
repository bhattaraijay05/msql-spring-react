package com.javamysql.backend.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Set;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @Column(name = "planId", unique = true, nullable = false, length = 40)
    private Integer planId;

    @Column(name = "planName", nullable = false, length = 40)
    private String planName;

    @JsonBackReference
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

    /**
     * @return Set<User> return the user
     */
    public Set<User> getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Set<User> user) {
        this.user = user;
    }

}
