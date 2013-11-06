package contentReader.test;

import java.io.File;

import org.junit.Test;

import contentReader.main.Reader;
import contentReader.main.ReaderFactory;

public class TestReader {

	@Test
	public void test(){
		File file = new File("F:\\test\\test.docx");
		Reader r = ReaderFactory.initReader(file);
		int num = r.getWordNum();
		String c = r.getContent();
		System.out.println(c);
		System.out.println(num);
	}
	
}
