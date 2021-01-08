package dino.extension;
import dino.main.Main;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.*;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
public class XML {
    File f;
    Document df;
    public XML(File f){
        this.f=f;
    }
    public XML(String path){
        this.f=new File(path);
    }
    public void setfile(File f) {
        this.f = f;
    }
    @Override
    public String toString() {
        return "XML{" +
                "f=" + f +
                ", df=" + df +
                '}';
    }
    public Document XML_init() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc=db.parse(f);
        return doc;
    }
    public Map<String,String> Read_XML_One_Child_Tag(String Main_Tag_Name,String Child_Tag_Name) throws IOException, SAXException, ParserConfigurationException {
        Document dc=XML_init();
        Map<String,String> mp = null;
        NodeList nl= dc.getElementsByTagName(Main_Tag_Name);
        for(Integer i=0;i<nl.getLength();i++){
            mp.put(Child_Tag_Name+i.toString(),dc.getElementsByTagName(Child_Tag_Name).item(i).getNodeValue());
        }
        return mp;
    }
}
