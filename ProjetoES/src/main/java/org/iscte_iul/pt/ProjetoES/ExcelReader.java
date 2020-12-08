package org.iscte_iul.pt.ProjetoES;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

	private String PATH;
	private String dados[][];
	// String[] header = { "MethodID", "package", "class", "method", "LOC", "CYCLO",
	// "ATFD", "LAA", "is_long_method",
	// "iPlasma", "PMD", "is_feature_envy" };
	private String[] headers= new String[12];

	public ExcelReader(String PATH) throws InvalidFormatException, IOException {
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
		Iterator<Row> rowIterator = sheet.rowIterator();
		dados = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// Now let's iterate over the columns of the current row
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				if (cell.getRowIndex() == 0) {
					//String[] headers = new String[sheet.getRow(0).getLastCellNum()];
					String cellValue = dataFormatter.formatCellValue(cell);
					headers[cell.getColumnIndex()] = cellValue;
				} else {
					String cellValue = dataFormatter.formatCellValue(cell);
					dados[row.getRowNum() - 1][cell.getColumnIndex()] = cellValue;
				}
			}

		}

	}

	public String getSampleXlsxFilePath() {
		return PATH;
	}

	public String[][] getDados() {
		return dados;
	}

	public String[] getHeader() {
		return headers;
	}

	public String[] getColunaInicial() {
		String[] temp = new String[12];
		for (int k = 0; k < 12; k++) {

			temp[k] = dados[0][k];

		}

		return temp;
	}

}