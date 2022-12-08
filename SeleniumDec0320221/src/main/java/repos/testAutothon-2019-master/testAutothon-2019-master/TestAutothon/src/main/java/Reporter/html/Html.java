package Reporter.html;

public class Html extends Tag {

    Header header = new Header();
    Body body = new Body();

    public Html() {
        super("html", "");
    }

    public Body getBody() {
        return body;
    }

    public void add(Tag element) {
        body.add(element);
    }

    public void setTitle(String title) {
        header.setTitle(title);
    }

    public void setStyle(String style) {
        header.setStyle(style);
    }

    public String toString() {
        return "<html>" + header + body + "\n</html>";
    }

}
