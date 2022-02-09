package com.assessment.upgradeassessment.models;

import javax.persistence.*;

@Entity
@Table(name = "Tbl_Profiles")
public class ProfileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idProfile;

    @Column(nullable = false)
    private String profile;

    /* Getters and Setters */
    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
