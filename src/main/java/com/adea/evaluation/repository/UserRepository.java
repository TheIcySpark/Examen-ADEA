package com.adea.evaluation.repository;

import com.adea.evaluation.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, String> {
    UserModel findByLogin(String login);

    // Basic query methods for filtering based on individual fields
    List<UserModel> findByNombre(String nombre);
    List<UserModel> findByFechaAlta(LocalDate fechaAlta);
    List<UserModel> findByFechaBaja(LocalDate fechaBaja);

    // Custom query methods for more complex filtering
    List<UserModel> findByNombreAndFechaAlta(String nombre, LocalDate fechaAlta);
    List<UserModel> findByNombreAndFechaBaja(String nombre, LocalDate fechaBaja);
    List<UserModel> findByFechaAltaAndFechaBaja(LocalDate fechaAlta, LocalDate fechaBaja);

    List<UserModel> findByNombreAndFechaAltaAndFechaBaja(String nombre, LocalDate fechaAlta, LocalDate fechaBaja);
}
