package com.example.zjbapplication.singleton;

public class TestCom {
    public TestCom() {
        Company company = new Company();
        Staff staff = new Staff();
        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        company.addStaff(staff);
        company.addStaff(staff1);
        company.addStaff(staff2);

        Staff staff3 = new Vp();
        Staff staff4 = new Vp();
        company.addStaff(staff3);
        company.addStaff(staff4);

        Staff staff5 = Ceo.getCeo();
        Staff staff6 = Ceo.getCeo();
        company.addStaff(staff5);
        company.addStaff(staff6);

        Staff staff7 = Ceo1.getInstance();
        Staff staff8 = Ceo1.getInstance();
        Staff staff9 = Ceo1.getInstance();
        Staff staff10 = Ceo1.getInstance();
        Staff staff11 = Ceo1.getInstance();
        Staff staff12 = Ceo1.getInstance();
        company.addStaff(staff7);
        company.addStaff(staff8);
        company.addStaff(staff9);
        company.addStaff(staff10);
        company.addStaff(staff11);
        company.addStaff(staff12);

        Staff staff13 = Ceo2.getInstance();
        Staff staff14 = Ceo2.getInstance();
        Staff staff15 = Ceo2.getInstance();
        Staff staff16 = Ceo2.getInstance();
        company.addStaff(staff13);
        company.addStaff(staff14);
        company.addStaff(staff15);
        company.addStaff(staff16);
        company.showAllStaff();
    }

}
