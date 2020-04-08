package interview;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetDocumentElements {
	HashSet<Node> visited = new HashSet<>();

	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
		String className = "visualClear";
		URL url = new URL("https://en.wikipedia.org/w/index.php?title=Document_Object_Model&oldid=892665204%22");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(url.openStream());
		GetDocumentElements obj = new GetDocumentElements();
		Set<Element> ele = obj.getDOMElements(doc, className);
		System.out.println(ele.size());
	}

	public Set<Element> getDOMElements(Node document, String className) {
		if (!document.hasChildNodes() || document.equals(null))
			return null;
		if (visited.contains(document)) {
			return null;
		}
		visited.add(document);
		NodeList nodes = document.getChildNodes();
		if (nodes.equals(null))
			return null;

		Set<Element> ele = new HashSet<>();
		for (int i = 0; i < nodes.getLength(); i++) {
			NodeList node = (NodeList) nodes.item(i);

			if (node instanceof Element) {
				Element child = (Element) node;
				if (child.hasAttribute("id")) {
					ele.add(child);
				}
				Set<Element> temp = getDOMElements(child, className);
				if (temp != null && !temp.isEmpty())
					ele.addAll(temp);
			}
		}
		return ele;
	}
}
