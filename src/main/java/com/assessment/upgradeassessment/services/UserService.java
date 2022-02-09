package com.assessment.upgradeassessment.services;

import java.util.ArrayList;
import java.util.Optional;

import com.assessment.upgradeassessment.models.UserModel;
import com.assessment.upgradeassessment.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /* GET */
    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    /* GET By ID */
    public Optional<UserModel> getUserById(Long idUser) {
        return userRepository.findById(idUser);
    }

    /* POST */
    public UserModel postUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    /* PUT */
    public UserModel putUser(UserModel userModel, Long idUser) {

        return userRepository.findById(idUser)
                .map(user -> {
                    user.setUserName(userModel.getUserName());
                    user.setPassword(userModel.getPassword());
                    user.setIdProfile(userModel.getIdProfile());
                    user.setIdEmployee(userModel.getIdEmployee());
                    user.setStatus(userModel.getStatus());
                    user.setCreateDate(userModel.getCreateDate());
                    user.setUpdateDate(userModel.getUpdateDate());
                    user.setLogin(userModel.getLogin());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    userModel.setIdUser(idUser);
                    return userRepository.save(userModel);
                });
    }

    /* DELETE */
    public boolean deleteUser(Long idUser) {
        try {
            userRepository.deleteById(idUser);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
