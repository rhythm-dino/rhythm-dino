package dino.extension;
import dino.main.Main;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.*;
import javax.print.Doc;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.*;
/**
 * Note: use Dom to dispatch XML document,because sax is too complex for me :(
 * by Caviar-X
 * */
public class XML {
    public Document Init(File F) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        return db.parse(F);
    }
    public void Read(File F) throws IOException, SAXException, ParserConfigurationException {
        Document doc=Init(F);

    }
}

