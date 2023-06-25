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

import domain.Users;

public class FilesLoginXML {

	public FilesLoginXML() {
		// TODO Auto-generated constructor stub
	}
	
	// Lee el XML del usuario
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
						System.out.println("Contraseña: " + eElement.getElementsByTagName("password").item(0).getTextContent());
						System.out.println("Tipo de Usuario: " + eElement.getElementsByTagName("typeUser").item(0).getTextContent());
						System.out.println("Estado: " + eElement.getElementsByTagName("state").item(0).getTextContent());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	// Escribe el XML del login
		public void writeLoginXML(String FileName, String elementType, String[] dataName, String[] data) {

			boolean userExist = userExistOnXML(FileName, elementType, dataName[0], data[0]);

			if (userExist && (data[0] == "admin")) {

				return; // Detener la ejecución del método writeXML
			}
			if (userExist && (data[0] != "admin")) {
				JOptionPane.showMessageDialog(null, "El usuario ya existe en el sistema");
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
		public Users searchUserAndDelete(String Filename, String elementType, String username) {
		    Users u = null;

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

		                if (eElement.getAttribute("user").equals(username)) {

		                    // Eliminar el atributo "user"
		                    eElement.removeAttribute("user");

		                    // Eliminar el elemento "User" completo
		                    eElement.getParentNode().removeChild(eElement);

		                    // Guardar los cambios en el archivo
		                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
		                    Transformer transformer = transformerFactory.newTransformer();
		                    DOMSource source = new DOMSource(doc);
		                    StreamResult result = new StreamResult(new File(Filename));
		                    transformer.transform(source, result);

		                    u = new Users();
		                    u.setUser(username);

		                    // Verificar si los nodos hijos existen antes de acceder a su contenido
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

		
		//Método que busca los datos en el archivo xml de usuarios (funcionando)
		public Users searchUsers(String Filename, String elementType, String user) {
			
		    Users u = null;

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

		                if (eElement.getAttribute("user").equals(user)) {
		                    u = new Users();
		                    u.setUser(eElement.getAttribute("user"));
		                    u.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
		                    u.setTypeUser(eElement.getElementsByTagName("typeUser").item(0).getTextContent());
		                    u.setState(eElement.getElementsByTagName("state").item(0).getTextContent());
		                    break;
		                }
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return u;
		}

		public ArrayList<Users> returnUsers(String Filename, String elementType) {
		    ArrayList<Users> arrayUsers = new ArrayList<>();

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



		public String readXMLToString(String Filename, String elementType) {

			String Data = "";

			try {

				File inputFile = new File(Filename);
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
							String passwordValue = element.getElementsByTagName("password").item(0)
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

		// Método para verificar el tipo de usuario y el estado
		public String[] returnTypeAndStatus(String FileName, String elementType, String username, String password) {

			String[] userTypeAndStatus = { "", ""};

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
							System.out.println(element.getAttribute("user"));
							System.out.println(element.getElementsByTagName("password").item(0).getTextContent());
							String userValue = element.getAttribute("user");
							
							String passwordValue = element.getElementsByTagName("password").item(0).getTextContent();
							

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
		
		//Método para modificarme el usuario
		public void modifyUser(String filename, String elementType, String username, String password, String typeUser, String statusUser) {
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

		                if (eElement.getAttribute("user").equals(username)) {
		                    // Modificar los elementos del usuario
		                    eElement.getElementsByTagName("password").item(0).setTextContent(password);
		                    eElement.getElementsByTagName("typeUser").item(0).setTextContent(typeUser);
		                    eElement.getElementsByTagName("state").item(0).setTextContent(statusUser);
		                }
		            }
		        }

		        // Guardar los cambios en el archivo
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
