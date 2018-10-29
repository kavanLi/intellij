/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.querer.libra.platform.core.domain.entity.BusinessEntity;

/**
 * Coupon entity.
 */
//annotation,这是一个Entity.
@Entity
/**
 *  数据库中对应表格的名称是t_biz_coupon, 也是存取数据的表格.
 */
@Table(name = "t_biz_coupon")
/**
 *  声明一个BusinessEntity的子类Coupon.
 */
public class Coupon extends BusinessEntity {

    /**
     * fields.
     * <p>
     * 对应表格中name的那一栏,最大数据长度为128个字节.
     */
    @Column(name = "name", length = 128)
    private String name;
    /**
     * 对应表格中description那一栏,最大数据长度为256字节.
     */
    @Column(name = "description", length = 256)
    private String description;
    /**
     * 多对1,join来指定生成外键的名字?.
     */
    @ManyToOne
    @JoinColumn(name = "event_oid")
    /**
     * coupon中包含一个event实例变量.
     */
    private Event event;


    /**
     * getter and setter.
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
