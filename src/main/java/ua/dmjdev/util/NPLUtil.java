package ua.dmjdev.util;

import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class NPLUtil {

    public static Set<String> getWordsFromSentence(String sentence) {
        try {
            InputStream tokenizerStream = new FileInputStream(new ClassPathResource("npl/en-token.bin").getFile().getAbsolutePath());
            TokenizerModel tokenizerModel = new TokenizerModel(tokenizerStream);
            TokenizerME tokenizer = new TokenizerME(tokenizerModel);
            InputStream posStream = new FileInputStream(new ClassPathResource("npl/en-pos-maxent.bin").getFile().getAbsolutePath());
            POSModel posModel = new POSModel(posStream);
            POSTaggerME posTagger = new POSTaggerME(posModel);
            InputStream dictLemmatizerIn = new FileInputStream(new ClassPathResource("npl/en-lemmatizer.dict").getFile().getAbsolutePath());
            DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizerIn);
            String[] tokens = tokenizer.tokenize(sentence);
            String[] tags = posTagger.tag(tokens);
            Set<String> extractedWords = new HashSet<>();
            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i];
                String tag = tags[i];
                if (!isExcludedPOS(tag)) {
                    if (tag.startsWith("VB")) {
                        String lemma = lemmatizer.lemmatize(new String[]{token}, new String[]{tag})[0];
                        extractedWords.add(lemma);
                    } else {
                        extractedWords.add(token);
                    }
                }
            }
            return extractedWords;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isExcludedPOS(String posTag) {
        return posTag.equals("DT") || posTag.startsWith("IN") || posTag.startsWith("TO")
                || posTag.startsWith("CC") || posTag.equals("UH") || posTag.equals("RP")
                || posTag.startsWith("MD");
    }
}
