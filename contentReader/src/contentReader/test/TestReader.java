package contentReader.test;

import java.io.File;

import org.junit.Test;

import contentReader.main.Reader;
import contentReader.main.ReaderFactory;

public class TestReader {

	@Test
	public void test(){
		File file = new File("F:\\test\\test1.txt");
		Reader r = ReaderFactory.initReader(file);
		int num = r.getWordNum();
		System.out.println(num);
	}
	
}
