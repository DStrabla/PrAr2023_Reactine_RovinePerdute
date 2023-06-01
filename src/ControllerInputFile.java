import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ControllerInputFile {

    public static final String TAG_CITY = "city";
    public static final String TAG_LINK = "link";
    public static final String TAG_MAP = "map";
    public static final String CASE_ID = "id";
    public static final String CASE_NAME = "name";
    public static final String CASE_X = "x";
    public static final String CASE_Y = "y";
    public static final String CASE_H = "h";
    public static final String ELABORAZIONE_IN_CORSO = "Elaborazione in corso...";
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

    /**
     * Scelta e lettura del file XML; creazione della mappa con tutti i dati relativi alle città che la compongono
     * @param n
     * @throws XMLStreamException
     */
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
                    System.out.println(ELABORAZIONE_IN_CORSO);
                    break;
                case XMLStreamConstants.START_ELEMENT://iniziodiunelemento:stampailnomedeltageisuoiattributi

                    //for per leggere gli attributi delle città e uno switch per distinguere l'informazione letta e
                    //inserirne il valore all'interno di una variabile temporanea che sarà poi utilizzata per
                    //istanziare la nuova città
                    for(int i = 0; i< xmlrMap.getAttributeCount(); i++){
                        if(xmlrMap.getLocalName().equals(TAG_CITY)) { //if per verificare che il tag in lettura corrisponda a city
                            nome_att = xmlrMap.getAttributeLocalName(i);
                            switch (nome_att) {
                                case CASE_ID: //se il nome dell'attributo corrisponde ad id, ne viene assegnato il valore alla relativa variabile temporanea
                                    id = Integer.parseInt(xmlrMap.getAttributeValue(i));
                                    break;

                                case CASE_NAME: //se il nome dell'attributo corrisponde a name, ne viene assegnato il valore alla relativa variabile temporanea
                                    nome = xmlrMap.getAttributeValue(i);
                                    break;

                                case CASE_X: //se il nome dell'attributo corrisponde ad x, ne viene assegnato il valore alla relativa variabile temporanea
                                    x = Integer.parseInt(xmlrMap.getAttributeValue(i));
                                    break;

                                case CASE_Y: //se il nome dell'attributo corrisponde ad y, ne viene assegnato il valore alla relativa variabile temporanea
                                    y = Integer.parseInt(xmlrMap.getAttributeValue(i));
                                    break;

                                case CASE_H: //se il nome dell'attributo corrisponde ad h, ne viene assegnato il valore alla relativa variabile temporanea
                                    h = Integer.parseInt(xmlrMap.getAttributeValue(i));
                                    break;
                            }
                        }
                        if(xmlrMap.getLocalName().equals(TAG_LINK)){ //if per verificare che il tag in lettura corrisponda a link
                            link.add(Integer.parseInt(xmlrMap.getAttributeValue(i))); //si aggiungono i link all'Array temporaneo che verra poi usato per istanziare la citta
                        }
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso

                    //if per istanziare la citta alla chiusura del relativo tag, aggiungendola nel temporaneo Arraylist
                    //che servirà a istanziare la mappa
                    if(xmlrMap.getLocalName().equals(TAG_CITY)){
                        Citta citta=new Citta(id, nome, x, y, h, link);
                        cittas.add(citta);
                        link=new ArrayList<Integer>();
                    } else if (xmlrMap.getLocalName().equals(TAG_MAP)){//creazione della mappa alla chiusura del relativo tag
                        mappa=new Mappa(cittas);
                        link=new ArrayList<Integer>();
                        mappa.calcoloPesi(mappa);
                    }
                    break;
                case XMLStreamConstants.COMMENT:
                    break;
                case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                    if (xmlrMap.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        System.out.println("-> " + xmlrMap.getText());
                    break;
            }
            xmlrMap.next();
        }
    }


}