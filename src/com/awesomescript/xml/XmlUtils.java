package com.awesomescript.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtils {

	public static Iterable<Node> iterate(final NodeList nodeList) {
		return new Iterable<Node>() {
			@Override
			public Iterator<Node> iterator() {
				
				return new Iterator<Node>() {
				
					int index = 0;
					
					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
					
					@Override
					public Node next() {
						return nodeList.item(index++);
					}
					
					@Override
					public boolean hasNext() {
						return index < nodeList.getLength();
					}
				};
			}
		};
	}
	
	public static Iterable<Node> getChildrenWithTagName(final Node node, String name) {
		List<Node> list = new ArrayList<>();
		for (Node n : iterate(node.getChildNodes())) {
			if (n.getNodeName().equals(name)) {
				list.add(n);
			}
		}
		return list;
	}
	
	public static Node getChildWithTagName(final Node node, String name) {
		Node r = null;
		for (Node n : iterate(node.getChildNodes())) {
			if (n.getNodeName().equals(name)) {
				r = n;
				break;
			}
		}
		return r;
		
	}
}
