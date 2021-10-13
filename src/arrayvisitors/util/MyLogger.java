package arrayvisitors.util;

import arrayvisitors.util.MyLogger.DebugLevel;

/**
 * 
 * @author Ramesh Chowdarapally
 *
 */
public class MyLogger {

	// FIXME: Add more enum values as needed for the assignment
	public static enum DebugLevel {
		DRIVER, RESULTS, NONE
	};

	private static DebugLevel debugLevel;

	private volatile static MyLogger myLogger;
	private MyLogger() {
	}

	public static MyLogger getInstance() {
		if (myLogger == null) {
			synchronized (MyLogger.class) {
				if (myLogger == null) {
					myLogger = new MyLogger();
				}
			}
		}
		return myLogger;
	}

	// FIXME: Add switch cases for all the levels
	public void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 2:
			debugLevel = DebugLevel.DRIVER;
			break;
		case 1:
			debugLevel = DebugLevel.RESULTS;
			break;
		default:
			debugLevel = DebugLevel.NONE;
			break;
		}
	}

	public void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	public void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.print(message);
	}

	public String toString() {
		return "The debug level has been set to the following " + debugLevel;
	}
}