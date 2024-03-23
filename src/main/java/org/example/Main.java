package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Door[] doors = new Door[3];
        doors[0] = new Door(false);
        doors[1] = new Door(true);
        doors[2] = new Door(false);

        ParadoxTest paradoxTest = new ParadoxTest();
        paradoxTest.setDoors(doors);

        Statistic statistic = new Statistic();
        File file = new File("statistic.txt");
        try {
            file.createNewFile();
            statistic.setWriter(new PrintStream(file));
        } catch (IOException e){}
        //statistic.setWriter(new PrintStream(System.out));
        paradoxTest.setStatisticModule(statistic);

        new Thread(paradoxTest).start();
    }
}