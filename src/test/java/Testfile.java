
import com.example.assigenment1pro.Controller;
import com.example.assigenment1pro.Find;
import com.example.assigenment1pro.open;
import javafx.application.Platform;
import javafx.stage.DirectoryChooser;
import org.fxmisc.richtext.CodeArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Testfile{
    @Test
    public void testOpen(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                open open = new open();
                File file = new File("src/test/resources/rtf.rtf");
                String string = open.getTextFromRtf(file);
                System.out.println(string);
                assertTrue(string.equals("assssssssssssssssssssssssssssssssssssssssssssssssssssssss"));
            }
        }).start();
    }

    @Test
    public void testSave() throws IOException {

        String text="123";

        // Write the texts into .txt
        File f= new File("src/test/resources/text.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.close();
    }

    @Test
    public void testSearch(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                open open = new open();
                File file = new File("src/test/resources/rtf.rtf");
                String string = open.getTextFromRtf(file);
                System.out.println(string);
                assertEquals("a", string.charAt(0));
            }
        }).start();
    }
}
