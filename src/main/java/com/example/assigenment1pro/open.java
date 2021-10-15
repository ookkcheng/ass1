package com.example.assigenment1pro;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class open extends Window {
    public File openfile(ActionEvent e){
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("text", "*.txt","*.rtf","*.py","*.java","*.cpp")
                    );

            File file = fileChooser.showOpenDialog(this);
            return file;


    }
    public String getTextFromRtf(File file){
        String result = null;
        try {
            DefaultStyledDocument styledDoc = new DefaultStyledDocument();
            // Create a file input stream
            InputStream streamReader = new FileInputStream(file);
            new RTFEditorKit().read(streamReader, styledDoc, 0);
            //Obtain byte[] in the encoding form of ISO-8859-1 and generate a string in the encoding form of GBK
            result = new String(styledDoc.getText(0, styledDoc.getLength()).getBytes("ISO8859-1"),"GBK");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return result;
    }


}
