package contentReader.main.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

import contentReader.main.Reader;

public class DocReader implements Reader {

	File inputFile;
	String content;
	
	public DocReader(File file){
		System.out.println("正在解析word文件...");
		inputFile = file;
	}
	
	@Override
	public Integer getWordNum() {
		int count = 0;
		content = getContent();
		Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
		Matcher m = p.matcher(content);
		while(m.find()) {
			System.out.println(m.group());
			count ++ ;
		}
		System.out.println("总共：" + count + "个单词");
		return count;
	}

	@Override
	public String getContent() {
		// word 2003： 图片不会被读取
		InputStream is = null;
		WordExtractor ex = null;
		try {
			is = new FileInputStream(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			try {
				ex = new WordExtractor(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (OfficeXmlFileException e) {
			// word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
			OPCPackage opcPackage = null;
			POIXMLTextExtractor extractor = null;
			try {
				opcPackage = POIXMLDocument.openPackage(inputFile.getAbsolutePath());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				extractor = new XWPFWordExtractor(opcPackage);
			} catch (XmlException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (OpenXML4JException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String text2007 = extractor.getText();
			content = text2007;
			System.out.println(text2007);
			return content;
			
		}
		String text2003 = ex.getText();
		content = text2003;
		System.out.println(text2003);
		return content;
	}
}
