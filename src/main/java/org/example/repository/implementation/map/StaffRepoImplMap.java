package org.example.repository.implementation.map;

import org.example.model.Staff;
import org.example.repository.StaffRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.Map;


public class StaffRepoImplMap extends MapGenericRepo<Staff> implements StaffRepo {
    public StaffRepoImplMap(Map<String,Staff> list) {
        super(list, "Staff");
    }


}