package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.Planes;

public class FilesPlanesXML {

	public FilesPlanesXML() {
		// TODO Auto-generated constructor stub
	}

	public boolean dataExistOnXML(String fileName, String elementType, String attributeName, String attributeValue) {
		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String attribute = eElement.getAttribute(attributeName);
					if (attribute.equals(attributeValue)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void writePlanesXML(String fileName, String elementType, String[] dataName, String[] data) {
		boolean modelExist = dataExistOnXML(fileName, elementType, dataName[0], data[0]);

		if (modelExist) {
			JOptionPane.showMessageDialog(null, "El vuelo ya existe en el sistema");
			return;
		}

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(new File(fileName));
			doc.getDocumentElement().normalize();

			Element rootElement = doc.getDocumentElement();

			Element ele = doc.createElement(elementType);
			rootElement.appendChild(ele);

			Attr atrr = doc.createAttribute(dataName[0]);
			atrr.setValue(data[0]);
			ele.setAttributeNode(atrr);

			for (int i = 1; i < data.length; i++) {
				Element dato = doc.createElement(dataName[i]);
				dato.appendChild(doc.createTextNode(data[i]));
				ele.appendChild(dato);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(fileName));
			transformer.transform(source, result);

			JOptionPane.showMessageDialog(null, "Registro Exitoso");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public Planes searchPlanes(String fileName, String elementType, String nameRegisAirc) {
		Planes p = null;

		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (eElement.getAttribute("registerOfAircft").equals(nameRegisAirc)) {
						p = new Planes(eElement.getAttribute("registerOfAircft"),
								eElement.getElementsByTagName("airline").item(0).getTextContent(),
								eElement.getElementsByTagName("model").item(0).getTextContent(),
								Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()));
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}
	
	public Planes planesDelete(String fileName, String elementType, String nameRegisAirc) {
		Planes p = new Planes();

		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (eElement.getAttribute("registerOfAircft").equals(nameRegisAirc)) {

						eElement.removeAttribute("registerOfAircft");
						eElement.getParentNode().removeChild(eElement);

						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(fileName));
						transformer.transform(source, result);

						p = new Planes();
						p.setRegisterOfAircft(nameRegisAirc);

						if (eElement.getElementsByTagName("airline").getLength() > 0) {
							p.setAirline(eElement.getElementsByTagName("airline").item(0).getTextContent());
						}
						if (eElement.getElementsByTagName("model").getLength() > 0) {
							p.setModel(eElement.getElementsByTagName("model").item(0).getTextContent());
						}
						if (eElement.getElementsByTagName("year").getLength() > 0) {
							p.setYear(Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()));
						}

						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}
	
	public ArrayList<Planes> returnPlanes(String fileName, String elementType) {
		ArrayList<Planes> arrayPlanes = new ArrayList<>();

		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Planes p = new Planes();
					p.setRegisterOfAircft(eElement.getAttribute("registerOfAircft"));
					p.setAirline(eElement.getElementsByTagName("airline").item(0).getTextContent());
					p.setModel(eElement.getElementsByTagName("model").item(0).getTextContent());
					p.setYear(Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()));
					arrayPlanes.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayPlanes;
	}
	
	public void modifyPlanes(String fileName, String elementType, String nameRegister, String airline, String model, int year) {

		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (eElement.getAttribute("registerOfAircft").equals(nameRegister)) {
						eElement.getElementsByTagName("airline").item(0).setTextContent(airline);
						eElement.getElementsByTagName("model").item(0).setTextContent(model);
						eElement.getElementsByTagName("year").item(0).setTextContent(String.valueOf(year));
						
					}
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(fileName));
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
