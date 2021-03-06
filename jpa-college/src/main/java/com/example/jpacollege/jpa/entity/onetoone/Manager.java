package com.example.jpacollege.jpa.entity.onetoone;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "JPA_MANAGERS")
@Entity
public class Manager implements Serializable {
    private Integer id;
    private String mgrName;
    private Department dept;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "MGR_NAME")
    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    //对于不维护关联关系，没有外键的一方使用OneToOne进行映射，建议设置mappedBy，这边就不需要维护关联关系，就会少执行SQL语句
    //mappedBy = "mgr" | 使用对方的那个属性，来维护关联关系[使用对方的mgr属性维护]
    @OneToOne(mappedBy = "mgr")
    @JsonIgnore //TODO 不加这个属性，查询Department表，然后向前端输出会导致栈溢出 【因为两边相互引用】
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
