package com.bitc.java404;

public class Main {
    public static void main(String[] args) {

//        UseExcel useExcel = new UseExcel();
//        useExcel.readExcel("C:/java404/test.xlsx");



//        Interior interior = new Interior();
//        interior.interiorList("C:/java404/interior.xlsx");

//        Cultural c = new Cultural();
//        c.CulturalList("C:/java404/cultural.xls");

        ExcelParsing ep = new ExcelParsing();
        ep.parsingExcel();

    }



}