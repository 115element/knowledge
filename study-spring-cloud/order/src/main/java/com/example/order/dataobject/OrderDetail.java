package com.example.order.dataobject;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

// hibernate中@Entity和@Table的区别：
// @Entity说明这个class是实体类，并且使用默认的orm规则，即class名即数据库表中表名，class字段名即表中的字段名
// 如果想改变这种默认的orm规则，就要使用@Table来改变class名与数据库中表名的映射规则，@Column来改变class中字段名与db中表的字段名的映射规则

@Entity
public class OrderDetail {
        @Id
        private String detailId;
        //订单id
        private String orderId;
        //商品id
        private String productId;
        //商品名
        private String productName;
        //商品价格
        private BigDecimal productPrice;
        //商品数量
        private Integer productQuantity;
        //商品图标
        private String productIcon;
        private Date createTime;
        private Date updateTime;

        public String getDetailId() {
                return detailId;
        }

        public void setDetailId(String detailId) {
                this.detailId = detailId;
        }

        public String getOrderId() {
                return orderId;
        }

        public void setOrderId(String orderId) {
                this.orderId = orderId;
        }

        public String getProductId() {
                return productId;
        }

        public void setProductId(String productId) {
                this.productId = productId;
        }

        public String getProductName() {
                return productName;
        }

        public void setProductName(String productName) {
                this.productName = productName;
        }

        public BigDecimal getProductPrice() {
                return productPrice;
        }

        public void setProductPrice(BigDecimal productPrice) {
                this.productPrice = productPrice;
        }

        public Integer getProductQuantity() {
                return productQuantity;
        }

        public void setProductQuantity(Integer productQuantity) {
                this.productQuantity = productQuantity;
        }

        public String getProductIcon() {
                return productIcon;
        }

        public void setProductIcon(String productIcon) {
                this.productIcon = productIcon;
        }

        public Date getCreateTime() {
                return createTime;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }

        public Date getUpdateTime() {
                return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
                this.updateTime = updateTime;
        }
}
