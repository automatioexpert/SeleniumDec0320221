package Reporter.html;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Table extends Tag {

	List<String> trs = new ArrayList<>();

	public Table() {
		super("table", "");
	}

	public Table(HashMap<String, String> attributes) {
		super("table", "", attributes);
	}

	public void addTableHeader(String pipeDelimitedString) {
		addTableHeader(pipeDelimitedString, "");
	}

	public void addTableHeader_movies(String columnString){
		String curRow =  "\n<thead>\n"+columnString+ "\n</thead>";
		trs.add(curRow);
	}
	public void addTableRow(String pipeDelimitedString) {
		addTableHeader(pipeDelimitedString, "");
	}

	public void addTableHeader(String columnString, String rowCssClass) {
		String curRow = (StringUtils.isEmpty(rowCssClass) ? "\n<thead><tr>\n" : "\n<tr class='" + rowCssClass + "'>\n");
		String[] columns = columnString.split("##");
		for (int i = 0; i < columns.length; i++) {
			curRow = curRow + "<th>" + columns[i] + "</th>";
		}
		curRow = curRow + "\n</tr></thead>";
		trs.add(curRow);
	}

	public void addTableRow(String columnString, String rowCssClass) {
		String curRow = (StringUtils.isEmpty(rowCssClass) ? "\n<tr>\n" : "\n<tr class='" + rowCssClass + "'>\n");
		String[] columns = columnString.split("##");
		for (int i = 0; i < columns.length; i++) {
			curRow = curRow + "<td>" + columns[i] + "</td>";
		}
		curRow = curRow + "\n</tr>";
		trs.add(curRow);
	}

	public String toString() {
		String returnString = "<table>";
		for (int i = 0; i < trs.size(); i++) {
			returnString = returnString.concat(trs.get(i));
		}
		returnString = returnString.concat("\n</table>\n");
		return returnString;
	}
}
