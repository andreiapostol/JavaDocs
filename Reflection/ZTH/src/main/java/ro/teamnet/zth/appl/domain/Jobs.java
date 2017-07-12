package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Andrei.Apostol on 7/12/2017.
 */

@Table
public class Jobs {
    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Long getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Long min_salary) {
        this.min_salary = min_salary;
    }

    public Long getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Long max_salary) {
        this.max_salary = max_salary;
    }
    @Id(name="job_id")
    private Long job_id;

    @Column(name="job_title")
    private String job_title;

    @Column(name="min_salary")
    private Long min_salary;

    @Column(name="max_salary")
    private Long max_salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jobs jobs = (Jobs) o;

        if (!job_id.equals(jobs.job_id)) return false;
        if (job_title != null ? !job_title.equals(jobs.job_title) : jobs.job_title != null) return false;
        if (min_salary != null ? !min_salary.equals(jobs.min_salary) : jobs.min_salary != null) return false;
        return max_salary != null ? max_salary.equals(jobs.max_salary) : jobs.max_salary == null;
    }

    @Override
    public int hashCode() {
        int result = job_id.hashCode();
        result = 31 * result + (job_title != null ? job_title.hashCode() : 0);
        result = 31 * result + (min_salary != null ? min_salary.hashCode() : 0);
        result = 31 * result + (max_salary != null ? max_salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "job_id=" + job_id +
                ", job_title='" + job_title + '\'' +
                ", min_salary=" + min_salary +
                ", max_salary=" + max_salary +
                '}';
    }
}
