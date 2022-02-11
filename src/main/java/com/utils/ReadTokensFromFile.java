package com.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ReadTokensFromFile {
	
	public static Map<String, String> tokens = new HashMap<>();
	public static String tokensFile=System.getProperty("user.dir")+ "\\testdata\\tokens.txt";
	
	@SuppressWarnings("finally")
	public static Map<String, String> getTokens(){
		try {
			File file = new File(tokensFile);
			BufferedReader br= new BufferedReader(new FileReader(file));
			String line;
			String keyVal[]= new String[2];
			while((line=br.readLine())!=null) {
				if(line.contains(":")) {
					keyVal = line.split(":");
					tokens.put(keyVal[0].trim(), keyVal[1].trim().replace("\"", "").trim());
				}					
			}
			br.close();
			System.out.println("Captured tokens..");
			System.out.println(tokens);
		}catch(Exception oExp) {
			oExp.printStackTrace();
		}finally {
			return tokens;
		}
	}
	
//	public static void main(String[] args) {
//		getTokens();
//	}
}
