package com.example.assigenment1pro;

import org.fxmisc.richtext.CodeArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java {
    public void java1(File file, CodeArea codeArea) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String tempStr;
        while ((tempStr = bufferedReader.readLine()) != null) {
            stringBuffer.append(tempStr+"\n");}
        bufferedReader.close();
    }
}
