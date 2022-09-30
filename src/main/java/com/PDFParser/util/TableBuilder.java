package com.PDFParser.util;

import com.spire.pdf.utilities.PdfTable;

import java.util.ArrayList;
import java.util.List;

public class TableBuilder {
    /**
     * Build table
     *
     * @param table table from pdf file
     * @return table from pdf in string format
     */
    public StringBuilder buildTable(PdfTable table) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < table.getRowCount(); i++) {
            buildRow(stringBuilder, table, i);
            stringBuilder.append("\r\n");
        }

        return stringBuilder;
    }

    /**
     * Fill stringBuilder each row from pdf table
     *
     * @param table table from pdf
     */
    public void buildRow(StringBuilder stringBuilder, PdfTable table, int i) {
        List<String> row = new ArrayList<>();
        for (int j = 0; j < table.getColumnCount(); j++) {
            String text = table.getText(i, j);
            if (text != null && text.trim().length() > 1) {
                row.add(text);
            }
        }

        stringBuilder.append(String.join(";", row));
    }
}
