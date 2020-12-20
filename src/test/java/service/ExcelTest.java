package service;

import com.datahub.common.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Create by HuQiuYue on 2020/9/27
 */
public class ExcelTest {
    public static void getExcel() throws IOException {
        File testFile= new File("/Users/Lee/Desktop/testExcel.xlsx");
        Workbook workbook = WorkbookFactory.create(testFile);
        List<String> keywords = ExcelUtil.getStringFromExcelFile(workbook,0,0);
        System.out.println(keywords);
    }

    public static void main(String[] args) throws IOException {
        getExcel();
    }

}
