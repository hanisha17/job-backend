package com.recruiter.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"companyName","jobTitle","location"})})
public class Recruiter{

    @Id
    @GeneratedValue
    private long id;
    private String companyName;
    private String imageUrl;
    private int salary;
    private String jobTitle;
    private String location;
    private int experience;
    private Status status = Status.Pending;

    @OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "cp_fk", referencedColumnName = "id")
    private List<Skills> dropdown;



}

