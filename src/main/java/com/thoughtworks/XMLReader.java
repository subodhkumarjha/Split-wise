package com.thoughtworks;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLReader implements Reader {
    @Override
    public String read (Transactions transactions) {
        try {
            int count=1;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Splitwise");
            doc.appendChild(rootElement);

            for (Transaction transaction : transactions.transactionList) {
                // staff elements
                Element staff = doc.createElement ("Transaction");
                rootElement.appendChild (staff);

                // set attribute to staff element
                Attr attr = doc.createAttribute ("id");
                attr.setValue (String.valueOf (count));
                count++;
                staff.setAttributeNode (attr);

                // Payer elements
                Element payer = doc.createElement ("Payer");
                payer.appendChild (doc.createTextNode (transaction.payer.getName ()));
                staff.appendChild (payer);

                // Amount elements
                Element amount = doc.createElement ("Amount");
                amount.appendChild (doc.createTextNode (String.valueOf (transaction.amount)));
                staff.appendChild (amount);

                // Payee elements
                Element payee = doc.createElement ("Payee");
                payee.appendChild (doc.createTextNode (transaction.payee.getName ()));
                staff.appendChild (payee);
            }


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File ("file.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        return "XML file reader";
    }
}
