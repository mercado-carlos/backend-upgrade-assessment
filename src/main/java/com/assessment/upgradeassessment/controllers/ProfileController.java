package com.assessment.upgradeassessment.controllers;

import java.util.*;

import com.assessment.upgradeassessment.models.ProfileModel;
import com.assessment.upgradeassessment.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    /* GET */
    @GetMapping()
    public ArrayList<ProfileModel> getProfiles() {
        return profileService.getProfiles();
    }

    /* GET By ID */
    @GetMapping(path = "/{id}")
    public Optional<ProfileModel> getProfileById(@PathVariable("id") Long idProfile) {
        return this.profileService.getProfileById(idProfile);
    }

    /* POST */
    @PostMapping()
    public ProfileModel postProfiles(@RequestBody ProfileModel profileModel) {
        return this.profileService.postProfile(profileModel);
    }

    /* PUT */
    @PutMapping(path = "/{id}")
    public ProfileModel putProfile(@RequestBody ProfileModel profileModel,
            @PathVariable("id") Long idProfile) {
        return this.profileService.putProfile(profileModel, idProfile);
    }

    /* DELETE */
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long idProfile) {
        boolean ok = this.profileService.deleteProfile(idProfile);

        if (ok) {
            return "The next profile has been deleted: " + idProfile;
        } else {
            return "The next profile cannot be deleted: " + idProfile;
        }
    }
}
