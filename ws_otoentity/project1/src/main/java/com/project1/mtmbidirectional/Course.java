package com.project1.mtmbidirectional;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
@Table(name = "course")
public class Course {
	@Id

    @Column(name = "CID")

    @GeneratedValue(strategy=GenerationType.AUTO)

    private int cid;

   

    @Column(name = "CNAME")

    private String cname;

   

    @ManyToMany(mappedBy = "courses",cascade=CascadeType.ALL)
    private Set<Student> students;

   

    public int getCid() {
            return this.cid;
    }

    public void setCid(int cid) {
            this.cid = cid;
    }

    public String getCname() {
            return this.cname;
    }

    public void setCname(String cname) {
            this.cname = cname;
    }

    public Set<Student> getStudents() {
            return this.students;
    }

    public void setStudents(Set<Student> students) {
            this.students = students;
    }
}
