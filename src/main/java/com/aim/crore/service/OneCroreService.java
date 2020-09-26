package com.aim.crore.service;

import com.aim.crore.model.Player;
import com.aim.crore.model.PlayerTypeEnum;
import com.aim.crore.model.TeamEnum;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OneCroreService {

    private static final String SAMPLE_XLSX_FILE_PATH = "./aim-sheet.xlsx";
    static List<Player> players = new ArrayList<Player>();

    public static void main(String[] args) throws IOException {

        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });

        Sheet sheet = workbook.getSheet("Sheet3");

        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");

        // 3. Or you can use Java 8 forEach loop with lambda
        System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
        sheet.forEach(row -> {
            if (row.getRowNum() == 0) return;
            Player player = new Player();
            row.forEach(cell -> {
                printCellValue(cell, player);
            });
            players.add(player);
            System.out.println(player);
        });

        // Closing the workbook
        workbook.close();
    }

    List<Player> selectedTeams = new ArrayList<Player>();
    int selected = 0;

    private void generateTeams(List<Player> players, int numOfTeams, List<TeamEnum> teams) {

    }

    int maxPoint = 100;
    int minPlayer = 4;
    int maxPlayer = 7;
    List<Player> wkList = new ArrayList<Player>();
    List<Player> batList = new ArrayList<Player>();
    List<Player> allList = new ArrayList<Player>();
    List<Player> ballList = new ArrayList<Player>();

    //Arrays[]combinations = [[1,3,2,5], [1,3,3,4], [1,4,1,5], [1,4,2,4], [1,4,3,3], [1,5,1,4], [1,5,2,3]];
    private void init() {
        for (Player p : players) {
            if (p.getType().toString().equals(PlayerTypeEnum.WK.toString())) wkList.add(p);
            if (p.getType().toString().equals(PlayerTypeEnum.BAT.toString())) batList.add(p);
            if (p.getType().toString().equals(PlayerTypeEnum.ALL.toString())) allList.add(p);
            if (p.getType().toString().equals(PlayerTypeEnum.BOWL.toString())) ballList.add(p);
        }

    }

    private void sample() {

    }

    private static void printCellValue(Cell cell, Player player) {
        switch (cell.getColumnIndex()) {
            case 0:
                player.setPlayerNo((int) cell.getNumericCellValue());
                break;
            case 1:
                player.setName(cell.getStringCellValue());
                break;
            case 2:
                player.setType(PlayerTypeEnum.valueOf(cell.getStringCellValue()));
                break;
            case 3:
                player.setCredits(Double.valueOf(cell.getRichStringCellValue().toString()));
                break;
            case 4:
                //player.setIsDreamPlayer(cell.getBooleanCellValue());
                break;
            default:
                System.out.print("============");
        }
    }


}
