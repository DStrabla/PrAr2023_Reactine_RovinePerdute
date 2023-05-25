import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;

public class CompilatoreOutputFile {

    //Inizializzazione per l'output
    XMLOutputFactory xmlof;
    XMLStreamWriter xmlwTonatiuh = null;
    XMLStreamWriter xmlwMetztli = null;

    //Percorso del file di output
    String pathVeicoloTonatiuh = "./Output_File/PercorsoVeicoloTonatiuh.xml";
    String pathVeicoloMetztli = "./Output_File/PercorsoVeicoloMetztli";

    ///////////Si vuole far funzionare la scrittura dell'output in questa classe e non nel main/////////
/*
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

}
