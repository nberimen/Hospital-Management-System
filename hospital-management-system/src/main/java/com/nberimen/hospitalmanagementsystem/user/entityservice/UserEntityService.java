package com.nberimen.hospitalmanagementsystem.user.entityservice;

import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import com.nberimen.hospitalmanagementsystem.user.User;
import com.nberimen.hospitalmanagementsystem.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserEntityService  extends BaseEntityService<User, UserRepository> {
    public UserEntityService(UserRepository repository) {
        super(repository);
    }
    public User findByIdentityNo(Long identityNo){
        return getRepository().findByIdentityNo(identityNo);
    }
}
