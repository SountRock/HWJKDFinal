package org.example;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.stat.StatUtils;

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
        Format dFormat = new DecimalFormat("#.###");

        double[] allProbability = new double[statistic.size()];
        int index = 0;
        for (Map.Entry stat : statistic.entrySet()) {
            allProbability[index++] = (double) stat.getValue();
            writerStatistic.println("Record№" + stat.getKey() + ": Probability = " + dFormat.format(stat.getValue()));
        }

        double MiddleProbability = StatUtils.mean(allProbability);
        writerStatistic.println("Middle Probability: " +  dFormat.format(MiddleProbability));
    }
}
