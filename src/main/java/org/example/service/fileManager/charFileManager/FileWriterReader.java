package org.example.service.fileManager.charFileManager;

import java.io.IOException;

public interface FileWriterReader {
    void fileWriter(String path, char[] text) throws IOException;
    String fileReader(String path) throws IOException;
}
