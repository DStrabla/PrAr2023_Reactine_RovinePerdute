import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ControllerInputFile {

    //Inizializzazione degli XMLStreamreader
    private static XMLInputFactory xmlif;
    private static XMLStreamReader xmlrMap = null;

    static Mappa mappa;

    //Path dei file
    private static String pathMap5 = "./Input_File/PgAr_Map_5.xml";
    private static String pathMap12 = "./Input_File/PgAr_Map_12.xml";
    private static String pathMap50 = "./Input_File/PgAr_Map_50.xml";
    private static String pathMap200 = "./Input_File/PgAr_Map_200.xml";
    private static String pathMap2000 = "./Input_File/PgAr_Map_2000.xml";
    private static String pathMap10000 = "./Input_File/PgAr_Map_10000.xml";

    //Metodi per stampare il contenuto dei file xml
    public static void leggiXML(int n) throws XMLStreamException {
        int id= 0;
        String nome= null;
        int x= 0;
        int y= 0;
        int h= 0;
        ArrayList<Integer> link =new ArrayList();
        ArrayList<Citta> cittas= new ArrayList();
        String nome_att;

        xmlif = XMLInputFactory.newInstance();
        try {
            switch (n) {
                case 1: xmlrMap = xmlif.createXMLStreamReader(pathMap5, new FileInputStream(pathMap5));
                    break;
                case 2: xmlrMap = xmlif.createXMLStreamReader(pathMap12, new FileInputStream(pathMap12));
                    break;
                case 3: xmlrMap = xmlif.createXMLStreamReader(pathMap50, new FileInputStream(pathMap50));
                    break;
                case 4: xmlrMap = xmlif.createXMLStreamReader(pathMap200, new FileInputStream(pathMap200));
                    break;
                case 5: xmlrMap = xmlif.createXMLStreamReader(pathMap2000, new FileInputStream(pathMap2000));
                    break;
                case 6: xmlrMap = xmlif.createXMLStreamReader(pathMap10000, new FileInputStream(pathMap10000));
                    break;
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        while (xmlrMap.hasNext()) { // continua a leggere finché ha eventi a disposizione
            switch (xmlrMap.getEventType()) { // switch sul tipo di evento
                case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                    //System.out.println("Start Read Doc " + pathMap5);
                    break;
                case XMLStreamConstants.START_ELEMENT://iniziodiunelemento:stampailnomedeltageisuoiattributi

                    for(int i = 0; i< xmlrMap.getAttributeCount(); i++){
                        if(xmlrMap.getLocalName().equals("city")) {
                            nome_att = xmlrMap.getAttributeLocalName(i);
                            switch (nome_att) {
                                case "id":
                                    id = Integer.parseInt(xmlrMap.getAttributeValue(i));
                                    break;

                                case "name":
                                    nome = xmlrMap.getAttributeValue(i);
                                    break;

                                case "x":
                                    x = Integer.parseInt(xmlrMap.getAttributeValue(i));
                                    break;

                                case "y":
                                    y = Integer.parseInt(xmlrMap.getAttributeValue(i));
                                    break;

                                case "h":
                                    h = Integer.parseInt(xmlrMap.getAttributeValue(i));
                                    break;
                            }
                        }
                        if(xmlrMap.getLocalName().equals("link")){
                            link.add(Integer.parseInt(xmlrMap.getAttributeValue(i)));
                        }
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                    if(xmlrMap.getLocalName().equals("city")){
                        Citta citta=new Citta(id, nome, x, y, h, link);
                        cittas.add(citta);
                        link=new ArrayList<Integer>();
                    } else if (xmlrMap.getLocalName().equals("map")){
                        mappa=new Mappa(cittas);
                        link=new ArrayList<Integer>();
                        mappa.calcoloPesi(mappa);
                        //mappa.printMappa(mappa);
                    }
                    break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("// commento " + xmlrMap.getText()); break; // commento: ne stampa il contenuto
                case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                    if (xmlrMap.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        System.out.println("-> " + xmlrMap.getText());
                    break;
            }
            xmlrMap.next();
        }
    }


}