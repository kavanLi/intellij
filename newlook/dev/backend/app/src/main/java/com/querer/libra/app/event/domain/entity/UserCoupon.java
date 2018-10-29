/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.querer.libra.platform.core.domain.entity.BusinessEntity;

/**
 * UserCoupon entity.
 */
//annotation,这是一个Entity.
@Entity
/**
 * 对应表名称t_biz_user_coupon.
 */
@Table(name = "t_biz_user_coupon")
/**
 * 声明一个BusinessEntity的子类UserCoupon.
 */
public class UserCoupon extends BusinessEntity {

    /**
     * fields.
     * <p>
     * 对应栏uid, coupon_oid, event_oid, rule_oid, hit_random_number, occur_time, submit_time,
     * start_time, end_time, used, used_by, used_occur_time, used_submit_time.
     */
    @Column(name = "uid", length = 256)
    private String uid;

    @ManyToOne
    @JoinColumn(name = "coupon_oid")
    private Coupon coupon;
    @ManyToOne
    @JoinColumn(name = "event_oid")
    private Event event;
    @Column(name = "coupon_barcode")
    private Long couponBarcode;
    @Column(name = "rule_oid")
    private Long ruleOid;
    @Column(name = "hit_random_number")
    private BigDecimal hitRandomNumber;

    @Column(name = "occur_time")
    private Date occurTime;
    @Column(name = "submit_time")
    private Date submitTime;

    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "used")
    private Boolean used;
    @Column(name = "used_by", length = 256)
    private String usedBy;
    @Column(name = "used_occur_time")
    private Date usedOccurTime;
    @Column(name = "used_submit_time")
    private Date usedSubmitTime;

    public Long getCouponBarcode() {
        return couponBarcode;
    }

    public void setCouponBarcode(Long couponBarcode) {
        this.couponBarcode = couponBarcode;
    }

    /**
     * getters/setters.
     */

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Long getRuleOid() {
        return ruleOid;
    }

    public void setRuleOid(Long ruleOid) {
        this.ruleOid = ruleOid;
    }

    public BigDecimal getHitRandomNumber() {
        return hitRandomNumber;
    }

    public void setHitRandomNumber(BigDecimal hitRandomNumber) {
        this.hitRandomNumber = hitRandomNumber;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public void setUsedBy(String usedBy) {
        this.usedBy = usedBy;
    }

    public Date getUsedOccurTime() {
        return usedOccurTime;
    }

    public void setUsedOccurTime(Date usedOccurTime) {
        this.usedOccurTime = usedOccurTime;
    }

    public Date getUsedSubmitTime() {
        return usedSubmitTime;
    }

    public void setUsedSubmitTime(Date usedSubmitTime) {
        this.usedSubmitTime = usedSubmitTime;
    }
}
