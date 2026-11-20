import java.util.*;
import java.io.*;

import sup.*;
import tasks.*;

public class Main {
    //======================================================================================================================
    static final String[][] tasks = new String[][]{
            {"5", "7"}, {"3"}, {"4"}, {"1"}, {"8"}, {"2"}, {"1", "2", "3"}, {"2"}
    };
    //======================================================================================================================
    static final int count_tasks = tasks.length;
    static Scanner scanner = new Scanner(System.in);
    static inputvalidator valid = new inputvalidator(scanner);

    public static void main(String[] args) {
        String[] pre = {"1", "2", "q", "quit", "в", "выход", "ds[jl", "d", "йгше", "й"};
        System.out.println("====================================================================================");
        String methood_choice = valid.readLine("Выберите вариант запуска (1/2/q)\n1-сдача\n2-отладка\nq,quit,в,выход\n", pre);
        System.out.println("====================================================================================");
        if (methood_choice.equals("1")) {
            cascade();
        } else if (methood_choice.equals("2")) {
            debug();
        } else {
            System.exit(0);
        }
    }

    private static void debug() {
        task1_5 task15 = new task1_5();
        task1_7 task17 = new task1_7();
        task2_3 task23 = new task2_3();
        task3_4 task34 = new task3_4();
        task4_1 task41 = new task4_1();
        task5_8 task58 = new task5_8();
        task6_2 task62 = new task6_2();
        task7_1 task71 = new task7_1();
        task7_2 task72 = new task7_2();
        task7_3 task73 = new task7_3();
        task8_2 task82 = new task8_2();
        int z1 = valid.readInt("Задание:\n", 1, count_tasks);
        String[] taskNumbers = tasks[z1 - 1];
        switch (z1) {
            case 1: {
                String z2 = valid.readLine("Задача:\n", taskNumbers);
                switch (z2) {
                    case "5": {
                        task15.show_task();
                        break;
                    }
                    case "7": {
                        task17.show_task();
                        break;
                    }
                }
                break;
            }
            case 2: {
                task23.show_task();
                break;
            }
            case 3: {
                task34.show_task();
                break;
            }
            case 4: {
                task41.show_task();
                break;
            }
            case 5: {
                task58.show_task();
                break;
            }
            case 6: {
                task62.show_task();
                break;
            }
            case 7: {
                String z2 = valid.readLine("Задача:\n", taskNumbers);
                switch (z2) {
                    case "1": {
                        task71.show_task();
                        break;
                    }
                    case "2": {
                        task72.show_task();
                        break;
                    }
                    case "3": {
                        task73.show_task();
                        break;
                    }
                }
                break;
            }
            case 8: {
                task82.show_task();
                break;
            }
        }
    }
    private static void cascade() {
        List<sub_task> taskList = List.of(
                new task1_5(),
                new task1_7(),
                new task2_3(),
                new task3_4(),
                new task4_1(),
                new task5_8(),
                new task6_2(),
                new task7_1(),
                new task7_2(),
                new task7_3(),
                new task8_2()
        );
        ArrayList<String> arr_task  = new ArrayList<>();
        ArrayList<String> arr_task1 = new ArrayList<>();
        for (int z = 0; z < tasks.length; z++) {
            for (String i2 : tasks[z]) {
                arr_task.add(i2);
                arr_task1.add(Integer.toString(z + 1));
            }
        }
        int i = 0;
        while (i < taskList.size()) {
            sub_task currentTask = taskList.get(i);
            System.out.println("\n================ Задание " + arr_task1.get(i) + " ================");
            System.out.println("\n================ Задача " + arr_task.get(i) + " =================");
            currentTask.show_task();
            boolean restart = false;
            boolean quit = false;
            while (true) {
                System.out.println("\n'r'-restart\n'q' - выход\n'Enter' - далее\n'add' - Добавить элемент");
                String input = sub_task.scanner.nextLine().trim().toLowerCase();
                if (input.isEmpty()) break;
                if (isAdd(input)) {
                    currentTask.add_new();
                    continue;
                }
                if (isQuit(input)) {
                    quit = true;
                    break;
                }
                if (isRestart(input)) {
                    restart = true;
                    break;
                }
            }
            if (quit) return;
            if (!restart) i++;
        }
    }

    private static boolean isRestart(String input) {
        return input.equals("r") || input.equals("restart") || input.equals("заново") || input.equals("повтор") || input.equals("repeat") || input.equals("again");
    }
    private static boolean isAdd(String input) {
        return input.equals("a") || input.equals("add");
    }
    private static boolean isQuit(String input) {
        return input.equals("q") || input.equals("quit") || input.equals("выход");
    }
}
