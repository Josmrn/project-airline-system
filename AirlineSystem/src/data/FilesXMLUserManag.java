package data;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FilesXMLUserManag {

	public FilesXMLUserManag() {}

	//Crea el XML
	public void createXML(String objectName, String fileName) {

		File file = new File(fileName);

		if (!file.exists()) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

				Document doc = dBuilder.newDocument();

				Element rootElement = doc.createElement(objectName);
				doc.appendChild(rootElement);

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();

				DOMSource source = new DOMSource(doc);

				StreamResult result = new StreamResult(file);
				transformer.transform(source, result);

				System.out.println("Archivo Creado");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Escribir en el XML
	public void writeXML(String FileName, String elementType, String[] dataName, String[] data) {

		boolean userExist = userExistOnXML(FileName, elementType, dataName[0], data[0]);

		if (userExist && (data[0] == "admin")) {

			return; // Detener la ejecución del método writeXML
		}
		if (userExist && (data[0] != "admin")) {
			System.out.println("El usuario ya existe en el sistema");
			return; // Detener la ejecución del método writeXML
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

			// escribirmos el contenido en un archivo xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(FileName));
			transformer.transform(source, result);

			System.out.println("Registro Guardado");

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

	//Leer el XML
	public void readXML(String Filename, String elementType) {

		try {
			File inputFile = new File(Filename);
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
					System.out.println("Usuario: " + eElement.getAttribute("user"));
					System.out.println(
							"Contraseña: " + eElement.getElementsByTagName("password").item(0).getTextContent());
					System.out.println(
							"Tipo de Usuario: " + eElement.getElementsByTagName("typeUser").item(0).getTextContent());
					System.out.println("Estado: " + eElement.getElementsByTagName("state").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// metodo que me dice si el usuario existe en el archivo XML
	public boolean userExistOnXML(String fileName, String elementType, String dataName, String username) {

		try {
			File file = new File(fileName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			if (file.exists()) {
				Document doc = db.parse(file);
				doc.getDocumentElement().normalize();

				Element rootElement = doc.getDocumentElement();
				NodeList nodeList = rootElement.getElementsByTagName(elementType);

				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if (node instanceof Element) {
						Element element = (Element) node;
						String value = element.getAttribute(dataName);
						if (value.equals(username)) {
							return true; // El usuario existe en el archivo
						}
					}
				}
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false; // El usuario no existe en el archivo o se produjo un error
	}

	// metodo que me dice si el usuario y contraseña existen en el archivo XML
	public boolean userExistWithPasswordOnXML(String fileName, String elementType, String userAttributeName,
			String passwordAttributeName, String username, String password) {
		try {
			File file = new File(fileName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			if (file.exists()) {
				Document doc = db.parse(file);
				doc.getDocumentElement().normalize();

				Element rootElement = doc.getDocumentElement();
				NodeList nodeList = rootElement.getElementsByTagName(elementType);

				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if (node instanceof Element) {
						Element element = (Element) node;
						String userValue = element.getAttribute(userAttributeName);
						String passwordValue = element.getElementsByTagName(passwordAttributeName).item(0)
								.getTextContent();

						if (userValue.equals(username) && passwordValue.equals(password)) {
							return true; // Usuario y contraseña coinciden en el archivo
						}
					}
				}
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false; // Usuario no encontrado o contraseña incorrecta, o se produjo un error
	}

	//Método para verificar el tipo de usuario y el estado
	public String[] returnTypeAndStatus(String FileName, String elementType, String userAttributeName,
			String passwordAttributeName, String username, String password) {

		String[] userTypeAndStatus = { "", "" };

		try {
			File file = new File(FileName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			if (file.exists()) {
				Document doc = db.parse(file);
				doc.getDocumentElement().normalize();

				Element rootElement = doc.getDocumentElement();
				NodeList nodeList = rootElement.getElementsByTagName(elementType);

				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if (node instanceof Element) {
						Element element = (Element) node;

						// Se verifica el usuario y Contraseña
						String userValue = element.getAttribute(userAttributeName);
						String passwordValue = element.getElementsByTagName(passwordAttributeName).item(0)
								.getTextContent();

						if (userValue.equals(username) && passwordValue.equals(password)) {

							// Se guardan tanto el tipo de usuario como el estado
							userTypeAndStatus[0] = element.getElementsByTagName("typeUser").item(0).getTextContent();
							userTypeAndStatus[1] = element.getElementsByTagName("state").item(0).getTextContent();

						}
					}
				}
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userTypeAndStatus;
	}
	
	//Método para modificar datos en el XML
	
	// Método para buscar en el XML
	

	/*
	 * public ArrayList <Users> returnUsers(String FileName,String elementType) {
	 * 
	 * ArrayList usersAL = new ArrayList <Users>();; Users usersToAdd = new Users();
	 * 
	 * try { File file = new File(FileName); DocumentBuilderFactory dbf =
	 * DocumentBuilderFactory.newInstance(); DocumentBuilder db =
	 * dbf.newDocumentBuilder(); Document doc = db.parse(file); NodeList nList =
	 * doc.getElementsByTagName(elementType);
	 * 
	 * for (int indice = 0; indice < nList.getLength(); indice++) { Node nNode =
	 * nList.item(indice); System.out.println("\nDatos de las Facturas: " +
	 * nNode.getNodeName());
	 * 
	 * if (nNode.getNodeType() == Node.ELEMENT_NODE) { Element eElement = (Element)
	 * nNode;
	 * 
	 * usersToAdd = new Users(eElement.getAttribute("user"),
	 * eElement.getElementsByTagName("password").item(0).getTextContent(),
	 * eElement.getElementsByTagName("typeUser").item(0).getTextContent(),
	 * eElement.getElementsByTagName("state").item(0).getTextContent());
	 * 
	 * usersAL.add(usersToAdd);
	 * 
	 * } }
	 * 
	 * 
	 * } catch (ParserConfigurationException pce) { pce.printStackTrace(); } catch
	 * (SAXException e) { e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return usersAL; }
	 */

}