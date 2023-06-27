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

import domain.Tickets;

public class FilesTicketsXML {

	public FilesTicketsXML() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Tickets> returnTickets(String Filename, String elementType) {
		ArrayList<Tickets> arrayTickets = new ArrayList<>();

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
					Tickets ticket = new Tickets();
					ticket.setTicketNum(Integer.parseInt(eElement.getAttribute("ticketNum")));
					ticket.setPassportNum(Integer.parseInt(eElement.getElementsByTagName("passportNum").item(0).getTextContent()));
					ticket.setFlightNum(Integer.parseInt(eElement.getElementsByTagName("flightNum").item(0).getTextContent()));
					
					arrayTickets.add(ticket);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayTickets;
	}
	
	// Escribe el XML del Ticket
		public void writeTicketXML(String FileName, String elementType, String[] dataName, String[] data) {

			boolean ticketExist = ticketExistOnXML(FileName, elementType, dataName[0], Integer.parseInt(data[0]));

			if (ticketExist == true) {

				JOptionPane.showMessageDialog(null, "El ticket ya existe en el sistema");
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

				JOptionPane.showMessageDialog(null, "Ticket registrado");

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
		// Método para saber si el numero de ticket existe en el XML
		public boolean ticketExistOnXML(String fileName, String elementType, String attributeName, int ticketNum) {
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
						if (attribute == ticketNum) {
							return true;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
		}
		//Busca el ticket por su numero
		public Tickets searchTicket(String Filename, String elementType, int ticketNum) {

			Tickets t = new Tickets();

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

						if (Integer.parseInt(eElement.getAttribute("ticketNum")) == ticketNum) {
							t = new Tickets();
							t.setTicketNum(Integer.parseInt(eElement.getAttribute("ticketNum")));
							t.setPassportNum(Integer.parseInt(eElement.getElementsByTagName("passportNum").item(0).getTextContent()));
							t.setFlightNum(Integer.parseInt(eElement.getElementsByTagName("flightNum").item(0).getTextContent()));
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return t;
		}
		
		// Método que elimina al ticket dentro del XML
		public Tickets searchTicketAndDelete(String Filename, String elementType, int ticketNum) {
			Tickets t = null;

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

						if (Integer.parseInt(eElement.getAttribute("ticketNum")) == ticketNum) {
							System.out.println("Encontre el numero de ticket");

							eElement.removeAttribute("ticketNum");
							eElement.getParentNode().removeChild(eElement);

							TransformerFactory transformerFactory = TransformerFactory.newInstance();
							Transformer transformer = transformerFactory.newTransformer();
							DOMSource source = new DOMSource(doc);
							StreamResult result = new StreamResult(new File(Filename));
							transformer.transform(source, result);

							t = new Tickets();
							t.setTicketNum(ticketNum);

							// Validaciones que verifican si los nodos hijos existen antes de acceder al
							// contenido
							if (eElement.getElementsByTagName("passportNum").getLength() > 0) {
								t.setPassportNum(Integer.parseInt(eElement.getElementsByTagName("passportNum").item(0).getTextContent()));
							}
							if (eElement.getElementsByTagName("flightNum").getLength() > 0) {
								t.setFlightNum(Integer.parseInt(eElement.getElementsByTagName("flightNum").item(0).getTextContent()));
							}
							

							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return t;
		}
		
		// Método para modificar el Ticket
		public void modifyTicket(String filename, String elementType,Object ticketNumOriginal, int ticketNum, int passportNum, int flightNum) {
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

						if (eElement.getAttribute("ticketNum").equals(String.valueOf(ticketNumOriginal))) {
							// Modificar los elementos del ticket
							System.out.println("Entre a modificar la ostia");
							eElement.setAttribute("ticketNum", String.valueOf(ticketNum));
							eElement.getElementsByTagName("passportNum").item(0).setTextContent(String.valueOf(passportNum));
							eElement.getElementsByTagName("flightNum").item(0).setTextContent(String.valueOf(flightNum));
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

}
