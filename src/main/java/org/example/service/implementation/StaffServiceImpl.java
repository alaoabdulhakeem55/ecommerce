package org.example.service.implementation;

import org.example.enums.Gender;
import org.example.enums.Roles;
import org.example.exceptions.AppException;
import org.example.model.Staff;
import org.example.repository.StaffRepo;
import org.example.resources.Resources;
import org.example.service.StaffService;

import java.util.Objects;

public class StaffServiceImpl implements StaffService {
    private final StaffRepo staffRepo;

    public StaffServiceImpl() {
        this.staffRepo = Resources.staffRepo;
    }

    @Override
    public Staff hire(String name, int age, Gender gender, Roles role) {
        if(role == Roles.CASHIER) {
            if((age >= 20) && (age <= 40) && gender == Gender.MALE || gender == Gender.FEMALE) {
                return staffRepo.save(new Staff("", name, age, gender.name(), role));
            }
        }
        if(role == Roles.MANAGER) {
            if((age >= 35) && (age <= 50) && gender == Gender.MALE || gender == Gender.FEMALE) {
                return staffRepo.save(new Staff("", name, age, gender.name(), role));
            }
        }
        throw new AppException("Not qualified");
    }

    @Override
    public Staff fire(String id) {
        Staff staff = staffRepo.getById(id);
        if(Objects.equals(staff.getRole(), staff.getId())) {
            return staff;
        }
        return staffRepo.deleteById(id);
    }

    @Override
    public Object findAll() {
        return staffRepo.getList();
    }

    @Override
    public Staff findById(String id) {
        return staffRepo.getById(id);
    }
}
