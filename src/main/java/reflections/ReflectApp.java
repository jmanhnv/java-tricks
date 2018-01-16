/*
 * FILENAME ReflectApp.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package reflections;

import java.lang.reflect.Method;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * Reflection in java provides ability to inspect and modify the runtime behavior of applications. Reflection is one of
 * the advance topic of core java. Using reflection we can inspect a class,interface, enums, get their structure,
 * methods and fields information at runtime even though class is not accessible at compile time. We can also use
 * reflection to instantiate an object, invoke it’s methods, change field values.
 */
public class ReflectApp {
	public static void main(String[] args) {
		// no paramater
		Class<?> noparams[] = {};

		// String parameter
		Class<?>[] paramString = new Class[1];
		paramString[0] = String.class;

		// int parameter
		Class<?>[] paramInt = new Class[1];
		paramInt[0] = Integer.TYPE;

		try {
			// load the AppTest at runtime
			Class<?> cls = Class.forName("interview.reflection.AppTest");
			Object obj = cls.newInstance();

			// call the printIt method
			Object dfValue = null;
			Method method = cls.getDeclaredMethod("printIt", noparams);
			method.invoke(obj, dfValue);

			// call the printItString method, pass a String param
			method = cls.getDeclaredMethod("printItString", paramString);
			method.invoke(obj, new String("mkyong"));

			// call the printItInt method, pass a int param
			method = cls.getDeclaredMethod("printItInt", paramInt);
			method.invoke(obj, 123);

			// call the setCounter method, pass a int param
			method = cls.getDeclaredMethod("setCounter", paramInt);
			method.invoke(obj, 999);

			// call the printCounter method
			method = cls.getDeclaredMethod("printCounter", noparams);
			method.invoke(obj, dfValue);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
