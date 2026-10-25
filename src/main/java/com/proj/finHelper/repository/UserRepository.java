package com.proj.finHelper.repository;

import com.proj.finHelper.entity.Lender;
import com.proj.finHelper.entity.User;
import com.proj.finHelper.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByLenderAndRole(Lender lender, Role role);
}
