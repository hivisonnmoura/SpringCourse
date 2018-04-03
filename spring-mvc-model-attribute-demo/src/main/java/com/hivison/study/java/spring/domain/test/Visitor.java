package com.hivison.study.java.spring.domain.test;

import java.io.Serializable;
import java.util.Objects;

public class Visitor implements Serializable {


    private String name;

    private String  email;

    public Visitor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return Objects.equals(name, visitor.name) &&
                Objects.equals(email, visitor.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Visitor{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
