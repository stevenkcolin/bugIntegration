package com.aethercoder.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hepengfei on 04/12/2017.
 */
@Entity
@Table(name = "zt_bug")
public class Bug {
    @Id
    @GeneratedValue
    @Basic(optional = false)
    private Integer id;
    private Integer product;
    private Integer project;

    private String title;
    private Byte severity;
//    private String status;
    private Boolean confirmed;

    @Column(name="openedbuild")
    private String openedBuild;

    @Column(name="openedby")
    private String openedBy;

    @Column(name="openeddate")
    private Date openedDate;

    @Column(name="assignedto")
    private String assignedTo;

    @Column(name="assigneddate")
    private Date assignedDate;

    @Type(type="text")
    private String steps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getSeverity() {
        return severity;
    }

    public void setSeverity(Byte severity) {
        this.severity = severity;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getOpenedBy() {
        return openedBy;
    }

    public void setOpenedBy(String openedBy) {
        this.openedBy = openedBy;
    }

    public Date getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getOpenedBuild() {
        return openedBuild;
    }

    public void setOpenedBuild(String openedBuild) {
        this.openedBuild = openedBuild;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }
}
