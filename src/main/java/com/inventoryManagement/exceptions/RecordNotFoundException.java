/**
 * @Description Custom Exception to handle record not present in data base.
 * @ClassName RecordNotFoundException
 * @author shubhams11
 * @Date 19-04-2022
 */
package com.inventoryManagement.exceptions;

public class RecordNotFoundException extends Exception {
	//Non argument constructor.
	public RecordNotFoundException() {
		super();
	}
	//With Argument Constructor
	public RecordNotFoundException(String customMassage) {
		super(customMassage);
	}

}
