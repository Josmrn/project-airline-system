package data;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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

import domain.Flights;


public class FilesFlightXML {

	public FilesFlightXML() {}
	
	public boolean dataExistOnXML(String fileName, String elementType, String attributeName, int numFlight) {
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
					if (attribute == numFlight) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void writeFlightXML(String fileName, String elementType, String[] dataName, String[] data) {
		boolean modelExist = dataExistOnXML(fileName, elementType, dataName[0], Integer.parseInt(data[0]));

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

			JOptionPane.showMessageDialog(null, "Vuelo registrado");

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
	
	public ArrayList<Flights> getFlights(String fileName, String elementType) {
		ArrayList<Flights> arrayFlight = new ArrayList<>();

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
					Flights f = new Flights();
					f.setFlightNum(Integer.parseInt(eElement.getAttribute("flightNum")));
					f.setDepartureCity(eElement.getElementsByTagName("departureCity").item(0).getTextContent());
					f.setDepartureDate(parseDate(eElement.getElementsByTagName("departureDate").item(0).getTextContent()));
					f.setDepartureHour(parseTime(eElement.getElementsByTagName("departureHour").item(0).getTextContent()));
					f.setPlane(eElement.getElementsByTagName("plane").item(0).getTextContent());
					f.setArrivalCity(eElement.getElementsByTagName("arrivalCity").item(0).getTextContent());
					f.setArrivalDate(parseDate(eElement.getElementsByTagName("arrivalDate").item(0).getTextContent()));
					f.setArrivalHour(parseTime(eElement.getElementsByTagName("arrivalHour").item(0).getTextContent()));
					f.setAmountOfExecSeat(Integer.parseInt(eElement.getElementsByTagName("amountOfExecSeat").item(0).getTextContent()));
					f.setAmountOfTourSeat(Integer.parseInt(eElement.getElementsByTagName("amountOfTourSeat").item(0).getTextContent()));
					f.setAmountOfEcoSeat(Integer.parseInt(eElement.getElementsByTagName("amountOfEcoSeat").item(0).getTextContent()));

					arrayFlight.add(f);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayFlight;
	}
	
	public Flights searchFlight(String Filename, String elementType, int numFlight) {
	    Flights f = null;

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

	                if (Integer.parseInt(eElement.getAttribute("flightNum")) == numFlight) {
	                    f = new Flights();
	                    f.setFlightNum(Integer.parseInt(eElement.getAttribute("flightNum")));
	                    f.setDepartureCity(eElement.getElementsByTagName("departureCity").item(0).getTextContent());
	                    f.setDepartureDate(parseDate(eElement.getElementsByTagName("departureDate").item(0).getTextContent()));
	                    f.setDepartureHour(parseTime(eElement.getElementsByTagName("departureHour").item(0).getTextContent()));
	                    
	                    // Verifica si los elementos de llegada existen antes de asignarlos
	                    if (eElement.getElementsByTagName("arrivalDate").getLength() > 0) {
	                        f.setArrivalDate(parseDate(eElement.getElementsByTagName("arrivalDate").item(0).getTextContent()));
	                    }
	                    if (eElement.getElementsByTagName("arrivalHour").getLength() > 0) {
	                        f.setArrivalHour(parseTime(eElement.getElementsByTagName("arrivalHour").item(0).getTextContent()));
	                    }
	                    
	                    f.setPlane(eElement.getElementsByTagName("plane").item(0).getTextContent());
	                    f.setArrivalCity(eElement.getElementsByTagName("arrivalCity").item(0).getTextContent());
	                    f.setAmountOfExecSeat(Integer.parseInt(eElement.getElementsByTagName("amountOfExecSeat").item(0).getTextContent()));
	                    f.setAmountOfTourSeat(Integer.parseInt(eElement.getElementsByTagName("amountOfTourSeat").item(0).getTextContent()));
	                    f.setAmountOfEcoSeat(Integer.parseInt(eElement.getElementsByTagName("amountOfEcoSeat").item(0).getTextContent()));
	                    break;
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return f;
	}

	private LocalDate parseDate(String date) {
	    String[] parts = date.split("-");
	    int year = Integer.parseInt(parts[0]);
	    int month = Integer.parseInt(parts[1]);
	    int day = Integer.parseInt(parts[2]);
	    return LocalDate.of(year, month, day);
	}

	private LocalTime parseTime(String time) {
	    String[] parts = time.split(":");
	    int hour = Integer.parseInt(parts[0]);
	    int minute = Integer.parseInt(parts[1]);
	    return LocalTime.of(hour, minute);
	}
}
