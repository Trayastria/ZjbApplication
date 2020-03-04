package com.example.zjbapplication.singleton;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Staff> staffList = new ArrayList<>();
    public void addStaff(Staff staff){
        staffList.add(staff);
    }

    public void showAllStaff(){
        for (Staff staff : staffList){
            System.out.println("公司员工有：" + staff.toString());
        }
    }
}
