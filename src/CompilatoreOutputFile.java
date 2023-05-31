import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class CompilatoreOutputFile {

    public static final String SPACE = "\n";
    public static final String ROUTES = "routes";
    public static final String A_CAPO = "\n\t\t";
    public static final String ROUTE = "route";
    public static final String TEAM = "team";
    public static final String TONATHIU = "Tonathiu";
    public static final String COST = "\tcost";
    public static final String CITIES = "\tcities";
    public static final String A_CAPO_PT2 = "\n\t\t\t";
    public static final String CITY = "city";
    public static final String ID = "  id=";
    public static final String NAME = "   name=";
    public static final String METZTLI = "Metztli";
    public static final String ERRORE = "Errore nell'inizializzazione del writer:";
    public static final String UTF_8 = "utf-8";
    public static final String VERSION = "1.0";
    public static final int INDEX_0 = 0;
    public static final int INDEX_1 = 1;
    public static final String ERRORE_PT2 = "Errore nella scrittura";

    //Inizializzazione per l'output
    static XMLOutputFactory xmlof;
    static XMLStreamWriter xmlwPercorso = null;

    //Percorso del file di output
    static String pathPercorso = "./Output_File/Percorso.xml";

    /**
     * Metodo che permette di compilere il file di output xml e
     * viene compilato con le seguente struttura:
     *
     * <routes>
     *      <route team="Tonathiu   cost="carburante_utilizzato   cities="numero_città_toccate">
     *          <city id="--" name="--"/>
     *          <city id="--" name="--"/>
     *          <city id="--" name="--"/>
     *          . . .
     *      </route>
     *      <route team="Metztli"   cost="carburante_utilizzato"  cities="numero_città_toccate">
     *          <city id="--" name="--"/>
     *          <city id="--" name="--"/>
     *          <city id="--" name="--"/>
     *          . . .
     *      </route>
     * </routes>
     *
     * @param routes ArrayList che contiene 2 percorsi, il percorso del mezzo Tonathiu e del mezzo Metztli
     * @param costoCarburanteTonathiu Parametro passato che contiene il peso totale degli archi
     *                                percorsi dal mezzo Tonathiu
     * @param costoCarburanteMetztli Parametro passato che contiene il peso totale degli archi
     *                               percorsi dal mezzo Metztli
     */
    public static void Output(List<List<Integer>> routes, double costoCarburanteTonathiu, double costoCarburanteMetztli){

        //Inizializzazione per l'output
        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlwPercorso = xmlof.createXMLStreamWriter(new FileOutputStream(pathPercorso), UTF_8);
            xmlwPercorso.writeStartDocument(UTF_8, VERSION);
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println(ERRORE);
            System.out.println(e.getMessage());
        }

        // blocco try per raccogliere eccezioni
        try {
            xmlwPercorso.writeCharacters(SPACE); //Per andare a capo
            xmlwPercorso.writeStartElement(ROUTES); // scrittura del tag radice <routes>
            for (int i = 0; i < routes.size(); i++) {
                if (i==0){
                    xmlwPercorso.writeCharacters(A_CAPO);
                    xmlwPercorso.writeStartElement(ROUTE); // scrittura del tag route...
                    xmlwPercorso.writeAttribute(TEAM, TONATHIU); // scrittura dell'attributo team
                    xmlwPercorso.writeAttribute(COST, Double.toString(costoCarburanteTonathiu));
                    xmlwPercorso.writeAttribute(CITIES, String.valueOf(routes.get(INDEX_0).size()));

                    for (int j = 0; j < routes.get(0).size(); j++) {
                        xmlwPercorso.writeCharacters(A_CAPO_PT2);
                        xmlwPercorso.writeStartElement(CITY);
                        xmlwPercorso.writeCharacters(ID +
                                ControllerInputFile.mappa.getCittas().get(routes.get(INDEX_0).get(j)).getId());
                        xmlwPercorso.writeCharacters(NAME +
                                ControllerInputFile.mappa.getCittas().get(routes.get(INDEX_0).get(j)).getNome()+" ");
                        xmlwPercorso.writeEndElement(); // chiusura di </city>
                    }
                    xmlwPercorso.writeCharacters(A_CAPO);
                    xmlwPercorso.writeEndElement(); //chiusura di </route>
                }

                else {
                    xmlwPercorso.writeCharacters(A_CAPO);
                    xmlwPercorso.writeStartElement(ROUTE); // scrittura del tag route...
                    xmlwPercorso.writeAttribute(TEAM, METZTLI); // scrittura dell'attributo team
                    xmlwPercorso.writeAttribute(COST, Double.toString(costoCarburanteMetztli));
                    xmlwPercorso.writeAttribute(CITIES, String.valueOf(routes.get(INDEX_1).size()));

                    for (int j = 0; j < routes.get(1).size(); j++) {
                        xmlwPercorso.writeCharacters(A_CAPO_PT2);
                        xmlwPercorso.writeStartElement(CITY);
                        xmlwPercorso.writeCharacters(ID +
                                ControllerInputFile.mappa.getCittas().get(routes.get(INDEX_1).get(j)).getId());
                        xmlwPercorso.writeCharacters(NAME +
                                ControllerInputFile.mappa.getCittas().get(routes.get(INDEX_1).get(j)).getNome()+" ");
                        xmlwPercorso.writeEndElement(); // chiusura di </city>
                    }
                    xmlwPercorso.writeCharacters(A_CAPO);
                    xmlwPercorso.writeEndElement(); //chiusura di </route>
                }

            }
            xmlwPercorso.writeCharacters(SPACE);

            xmlwPercorso.writeEndElement(); //chiusura di </routes>

            xmlwPercorso.writeEndDocument(); // scrittura della fine del documento
            xmlwPercorso.flush(); // svuota il buffer e procede alla scrittura
            xmlwPercorso.close(); // chiusura del documento e delle risorse impiegate

        } catch (Exception e) { // se c’è un errore viene eseguita questa parte
            System.out.println(ERRORE_PT2);
        }
    }
}
