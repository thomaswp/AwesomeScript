package com.awesomescript.importer;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Importer {


	public final static String PATH = "C:/Program Files/Steam/SteamApps/common/Awesomenauts/Data/BehaviourCreator/Blockdefinitions.xml";
	public final static String OUT = "./out/";
	
	public static Domain parseDomain(String path) throws ParserConfigurationException, SAXException, IOException {
		Domain domain = new Domain();
		
		File fXmlFile = new File(PATH);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		Document doc;
		
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();

		for (Node enumNode : iterate(doc.getElementsByTagName("predefined_values"))) {
			if (enumNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Enumeration predef = new Enumeration();
				predef.id = enumNode.getAttributes().getNamedItem("id").getNodeValue();
				domain.enumerations.put(predef.id, predef);
				
				for (Node valueNode : iterate(enumNode.getChildNodes())) {
					if (valueNode.getNodeType() == Node.ELEMENT_NODE &&
							valueNode.getNodeName().equalsIgnoreCase("value")) {
						predef.values.add(valueNode.getTextContent());
					}
				}
			}
		}
		
		for (Node actionNode : iterate(doc.getElementsByTagName("action"))) {
			if (actionNode.getNodeType() == Node.ELEMENT_NODE) {
				Action action = new Action();
				populateMethod(domain, actionNode, action);
				domain.actions.put(action.name, action);
			}	
		}
		
		for (Node conditionNode : iterate(doc.getElementsByTagName("condition"))) {
			if (conditionNode.getNodeType() == Node.ELEMENT_NODE) {
				Condition condition = new Condition();
				populateMethod(domain, conditionNode, condition);
				domain.conditions.put(condition.name, condition);
			}	
		}
		
		return domain;
	}
	
	public static void main(String[] args) {
		try {
			Domain domain = parseDomain(PATH);
			domain.write(new File(OUT));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void populateMethod(Domain domain, Node actionNode, Method method) {
		method.name = actionNode.getAttributes().getNamedItem("name").getNodeValue();
		
		for (Node valueNode : iterate(actionNode.getChildNodes())) {
			if (valueNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Parameter parameter = new Parameter();
				method.parameters.add(parameter);
				parameter.type = valueNode.getNodeName(); 
				
				NamedNodeMap attributes = valueNode.getAttributes(); 
				parameter.name = attributes.getNamedItem("name").getNodeValue();
				
				Node valuesNode = attributes.getNamedItem("values");
				if (valuesNode != null) {
					parameter.values = domain.enumerations.get(valuesNode.getNodeValue());
				}
				
				Node multiselectNode = attributes.getNamedItem("multiselect");
				if (multiselectNode != null) {
					parameter.multiselect = multiselectNode.getNodeValue().equalsIgnoreCase("true");
				}
			}
		}
	}
	
	private static Iterable<Node> iterate(final NodeList nodeList) {
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

}
