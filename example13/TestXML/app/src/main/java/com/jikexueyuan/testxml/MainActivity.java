package com.jikexueyuan.testxml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = (TextView) findViewById(R.id.tvText);

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
//            InputStream is = getAssets().open("languages.xml");
//            Document document = builder.parse(is);
//
//            Element element = document.getDocumentElement();
//            NodeList list = element.getElementsByTagName("lan");
//            for (int i = 0; i < list.getLength(); i++) {
//                Element lan = (Element) list.item(i);
//                tvText.append(lan.getAttribute("id") + "\n");
//                tvText.append(lan.getElementsByTagName("name").item(0).getTextContent() + "\n");
//                tvText.append(lan.getElementsByTagName("ide").item(0).getTextContent() + "\n");
//            }

            Document newXml = builder.newDocument();
            Element languages = newXml.createElement("languages");
            languages.setAttribute("cat", "it");

            Element lan1 = newXml.createElement("lan");
            lan1.setAttribute("id", "1");
            Element name1 = newXml.createElement("name");
            name1.setTextContent("Java");
            Element ide1 = newXml.createElement("ide");
            ide1.setTextContent("Android Studio");
            lan1.appendChild(name1);
            lan1.appendChild(ide1);
            languages.appendChild(lan1);

            Element lan2 = newXml.createElement("lan");
            lan2.setAttribute("id", "2");
            Element name2 = newXml.createElement("name");
            name2.setTextContent("Swift");
            Element ide2 = newXml.createElement("ide");
            ide2.setTextContent("Xcode");
            lan2.appendChild(name2);
            lan2.appendChild(ide2);
            languages.appendChild(lan2);

            Element lan3 = newXml.createElement("lan");
            lan3.setAttribute("id", "3");
            Element name3 = newXml.createElement("name");
            name3.setTextContent("C#");
            Element ide3 = newXml.createElement("ide");
            ide3.setTextContent("Visual Studio");
            lan3.appendChild(name3);
            lan3.appendChild(ide3);
            languages.appendChild(lan3);

            newXml.appendChild(languages);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("encoding", "utf-8");
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(languages), new StreamResult(sw));

            tvText.setText(sw.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
