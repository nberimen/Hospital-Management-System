package com.nberimen.hospitalmanagementsystem.admin.entityservice;

import com.nberimen.hospitalmanagementsystem.admin.Admin;
import com.nberimen.hospitalmanagementsystem.admin.AdminRepository;
import com.nberimen.hospitalmanagementsystem.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminEntityService extends BaseEntityService<Admin, AdminRepository> {

    public AdminEntityService(AdminRepository repository) {
        super(repository);
    }
}
