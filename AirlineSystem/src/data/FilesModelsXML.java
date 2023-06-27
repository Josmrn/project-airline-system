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

import domain.Models;

public class FilesModelsXML {

	public FilesModelsXML() {
		// TODO Auto-generated constructor stub
	}

	public String readModelsXML(String fileName, String elementType) {

		String data = " ";
		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			data += "Raíz de los Elementos:" + doc.getDocumentElement().getNodeName();
			NodeList nList = doc.getElementsByTagName(elementType);
			data += "----------------------------";

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);
				data += "\nDatos de las Facturas: " + nNode.getNodeName();

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					data += "Nombre: " + eElement.getAttribute("name");
					data += "Marca: " + eElement.getElementsByTagName("brand").item(0).getTextContent();
					data += "Ejecutivo: " + eElement.getElementsByTagName("execSeats").item(0).getTextContent();
					data += "Turista: " + eElement.getElementsByTagName("tourSeats").item(0).getTextContent();
					data += "Economico: " + eElement.getElementsByTagName("ecoSeats").item(0).getTextContent();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public ArrayList<Models> readXMLToArrayList(String fileName, String elementType) {

		ArrayList<Models> arrayLModels = new ArrayList<Models>();
		Models m = new Models();

		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			System.out.println("Raíz de los Elementos:" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName(elementType);
			System.out.println("----------------------------");

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);
				System.out.println("\nDatos de las Facturas: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					m = new Models();
					m.setName(eElement.getAttribute("name"));
					m.setBrand(eElement.getElementsByTagName("brand").item(0).getTextContent());
					m.setExecSeats(
							Integer.parseInt(eElement.getElementsByTagName("execSeats").item(0).getTextContent()));
					m.setTourSeats(
							Integer.parseInt(eElement.getElementsByTagName("tourSeats").item(0).getTextContent()));
					m.setTourSeats(
							Integer.parseInt(eElement.getElementsByTagName("ecoSeats").item(0).getTextContent()));
					arrayLModels.add(m);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLModels;
	}

	public String readBrandXMLToString(String fileName, String elementType) {

		String information = "";

		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			information += "Raíz de los Elementos:" + doc.getDocumentElement().getNodeName();
			NodeList nList = doc.getElementsByTagName(elementType);
			information += "----------------------------";

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);
				information += "\nDatos de las Facturas: " + nNode.getNodeName();

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					information += "\nNombre: " + eElement.getAttribute("name");
					information += "\nMarca: " + eElement.getElementsByTagName("brand").item(0).getTextContent();
					information += "\nEjecutivo: "
							+ eElement.getElementsByTagName("execSeats").item(0).getTextContent();
					information += "\nTurista: " + eElement.getElementsByTagName("tourSeats").item(0).getTextContent();
					information += "\nEconomico: " + eElement.getElementsByTagName("ecoSeats").item(0).getTextContent();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return information;
	}

	public boolean modelsExistOnXML(String fileName, String elementType, String attributeName, String attributeValue) {
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

	public ArrayList<Models> returnModels(String fileName, String elementType) {
		ArrayList<Models> arrayModels = new ArrayList<>();

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
					Models model = new Models();
					model.setName(eElement.getAttribute("name"));
					model.setBrand(eElement.getElementsByTagName("brand").item(0).getTextContent());
					model.setExecSeats(
							Integer.parseInt(eElement.getElementsByTagName("execSeats").item(0).getTextContent()));
					model.setTourSeats(
							Integer.parseInt(eElement.getElementsByTagName("tourSeats").item(0).getTextContent()));
					model.setEcoSeats(
							Integer.parseInt(eElement.getElementsByTagName("ecoSeats").item(0).getTextContent()));

					arrayModels.add(model);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayModels;
	}

	public void writeModelXML(String fileName, String elementType, String[] dataName, String[] data) {
		boolean modelExist = modelsExistOnXML(fileName, elementType, dataName[0], data[0]);

		if (modelExist) {
			JOptionPane.showMessageDialog(null, "El modelo ya existe en el sistema");
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
				String elementName = sanitizeElementName(dataName[i]);
				Element dato = doc.createElement(elementName);

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

	private String sanitizeElementName(String elementName) {
		// Remover caracteres no válidos en XML
		elementName = elementName.replaceAll("[^a-zA-Z0-9_-]", "");

		// Verificar si el nombre comienza con un número
		if (Character.isDigit(elementName.charAt(0))) {
			// Agregar un prefijo si el nombre comienza con un número
			elementName = "element_" + elementName;
		}

		return elementName;
	}

	public void modifyModel(String fileName, String elementType, String nameModel, String brand, int execSeats, int tourSeats, int ecoSeats) {

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

					if (eElement.getAttribute("name").equals(nameModel)) {
						
						eElement.getElementsByTagName("brand").item(0).setTextContent(brand);
						eElement.getElementsByTagName("execSeats").item(0).setTextContent(String.valueOf(execSeats));
						eElement.getElementsByTagName("tourSeats").item(0).setTextContent(String.valueOf(tourSeats));
						eElement.getElementsByTagName("ecoSeats").item(0).setTextContent(String.valueOf(ecoSeats));
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

	public Models searchModel(String fileName, String elementType, String nameModel) {
		Models m = null;

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

					if (eElement.getAttribute("name").equals(nameModel)) {
						m = new Models(eElement.getAttribute("name"),
								eElement.getElementsByTagName("brand").item(0).getTextContent(),
								Integer.parseInt(eElement.getElementsByTagName("execSeats").item(0).getTextContent()),
								Integer.parseInt(eElement.getElementsByTagName("tourSeats").item(0).getTextContent()),
								Integer.parseInt(eElement.getElementsByTagName("ecoSeats").item(0).getTextContent()));

						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}
	
	public Models modelDelete(String fileName, String elementType, String modelName) {
		Models m = new Models();

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

					if (eElement.getAttribute("name").equals(modelName)) {

						eElement.removeAttribute("name");
						eElement.getParentNode().removeChild(eElement);

						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(fileName));
						transformer.transform(source, result);

						m = new Models();
						m.setName(modelName);

						if (eElement.getElementsByTagName("brand").getLength() > 0) {
							m.setBrand(eElement.getElementsByTagName("brand").item(0).getTextContent());
						}
						if (eElement.getElementsByTagName("execSeats").getLength() > 0) {
							m.setExecSeats(Integer.parseInt(eElement.getElementsByTagName("execSeats").item(0).getTextContent()));
						}
						if (eElement.getElementsByTagName("tourSeats").getLength() > 0) {
							m.setTourSeats(Integer.parseInt(eElement.getElementsByTagName("tourSeats").item(0).getTextContent()));
						}
						if (eElement.getElementsByTagName("tourSeats").getLength() > 0) {
							m.setEcoSeats(Integer.parseInt(eElement.getElementsByTagName("ecoSeats").item(0).getTextContent()));
						}

						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}
}
