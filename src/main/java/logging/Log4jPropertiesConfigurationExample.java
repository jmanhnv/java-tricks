/*
 * FILENAME Log4jPropertiesConfigurationExample.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VietinBank Group. All rights reserved. This software is the confidential and proprietary information of
 * VietinBank Group ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with VietinBank Group.
 */

package logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class Log4jPropertiesConfigurationExample {
	// static final String BUNDLE_NAME = "log4j";
	// static final ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
	static Logger logger = Logger.getLogger(Log4jPropertiesConfigurationExample.class);

	public static void main(final String[] args) {
		// PropertiesConfigurator is used to configure logger from properties file
		PropertyConfigurator.configure("log4j.properties");

		// Log in console in and log file
		logger.debug("Log4j appender configuration is successful !!");
	}
}
