package org.ignatov;

import java.util.*;

public class Main {
    private static final int doors = 3;         // кол-во дверей;
    private static final int games = 50;        // кол-во розыгрышей (игр)
    private static final Door[] allDoors = new Door[doors]; // массив дверей
    private static final List<Integer> selDoors= new ArrayList<>(); // список ключей массива дверей для выбора игроком
                                                                    // после открытия двери с козой ведущим
    static Random rnd = new Random();

    public static void main(String[] args) {
        int positiv = 0;
        int negative = 0;
        HashMap<Integer, String> gameRes = new HashMap<>(); // результаты розыгрышей

        for(int i = 1; i <= games; i++){
            init();
 //           System.out.println("doors:" + Arrays.toString(allDoors));
            int playerRnd = rnd.nextInt(doors);
            // если за дверью авто, монти прелагает перевыбор двери
            if(allDoors[playerRnd].isVal()) {
                if (rnd.nextBoolean()){
                    // если менял выбор
                    gameRes.put(i, "авто,менял,поражение");
                    negative++;
                }else {
                    // если не менял выбор
                    gameRes.put(i, "авто,не менял,победа");
                    positiv++;
                }
            //если за дверью коза
            }else {
                // монти отрывает другую дверь с козой
                openDoorGoat(playerRnd);
                if(rnd.nextBoolean()) {
                    // если менял выбор
                    boolean close = true;
                    int selp = rnd.nextInt(selDoors.size());
                    while (close){
                        if(!allDoors[selDoors.get(selp)].isClose()){
                            selp = rnd.nextInt(selDoors.size());
                        }else{
                            close = false;
                        }
                    }
                    if(allDoors[selDoors.get(selp)].isVal()) {
                            gameRes.put(i, "коза,менял,победа");
                            positiv++;
                    }else {
                            gameRes.put(i, "коза,менял,поражение");
                            negative++;
                    }

                }else {
                    // если не менял выбор
                    gameRes.put(i, "коза,не менял,поражение");
                    negative++;
                }
            }
        }

        for (Map.Entry<Integer, String> data: gameRes.entrySet()) {
            System.out.println("Шаг " + data.getKey() + ": " + data.getValue());
        }

        System.out.printf("\nколичество позитивных результатов = %d, или %f процентов от общего количества шагов цикла ",positiv, (double)positiv/games*100);
        System.out.printf("\nколичество негативных результатов = %d, или %f процентов от общего количества шагов цикла ", negative, (double)negative/games*100);

    }

    static void init() {
        for (int i=0; i < doors; i++) {
            allDoors[i] = new Door();
        }
        int i = rnd.nextInt(doors);
        allDoors[i].setVal(true);
    }
    static void openDoorGoat(int sel){
        selDoors.clear();
        for (int s=0; s < doors; s++){
            if(s != sel ){
                selDoors.add(s);
                if(!allDoors[s].isVal()){
                    allDoors[s].setClose(false);
                }
            }
        }
    }
}