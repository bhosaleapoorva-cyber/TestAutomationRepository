package TestAutomationSuite.BaseObjectDirectory;

import java.util.HashMap;

import com.github.javafaker.Faker;

public class FakerUtils {
	
//	Faker faker=new Faker();	
//	public HashMap<String, String> stringValueGenerator() {
//		
//		HashMap<String,String> h=new HashMap<>();		
//		h.put("username", faker.name().username());
//		h.put("password", faker.internet().password());
//		h.put("email", faker.internet().emailAddress());
//		h.put("testername", faker.name().name());
//		return h;
//	}  
//	
//    public HashMap<String, Integer> numericValueGenerator() {
//		
//		HashMap<String,Integer> hn=new HashMap<>();		
//		hn.put("min_value", faker.number()ndomDigit());
//		hn.put("max_value", faker.number().randomDigit());
//		return hn;
//	}
    
	 private static Faker faker = new Faker();

	    public static String getProductName() {
	        return faker.name().name();
	    }
	    
	    public static String getminval() {
	        return faker.number().toString();
	    }
	    public static String getmaxval() {
	        return faker.number().toString();
	    }

	   	
}

