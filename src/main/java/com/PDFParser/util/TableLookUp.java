package com.PDFParser.util;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTableExtractor;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class TableLookUp {
    /**
     * Search tables from pdf file
     * @param file pdf format
     * @return List tables
     */
    @SneakyThrows
    public List<List<String>> searchTables(File file) {
        TableParser getTableParser = new TableParser();
        PdfDocument document = new PdfDocument();
        PdfTableExtractor pdfTableExtractor = new PdfTableExtractor(document);
        document.loadFromBytes(Files.readAllBytes(file.toPath()));


        return getTableParser.getTablesFromPdf(document, pdfTableExtractor);
    }
}
