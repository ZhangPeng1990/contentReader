package contentReader.main.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import contentReader.main.Reader;

public class TxtReader implements Reader {

	StringBuffer buffer = null;
	BufferedReader br = null;
	File inputFile;
	
	public TxtReader(File file){
		System.out.println("正在解析txt文件...");
		inputFile = file;
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
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

	@Override
	public String getContent() {
		if(buffer != null){
			return buffer.toString();
		}
		
		StringBuffer sb = new StringBuffer();
		try {
            String encoding="GBK";
            if(inputFile.exists() && inputFile.isFile()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(inputFile),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	sb.append(lineTxt + "\n");
                    System.out.println(lineTxt);
                }
                read.close();
	    }else{
	        System.out.println("找不到指定的文件");
	    }
	    } catch (Exception e) {
	        System.out.println("读取文件内容出错");
	        e.printStackTrace();
	    }
			return sb.toString();
		}
	
}
