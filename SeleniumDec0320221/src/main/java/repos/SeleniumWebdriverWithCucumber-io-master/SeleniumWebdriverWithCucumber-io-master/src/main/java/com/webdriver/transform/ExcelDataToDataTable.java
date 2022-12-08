package com.webdriver.transform;

public class ExcelDataToDataTable  {

	//extends Transformer<DataTable>
	/*@Override
	public DataTable transform(String filename) {
		String path = getFilePath(filename);
		ExcelReader reader = new ExcelReader.ExcelReaderBuilder()
				.setFileLocation(path)
				.setSheet(0)
				.build();
		
		List<List<String>> excelData = getExcelData(reader);
		
		List<DataTableRow> dataTableRows = getDataTableRows(excelData);
		
		DataTable table = getDataTable(dataTableRows);
		
		return table;
	}


	private String getFilePath(String filename) {
		String path = ResourceUtils.getResourcePath(filename);
		
		if(null != path)
			return path;
		throw new RuntimeException("Invlaid File Name : " + filename);
	}


	private DataTable getDataTable(List<DataTableRow> dataTableRows) {
		ParameterInfo parameterInfo = new ParameterInfo(null, null, null, null);
	    TableConverter tableConverter = new TableConverter(new LocalizedXStreams(Thread.currentThread().getContextClassLoader()).get(Locale.getDefault()), parameterInfo);
		
		DataTable table = new DataTable(dataTableRows, tableConverter);
		return table;
	}

	private List<DataTableRow> getDataTableRows(List<List<String>> excelData) {
		List<DataTableRow> dataTableRows = new LinkedList<>();
		int line = 1;
		
		for(List<String> list : excelData){
			Comment commnet = new Comment("", line);
			DataTableRow tableRow = new DataTableRow(Arrays.asList(commnet), list, line++);
			dataTableRows.add(tableRow);
		}
		return dataTableRows;
	}

	private List<List<String>> getExcelData(ExcelReader reader) {
		List<List<String>> excelData = new LinkedList<>();
		
		try {
			excelData = reader.getSheetDataAt();
		} catch (InvalidFormatException | IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return excelData;
	}*/

}
