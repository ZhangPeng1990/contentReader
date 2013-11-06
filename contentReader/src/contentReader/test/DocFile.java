package contentReader.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.junit.Test;

public class DocFile {

	/**
	 * 获取word2003文件内容
	 * @param f
	 * @return
	 */
	public String getContent(File f) {
		FileInputStream fis = null;
		HWPFDocument doc = null;
		try {
			fis = new FileInputStream(f);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			doc = new HWPFDocument(fis);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Range rang = null;
		if (doc != null) {
			rang = doc.getRange();
		} else {
			// rang = doc2007.getgetRange();
		}
		String text = rang.text();
		return text;
	}

	public void read2() throws Exception {

		// word 2003： 图片不会被读取
		InputStream is = new FileInputStream(new File("c://files//2003.doc"));
		WordExtractor ex = new WordExtractor(is);
		String text2003 = ex.getText();
		System.out.println(text2003);

		// word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
		OPCPackage opcPackage = POIXMLDocument
				.openPackage("F:\\test\\test.docx");
		POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
		String text2007 = extractor.getText();
		System.out.println(text2007);
	}

	@Test
	public void test() {
		try {
			read2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
