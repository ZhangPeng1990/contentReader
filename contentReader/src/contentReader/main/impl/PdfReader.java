package contentReader.main.impl;

import java.io.File;

import contentReader.main.Reader;

public class PdfReader implements Reader {

	public PdfReader(File file){
		System.out.println("���ڽ���pdf�ļ�");
	}
	
	@Override
	public Long getWordNum() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
