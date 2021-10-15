package com.example.assigenment1pro;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Alert;
        import javafx.scene.control.ButtonBar;
        import javafx.scene.control.ButtonType;
        import javafx.scene.text.Text;
        import javafx.scene.transform.Scale;
        import javafx.stage.DirectoryChooser;
        import javafx.stage.Window;
        import org.apache.pdfbox.pdmodel.common.PDRectangle;
        import org.apache.pdfbox.pdmodel.font.PDFont;
        import org.dom4j.DocumentException;
        import org.fxmisc.richtext.CodeArea;

        import javax.print.*;

        import org.apache.pdfbox.pdmodel.PDDocument;
        import org.apache.pdfbox.pdmodel.PDPage;
        import org.apache.pdfbox.pdmodel.PDPageContentStream;
        import org.apache.pdfbox.pdmodel.font.PDType1Font;
        import org.fxmisc.richtext.CodeArea;

        import javax.print.PrintException;
        import javax.print.attribute.*;
        import javax.print.attribute.standard.Copies;
        import javax.swing.*;
        import javax.swing.text.Document;

        import java.awt.*;
        import java.awt.print.PrinterException;
        import java.io.*;
        import java.net.URL;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.ResourceBundle;



public class Controller extends Window implements Initializable {

    @FXML
    private CodeArea Codearea;

    @FXML
    private Text time;


    //Display the names of both team members and a brief message in a popup message box.

    @FXML
    void about(ActionEvent event) {
        String info="Team members:  Dongyi Jiao & Mike Chen"+"\n"+"Welcome to the text editor!" ;
        Alert alert = new Alert(Alert.AlertType.INFORMATION, info, new ButtonType("Okay", ButtonBar.ButtonData.YES));
        alert.setHeaderText(null);
        alert.setTitle("About Us");
        alert.show();
    }

    @FXML
    void copy(ActionEvent event) {
        Codearea.copy();
    }

    @FXML
    void cut(ActionEvent event) {
        Codearea.cut();
    }


    @FXML   // To quit the program – close all windows
    void exit(ActionEvent event) {
        System.exit(0);
    }



    @FXML   // To create a new (fresh) window.
    void new_(ActionEvent event) { Codearea.clear(); }

    //  To read other text files (.txt/.rtf/.py/.css/.java).
    //  This should allow users to navigate the file system to search for a file
    @FXML
    void open(ActionEvent event) throws IOException {
        open open =new open();
        File file = open.openfile(event);
        System.out.println(file);
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String tempStr;
        while ((tempStr = bufferedReader.readLine()) != null) {
            stringBuffer.append(tempStr+"\n");}
        bufferedReader.close();
        Codearea.append(stringBuffer.toString(),"red");

    }

    @FXML
    void paste(ActionEvent event) {
        Codearea.paste();
    }


    //Allow your editor to print text by connecting it to the local printer in your machine
    @FXML
    void print(ActionEvent event) throws PrinterException, PrintException, IOException {
        //It can be easier to operate if the text can be saved as first.
        File file=new File("data\\print.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Codearea.getText());
        bw.close();

        if(file.exists()){
            //Build the print request property set
            HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            //Set the print format, select AutoSense because the type is not determined
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            //Find all available print services
            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
            //Locate the default print service
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
            //Displays the print dialog box
            PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
            if(service != null){
                try {
                    DocPrintJob job = service.createPrintJob(); //Creating a Print job
                    FileInputStream fis = new FileInputStream(file); //Construct the file stream to print
                    DocAttributeSet das = new HashDocAttributeSet();
                    Doc doc = new SimpleDoc(fis, flavor, das);
                    job.print(doc, pras);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
             }
    }


    //Include a PDF conversation function to your editor so the file can be also saved into PDF format (for standard text files).
    @FXML
    void toPDF(ActionEvent event) throws PrintException, IOException {
        //Get the chosen path
        DirectoryChooser directoryChooser=new DirectoryChooser();
        File f = directoryChooser.showDialog(this);
        String path = f.getPath();
        path=path+"\\text.pdf";

        PDDocument doc = null;
        try
        {
            // Format the text display
            doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            PDFont pdfFont = PDType1Font.HELVETICA;
            float fontSize = 25;
            float leading = 1.5f * fontSize;
            PDRectangle mediabox = page.getMediaBox();
            float margin = 72;
            float width = mediabox.getWidth() - 2*margin;
            float startX = mediabox.getLowerLeftX() + margin;
            float startY = mediabox.getUpperRightY() - margin;
            String textNL = Codearea.getText();
            List<String> lines = new ArrayList<String>();

            //Dealing with the new line \n
            for (String text: textNL.split("\n")){
                //Split long string
                int lastSpace = -1;
                while (text.length() > 0)
                {
                    int spaceIndex = text.indexOf(' ', lastSpace + 1);
                    if (spaceIndex < 0)
                        spaceIndex = text.length();
                    String subString = text.substring(0, spaceIndex);
                    float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
                    if (size > width)
                    {
                        if (lastSpace < 0)
                            lastSpace = spaceIndex;
                        subString = text.substring(0, lastSpace);
                        lines.add(subString);
                        text = text.substring(lastSpace).trim();
                        System.out.printf("'%s' is line\n", subString);
                        lastSpace = -1;
                    }
                    else if (spaceIndex == text.length())
                    {
                        lines.add(text);
                        System.out.printf("'%s' is line\n", text);
                        text = "";
                    }
                    else
                    {
                        lastSpace = spaceIndex;
                    }
                }}
            //Begin the Content stream
            contentStream.beginText();
            //Setting the font to the Content stream
            contentStream.setFont(pdfFont, fontSize);
            //Setting the position for the line
            contentStream.newLineAtOffset(startX, startY);
            for (String line: lines)
            {
                //Adding text in the form of string
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -leading);
            }
            //Ending the content stream
            contentStream.endText();
            //Closing the content stream
            contentStream.close();
            doc.save(new File(path));
        }
        finally
        {
            if (doc != null)
            {
                //Closing the document
                doc.close();
            }
        }
    }

    //    Save text output into .txt file format.
    //    This should allow users to navigate the file system to save the file in a selected drive/location.
    @FXML
    void save(ActionEvent event) throws IOException {
        // Get the chosen path

        DirectoryChooser directoryChooser=new DirectoryChooser();
        File file = directoryChooser.showDialog(this);
        String path = file.getPath();
        String text=Codearea.getText();
        path=path+"\\text.txt";

        // Write the texts into .txt
        File f=new File(path);
        FileWriter fw = new FileWriter(f.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.close();
    }


    //Search for text within the screen (this will be tested based on a single word)
    @FXML
    void search(ActionEvent event) {
        Find find = new Find();
        find.find(Codearea);
    }

    @FXML
    void select(ActionEvent event) {
        Codearea.selectAll();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Retrieve the current time and data from the OS and place it at the top of the page of the editor.
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd      HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        time.setText(formatter.format(date));
        Codearea.setWrapText(true);

        //Ability to read source code files such as .java, .py, .cpp or similar.
        // Different syntax should be shown in different colours.
        keywords keywords =new keywords();
        keywords.start(Codearea);
    }
}
