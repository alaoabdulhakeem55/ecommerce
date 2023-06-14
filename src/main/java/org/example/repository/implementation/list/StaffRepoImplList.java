package org.example.repository.implementation.list;

import org.example.model.Staff;
import org.example.repository.StaffRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.List;
import java.util.Map;


public class StaffRepoImplList extends ListGenericRepo<Staff> implements StaffRepo {
    public StaffRepoImplList(List<Staff> list) {
        super(list, "Staff");
    }


}