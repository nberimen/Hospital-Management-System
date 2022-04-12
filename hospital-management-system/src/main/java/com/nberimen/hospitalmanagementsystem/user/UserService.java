package com.nberimen.hospitalmanagementsystem.user;

import com.nberimen.hospitalmanagementsystem.gen.exceptions.ItemNotFoundException;
import com.nberimen.hospitalmanagementsystem.user.entityservice.UserEntityService;
import com.nberimen.hospitalmanagementsystem.user.enums.UserErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserEntityService userEntityService;


    public User findByIdentityNo(Long identityNo) {
        User inDB = userEntityService.findByIdentityNo(identityNo);
        if (inDB == null) {
            throw new ItemNotFoundException(UserErrorMessage.USER_ERROR_MESSAGE);
        }
        return inDB;
    }
}
