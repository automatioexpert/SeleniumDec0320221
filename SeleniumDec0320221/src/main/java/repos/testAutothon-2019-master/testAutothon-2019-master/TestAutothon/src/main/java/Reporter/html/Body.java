package Reporter.html;

import java.util.ArrayList;
import java.util.HashMap;

public class Body extends Tag {

	ArrayList<Tag> elements = new ArrayList<Tag>();

	public Body() {
		super("body", "");
	}

	public Body(HashMap<String, String> attributes) {
		super("body", "", attributes);
	}

	public void add(Tag element) {
		elements.add(element);
	}

	public String toString() {
		String returnString = "\n<body>";
		elements.trimToSize();
		for (int i = 0; i < elements.size(); i++) {
			returnString = returnString.concat(elements.get(i).toString());
		}
		returnString = returnString.concat("</body>");
		return returnString;
	}
}
