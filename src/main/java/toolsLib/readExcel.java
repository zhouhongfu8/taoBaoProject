package toolsLib;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class readExcel {

    private String filename;
    private int sheetName;

    public readExcel(String filename, int sheetName) {
        this.filename = filename;
        this.sheetName = sheetName;
    }

    public Object[][] getExcelData() throws IOException {
        File filePath = new File("date_Excel\\" + filename + ".xlsx");
        FileInputStream fileIntputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileIntputStream);
        //获取具体操作的sheet
        Sheet sheet = workbook.getSheetAt(sheetName);
        //获取标题行
        Row tittlesRow = sheet.getRow(0);
        //获取sheet的行数
        int rowNum = sheet.getPhysicalNumberOfRows();
        //获取sheet的列数
        int colNum = tittlesRow.getPhysicalNumberOfCells();
        //定义HashMap的二维数组，多行1列的二维HashMap
        HashMap<String, String>[][] testdata = new HashMap[rowNum - 1][1];
        if (rowNum > 1) {
            for (int i = 0; i < rowNum - 1; i++) {
                //每一行的HashMap进行初始化，<String,String>
                testdata[i][0] = new HashMap<String, String>();
            }
        } else {
            System.out.println("excel中没有数据");
            return null;
        }

        Iterator<Cell> heads = tittlesRow.cellIterator();
        //列名数组，以及数组的长度
        String[] columnName = new String[(tittlesRow.getPhysicalNumberOfCells())];
        //通过迭代器的遍历，将列名的值存放入列名数组columnName
        int count = 0;
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnName[count] = cell.getStringCellValue().toString();
            count++;
        }
        //循环行数
        for (int i = 1; i < rowNum; i++) {
            //循环列数，依次将 <列名:value(第i行)>放入HashMap的二维数组
            for (int j = 0; j < colNum; j++) {
                String cellValue = sheet.getRow(i).getCell(j).toString();
                testdata[i - 1][0].put(columnName[j], cellValue);
            }
        }
        return testdata;
    }


}


