package Reporter.html;

import java.util.HashMap;
import java.util.Iterator;

public class Tag {

	HashMap<String, String> attributes = new HashMap<String, String>();
	Object element;
    private String tagName;

	public Tag(String tagName, Object element) {
		this.tagName = tagName;
		this.element = element;
	}

	public Tag(String tagName, Object element, HashMap<String, String> attributes) {
		this.tagName = tagName;
		this.element = element;
		this.attributes = attributes;
	}

	public String toString() {
		String atts = "";
		Iterator<String> attName = attributes.keySet().iterator();
		while (attName.hasNext()) {
			String tempAttName = attName.next().toString();
			atts = atts + " " + tempAttName + "='"
					+ attributes.get(tempAttName) + "' ";
		}
		return "\n<" + tagName + atts + ">" + element + "</" + tagName + ">\n";
	}
}
