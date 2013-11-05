package contentReader.main.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import contentReader.main.Reader;

public class TxtReader implements Reader {

	StringBuffer buffer = null;
	BufferedReader br = null;
	
	public TxtReader(File file){
		System.out.println("正在解析txt文件...");
		buffer = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Integer getWordNum() {
		int count = 0;
		String s = "";
			try {
				while ((s = br.readLine()) != null) {
					buffer.append(s + '\n');
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
		}
		Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
		Matcher m = p.matcher(buffer.toString());
		while(m.find()) {
			System.out.println(m.group());
			count ++ ;
		}
		System.out.println("总共：" + count + "个单词");
		return count;
	}

}
