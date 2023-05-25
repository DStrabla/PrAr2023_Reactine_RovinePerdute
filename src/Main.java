import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws XMLStreamException {

        //Inizializzazione degli XMLStreamreader
        XMLInputFactory xmlif;
        XMLStreamReader xmlrMap5 = null;
        XMLStreamReader xmlrMap12 = null;
        XMLStreamReader xmlrMap50 = null;
        XMLStreamReader xmlrMap200 = null;
        XMLStreamReader xmlrMap2000 = null;
        XMLStreamReader xmlrMap10000 = null;

        //Path dei file
        String pathMap5 = "./Input_File/PgAr_Map_5.xml";
        String pathMap12 = "./Input_File/PgAr_Map_12.xml";
        String pathMap50 = "./Input_File/PgAr_Map_50.xml";
        String pathMap200 = "./Input_File/PgAr_Map_200.xml";
        String pathMap2000 = "./Input_File/PgAr_Map_2000.xml";
        String pathMap10000 = "./Input_File/PgAr_Map_10000.xml";


        //Inizializzazione per l'input
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlrMap5 = xmlif.createXMLStreamReader(pathMap5, new FileInputStream(pathMap5));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlrMap12 = xmlif.createXMLStreamReader(pathMap12, new FileInputStream(pathMap12));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlrMap50 = xmlif.createXMLStreamReader(pathMap50, new FileInputStream(pathMap50));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlrMap200 = xmlif.createXMLStreamReader(pathMap200, new FileInputStream(pathMap200));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlrMap2000 = xmlif.createXMLStreamReader(pathMap2000, new FileInputStream(pathMap2000));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        while (xmlrMap5.hasNext()) { // continua a leggere finché ha eventi a disposizione
            switch (xmlrMap5.getEventType()) { // switch sul tipo di evento
                case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                    System.out.println("Start Read Doc " + pathMap5); break;
                case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                    System.out.println("Tag " + xmlrMap5.getLocalName());
                    for (int i = 0; i < xmlrMap5.getAttributeCount(); i++)
                        System.out.printf("    attributo: %s->%s%n", xmlrMap5.getAttributeLocalName(i), xmlrMap5.getAttributeValue(i));
                    break;
                case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                    System.out.println("END-Tag " + xmlrMap5.getLocalName()); break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("// commento " + xmlrMap5.getText()); break; // commento: ne stampa il contenuto
                case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                    if (xmlrMap5.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        System.out.println("-> " + xmlrMap5.getText());
                    break;
            }
            xmlrMap5.next();
        }



        //Ciao
        //Inizializzazione per l'output
        XMLOutputFactory xmlof;
        XMLStreamWriter xmlw = null;

        //Percorso del file di output
        String pathOutput = "./Output_File/Percorso.xml";

        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(pathOutput), "utf-8");
            xmlw.writeStartDocument("utf-8", "1.0");
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del writer:");
            System.out.println(e.getMessage());
        }
    }
}