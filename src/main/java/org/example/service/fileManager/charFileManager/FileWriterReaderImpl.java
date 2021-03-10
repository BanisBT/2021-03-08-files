package org.example.service.fileManager.charFileManager;

import org.example.service.fileManager.charFileManager.FileWriterReader;

import java.io.*;

public class FileWriterReaderImpl implements FileWriterReader {
    @Override
    public void fileWriter(String path, char[] text) throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(path);
            for (int i = 0; i < text.length; i++){
                out.write(text[i]);
            }
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
        }
    }

    @Override
    public String fileReader(String path) throws IOException {
        String textFromFile = "";
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            int raidesKodas;
            while ((raidesKodas = in.read()) > 0) {
                textFromFile += (char) raidesKodas;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
        }
        return textFromFile;
    }
}
