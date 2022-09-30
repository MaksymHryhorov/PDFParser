package com.PDFParser;

import com.PDFParser.model.Model;
import com.PDFParser.util.ModelWriter;
import com.PDFParser.util.TableLookUp;
import com.PDFParser.write.Writer;
import lombok.SneakyThrows;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        TableLookUp tableLookUp = new TableLookUp();
        Writer writer = new Writer();
        ModelWriter modelWriter = new ModelWriter();

        URL url = Main.class.getClassLoader().getResource("sample.pdf");
        File file = new File(url.toURI());
        List<List<String>> allTables = tableLookUp.searchTables(file);
        List<List<Model>> modelList = new ArrayList<>();

        modelWriter.writeToModelList(writer, allTables, modelList);
    }
}
