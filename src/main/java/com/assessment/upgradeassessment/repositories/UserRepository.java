package com.assessment.upgradeassessment.repositories;

import java.util.ArrayList;

import com.assessment.upgradeassessment.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    public abstract ArrayList<UserModel> findByIdUser(Long idUser);
}
