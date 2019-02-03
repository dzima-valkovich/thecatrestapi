package org.thecatrestapi.util.property;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thecatrestapi.api.util.property.IHeaderProperties;

@Component
public class HeaderProperties implements IHeaderProperties {
	private static final String PATH_TO_PROPERTIES = "src/main/resources/header.properties";
	private static final Properties DEFAULT_PROPERTIES;

	private Properties properties;

	static {
		DEFAULT_PROPERTIES = new Properties();
		DEFAULT_PROPERTIES.setProperty("x-api-key", "31255f06-49d3-4889-a7d5-b607af395589");
		DEFAULT_PROPERTIES.setProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
	}

	public HeaderProperties() {
		try {
			properties = PropertiesLoader.load(PATH_TO_PROPERTIES);
		} catch (IOException e) {
			//
			e.printStackTrace();
			properties = new Properties(DEFAULT_PROPERTIES);
		}
	}

	public HeaderProperties(String pathToProperties) {
		try {
			properties = PropertiesLoader.load(pathToProperties);
		} catch (IOException e) {
			//
			e.printStackTrace();
			properties = new Properties(DEFAULT_PROPERTIES);
		}
	}

	@Override
	public String getHeaderValue(String headerName) {
		return properties.getProperty(headerName);
	}

	@Override
	public Set<Entry<Object, Object>> getAllHeaders() {
		return properties.entrySet();
	}

}
