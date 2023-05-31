import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class CompilatoreOutputFile {
    //Inizializzazione per l'output
    static XMLOutputFactory xmlof;
    static XMLStreamWriter xmlwPercorso = null;

    //Percorso del file di output
    static String pathPercorso = "./Output_File/Percorso.xml";

    public static void Output(List<List<Integer>> routes, double costoCarburanteTonathiu, double costoCarburanteMetztli){
        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlwPercorso = xmlof.createXMLStreamWriter(new FileOutputStream(pathPercorso), "utf-8");
            xmlwPercorso.writeStartDocument("utf-8", "1.0");
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println("Errore nell'inizializzazione del writer:");
            System.out.println(e.getMessage());
        }

        try { // blocco try per raccogliere eccezioni

            xmlwPercorso.writeCharacters("\n"); //Per andare a capo
            xmlwPercorso.writeStartElement("routes"); // scrittura del tag radice <routes>
            for (int i = 0; i < 2; i++) {
                if (i==0){
                    xmlwPercorso.writeCharacters("\n\t\t");
                    xmlwPercorso.writeStartElement("route"); // scrittura del tag route...
                    xmlwPercorso.writeAttribute("team", "Tonathiu"); // scrittura dell'attributo team
                    xmlwPercorso.writeAttribute("\tcost", Double.toString(costoCarburanteTonathiu));
                    xmlwPercorso.writeAttribute("\tcities", String.valueOf(routes.get(0).size()));

                    for (int j = 0; j < routes.get(0).size(); j++) {
                        xmlwPercorso.writeCharacters("\n\t\t\t");
                        xmlwPercorso.writeStartElement("city");
                        xmlwPercorso.writeCharacters("  id="+
                                ControllerInputFile.mappa.getCittas().get(routes.get(0).get(j)).getId());
                        xmlwPercorso.writeCharacters("   name="+
                                ControllerInputFile.mappa.getCittas().get(routes.get(0).get(j)).getNome()+" ");
                        xmlwPercorso.writeEndElement(); // chiusura di </city>
                    }
                    xmlwPercorso.writeCharacters("\n\t\t");
                    xmlwPercorso.writeEndElement(); //chiusura di </route>
                }

                else {
                    xmlwPercorso.writeCharacters("\n\t\t");
                    xmlwPercorso.writeStartElement("route"); // scrittura del tag route...
                    xmlwPercorso.writeAttribute("team", "Metztli"); // scrittura dell'attributo team
                    xmlwPercorso.writeAttribute("\tcost", Double.toString(costoCarburanteMetztli));
                    xmlwPercorso.writeAttribute("\tcities", String.valueOf(routes.get(1).size()));

                    for (int j = 0; j < routes.get(1).size(); j++) {
                        xmlwPercorso.writeCharacters("\n\t\t\t");
                        xmlwPercorso.writeStartElement("city");
                        xmlwPercorso.writeCharacters("  id="+
                                ControllerInputFile.mappa.getCittas().get(routes.get(1).get(j)).getId());
                        xmlwPercorso.writeCharacters("   name="+
                                ControllerInputFile.mappa.getCittas().get(routes.get(1).get(j)).getNome()+" ");
                        xmlwPercorso.writeEndElement(); // chiusura di </city>
                    }
                    xmlwPercorso.writeCharacters("\n\t\t");
                    xmlwPercorso.writeEndElement(); //chiusura di </route>
                }

            }
            xmlwPercorso.writeCharacters("\n");

            xmlwPercorso.writeEndElement(); //chiusura di </routes>

            xmlwPercorso.writeEndDocument(); // scrittura della fine del documento
            xmlwPercorso.flush(); // svuota il buffer e procede alla scrittura
            xmlwPercorso.close(); // chiusura del documento e delle risorse impiegate

        } catch (Exception e) { // se c’è un errore viene eseguita questa parte
            System.out.println("Errore nella scrittura");
        }
    }
}
