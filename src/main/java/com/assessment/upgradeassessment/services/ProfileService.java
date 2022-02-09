package com.assessment.upgradeassessment.services;

import java.util.ArrayList;
import java.util.Optional;

import com.assessment.upgradeassessment.models.ProfileModel;
import com.assessment.upgradeassessment.repositories.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    /* GET */
    public ArrayList<ProfileModel> getProfiles() {
        return (ArrayList<ProfileModel>) profileRepository.findAll();
    }

    /* GET By ID */
    public Optional<ProfileModel> getProfileById(Long idProfile) {
        return profileRepository.findById(idProfile);
    }

    /* POST */
    public ProfileModel postProfile(ProfileModel profileModel) {
        return profileRepository.save(profileModel);
    }

    /* PUT */
    public ProfileModel putProfile(ProfileModel profileModel, Long idProfile) {

        return profileRepository.findById(idProfile)
                .map(profile -> {
                    profile.setProfile(profileModel.getProfile());
                    return profileRepository.save(profile);
                })
                .orElseGet(() -> {
                    profileModel.setIdProfile(idProfile);
                    return profileRepository.save(profileModel);
                });
    }

    /* DELETE */
    public boolean deleteProfile(Long idProfile) {
        try {
            profileRepository.deleteById(idProfile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
