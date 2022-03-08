package com.filesystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class GetAllFileNames {
	String path= "C:\\Users\\gopiv\\Desktop\\exlData";
	String searchFor="venu.txt";
	String patt="";
	@Test
	public void getAllFiles() {
		
		traverseDir(path, searchFor);
	}
	
	
	public void traverseDir(String path, String searchForFile) {
		try {
			File f = new File(path);
			if(f.isDirectory()) {
				File[] files = f.listFiles();				
				for (File file : files) {
					if(file.isFile() && file.getName().equalsIgnoreCase(searchForFile)) {
						System.out.println("File Name: "+ file.getName() + " and file path: "+ file.getAbsolutePath());	
						readFileForPattern(file.getAbsolutePath(), patt);
						break;
						
					}else if(file.isDirectory()) {
						System.out.println("I am in the directory: "+ file.getName());
						traverseDir(file.getAbsolutePath(), searchForFile);						
					}
				}				
			}else if(f.isFile() && f.getName().equalsIgnoreCase(searchForFile)) {
				System.out.println("File Name: "+ f.getName() + " and file path: "+ f.getAbsolutePath());	
				readFileForPattern(f.getAbsolutePath(), patt);						
			}			
		}catch(Exception oExp) {
			oExp.printStackTrace();
		}
	}
	
	public void readFileForPattern(String filePath, String pattern) {
		try {
			File f = new File(filePath);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
//			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);		//read file of specific format.. 
//			System.out.println(lines);
										//I have 13 years of experience in automation testing
			Pattern pattern1 = Pattern.compile("\\d+ years");
//			Pattern pattern1 = Pattern.compile("\\d+ (y|Y)ears");
//			Pattern pattern1 = Pattern.compile("(?i)\\d+ Years");		//case insensitive
//			Pattern pattern1 = Pattern.compile("(\\d+ years .*)");		//going for groups.. ()
			while((line=br.readLine())!=null) {
				Matcher matcher = pattern1.matcher(line);
				if(matcher.find()) {
					System.out.println("===================="+ matcher.group());
					System.out.println("===================="+ matcher.groupCount());
					System.out.println("file line text: "+ line);
					
//					String s = matcher.replaceFirst(matcher.group().toUpperCase());
//					System.out.println(s);
//					matcher.replaceAll(replacement)
					break;
				}
			}		
			
			pattern1 = Pattern.compile("(\\d+\\s)(years)");
			Matcher m2= pattern1.matcher("I have 13 years of experience in automation testing");
			while(m2.find()) {
				System.out.println("m2.group(): "+ m2.group());
				System.out.println("m2.groupCount(): "+ m2.groupCount());
				System.out.println("m2.group(0): "+ m2.group(0));
				System.out.println("m2.group(1): "+ m2.group(1));
				System.out.println("m2.start() start index: "+ m2.start());
				System.out.println("m2.end() end index: "+ m2.end());
			}

			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
