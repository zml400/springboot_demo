package guru.springframework.domain;

import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String empNo;
    private String firstNme;
    private String midiNit;
    private String lastName;
    private String workDept;
    private String phoneNo;
    private Date hireDate;
    private String edLevel;
    private String sex;
    private Date birthDate;
    private double salary;
    private double bonus;
    private double comm;

    public Employee(String empNo, String firstNme, String midiNit, String lastName, String workDept, String phoneNo, Date hireDate, String edLevel, String sex, Date birthDate, double salary, double bonus, double comm) {
        this.empNo = empNo;
        this.firstNme = firstNme;
        this.midiNit = midiNit;
        this.lastName = lastName;
        this.workDept = workDept;
        this.phoneNo = phoneNo;
        this.hireDate = hireDate;
        this.edLevel = edLevel;
        this.sex = sex;
        this.birthDate = birthDate;
        this.salary = salary;
        this.bonus = bonus;
        this.comm = comm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getFirstNme() {
        return firstNme;
    }

    public void setFirstNme(String firstNme) {
        this.firstNme = firstNme;
    }

    public String getMidiNit() {
        return midiNit;
    }

    public void setMidiNit(String midiNit) {
        this.midiNit = midiNit;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWorkDept() {
        return workDept;
    }

    public void setWorkDept(String workDept) {
        this.workDept = workDept;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getEdLevel() {
        return edLevel;
    }

    public void setEdLevel(String edLevel) {
        this.edLevel = edLevel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }
}
