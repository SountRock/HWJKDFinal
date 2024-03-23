package org.example;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для записи статистики
 */
public class Statistic {
    private HashMap<Integer, Double> statistic;
    private PrintStream writerStatistic;
    private static int numberRecord = 1;

    /**
     * Установить объект для записи статистики в то или иное место
     * @param writerStatistic
     */
    public void setWriter(PrintStream writerStatistic){
        this.writerStatistic = writerStatistic;
        statistic = new HashMap<>();
    }

    /**
     * Добавляет запись в лист статистики
     * @param tryCount
     * @param maxCountOfAttempts
     */
    public void addRecord(int tryCount, int maxCountOfAttempts){
        double probability = (double) tryCount / maxCountOfAttempts;
        statistic.put(numberRecord++, probability);
    }

    /**
     * Печатает статистику
     */
    public void printStatistic(){
        double allSumProbability = 0;
        for (Map.Entry stat : statistic.entrySet()) {
            allSumProbability += (double) stat.getValue();
            writerStatistic.println("Record№" + stat.getKey() + ": Probability = " + stat.getValue());
        }

        double MiddleProbability = allSumProbability / statistic.size();
        writerStatistic.println("Middle Probability: " +  MiddleProbability);
    }
}
