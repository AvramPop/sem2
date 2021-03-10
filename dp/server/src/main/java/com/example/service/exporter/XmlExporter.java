package com.example.service.exporter;

import com.example.domain.Grade;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.sql.rowset.spi.XmlWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.List;

public class XmlExporter extends Exporter {
  @Override
  protected String convertGradesToString(List<Grade> grades) {
    DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
    DocumentBuilder build = null;
    try {
      build = dFact.newDocumentBuilder();
    } catch(ParserConfigurationException e) {
      e.printStackTrace();
    }
    Document doc = build.newDocument();
    Element root = doc.createElement("Grades");
    doc.appendChild(root);
    grades.forEach(grade -> {
      Element gradeElement = doc.createElement("Grade");
      root.appendChild(gradeElement);

      Element studentId = doc.createElement("StudentUniqueNumber");
      studentId.appendChild(doc.createTextNode(grade.getStudentId().toString()));
      gradeElement.appendChild(studentId);

      Element subject = doc.createElement("Subject");
      subject.appendChild(doc.createTextNode(grade.getSubject()));
      gradeElement.appendChild(subject);

      Element value = doc.createElement("Value");
      value.appendChild(doc.createTextNode(grade.getValue().toString()));
      gradeElement.appendChild(value);
    });

    DOMSource domSource = new DOMSource(doc);
    StringWriter writer = new StringWriter();
    StreamResult result = new StreamResult(writer);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = null;
    try {
      transformer = tf.newTransformer();
    } catch(TransformerConfigurationException e) {
      e.printStackTrace();
    }
    try {
      transformer.transform(domSource, result);
    } catch(TransformerException e) {
      e.printStackTrace();
    }
    return writer.toString();
  }

  @Override
  protected String generateFilePath(String filename) {
    return "/home/dani/Desktop/code/scoala/an3/sem2/dp/server/src/main/resources/" + filename + ".xml";
  }
}
