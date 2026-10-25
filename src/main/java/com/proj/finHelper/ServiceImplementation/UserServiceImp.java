package com.proj.finHelper.ServiceImplementation;

import com.proj.finHelper.DTO.UserDTO.SuperAdminRequestDTO;
import com.proj.finHelper.DTO.UserDTO.UserResponseDTO;
import com.proj.finHelper.entity.Lender;
import com.proj.finHelper.entity.User;
import com.proj.finHelper.enums.Role;
import com.proj.finHelper.enums.Status;
import com.proj.finHelper.exception.LenderNotFoundException;
import com.proj.finHelper.repository.LenderRepository;
import com.proj.finHelper.repository.UserRepository;
import com.proj.finHelper.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final LenderRepository lenderRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserResponseDTO createSuperAdminService(SuperAdminRequestDTO superAdminRequestDTO) {
        Lender lender = lenderRepository.findByLenderCodeAndIsDeletedFalse(superAdminRequestDTO.getLenderCode())
                .orElseThrow(()-> new LenderNotFoundException("Lender Does Not Exist / Invalid Lender Code"));

        if (lender.getStatus() != Status.ACTIVE){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Lender Not Active");
        }

        if (userRepository.existsByEmail(superAdminRequestDTO.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email Already Exist");
        }

        if (userRepository.existsByLenderAndRole(lender, Role.SUPER_ADMIN)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Super Admin Already Exists for This Lender");
        }

        User user = new User();
        user.setLender(lender);
        user.setParent(null);
        user.setName(superAdminRequestDTO.getName());
        user.setEmail(superAdminRequestDTO.getEmail());
        user.setAddress(superAdminRequestDTO.getAddress());
        user.setPhone(superAdminRequestDTO.getPhone());
        user.setPassword(passwordEncoder.encode(superAdminRequestDTO.getPassword()));
        user.setRole(Role.SUPER_ADMIN);
        userRepository.save(user);

        return UserResponseDTO.toUserResponseDTO(user);
    }
}
