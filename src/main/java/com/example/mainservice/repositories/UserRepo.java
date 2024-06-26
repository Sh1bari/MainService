package com.example.mainservice.repositories;

import com.example.mainservice.models.entities.Department;
import com.example.mainservice.models.entities.User;
import com.example.mainservice.models.enums.UserRoleInDepartment;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findByAuthId(UUID authid);
    Set<User> findAllByDepartmentRoles_department_idAndDepartmentRoles_rolesIn(UUID departmentRoles_department_id, Collection<List<UserRoleInDepartment>> departmentRoles_roles);
    @Query("SELECT u FROM User u WHERE u.id IN :ids")
    Set<User> findAllByIds(List<UUID> ids);
    Page<User> findAllByDepartmentRoles_department_id(UUID id, Pageable pageable);

    Page<User> findAll(Specification<User> spec, Pageable pageable);
}
