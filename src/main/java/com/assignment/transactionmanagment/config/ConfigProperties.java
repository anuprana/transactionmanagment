package com.assignment.transactionmanagment.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.assignment.transactionmanagment.constants.TransactionConstants;

/**
 * ConfigProperties
 *
 */
public class ConfigProperties {

	private static String transFilePath;

	/**
	 * MethodName : setConfig()
	 * Reads the config and set into the property.
	 */
	private static void setConfig() throws FileNotFoundException, IOException {

		try (InputStream input = ConfigProperties.class.getClassLoader().getResourceAsStream(TransactionConstants.CONFIG)) {
			Properties prop = new Properties();
			if (input == null) {
				System.out.println("Unable to locate config.");
				return;
			}
			prop.load(input);
			transFilePath = prop.getProperty("transFilePath");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	/** MethodName : getTransFilePath()
	 * Returns the transaction Input FilePath.
	 */
	public static String getTransFilePath() throws FileNotFoundException, IOException  {
		setConfig();
		return transFilePath;
	}

}
