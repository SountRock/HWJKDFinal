package org.example;

import java.util.Random;

/**
 * Класс для проведения исследования парадокса Монти Холла
 */
public class ParadoxTest implements Runnable{
    private Door[] doors;
    private Statistic statistic;
    private Random random;

    /**
     * Положить массив дверей в тестер
     * @param doors
     */
    public void setDoors(Door[] doors){
        this.doors = doors;
        random = new Random();
    }

    /**
     * Подключить класс записи статистики
     * @param statistic
     */
    public void setStatisticModule(Statistic statistic){
        this.statistic = statistic;
    }

    /**
     * Закрыть все двери (нужно для начала новой игры)
     */
    private void closeDoors(){
        for (int i = 0; i < doors.length; i++) {
            doors[i].close();
        }
    }

    /**
     * Метод проводящий тестирование 1000 раз с записей результатов
     */
    private void test(){
        for (int i = 0; i < 1000; i++) {
            int countTry = 1;
            while (true){
                int choice = random.nextInt(0, doors.length);
                if(!doors[choice].isOpen()){
                    boolean win = doors[choice].open();
                    if(win){
                        statistic.addRecord(countTry, doors.length);
                        closeDoors();
                        break;
                    }

                    countTry++;
                }
            }
        }
    }

    @Override
    public void run() {
        test();
        statistic.printStatistic();
    }
}
