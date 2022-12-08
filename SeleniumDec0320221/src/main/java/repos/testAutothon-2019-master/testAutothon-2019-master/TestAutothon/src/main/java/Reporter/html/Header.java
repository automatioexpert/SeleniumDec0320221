package Reporter.html;

import java.util.HashMap;

public class Header extends Tag {

	public Header() {
		super("header", "");
		super.element = new Tag("title", "Untitled - Html");
	}

    public void setTitle(String title) {
        this.element = new Tag("title", title);
    }

	public void setStyle(String style) {
		HashMap<String, String> styleAtts = new HashMap<String, String>();
		styleAtts.put("type", "text/css");
		this.element = this.element.toString()
				+ new Tag("Style", style, styleAtts).toString();
	}

}
