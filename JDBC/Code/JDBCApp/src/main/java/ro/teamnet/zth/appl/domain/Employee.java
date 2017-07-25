package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.util.Date;

/**
 * Created by Andrei.Apostol on 7/12/2017.
 */
@Table
public class Employee {
    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(Double commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    @Id(name="employee_id")
    private Long employee_id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phone_number;

    @Column(name="hire_date")
    private Date hire_date;

    @Column(name="job_id")
    private Long job_id;

    @Column(name="salary")
    private Double salary;

    @Column(name="commission_pct")
    private Double commission_pct;

    @Column(name="manager_id")
    private Long manager_id;

    @Column(name="department_id")
    private Long department_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!employee_id.equals(employee.employee_id)) return false;
        if (first_name != null ? !first_name.equals(employee.first_name) : employee.first_name != null) return false;
        if (last_name != null ? !last_name.equals(employee.last_name) : employee.last_name != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (phone_number != null ? !phone_number.equals(employee.phone_number) : employee.phone_number != null)
            return false;
        if (hire_date != null ? !hire_date.equals(employee.hire_date) : employee.hire_date != null) return false;
        if (job_id != null ? !job_id.equals(employee.job_id) : employee.job_id != null) return false;
        if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) return false;
        if (commission_pct != null ? !commission_pct.equals(employee.commission_pct) : employee.commission_pct != null)
            return false;
        if (manager_id != null ? !manager_id.equals(employee.manager_id) : employee.manager_id != null) return false;
        return department_id != null ? department_id.equals(employee.department_id) : employee.department_id == null;
    }

    @Override
    public int hashCode() {
        int result = employee_id.hashCode();
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        result = 31 * result + (hire_date != null ? hire_date.hashCode() : 0);
        result = 31 * result + (job_id != null ? job_id.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (commission_pct != null ? commission_pct.hashCode() : 0);
        result = 31 * result + (manager_id != null ? manager_id.hashCode() : 0);
        result = 31 * result + (department_id != null ? department_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", hire_date=" + hire_date +
                ", job_id=" + job_id +
                ", salary=" + salary +
                ", commission_pct=" + commission_pct +
                ", manager_id=" + manager_id +
                ", department_id=" + department_id +
                '}';
    }
}
