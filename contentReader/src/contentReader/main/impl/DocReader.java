package contentReader.main.impl;

import java.io.File;

import contentReader.main.Reader;

public class DocReader implements Reader {

	public DocReader(File file){
		System.out.println("正在解析word文件");
	}
	
	@Override
	public Long getWordNum() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void test(){
		
	}
}
