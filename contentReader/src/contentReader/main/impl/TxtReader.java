package contentReader.main.impl;

import java.io.File;

import contentReader.main.Reader;

public class TxtReader implements Reader {

	public TxtReader(File file){
		System.out.println("���ڽ���txt�ļ�");
	}
	
	@Override
	public Long getWordNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
