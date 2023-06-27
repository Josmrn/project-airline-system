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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.Brands;

public class FilesBrandsXML {

	public FilesBrandsXML() {
		// TODO Auto-generated constructor stub
	}

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
}
