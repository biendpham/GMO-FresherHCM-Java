/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class ResourceBundleDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.resourcebundle;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
		
		File file = new File(System.getProperty("user.dir"));
		URL[] urls = {file.toURI().toURL()};
		ClassLoader loader = new URLClassLoader(urls);
		
		Locale localeEn = new Locale("en");
		ResourceBundle labels = ResourceBundle.getBundle("messages", localeEn, loader);
		System.out.println("Xin chào trong tiếng anh: " + labels.getString("hello"));

		Locale localeVi = new Locale("vi");
		labels = ResourceBundle.getBundle("messages", localeVi, loader);
		System.out.println("Xin chào trong tiếng việt: " + convertToUTF8(labels.getString("hello")));
		
	}

	static String convertToUTF8(String context) {
		try {
			return new String(context.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
}
