package com.hivison.study.java.spring.domain.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VisitorData implements Serializable{

    
    private String currentVisitorName;
    private String currentVisitorEmail;
    private List<Visitor> visitors = new ArrayList<>();


    public VisitorData(){}

    public VisitorData(String currentVisitorName, String currentVisitorEmail, List<Visitor> visitors) {
        this.currentVisitorName = currentVisitorName;
        this.currentVisitorEmail = currentVisitorEmail;
        this.visitors = visitors;
    }


    public List<Visitor> getVisitors() {

        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public String getCurrentVisitorName() {
        return currentVisitorName;
    }

    public void setCurrentVisitorName(String currentVisitorName) {
        this.currentVisitorName = currentVisitorName;
    }

    public String getCurrentVisitorEmail() {
        return currentVisitorEmail;
    }

    public void setCurrentVisitorEmail(String currentVisitorEmail) {
        this.currentVisitorEmail = currentVisitorEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitorData that = (VisitorData) o;
        return Objects.equals(currentVisitorName, that.currentVisitorName) &&
                Objects.equals(currentVisitorEmail, that.currentVisitorEmail) &&
                Objects.equals(visitors, that.visitors);
    }

    @Override
    public int hashCode() {

        return Objects.hash(currentVisitorName, currentVisitorEmail, visitors);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VisitorData{");
        sb.append("currentVisitorName='").append(currentVisitorName).append('\'');
        sb.append(", currentVisitorEmail='").append(currentVisitorEmail).append('\'');
        sb.append(", visitors=").append(visitors);
        sb.append('}');
        return sb.toString();
    }
}
