package org.iscte_iul.pt.ProjetoES;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
/**
 * neste método é feita a leitura de um ficherio.xls e guardar os seus valores
 * @author mdmpe
 *
 */
public class ExcelReader {

	private String PATH;
	private String dados[][];
	private String[] headers= new String[12];
/**
 * 
 * @param PATH	o caminho para o ficheiro
 * @throws InvalidFormatException
 * @throws IOException
 */
	public ExcelReader(String PATH) throws InvalidFormatException, IOException {
		this.PATH = PATH;
		StartRead();
	}
/**
 * é criado um uma sheet a partir do ficheiro e também uma data formater para depois guardar o ficheiro
 * a seguir é criado um iterador para percorrer as linhas do ficheiro
 * de seguida é criado um iterador para as celas para que tanto coluna como linha sejam lidos
 * se as celas forem da primeira linha elas são guardadas no vetor headers 
 * as restantes celas, ordenadas, são guardadas na matriz dados
 * @throws IOException
 * @throws InvalidFormatException
 */
	public void StartRead() throws IOException, InvalidFormatException {

		Workbook workbook = WorkbookFactory.create(new File(PATH));

		Sheet sheet = workbook.getSheetAt(0);

		DataFormatter dataFormatter = new DataFormatter();

		Iterator<Row> rowIterator = sheet.rowIterator();
		dados = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				if (cell.getRowIndex() == 0) {
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

	/*public String[] getColunaInicial() {
		String[] temp = new String[12];
		for (int k = 0; k < 12; k++) {

			temp[k] = dados[0][k];

		}

		return temp;
	}*/

}