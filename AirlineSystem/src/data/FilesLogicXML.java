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

import domain.Brands;
import domain.Models;
import domain.Users;
import domain.Passengers;

public class FilesLogicXML {

	public FilesLogicXML() {
	}

	// Lee el XML del usuario
	public String readXML(String fileName, String elementType) {

		String information = " ";

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
					information += "Usuario: " + eElement.getAttribute("user");
					information += "Contraseña: " + eElement.getElementsByTagName("password").item(0).getTextContent();
					information += "Tipo de Usuario: "
							+ eElement.getElementsByTagName("typeUser").item(0).getTextContent();
					information += "Estado: " + eElement.getElementsByTagName("state").item(0).getTextContent();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return information;
	}

	// Escribe el XML del login
	public void writeLoginXML(String fileName, String elementType, String[] dataName, String[] data) {

		boolean userExist = dataExistOnXML(fileName, elementType, dataName[0], data[0]);

		if (userExist && (data[0] == "admin")) {

			return;
		}
		if (userExist && (data[0] != "admin")) {
			JOptionPane.showMessageDialog(null, "El usuario ya existe en el sistema");
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

			StreamResult result = new StreamResult(new File(fileName));
			transformer.transform(source, result);

			JOptionPane.showMessageDialog(null, "Usuario registrado");

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

	// Método que elimina al usuario dentro del XML (funcionando)
	public Users searchUserAndDelete(String fileName, String elementType, String username) {
		Users u = new Users();

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

					if (eElement.getAttribute("user").equals(username)) {

						eElement.removeAttribute("user");
						eElement.getParentNode().removeChild(eElement);

						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(fileName));
						transformer.transform(source, result);

						u = new Users();
						u.setUser(username);

						// Validaciones que verifican si los nodos hijos existen antes de acceder al
						// contenido
						if (eElement.getElementsByTagName("password").getLength() > 0) {
							u.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
						}
						if (eElement.getElementsByTagName("typeUser").getLength() > 0) {
							u.setTypeUser(eElement.getElementsByTagName("typeUser").item(0).getTextContent());
						}
						if (eElement.getElementsByTagName("state").getLength() > 0) {
							u.setState(eElement.getElementsByTagName("state").item(0).getTextContent());
						}

						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// Método que busca los datos en el archivo xml de usuarios (funcionando)
	public Users searchUsers(String fileName, String elementType, String user) {
		Users u = null;

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

					if (eElement.getAttribute("user").equals(user)) {
						u = new Users(eElement.getAttribute("user"),
								eElement.getElementsByTagName("password").item(0).getTextContent(),
								eElement.getElementsByTagName("typeUser").item(0).getTextContent(),
								eElement.getElementsByTagName("state").item(0).getTextContent());
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// Retorno de usuarios
	public ArrayList<Users> returnUsers(String fileName, String elementType) {
		ArrayList<Users> arrayUsers = new ArrayList<>();

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
					Users user = new Users();
					user.setUser(eElement.getAttribute("user"));
					user.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
					user.setTypeUser(eElement.getElementsByTagName("typeUser").item(0).getTextContent());
					user.setState(eElement.getElementsByTagName("state").item(0).getTextContent());
					arrayUsers.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayUsers;
	}

	public String readXMLToString(String filename, String elementType) {

		String Data = "";

		try {

			File inputFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			Data += "Raíz de los Elementos:" + doc.getDocumentElement().getNodeName() + "\n";
			NodeList nList = doc.getElementsByTagName(elementType);
			Data += "----------------------------";

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);
				Data += "\nDatos de las Facturas: " + nNode.getNodeName();

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Data += "\nUsuario: " + eElement.getAttribute("user");
					Data += "\nContraseña: " + eElement.getElementsByTagName("password").item(0).getTextContent();
					Data += "\nTipo de Usuario: " + eElement.getElementsByTagName("typeUser").item(0).getTextContent();
					Data += "\nEstado: " + eElement.getElementsByTagName("state").item(0).getTextContent();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Data;
	}

	// Método para saber si el usuario existe en el XML
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

	// metodo que me dice si el usuario y contraseña existen en el archivo XML
	public boolean userExistWithPasswordOnXML(String fileName, String elementType, String username, String password) {
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
						String userValue = element.getAttribute("user");
						String passwordValue = element.getElementsByTagName("password").item(0).getTextContent();

						if (userValue.equals(username) && passwordValue.equals(password)) {
							return true; // Usuario y contraseña coinciden
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

		return false;
	}

	// Método para verificar el tipo de usuario y el estado
	public String[] returnTypeAndStatus(String fileName, String elementType, String username, String password) {

		String[] userTypeAndStatus = { "", "" };

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

						// Se verifica el usuario y Contraseña
						System.out.println(element.getAttribute("user"));
						System.out.println(element.getElementsByTagName("password").item(0).getTextContent());
						String userValue = element.getAttribute("user");

						String passwordValue = element.getElementsByTagName("password").item(0).getTextContent();

						if (userValue.equals(username) && passwordValue.equals(password)) {
							// Se guarda tanto el tipo de usuario como el estado
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

	// Método para modificarme el usuario
	public void modifyUser(String fileName, String elementType, String username, String password, String typeUser,
			String statusUser) {

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

					if (eElement.getAttribute("user").equals(username)) {
						// Modificar los elementos del usuario
						eElement.getElementsByTagName("password").item(0).setTextContent(password);
						eElement.getElementsByTagName("typeUser").item(0).setTextContent(typeUser);
						eElement.getElementsByTagName("state").item(0).setTextContent(statusUser);
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

//-----------------------------------------------------------------------------------------------------------------------------------------	
	// Método para escribir marcas en el xml
	public void writeBrandsXML(String fileName, String elementType, String[] dataName, String[] data) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc;
			File file = new File(fileName);

			if (file.exists()) {
				doc = db.parse(file);
				doc.getDocumentElement().normalize();
			} else {
				doc = db.newDocument();
				Element rootElement = doc.createElement("Brands");
				doc.appendChild(rootElement);
			}

			Element rootElement = doc.getDocumentElement();
			Element ele = doc.createElement(elementType);
			rootElement.appendChild(ele);

			for (int i = 0; i < data.length; i++) {
				Element dato = doc.createElement(dataName[i]);
				dato.appendChild(doc.createTextNode(data[i]));
				ele.appendChild(dato);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

			JOptionPane.showMessageDialog(null, "Marca de avión registrada");

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

	public Brands searchBrand(String fileName, String elementType, String brandName) {

		Brands brand = null;

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

					if (eElement.getElementsByTagName("nameBrands").item(0).getTextContent().equals(brandName)) {
						brand = new Brands();
						brand.setName(eElement.getElementsByTagName("nameBrands").item(0).getTextContent());
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return brand;
	}

	public ArrayList<Brands> returnBrand(String fileName, String elementType) {
		ArrayList<Brands> arrayBrands = new ArrayList<>();

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
					Brands brand = new Brands();

					brand.setName(eElement.getElementsByTagName("nameBrands").item(0).getTextContent());
					arrayBrands.add(brand);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayBrands;
	}

	// Edita las marcas
	public void modifyBrand(String fileName, String elementType, String nameBrands, String newNameBrands) {
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
					String currentName = eElement.getElementsByTagName("nameBrands").item(0).getTextContent();

					if (currentName.equals(nameBrands)) {
						eElement.getElementsByTagName("nameBrands").item(0).setTextContent(newNameBrands);
						break; // Se encontró la marca, se sale del bucle
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

	public Brands deleteBrand(String fileName, String elementType, String nameBrand) {
		Brands brand = new Brands();

		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE && nNode.getNodeName().equals(elementType)) {
					Element eElement = (Element) nNode;
					NodeList nameList = eElement.getElementsByTagName("nameBrands");

					if (nameList != null && nameList.getLength() > 0) {
						Node nameNode = nameList.item(0);

						if (nameNode.getTextContent().trim().equalsIgnoreCase(nameBrand.trim())) {
							Node parent = eElement.getParentNode();
							parent.removeChild(eElement);

							TransformerFactory transformerFactory = TransformerFactory.newInstance();
							Transformer transformer = transformerFactory.newTransformer();
							DOMSource source = new DOMSource(doc);
							StreamResult result = new StreamResult(new File(fileName));
							transformer.transform(source, result);

							brand = new Brands();
							brand.setName(nameBrand);

							System.out.println("Marca eliminada exitosamente: " + nameBrand);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return brand;
	}

	public ArrayList<Brands> getBrandXML(String filename, String elementType) {
		ArrayList<Brands> arrayBrands = new ArrayList<>();

		try {
			File inputFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(elementType);

			for (int index = 0; index < nList.getLength(); index++) {
				Node nNode = nList.item(index);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Brands brand = new Brands();

					brand.setName(eElement.getElementsByTagName("nameBrands").item(0).getTextContent());
					arrayBrands.add(brand);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayBrands;
	}

//-----------------------------------------------------------------------------------------------------------------------------------------

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

//-----------------------------------------------------------------------------------------------------------------------------------------

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
						p.setCellphone(
								Integer.parseInt(eElement.getElementsByTagName("cellphone").item(0).getTextContent()));
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
	public void modifyPassenger(String filename, String elementType, int passportNum, String name, String lastName,
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

					if (Integer.parseInt(eElement.getAttribute("passportNum")) == passportNum) {
						// Modificar los elementos del pasajero
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

//-----------------------------------------------------------------------------------------------------------------------------------------

}
