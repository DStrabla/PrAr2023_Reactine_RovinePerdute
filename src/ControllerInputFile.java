import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ControllerInputFile {

    //Inizializzazione degli XMLStreamreader
    private static XMLInputFactory xmlif;
    private static XMLStreamReader xmlrMap5 = null;
    private static XMLStreamReader xmlrMap12 = null;
    private static XMLStreamReader xmlrMap50 = null;
    private static XMLStreamReader xmlrMap200 = null;
    private static XMLStreamReader xmlrMap2000 = null;
    private static XMLStreamReader xmlrMap10000 = null;

    //Path dei file
    private static String pathMap5 = "./Input_File/PgAr_Map_5.xml";
    private static String pathMap12 = "./Input_File/PgAr_Map_12.xml";
    private static String pathMap50 = "./Input_File/PgAr_Map_50.xml";
    private static String pathMap200 = "./Input_File/PgAr_Map_200.xml";
    private static String pathMap2000 = "./Input_File/PgAr_Map_2000.xml";
    private static String pathMap10000 = "./Input_File/PgAr_Map_10000.xml";

    //Metodi per stampare il contenuto dei file xml
    public static void stampaXmlMap5() throws XMLStreamException {

        {
            xmlif = XMLInputFactory.newInstance();
            try {
                xmlrMap12 = xmlif.createXMLStreamReader(pathMap12, new FileInputStream(pathMap12));
            } catch (XMLStreamException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while (xmlrMap12.hasNext()) { // continua a leggere finché ha eventi a disposizione
            switch (xmlrMap12.getEventType()) { // switch sul tipo di evento
                case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                    System.out.println("Start Read Doc " + pathMap12); break;
                case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                    System.out.println("Tag " + xmlrMap12.getLocalName());
                    for (int i = 0; i < xmlrMap12.getAttributeCount(); i++)
                        System.out.printf("    attributo: %s->%s%n", xmlrMap12.getAttributeLocalName(i), xmlrMap12.getAttributeValue(i));
                    break;
                case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                    System.out.println("END-Tag " + xmlrMap12.getLocalName()); break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("// commento " + xmlrMap12.getText()); break; // commento: ne stampa il contenuto
                case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                    if (xmlrMap12.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        System.out.println("-> " + xmlrMap12.getText());
                    break;
            }
            xmlrMap12.next();
        }
    }
    public static void stampaXmlMap12() throws XMLStreamException {

        {
            xmlif = XMLInputFactory.newInstance();
            try {
                xmlrMap12 = xmlif.createXMLStreamReader(pathMap12, new FileInputStream(pathMap12));
            } catch (XMLStreamException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while (xmlrMap12.hasNext()) { // continua a leggere finché ha eventi a disposizione
            switch (xmlrMap12.getEventType()) { // switch sul tipo di evento
                case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                    System.out.println("Start Read Doc " + pathMap12); break;
                case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                    System.out.println("Tag " + xmlrMap12.getLocalName());
                    for (int i = 0; i < xmlrMap12.getAttributeCount(); i++)
                        System.out.printf("    attributo: %s->%s%n", xmlrMap12.getAttributeLocalName(i), xmlrMap12.getAttributeValue(i));
                    break;
                case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                    System.out.println("END-Tag " + xmlrMap12.getLocalName()); break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("// commento " + xmlrMap12.getText()); break; // commento: ne stampa il contenuto
                case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                    if (xmlrMap12.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        System.out.println("-> " + xmlrMap12.getText());
                    break;
            }
            xmlrMap12.next();
        }
    }
    public static void stampaXmlMap50() throws XMLStreamException {

        {
            xmlif = XMLInputFactory.newInstance();
            try {
                xmlrMap50 = xmlif.createXMLStreamReader(pathMap50, new FileInputStream(pathMap50));
            } catch (XMLStreamException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while (xmlrMap50.hasNext()) { // continua a leggere finché ha eventi a disposizione
            switch (xmlrMap50.getEventType()) { // switch sul tipo di evento
                case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                    System.out.println("Start Read Doc " + pathMap50); break;
                case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                    System.out.println("Tag " + xmlrMap50.getLocalName());
                    for (int i = 0; i < xmlrMap50.getAttributeCount(); i++)
                        System.out.printf("    attributo: %s->%s%n", xmlrMap50.getAttributeLocalName(i), xmlrMap50.getAttributeValue(i));
                    break;
                case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                    System.out.println("END-Tag " + xmlrMap50.getLocalName()); break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("// commento " + xmlrMap50.getText()); break; // commento: ne stampa il contenuto
                case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                    if (xmlrMap50.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        System.out.println("-> " + xmlrMap50.getText());
                    break;
            }
            xmlrMap50.next();
        }
    }
    public static void stampaXmlMap200() throws XMLStreamException {

        {
            xmlif = XMLInputFactory.newInstance();
            try {
                xmlrMap200 = xmlif.createXMLStreamReader(pathMap200, new FileInputStream(pathMap200));
            } catch (XMLStreamException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while (xmlrMap200.hasNext()) { // continua a leggere finché ha eventi a disposizione
            switch (xmlrMap200.getEventType()) { // switch sul tipo di evento
                case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                    System.out.println("Start Read Doc " + pathMap200); break;
                case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                    System.out.println("Tag " + xmlrMap200.getLocalName());
                    for (int i = 0; i < xmlrMap200.getAttributeCount(); i++)
                        System.out.printf("    attributo: %s->%s%n", xmlrMap200.getAttributeLocalName(i), xmlrMap200.getAttributeValue(i));
                    break;
                case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                    System.out.println("END-Tag " + xmlrMap200.getLocalName()); break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("// commento " + xmlrMap200.getText()); break; // commento: ne stampa il contenuto
                case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                    if (xmlrMap200.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        System.out.println("-> " + xmlrMap200.getText());
                    break;
            }
            xmlrMap200.next();
        }
    }
    public static void stampaXmlMap2000() throws XMLStreamException {

        {
            xmlif = XMLInputFactory.newInstance();
            try {
                xmlrMap2000 = xmlif.createXMLStreamReader(pathMap2000, new FileInputStream(pathMap2000));
            } catch (XMLStreamException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while (xmlrMap2000.hasNext()) { // continua a leggere finché ha eventi a disposizione
            switch (xmlrMap2000.getEventType()) { // switch sul tipo di evento
                case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                    System.out.println("Start Read Doc " + pathMap2000); break;
                case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                    System.out.println("Tag " + xmlrMap2000.getLocalName());
                    for (int i = 0; i < xmlrMap2000.getAttributeCount(); i++)
                        System.out.printf("    attributo: %s->%s%n", xmlrMap2000.getAttributeLocalName(i), xmlrMap2000.getAttributeValue(i));
                    break;
                case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                    System.out.println("END-Tag " + xmlrMap2000.getLocalName()); break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("// commento " + xmlrMap2000.getText()); break; // commento: ne stampa il contenuto
                case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                    if (xmlrMap2000.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        System.out.println("-> " + xmlrMap2000.getText());
                    break;
            }
            xmlrMap2000.next();
        }
    }
    public static void stampaXmlMap10000() throws XMLStreamException {

        {
            xmlif = XMLInputFactory.newInstance();
            try {
                xmlrMap10000 = xmlif.createXMLStreamReader(pathMap10000, new FileInputStream(pathMap10000));
            } catch (XMLStreamException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while (xmlrMap10000.hasNext()) { // continua a leggere finché ha eventi a disposizione
            switch (xmlrMap10000.getEventType()) { // switch sul tipo di evento
                case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                    System.out.println("Start Read Doc " + pathMap10000); break;
                case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                    System.out.println("Tag " + xmlrMap10000.getLocalName());
                    for (int i = 0; i < xmlrMap10000.getAttributeCount(); i++)
                        System.out.printf("    attributo: %s->%s%n", xmlrMap10000.getAttributeLocalName(i), xmlrMap10000.getAttributeValue(i));
                    break;
                case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                    System.out.println("END-Tag " + xmlrMap10000.getLocalName()); break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("// commento " + xmlrMap10000.getText()); break; // commento: ne stampa il contenuto
                case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                    if (xmlrMap10000.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        System.out.println("-> " + xmlrMap10000.getText());
                    break;
            }
            xmlrMap10000.next();
        }
    }
}
