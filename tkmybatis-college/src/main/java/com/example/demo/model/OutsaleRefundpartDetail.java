package com.example.demo.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "outsale_refundpart_detail")
public class OutsaleRefundpartDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.order_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.refund_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String refundId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.seq
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private Integer seq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.product_code
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String productCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.product_name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String productName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.product_price
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private BigDecimal productPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.product_num
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private BigDecimal productNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.sku_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String skuId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outsale_refundpart_detail.item_void
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    private String itemVoid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.id
     *
     * @return the value of outsale_refundpart_detail.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.id
     *
     * @param id the value for outsale_refundpart_detail.id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.order_id
     *
     * @return the value of outsale_refundpart_detail.order_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.order_id
     *
     * @param orderId the value for outsale_refundpart_detail.order_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.refund_id
     *
     * @return the value of outsale_refundpart_detail.refund_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getRefundId() {
        return refundId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.refund_id
     *
     * @param refundId the value for outsale_refundpart_detail.refund_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.seq
     *
     * @return the value of outsale_refundpart_detail.seq
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.seq
     *
     * @param seq the value for outsale_refundpart_detail.seq
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.product_code
     *
     * @return the value of outsale_refundpart_detail.product_code
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.product_code
     *
     * @param productCode the value for outsale_refundpart_detail.product_code
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.product_name
     *
     * @return the value of outsale_refundpart_detail.product_name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.product_name
     *
     * @param productName the value for outsale_refundpart_detail.product_name
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.product_price
     *
     * @return the value of outsale_refundpart_detail.product_price
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.product_price
     *
     * @param productPrice the value for outsale_refundpart_detail.product_price
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.product_num
     *
     * @return the value of outsale_refundpart_detail.product_num
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public BigDecimal getProductNum() {
        return productNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.product_num
     *
     * @param productNum the value for outsale_refundpart_detail.product_num
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setProductNum(BigDecimal productNum) {
        this.productNum = productNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.sku_id
     *
     * @return the value of outsale_refundpart_detail.sku_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.sku_id
     *
     * @param skuId the value for outsale_refundpart_detail.sku_id
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outsale_refundpart_detail.item_void
     *
     * @return the value of outsale_refundpart_detail.item_void
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public String getItemVoid() {
        return itemVoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outsale_refundpart_detail.item_void
     *
     * @param itemVoid the value for outsale_refundpart_detail.item_void
     *
     * @mbg.generated Mon May 18 09:42:44 CST 2020
     */
    public void setItemVoid(String itemVoid) {
        this.itemVoid = itemVoid;
    }
}