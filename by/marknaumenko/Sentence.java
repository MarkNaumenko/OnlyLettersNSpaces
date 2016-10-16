package by.marknaumenko;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sentence {
    private String originalText;

    public List getWords() {
        return words;
    }

    public void setWords(List words) {
        this.words = words;
    }

    private List words = new ArrayList<Word>();

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public Sentence() {
        Scanner sentenceScanner = new Scanner(System.in);
        System.out.print("Input from keyboard. Enter your text:\n");
        this.originalText = sentenceScanner.nextLine();
        sentenceConfirmation();
    }

    public Sentence(FileReader inputFile) {
        Scanner textFromFile = new Scanner(inputFile);
        System.out.print("Input from file...");
        while (textFromFile.hasNextLine()) {
            this.originalText += textFromFile.nextLine();
        }
        textFromFile.close();
        System.out.print(" succeed.\n");
        sentenceConfirmation();
    }

    private void sentenceConfirmation(){
        System.out.print("This is the text you have been entered:\n" + originalText + "\n\n");
    }

    public void sentenceParsing(String sentenceToParse){
        String result = (sentenceToParse.replaceAll("[^ A-Za-z]", " ")).replaceAll(" +", " ");
        for (String word : result.split(" ")){
            this.words.add(word);
        }
        this.sentencePrint();
    }

    public void sentencePrint(){
        for (Object word : this.words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
