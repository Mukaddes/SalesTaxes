package com.mukaddes;

/**
 * This class builds a receipt writer according to parameter
 * @author Mukaddes
 *
 */
public class ReceiptWriterFactory {

	// use getWriter method to get object of type ReceiptWriter
	public ReceiptWriter getWriter(String writerType) {
		if (writerType == null) {
			return null;
		}
		if (writerType.equalsIgnoreCase("FILE")) {
			return new ReceiptFileWriter();

		} else if (writerType.equalsIgnoreCase("CONSOLE")) {
			return new ReceiptConsoleWrite();

		}

		return null;
	}
}
