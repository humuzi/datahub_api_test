package com.datahub.common.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Create by HuQiuYue on 2020/9/27
 */
public class ExcelUtil {
    public static List<String> getStringFromExcelFile(Workbook workbook,int sheetIndex,int colIndex) throws IOException {
        List<String> results = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Iterator<Row> rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            if(row.getRowNum() != 0){
                results.add(row.getCell(colIndex).getStringCellValue());
            }
        }
        workbook.close();
        return results;
    }
}
