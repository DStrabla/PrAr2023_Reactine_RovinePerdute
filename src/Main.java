import javax.xml.stream.*;
import java.io.FileOutputStream;
import it.kibo.fp.lib.* ;

public class Main {

    public static final String SALUTI = "Allora fottiti";

    public static void main(String[] args) throws XMLStreamException {

        Menu menu = new Menu("Seleziona la mappa da usare", new String[]{
                "Map 5",
                "Map 12",
                "Map 50",
                "Map 200",
                "Map 2000",
                "Map 10000"
        }, true, true, true);


        ///////////Programma funzionante nel main ma non in un'altra classe/////
        /*
        //Inizializzazione per l'output
        XMLOutputFactory xmlof;
        XMLStreamWriter xmlwTonatiuh = null;
        XMLStreamWriter xmlwMetztli = null;

        //Percorso del file di output
        String pathVeicoloTonatiuh = "./Output_File/PercorsoVeicoloTonatiuh.xml";
        String pathVeicoloMetztli = "./Output_File/PercorsoVeicoloMetztli.xml";


        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlwTonatiuh = xmlof.createXMLStreamWriter(new FileOutputStream(pathVeicoloTonatiuh), "utf-8");
            xmlwTonatiuh.writeStartDocument("utf-8", "1.0");
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del writer:");
            System.out.println(e.getMessage());
        }

        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlwMetztli = xmlof.createXMLStreamWriter(new FileOutputStream(pathVeicoloMetztli), "utf-8");
            xmlwMetztli.writeStartDocument("utf-8", "1.0");
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del writer:");
            System.out.println(e.getMessage());
        }
        */


        int scelta = menu.choose();
        switch (scelta) {
            case 0 -> System.out.println(SALUTI);
            case 1 -> ControllerInputFile.stampaXmlMap5();
            case 2 -> ControllerInputFile.stampaXmlMap12();
            case 3 -> ControllerInputFile.stampaXmlMap50();
            case 4 -> ControllerInputFile.stampaXmlMap200();
            case 5 -> ControllerInputFile.stampaXmlMap2000();
            case 6 -> ControllerInputFile.stampaXmlMap10000();
        }
    }
}