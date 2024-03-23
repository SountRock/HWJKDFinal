package org.example;

/**
 * Класс описывающий дверь
 */
public class Door {
    private enum Status{OPEN, CLOSE};
    private Status status;
    private boolean isAuto;

    public Door(boolean isAuto) {
        this.isAuto = isAuto;
        status = Status.CLOSE;
    }

    /**
     * Открыть дверь
     * @return
     */
    public boolean open(){
        status = Status.OPEN;
        return isAuto;
    }

    /**
     * Закрыть дверь
     */
    public void close(){
        status = Status.CLOSE;
    }

    /**
     * Проверить открыта ли дверь
     * @return
     */
    public boolean isOpen() {
        return status == Status.OPEN;
    }
}
