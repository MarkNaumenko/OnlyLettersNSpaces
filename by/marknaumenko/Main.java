package by.marknaumenko;

/*
ЗАДАНИЕ

Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
Между последовательностями подряд идущих букв оставить хотя бы один пробел.

ТРЕБОВАНИЯ.
1.	При выполнении задания создать и  обязательно использовать классы Word и Sentence.
2.	Приложение должно быть написано на любом из языков: С++, С# или Java.
3.	При кодировании должны быть использованы соглашения об оформлении кода для соответствующего языка – code convention.
4.	По возможности использовать принципы ООП: наследование, полиморфизм, инкапсуляция.
5.	Не использовать графический интерфейс! Приложение должно быть консольным. но консольное меню должно быть минимальным
6.	На собеседование приносить на флеш-носителе исходный код и откомпилированное приложение.
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.print("Input \"f\" to read text from a file or \"k\" for keyboard input.\nInput \"e\" to exit.\n");
        Scanner inputKey = new Scanner(System.in);
        String key = inputKey.next();
        while (!Pattern.matches("[fke]", key)){
            System.out.print("Wrong input!\n");
            key = inputKey.next();
        }
        Sentence mySentence = null;
        final String filePath = "src/input.txt";

        try {
            switch (key) {
                case "f":
                    mySentence = new Sentence(new FileReader(filePath));
                    break;
                case "k":
                    mySentence = new Sentence();
                    break;
                case "e":
                    System.out.print("Exiting... Bye-bye.\n");
                    System.exit(0);
                    break;
            }
        } catch (FileNotFoundException e) {System.out.print("can not find \"" + filePath + "\" file.\n\n"); main(null);}

        mySentence.sentenceParsing(mySentence.getOriginalText());
        main(null);
        //??унаследовать предложение от слова??
        //полиморфизм для слова и для предложения
        //инкапсуляция в виде геттеров и сеттеров для каждого поля классов

        inputKey.close();
    }
}
