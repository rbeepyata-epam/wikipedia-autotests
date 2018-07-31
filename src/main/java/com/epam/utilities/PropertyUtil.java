package com.epam.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class PropertyUtil {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	static Properties props = new Properties();
	String filename;

    public PropertyUtil(String filename) {
        this.filename = filename;
    }

    public String get(String key) {
        String value = new String();
		try {
			File f = new File(filename);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				value = props.getProperty(key);
				in.close();
			} else
				logger.error("File not found!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void set(String key, String value) throws Throwable {
		try {
			File f = new File(filename);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				props.setProperty(key, value);
				props.store(new FileOutputStream(filename), null);
				in.close();
			} else {
				logger.error("File not found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remove(String strKey) {
		try {
			File f = new File(filename);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				props.remove(strKey);
				props.store(new FileOutputStream(filename), null);
				in.close();
			} else
				logger.error("File not found!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
