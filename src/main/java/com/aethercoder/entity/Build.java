package com.aethercoder.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hepengfei on 05/12/2017.
 */
@Entity
@Table(name = "zt_build")
public class Build {
    @Id
    @GeneratedValue
    @Basic(optional = false)
    private Integer id;
    private Integer product;
    private Integer project;

    @Column(name="name", columnDefinition="char(150)")
    private String name;

    @Column(name="scmpath", columnDefinition="char(255)")
    private String scmPath;

    @Column(name="filepath", columnDefinition="char(255)")
    private String filePath;

    @Column(name="`date`")
    private Date date;

    @Type(type="text")
    private String stories;

    @Type(type="text")
    private String bugs;

    @Column(name="`desc`")
    @Type(type="text")
    private String desc;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScmPath() {
        return scmPath;
    }

    public void setScmPath(String scmPath) {
        this.scmPath = scmPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStories() {
        return stories;
    }

    public void setStories(String stories) {
        this.stories = stories;
    }

    public String getBugs() {
        return bugs;
    }

    public void setBugs(String bugs) {
        this.bugs = bugs;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
