package jp.canetrash.sample.s2jdbc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Emp")
@Table(name = "EMP")
public class Employee {

    @Id
    public Integer id;
    public String shortName;
}
