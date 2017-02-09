package blogmgr.test.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;
import org.junit.Test;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorkbookDesigner;
import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import com.huangtl.blogmgr.core.aspose.MapDataSource;

/**
 * aspoise  导出 测试
 * @author PraiseLord
 * @date 2017年2月9日
 *
 */
public class AsposeTest {

	/**
     * word license
     * 
     * @return
     */
    public static boolean getWordLicense() {
        boolean result = false;
        try {
            InputStream is = Test.class.getClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * word license
     * 
     * @return
     */
    public static boolean getExcelLicense() {
        boolean result = false;
        try {
            InputStream is = Test.class.getClassLoader().getResourceAsStream("license.xml");
            com.aspose.cells.License aposeLic = new com.aspose.cells.License();
            
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

	
	@Test
	public void exportWrodTest(){
		getWordLicense();
		try {
			File file = new File("e:\\test1.docx");
			FileOutputStream os = new FileOutputStream(file);
			Document doc = new Document("e:\\test.docx");
			
			doc.save(os, SaveFormat.DOCX);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void exportExcelTest() throws Exception{
		//user_list
		getExcelLicense();
		try {
			File file = new File("e:\\user_list_11.xlsx");
			FileOutputStream os = new FileOutputStream(file);
			Workbook book = new Workbook("e:\\user_list.xlsx");
			
			WorkbookDesigner designer = new WorkbookDesigner(book);
			
			designer.setDataSource("date", new LocalDate().toString("yyyy-MM-dd"));
			MapDataSource data = new MapDataSource(getUser());
			designer.setDataSource("user", data);
			designer.process();
			book.save(os, com.aspose.cells.SaveFormat.XLSX);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Map<String, Object>> getUser(){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rn", 1);
		map.put("fName", "张三");
		map.put("fAccount", "zhangsa");
		map.put("fStatus"," 可用");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("rn", 2);
		map.put("fName", "李四");
		map.put("fAccount", "lis");
		map.put("fStatus","不可用");
		list.add(map);
		
		return list;
	}
	
	
}
