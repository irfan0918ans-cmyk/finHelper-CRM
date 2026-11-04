package com.proj.finHelper.ServiceImplementation;

import com.proj.finHelper.DTO.AdminCreateDTO.AdminCreateRequestDTO;
import com.proj.finHelper.DTO.AdminCreateDTO.AdminCreateResponseDTO;
import com.proj.finHelper.entity.User;
import com.proj.finHelper.enums.Role;
import com.proj.finHelper.enums.Status;
import com.proj.finHelper.repository.UserRepository;
import com.proj.finHelper.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImp implements AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private User getActiveUserWithRole(Integer id, Role role){
        User user = userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found"));

        if (user.getRole() != role){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Only" + role + "Can do this");
        }

        if (user.getStatus() != Status.ACTIVE){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"User is Not Active");
        }
        return user;

    }

    @Override
    public AdminCreateResponseDTO createAdminService(AdminCreateRequestDTO adminCreateRequestDTO) {
        User superAdmin = getActiveUserWithRole(adminCreateRequestDTO.getSuperAdminId(),Role.SUPER_ADMIN);

        if (userRepository.existsByEmail(adminCreateRequestDTO.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already in Use");
        }

        User createAdmin = new User();
        createAdmin.setLender(superAdmin.getLender());
        createAdmin.setParent(superAdmin);
        createAdmin.setName(adminCreateRequestDTO.getName());
        createAdmin.setEmail(adminCreateRequestDTO.getEmail());
        createAdmin.setPhone(adminCreateRequestDTO.getPhone());
        createAdmin.setPassword(passwordEncoder.encode(adminCreateRequestDTO.getPassword()));
        createAdmin.setRole(Role.ADMIN);

        User savedUser = userRepository.save(createAdmin);

        return AdminCreateResponseDTO.toAdminCreateResponseDTO(savedUser);
    }

    @Override
    public List<AdminCreateResponseDTO> getAllAdminService(Integer superAdminId) {
        getActiveUserWithRole(superAdminId,Role.ADMIN);
        return userRepository.findByParentIdAndRoleAndIsDeletedFalse(superAdminId,Role.ADMIN)
                .stream()
                .map(AdminCreateResponseDTO::toAdminCreateResponseDTO)
                .toList();
    }


}
