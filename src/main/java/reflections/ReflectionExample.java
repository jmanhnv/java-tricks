/*
 * FILENAME ReflectionExample.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

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
public class ReflectionExample {
	public static void main(String[] args) {
		// Obtain the class object if we know the name of the class
		Class<RentCar> rental = RentCar.class;
		try {
			// get the absolute name of the class
			String rentalClassPackage = rental.getName();
			System.out.println("Class Name is: " + rentalClassPackage);

			// get the simple name of the class (without package info)
			String rentalClassNoPackage = rental.getSimpleName();
			System.out.println("Class Name without package is: " + rentalClassNoPackage);

			// get the package name of the class
			Package rentalPackage = rental.getPackage();
			System.out.println("Package Name is: " + rentalPackage);

			// get all the constructors of the class
			Constructor<?>[] constructors = rental.getConstructors();
			System.out.println("Constructors are: " + Arrays.toString(constructors));

			// get constructor with specific argument
			Constructor<RentCar> constructor = rental.getConstructor(Integer.TYPE);

			// initializing an object of the RentCar class
			RentCar rent = constructor.newInstance(455);

			// get all methods of the class including declared methods of
			// superclasses
			// in that case, superclass of RentCar is the class java.lang.Object
			Method[] allmethods = rental.getMethods();
			System.out.println("Methods are: " + Arrays.toString(allmethods));
			for (Method method : allmethods) {
				System.out.println("method = " + method.getName());
			}

			// get all methods declared in the class
			// but excludes inherited methods.
			Method[] declaredMethods = rental.getDeclaredMethods();
			System.out.println("Declared Methods are: " + Arrays.toString(declaredMethods));
			for (Method dmethod : declaredMethods) {
				System.out.println("method = " + dmethod.getName());
			}

			// get method with specific name and parameters
			Method oneMethod = rental.getMethod("computeRentalCost", new Class[] { Integer.TYPE });
			System.out.println("Method is: " + oneMethod);

			// call computeRentalCost method with parameter int
			oneMethod.invoke(rent, 4);

			// get all the parameters of computeRentalCost
			Class<?>[] parameterTypes = oneMethod.getParameterTypes();
			System.out.println("Parameter types of computeRentalCost() are: " + Arrays.toString(parameterTypes));

			// get the return type of computeRentalCost
			Class<?> returnType = oneMethod.getReturnType();
			System.out.println("Return type is: " + returnType);

			// gets all the public member fields of the class RentCar
			Field[] fields = rental.getFields();

			System.out.println("Public Fields are: ");
			for (Field oneField : fields) {
				// get public field name
				Field field = rental.getField(oneField.getName());
				String fieldname = field.getName();
				System.out.println("Fieldname is: " + fieldname);

				// get public field type
				Object fieldType = field.getType();
				System.out.println("Type of field " + fieldname + " is: " + fieldType);

				// get public field value
				Object value = field.get(rent);
				System.out.println("Value of field " + fieldname + " is: " + value);

			}

			// How to access private member fields of the class

			// getDeclaredField() returns the private field
			Field privateField = RentCar.class.getDeclaredField("type");

			String name = privateField.getName();
			System.out.println("One private Fieldname is: " + name);
			// makes this private field instance accessible
			// for reflection use only, not normal code
			privateField.setAccessible(true);

			// get the value of this private field
			String fieldValue = (String) privateField.get(rent);
			System.out.println("fieldValue = " + fieldValue);

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
