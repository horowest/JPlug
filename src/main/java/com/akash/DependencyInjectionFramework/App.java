package com.akash.DependencyInjectionFramework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class App {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException,
			ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// read bean definitions from file
		File file = new File("src/main/java/resource/applicationContext.json");
		
		Map<String, BeanDefinitions> beanDefinitionsMap = getBeanDefinitionsFromJson(file);
		

		String beanName = beanDefinitionsMap.get("helloWorld").getClassName();
		
		Class<?> beanClass = Class.forName(beanName);
		
		for(Method method : beanClass.getDeclaredMethods()) {
			method.invoke(null);
		}

	}

	/*
	 * Jackson data binding wasn't working. So I had to resort to this.
	 */
	private static Map<String, BeanDefinitions> getBeanDefinitionsFromJson(File file) 
			throws JsonProcessingException, IOException {
		Map<String, BeanDefinitions> beanDefinitionsMap = new HashMap<>();
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(file);
		
		
		for(JsonNode children : jsonNode) {
			String beanId = children.get("id").asText(null);
			String beanQualifiedName = children.get("class").asText(null);
			
			BeanDefinitions beanDef = new BeanDefinitions(beanId, beanQualifiedName);
			beanDefinitionsMap.put(beanId, beanDef);
			
		}
		return beanDefinitionsMap;
	}
}
