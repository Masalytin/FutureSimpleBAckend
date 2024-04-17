package ua.dmjdev.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dmjdev.dto.EnglishLevel;
import ua.dmjdev.models.dictionary.Word;
import ua.dmjdev.models.dictionary.WordsSet;
import ua.dmjdev.repos.WordSetRepository;
import ua.dmjdev.service.WordService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/word-set")
public class WordSetController {
    private final WordService wordService;
    private final WordSetRepository wordSetRepository;

    public WordSetController(WordService wordService, WordSetRepository wordSetRepository) {
        this.wordService = wordService;
        this.wordSetRepository = wordSetRepository;
    }

    // TODO: 15.04.2024 Just for parse. It will delete after parsing
    @GetMapping("/parse-words")
    public boolean parse() {
        File directory = new File("D:\\\\Word Sets");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    WordsSet wordsSet = new WordsSet();
                    List<Word> words = new ArrayList<>();
                    String[] parts = file.getName().substring(0, file.getName().lastIndexOf(".")).split("_");
                    wordsSet.setName(String.format("%s, (%s)", parts[0], parts[1]));
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            wordService.saveWord(line);
                            Thread.sleep(100);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    wordsSet.setEnglishLevel(switch (parts[1]) {
                        case "A1", "A2" -> EnglishLevel.BEGINNER;
                        case "B1", "B2" -> EnglishLevel.INTERMEDIATE;
                        case "C1", "C2" -> EnglishLevel.ADVANCED;
                        default -> throw new IllegalStateException("Unexpected value: " + parts[1]);
                    });
                    wordSetRepository.save(wordsSet);
                }
            }
        }
        return true;
    }
}
