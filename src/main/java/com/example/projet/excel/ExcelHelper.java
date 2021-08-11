package com.example.projet.excel;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import java.util.ArrayList;

import java.util.List;
import java.util.Iterator;

import com.example.projet.entities.Aspect;
import com.example.projet.entities.Recommandation;
import com.example.projet.services.AspectServices;
import com.example.projet.services.RecommandationServices;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "reference", "recommandations", "cotation", "methode" };
    static String SHEET = "aspc";
    @Autowired
    RecommandationServices recoScv;
    @Autowired
    AspectServices asSvc;

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public List<Recommandation> excelToTutorials(InputStream is) throws ParseException {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Recommandation> tutorials = new ArrayList<Recommandation>();
           
            int i = 1;
            int rowNumber = 0;
            while (rows.hasNext()) {

                Row currentRow = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;

                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Recommandation reco = new Recommandation();
                Aspect asp = asSvc.findById(6L);
                reco.setAspect(asp);

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                    case 0:
                        String reference = currentCell.getStringCellValue();
                        System.out.println(reference);
                        reco.setReference(reference);
                        break;

                    case 1:
                        String auteur = currentCell.getStringCellValue();
                        System.out.println(auteur);
                        reco.setLabel(auteur);
                        break;
                    // case 2:
                    // String sDate1 = currentCell.getStringCellValue();
                    // System.out.println(sDate1);
                    // break;
                    // case 3:
                    // String descriptif = currentCell.getStringCellValue();
                    // System.out.println(descriptif);
                    // break;

                    // case 4:
                    // String theme = currentCell.getStringCellValue();
                    // System.out.println(theme);
                    // break;

                    default:
                        break;
                    }

                    cellIdx++;
                }
                i++;
                tutorials.add(reco);
            }

            workbook.close();

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}