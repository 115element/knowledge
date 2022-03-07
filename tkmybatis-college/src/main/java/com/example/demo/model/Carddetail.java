package com.example.demo.model;

import javax.persistence.*;

@Table(name = "carddetail")
public class Carddetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.storeId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String storeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.posNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer posno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.transactionNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer transactionnumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.seq
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer seq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.payamt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String payamt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.bankcode
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String bankcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.cardno
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String cardno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.trace
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String trace;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.merid
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String merid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.terid
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String terid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.batchno
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String batchno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.refdata
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String refdata;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.authcode
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String authcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.settledate
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String settledate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.lrc
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String lrc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.discamt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String discamt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.cardtype
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String cardtype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.systemDate
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String systemdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.memo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String memo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.uploadFlag
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String uploadflag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.payId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String payid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.payName
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String payname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.tradeNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String tradeno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.outid
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String outid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.cardPayId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String cardpayid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.balance
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.codeType
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String codetype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.transAmt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String transamt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carddetail.factAmt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String factamt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.id
     *
     * @return the value of carddetail.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.id
     *
     * @param id the value for carddetail.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.storeId
     *
     * @return the value of carddetail.storeId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getStoreid() {
        return storeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.storeId
     *
     * @param storeid the value for carddetail.storeId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.posNo
     *
     * @return the value of carddetail.posNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getPosno() {
        return posno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.posNo
     *
     * @param posno the value for carddetail.posNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setPosno(Integer posno) {
        this.posno = posno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.transactionNumber
     *
     * @return the value of carddetail.transactionNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getTransactionnumber() {
        return transactionnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.transactionNumber
     *
     * @param transactionnumber the value for carddetail.transactionNumber
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTransactionnumber(Integer transactionnumber) {
        this.transactionnumber = transactionnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.seq
     *
     * @return the value of carddetail.seq
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.seq
     *
     * @param seq the value for carddetail.seq
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.payamt
     *
     * @return the value of carddetail.payamt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getPayamt() {
        return payamt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.payamt
     *
     * @param payamt the value for carddetail.payamt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setPayamt(String payamt) {
        this.payamt = payamt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.bankcode
     *
     * @return the value of carddetail.bankcode
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getBankcode() {
        return bankcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.bankcode
     *
     * @param bankcode the value for carddetail.bankcode
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.cardno
     *
     * @return the value of carddetail.cardno
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getCardno() {
        return cardno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.cardno
     *
     * @param cardno the value for carddetail.cardno
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.trace
     *
     * @return the value of carddetail.trace
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getTrace() {
        return trace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.trace
     *
     * @param trace the value for carddetail.trace
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.merid
     *
     * @return the value of carddetail.merid
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getMerid() {
        return merid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.merid
     *
     * @param merid the value for carddetail.merid
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setMerid(String merid) {
        this.merid = merid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.terid
     *
     * @return the value of carddetail.terid
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getTerid() {
        return terid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.terid
     *
     * @param terid the value for carddetail.terid
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTerid(String terid) {
        this.terid = terid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.batchno
     *
     * @return the value of carddetail.batchno
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getBatchno() {
        return batchno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.batchno
     *
     * @param batchno the value for carddetail.batchno
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.refdata
     *
     * @return the value of carddetail.refdata
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getRefdata() {
        return refdata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.refdata
     *
     * @param refdata the value for carddetail.refdata
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setRefdata(String refdata) {
        this.refdata = refdata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.authcode
     *
     * @return the value of carddetail.authcode
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getAuthcode() {
        return authcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.authcode
     *
     * @param authcode the value for carddetail.authcode
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.settledate
     *
     * @return the value of carddetail.settledate
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getSettledate() {
        return settledate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.settledate
     *
     * @param settledate the value for carddetail.settledate
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setSettledate(String settledate) {
        this.settledate = settledate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.lrc
     *
     * @return the value of carddetail.lrc
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getLrc() {
        return lrc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.lrc
     *
     * @param lrc the value for carddetail.lrc
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.discamt
     *
     * @return the value of carddetail.discamt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getDiscamt() {
        return discamt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.discamt
     *
     * @param discamt the value for carddetail.discamt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setDiscamt(String discamt) {
        this.discamt = discamt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.cardtype
     *
     * @return the value of carddetail.cardtype
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getCardtype() {
        return cardtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.cardtype
     *
     * @param cardtype the value for carddetail.cardtype
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.systemDate
     *
     * @return the value of carddetail.systemDate
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getSystemdate() {
        return systemdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.systemDate
     *
     * @param systemdate the value for carddetail.systemDate
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setSystemdate(String systemdate) {
        this.systemdate = systemdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.memo
     *
     * @return the value of carddetail.memo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.memo
     *
     * @param memo the value for carddetail.memo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.name
     *
     * @return the value of carddetail.name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.name
     *
     * @param name the value for carddetail.name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.uploadFlag
     *
     * @return the value of carddetail.uploadFlag
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getUploadflag() {
        return uploadflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.uploadFlag
     *
     * @param uploadflag the value for carddetail.uploadFlag
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setUploadflag(String uploadflag) {
        this.uploadflag = uploadflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.payId
     *
     * @return the value of carddetail.payId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getPayid() {
        return payid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.payId
     *
     * @param payid the value for carddetail.payId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setPayid(String payid) {
        this.payid = payid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.payName
     *
     * @return the value of carddetail.payName
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getPayname() {
        return payname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.payName
     *
     * @param payname the value for carddetail.payName
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setPayname(String payname) {
        this.payname = payname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.tradeNo
     *
     * @return the value of carddetail.tradeNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getTradeno() {
        return tradeno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.tradeNo
     *
     * @param tradeno the value for carddetail.tradeNo
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.outid
     *
     * @return the value of carddetail.outid
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getOutid() {
        return outid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.outid
     *
     * @param outid the value for carddetail.outid
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setOutid(String outid) {
        this.outid = outid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.cardPayId
     *
     * @return the value of carddetail.cardPayId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getCardpayid() {
        return cardpayid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.cardPayId
     *
     * @param cardpayid the value for carddetail.cardPayId
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setCardpayid(String cardpayid) {
        this.cardpayid = cardpayid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.balance
     *
     * @return the value of carddetail.balance
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.balance
     *
     * @param balance the value for carddetail.balance
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.codeType
     *
     * @return the value of carddetail.codeType
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getCodetype() {
        return codetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.codeType
     *
     * @param codetype the value for carddetail.codeType
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setCodetype(String codetype) {
        this.codetype = codetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.transAmt
     *
     * @return the value of carddetail.transAmt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getTransamt() {
        return transamt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.transAmt
     *
     * @param transamt the value for carddetail.transAmt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTransamt(String transamt) {
        this.transamt = transamt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carddetail.factAmt
     *
     * @return the value of carddetail.factAmt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getFactamt() {
        return factamt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carddetail.factAmt
     *
     * @param factamt the value for carddetail.factAmt
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setFactamt(String factamt) {
        this.factamt = factamt;
    }
}