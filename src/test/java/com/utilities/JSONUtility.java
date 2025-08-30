package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.ui.pojo.Config;
import com.google.gson.Gson;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static Environment readJSON(com.constants.Environment env) {
		Gson gson=new Gson();
		File jsonFile=new File(System.getProperty("user.dir")+"\\config\\config.json");
		FileReader fileReader=null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config=gson.fromJson(fileReader, Config.class);
		Environment environment=config.getEnvironments().get("QA");
		System.out.println(environment.getUrl());
		return environment;
	}
	
}
