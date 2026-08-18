package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonReader {

	public jsonReader() {

		try {

			ObjectMapper mapper = new ObjectMapper();
			File jsonFile = new File("file.json");

			this.jsonData = mapper.readValue(jsonFile, Map.class);

		} catch (Exception e) {

		}

	}

	public String url;

	public Map<?, ?> jsonData;


	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		File jsonFile = new File("file.json");

		Map<?, ?> testData = mapper.readValue(jsonFile, Map.class);
		String url = (String) testData.get("url");
		System.out.println(url);

	}

	public String getUrl() {

		this.url = (String) jsonData.get("url");
		
		return url;

	}

}
