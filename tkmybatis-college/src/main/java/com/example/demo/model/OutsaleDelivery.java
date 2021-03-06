package com.example.demo.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "outsale_delivery")
public class OutsaleDelivery {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.order_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.seq
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer seq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.delivery_code
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String deliveryCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.delivery_type
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer deliveryType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.shipper_name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String shipperName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.shipper_phone
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String shipperPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.confirm_time
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String confirmTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.take_time
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String takeTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.delivery_fee
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private BigDecimal deliveryFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_delivery.delivery_status
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer deliveryStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.order_id
     *
     * @return the value of outsale_delivery.order_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.order_id
     *
     * @param orderId the value for outsale_delivery.order_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.seq
     *
     * @return the value of outsale_delivery.seq
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.seq
     *
     * @param seq the value for outsale_delivery.seq
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.delivery_code
     *
     * @return the value of outsale_delivery.delivery_code
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getDeliveryCode() {
        return deliveryCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.delivery_code
     *
     * @param deliveryCode the value for outsale_delivery.delivery_code
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.delivery_type
     *
     * @return the value of outsale_delivery.delivery_type
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getDeliveryType() {
        return deliveryType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.delivery_type
     *
     * @param deliveryType the value for outsale_delivery.delivery_type
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.shipper_name
     *
     * @return the value of outsale_delivery.shipper_name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getShipperName() {
        return shipperName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.shipper_name
     *
     * @param shipperName the value for outsale_delivery.shipper_name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.shipper_phone
     *
     * @return the value of outsale_delivery.shipper_phone
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getShipperPhone() {
        return shipperPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.shipper_phone
     *
     * @param shipperPhone the value for outsale_delivery.shipper_phone
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.confirm_time
     *
     * @return the value of outsale_delivery.confirm_time
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getConfirmTime() {
        return confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.confirm_time
     *
     * @param confirmTime the value for outsale_delivery.confirm_time
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.take_time
     *
     * @return the value of outsale_delivery.take_time
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getTakeTime() {
        return takeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.take_time
     *
     * @param takeTime the value for outsale_delivery.take_time
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.delivery_fee
     *
     * @return the value of outsale_delivery.delivery_fee
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.delivery_fee
     *
     * @param deliveryFee the value for outsale_delivery.delivery_fee
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_delivery.delivery_status
     *
     * @return the value of outsale_delivery.delivery_status
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_delivery.delivery_status
     *
     * @param deliveryStatus the value for outsale_delivery.delivery_status
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}