package com.example.demo.model;

import javax.persistence.*;

@Table(name = "sot_eod")
public class SotEod {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sot_eod.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sot_eod.storeId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String storeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sot_eod.posNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer posno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sot_eod.zNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer znumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sot_eod.transactionnumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer transactionnumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sot_eod.id
     *
     * @return the value of sot_eod.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sot_eod.id
     *
     * @param id the value for sot_eod.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sot_eod.storeId
     *
     * @return the value of sot_eod.storeId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getStoreid() {
        return storeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sot_eod.storeId
     *
     * @param storeid the value for sot_eod.storeId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sot_eod.posNo
     *
     * @return the value of sot_eod.posNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getPosno() {
        return posno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sot_eod.posNo
     *
     * @param posno the value for sot_eod.posNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setPosno(Integer posno) {
        this.posno = posno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sot_eod.zNumber
     *
     * @return the value of sot_eod.zNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getZnumber() {
        return znumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sot_eod.zNumber
     *
     * @param znumber the value for sot_eod.zNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setZnumber(Integer znumber) {
        this.znumber = znumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sot_eod.transactionnumber
     *
     * @return the value of sot_eod.transactionnumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getTransactionnumber() {
        return transactionnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sot_eod.transactionnumber
     *
     * @param transactionnumber the value for sot_eod.transactionnumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTransactionnumber(Integer transactionnumber) {
        this.transactionnumber = transactionnumber;
    }
}