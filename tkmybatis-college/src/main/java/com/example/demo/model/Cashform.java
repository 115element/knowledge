package com.example.demo.model;

import javax.persistence.*;

@Table(name = "cashform")
public class Cashform {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.storeId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String storeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.posNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer posno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.shiftNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer shiftnumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.zNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer znumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.hundred
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer hundred;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.fifty
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer fifty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.twenty
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer twenty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.ten
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer ten;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.five
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer five;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.two
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer two;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.one
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer one;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.fiveJiao
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer fivejiao;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.twoJiao
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer twojiao;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.oneJiao
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer onejiao;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cashform.totalAmount
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String totalamount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.id
     *
     * @return the value of cashform.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.id
     *
     * @param id the value for cashform.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.storeId
     *
     * @return the value of cashform.storeId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getStoreid() {
        return storeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.storeId
     *
     * @param storeid the value for cashform.storeId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.posNo
     *
     * @return the value of cashform.posNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getPosno() {
        return posno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.posNo
     *
     * @param posno the value for cashform.posNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setPosno(Integer posno) {
        this.posno = posno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.shiftNumber
     *
     * @return the value of cashform.shiftNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getShiftnumber() {
        return shiftnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.shiftNumber
     *
     * @param shiftnumber the value for cashform.shiftNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setShiftnumber(Integer shiftnumber) {
        this.shiftnumber = shiftnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.zNumber
     *
     * @return the value of cashform.zNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getZnumber() {
        return znumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.zNumber
     *
     * @param znumber the value for cashform.zNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setZnumber(Integer znumber) {
        this.znumber = znumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.hundred
     *
     * @return the value of cashform.hundred
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getHundred() {
        return hundred;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.hundred
     *
     * @param hundred the value for cashform.hundred
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setHundred(Integer hundred) {
        this.hundred = hundred;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.fifty
     *
     * @return the value of cashform.fifty
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getFifty() {
        return fifty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.fifty
     *
     * @param fifty the value for cashform.fifty
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setFifty(Integer fifty) {
        this.fifty = fifty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.twenty
     *
     * @return the value of cashform.twenty
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getTwenty() {
        return twenty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.twenty
     *
     * @param twenty the value for cashform.twenty
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTwenty(Integer twenty) {
        this.twenty = twenty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.ten
     *
     * @return the value of cashform.ten
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getTen() {
        return ten;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.ten
     *
     * @param ten the value for cashform.ten
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTen(Integer ten) {
        this.ten = ten;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.five
     *
     * @return the value of cashform.five
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getFive() {
        return five;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.five
     *
     * @param five the value for cashform.five
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setFive(Integer five) {
        this.five = five;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.two
     *
     * @return the value of cashform.two
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getTwo() {
        return two;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.two
     *
     * @param two the value for cashform.two
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTwo(Integer two) {
        this.two = two;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.one
     *
     * @return the value of cashform.one
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getOne() {
        return one;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.one
     *
     * @param one the value for cashform.one
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setOne(Integer one) {
        this.one = one;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.fiveJiao
     *
     * @return the value of cashform.fiveJiao
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getFivejiao() {
        return fivejiao;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.fiveJiao
     *
     * @param fivejiao the value for cashform.fiveJiao
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setFivejiao(Integer fivejiao) {
        this.fivejiao = fivejiao;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.twoJiao
     *
     * @return the value of cashform.twoJiao
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getTwojiao() {
        return twojiao;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.twoJiao
     *
     * @param twojiao the value for cashform.twoJiao
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTwojiao(Integer twojiao) {
        this.twojiao = twojiao;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.oneJiao
     *
     * @return the value of cashform.oneJiao
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getOnejiao() {
        return onejiao;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.oneJiao
     *
     * @param onejiao the value for cashform.oneJiao
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setOnejiao(Integer onejiao) {
        this.onejiao = onejiao;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cashform.totalAmount
     *
     * @return the value of cashform.totalAmount
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getTotalamount() {
        return totalamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cashform.totalAmount
     *
     * @param totalamount the value for cashform.totalAmount
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }
}