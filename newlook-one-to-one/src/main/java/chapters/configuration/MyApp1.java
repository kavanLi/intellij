/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package chapters.configuration;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class description goes here.
 */
public class MyApp1 {

    /* fields -------------------------------------------------------------- */

    final static Logger logger = LoggerFactory.getLogger(MyApp1.class);

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    public static void main(String[] args) {
        logger.info("Entering application.");

        Foo foo = new Foo();
        foo.doIt();
        logger.debug("Exiting application.");
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}