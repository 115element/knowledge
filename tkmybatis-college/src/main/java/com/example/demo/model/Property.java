package com.example.demo.model;

import javax.persistence.*;

@Table(name = "property")
public class Property {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column property.name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column property.value
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String value;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column property.name
     *
     * @return the value of property.name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column property.name
     *
     * @param name the value for property.name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column property.value
     *
     * @return the value of property.value
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column property.value
     *
     * @param value the value for property.value
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setValue(String value) {
        this.value = value;
    }
}