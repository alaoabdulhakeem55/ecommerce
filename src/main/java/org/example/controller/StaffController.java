package org.example.controller;

import org.example.enums.Gender;
import org.example.enums.Roles;
import org.example.exceptions.AppException;
import org.example.exceptions.DBException;
import org.example.model.Staff;
import org.example.response.APIResponse;
import org.example.service.StaffService;
import org.example.service.implementation.StaffServiceImpl;


public class StaffController {

    private final StaffService staffService;

    public StaffController() {

        this.staffService = new StaffServiceImpl();
    }
    public APIResponse<Staff> hire(String name, int age, Gender gender, Roles role) {
        Staff staff;
        try {
            staff = staffService.hire(name, age, gender, role);
        } catch (AppException | DBException e){
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(staff, "staff successfully added", 200);
    }

    public APIResponse<Staff> fire(String id) {
        Staff staff;
        try {
            staff = staffService.fire(id) ;
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(staff, "staff has been fired", 200);
    }
    public APIResponse<Object> findAll() {
        Object staffList;
        try {
            staffList = staffService.findAll();
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(staffList, "List of all staff", 200);
    }

    public APIResponse<Staff> findById(String id) {
        Staff staff;
        try {
            staff = staffService.findById(id);
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(staff, "staff found", 200);
    }



















}
