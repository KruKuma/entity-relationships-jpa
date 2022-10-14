package com.example.eclipselink.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Claz {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int cid;
    private String cname;
    
    @ManyToMany(targetEntity = Teacher.class)
    private Set teacherSet;

    public Claz(int cid, String cname, Set teacherSet) {
        super();
        this.cid = cid;
        this.cname = cname;
        this.teacherSet = teacherSet;
    }

    public Claz() {
        super();
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set teacherSet) {
        this.teacherSet = teacherSet;
    }
}
