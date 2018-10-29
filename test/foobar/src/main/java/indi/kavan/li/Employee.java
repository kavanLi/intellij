package indi.kavan.li;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ritchie in 16:55 2017/12/24.
 */
@Data
public class Employee {
    private String id;
    private int salary;
    private String name;
    private String organization;
    private Date hiredate;

    public Employee() {
    }

    public Employee(String id, int salary, String name, String organization, String hiredate) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.organization = organization;

        DateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            this.hiredate = format.parse(hiredate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
