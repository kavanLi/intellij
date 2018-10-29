/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.security.authc;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * It represents the AuthenticationToken. All tokens should implements this
 * interface. Right now it's empty interface, but it is supposed to be extended
 * in future for all CI tokens.
 * <p>
 * See example in SimpleAuthenticationToken.
 */
public interface DefaultAuthenticationToken extends AuthenticationToken {
}
