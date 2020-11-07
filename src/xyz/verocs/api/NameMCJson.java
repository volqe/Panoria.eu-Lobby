package xyz.verocs.api;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class NameMCJson {
	
	
	
	private static String getRawString(final String url) throws Exception {
		final InputStream inputStream = new URL(url).openStream();
		
		final BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
		
		return read(bufferReader);
	}

	
	
	
	
	
	public static ArrayList<String> getUUIDs(String url) throws Exception{
		ArrayList<String> list = new ArrayList<>();
		
		String rawString = getRawString(url).replace("[", "").replace("]", "");
		
		for(String strg : rawString.split(", ")) {
			list.add(strg.replace("\"", ""));
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	private static String read(final Reader reader) throws IOException {
		final StringBuilder stringBuilder = new StringBuilder();
		
		int counter;
		
		while((counter = reader.read()) != -1) {
			stringBuilder.append((char) counter);
		}
		
		return stringBuilder.toString();
	}
}
