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

import domain.Passengers;

public class FilesPassXML {

	public FilesPassXML() {
		// TODO Auto-generated constructor stub
	}

	public Passengers searchPassengers(String Filename, String elementType, int passport) {

		Passengers p = new Passengers();

		try {
			File inputFile = new File(Filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (Integer.parseInt(eElement.getAttribute("passportNum")) == passport) {
						p = new Passengers();
						p.setPassportNum(Integer.parseInt(eElement.getAttribute("passportNum")));
						p.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
						p.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
						p.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
						p.setBornDate(eElement.getElementsByTagName("bornDate").item(0).getTextContent());
						p.setCellphone(Integer.parseInt(eElement.getElementsByTagName("cellphone").item(0).getTextContent()));
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	public ArrayList<Passengers> returnPassengers(String Filename, String elementType) {
		ArrayList<Passengers> arrayPassengers = new ArrayList<>();

		try {
			File inputFile = new File(Filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Passengers passenger = new Passengers();
					passenger.setPassportNum(Integer.parseInt(eElement.getAttribute("passportNum")));
					passenger.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
					passenger.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
					passenger.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
					passenger.setBornDate(eElement.getElementsByTagName("bornDate").item(0).getTextContent());
					passenger.setCellphone(
							Integer.parseInt(eElement.getElementsByTagName("cellphone").item(0).getTextContent()));
					arrayPassengers.add(passenger);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayPassengers;
	}

	// Método para modificar el pasajero
	public void modifyPassenger(String filename, String elementType,Object passportNumOriginal, int passportNum, String name, String lastName,
			String birthDate, String email, int cellphone) {
		try {
			File inputFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (eElement.getAttribute("passportNum").equals(String.valueOf(passportNumOriginal))) {
						// Modificar los elementos del pasajero
						eElement.setAttribute("passportNum", String.valueOf(passportNum));
						eElement.getElementsByTagName("name").item(0).setTextContent(name);
						eElement.getElementsByTagName("lastName").item(0).setTextContent(lastName);
						eElement.getElementsByTagName("bornDate").item(0).setTextContent(birthDate);
						eElement.getElementsByTagName("email").item(0).setTextContent(email);
						eElement.getElementsByTagName("cellphone").item(0).setTextContent(String.valueOf(cellphone));
					}
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Escribe el XML del pasajero
	public void writePassengerXML(String FileName, String elementType, String[] dataName, String[] data) {

		boolean passportExist = passportExistOnXML(FileName, elementType, dataName[0], Integer.parseInt(data[0]));

		if (passportExist == true) {

			JOptionPane.showMessageDialog(null, "El pasaporte ya existe en el sistema");
			return;
		}

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(new File(FileName));
			doc.getDocumentElement().normalize();

			Element rootElement = doc.getDocumentElement();

			Element ele = doc.createElement(elementType);
			rootElement.appendChild(ele);

			Attr attr = doc.createAttribute(dataName[0]);
			attr.setValue(data[0]);
			ele.setAttributeNode(attr);

			for (int i = 1; i < data.length; i++) {

				Element dato = doc.createElement(dataName[i]);

				dato.appendChild(doc.createTextNode(data[i]));

				ele.appendChild(dato);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(FileName));
			transformer.transform(source, result);

			JOptionPane.showMessageDialog(null, "Pasajero registrado");

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

	// Método para saber si el pasajero existe en el XML
	public boolean passportExistOnXML(String fileName, String elementType, String attributeName, int passport) {
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
					int attribute = Integer.parseInt(eElement.getAttribute(attributeName));
					if (attribute == passport) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// Método que elimina al pasajero dentro del XML (funcionando)
	public Passengers searchPassengerAndDelete(String Filename, String elementType, int passportNum) {
		Passengers p = null;

		try {
			File inputFile = new File(Filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (Integer.parseInt(eElement.getAttribute("passportNum")) == passportNum) {
						System.out.println("Encontre el pasaporte");

						eElement.removeAttribute("passportNum");
						eElement.getParentNode().removeChild(eElement);

						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(Filename));
						transformer.transform(source, result);

						p = new Passengers();
						p.setPassportNum(passportNum);

						// Validaciones que verifican si los nodos hijos existen antes de acceder al
						// contenido
						if (eElement.getElementsByTagName("name").getLength() > 0) {
							p.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
						}
						if (eElement.getElementsByTagName("lastName").getLength() > 0) {
							p.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
						}
						if (eElement.getElementsByTagName("birthDate").getLength() > 0) {
							p.setBornDate(eElement.getElementsByTagName("birthDate").item(0).getTextContent());
						}
						if (eElement.getElementsByTagName("email").getLength() > 0) {
							p.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
						}
						if (eElement.getElementsByTagName("cellphone").getLength() > 0) {
							p.setCellphone(Integer
									.parseInt(eElement.getElementsByTagName("cellphone").item(0).getTextContent()));
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
}
