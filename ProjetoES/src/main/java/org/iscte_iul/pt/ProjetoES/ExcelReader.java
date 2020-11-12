package org.iscte_iul.pt.ProjetoES;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ExcelReader {
	// private static String SAMPLE_XLSX_FILE_PATH =
	// "C:\\Users\\pedro\\OneDrive\\Desktop\\Faculdade\\3º Ano\\Engenharia de
	// Software\\Defeitos.xlsx";
	private String PATH;
	private String dados[][];

	public ExcelReader(String PATH) throws InvalidFormatException, IOException{
		this.PATH = PATH;
		StartRead();
	}

	public void StartRead() throws IOException, InvalidFormatException {

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(PATH));

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// 1. You can obtain a rowIterator and columnIterator and iterate over them
		System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// Now let's iterate over the columns of the current row
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);

				dados[row.getRowNum()][cell.getColumnIndex()] = cellValue;
			}
			// System.out.println();

		}

	}

	public String getSampleXlsxFilePath() {
		return PATH;
	}

	public String[][] getDados() {
		return dados;
	}

}