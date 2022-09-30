package com.PDFParser.util;

import com.PDFParser.parser.Parser;
import com.PDFParser.write.Writer;
import com.PDFParser.model.Model;

import java.util.List;

public class ModelWriter {
    /**
     * Fill model columns from table
     * @param allTables from pdf file
     * @param modelList filled model columns
     */
    public void writeToModelList(Writer writer, List<List<String>> allTables, List<List<Model>> modelList) {
        List<Model> personList;
        for (List<String> allTable : allTables) {
            allTable.set(0, allTable.get(0).toLowerCase());
            personList = Parser.transform(allTable, Model.class);
            modelList.add(personList);
            printToConsole(writer, personList, allTable);
        }
    }

    /**
     * Print table from table
     * @param personList Filled model columns from table
     * @param allTable table from pdf
     */
    public void printToConsole(Writer writer, List<Model> personList, List<String> allTable) {
        for (Model person : personList) {
            String[] str = allTable.get(0).split(";");
            writer.writeToConsole(person, str);
        }
        System.out.println("\r\n");
    }
}
