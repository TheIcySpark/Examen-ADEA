package com.adea.evaluation.service;

import com.adea.evaluation.model.UserModel;
import com.adea.evaluation.repository.UserRepository;
import com.adea.evaluation.utilities.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserModel> list(){
        return userRepository.findAll();
    }

    public void delete(String login){
        userRepository.deleteById(login);
    }

    public List<UserModel> searchUsers(String nombre, LocalDate fechaAlta, LocalDate fechaBaja) {
        if(nombre != null && nombre.isEmpty()){
            nombre = null;
        }
        if (nombre != null && fechaAlta != null && fechaBaja != null) {
            return userRepository.findByNombreAndFechaAltaAndFechaBaja(nombre, fechaAlta, fechaBaja);
        } else if (nombre != null && fechaAlta != null) {
            return userRepository.findByNombreAndFechaAlta(nombre, fechaAlta);
        } else if (nombre != null && fechaBaja != null) {
            return userRepository.findByNombreAndFechaBaja(nombre, fechaBaja);
        } else if (fechaAlta != null && fechaBaja != null) {
            return userRepository.findByFechaAltaAndFechaBaja(fechaAlta, fechaBaja);
        } else if (nombre != null) {
            return userRepository.findByNombre(nombre);
        } else if (fechaAlta != null) {
            return userRepository.findByFechaAlta(fechaAlta);
        } else if (fechaBaja != null) {
            return userRepository.findByFechaBaja(fechaBaja);
        } else {
            return userRepository.findAll();
        }
    }

    public void save(UserModel user){
        CustomPasswordEncoder customPasswordEncoder = new CustomPasswordEncoder();
        user.setPassword(customPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void update(UserModel newUser, String oldLogin){
        UserModel oldUser = userRepository.findByLogin(oldLogin);
        if(newUser.getPassword().isEmpty()){
            newUser.setPassword(oldUser.getPassword());
            userRepository.delete(oldUser);
            userRepository.save(newUser);
        }else{
            userRepository.delete(oldUser);
            save(newUser);
        }
    }

    public void changeUserStatus(String login, Character status) {
        UserModel userModel = userRepository.findByLogin(login);
        userModel.setStatus(status);
        userRepository.save(userModel);
    }
}
