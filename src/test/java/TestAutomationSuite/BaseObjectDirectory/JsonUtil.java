package TestAutomationSuite.BaseObjectDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public List<HashMap<String, String>> getJsonData(String path) throws IOException {
		
		//json to string
		String jsonstring=FileUtils.readFileToString
				(new File(System.getProperty("user.directory")+path),StandardCharsets.UTF_8);
	
			//string to hashmap
		ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> maps=	mapper.readValue
			(jsonstring, new TypeReference<List<HashMap<String,String>>>(){});
		
	return maps;
	///TestAutomationSuite/src/test/java/TestAutomationSuite/TestData/ProductNames.json
	}
	
}
