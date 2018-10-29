/******************************************************************************
 *                         Libra FRAMEWORK
 *           © Libra framework, (2017). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/

package com.querer.libra.app.event.exception;

import com.querer.libra.platform.core.exception.BusinessException;

/**
 * 声明一个BusinessException的子类EventClosedException.
 */
public class EventClosedException extends BusinessException {

    /* constructors -------------------------------------------------------- */

    /**
     * 该类的默认构造法调用父类的默认构造法.
     *
     * @param message 传入异常说明信息.
     */
    public EventClosedException(String message) {
        super(message);
    }

    /**
     * 该类的默认构造法调用父类的默认构造法.
     *
     * @param message 传入异常说明信息.
     * @param cause   传入一个Throwable对象.
     */
    public EventClosedException(String message, Throwable cause) {
        super(message, cause);
    }

}
