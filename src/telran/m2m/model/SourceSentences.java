package telran.m2m.model;

import static telran.m2m.model.SentenceComponents.*;

public class SourceSentences {


    /**
     * generates a sentence
     *
     * @return sentence
     */
    public String sentence() {
        String sentence = properNoun() + " " + transitiveVerb() + " " + determiner() + " "
                + adjective()+ " " + commonNoun() + " " + conjunction() + " "
                + intransitiveVerb() + " " + determiner() + " " + adjective()+ " "
                + commonNoun() + ".";
        return sentence;
    }

}
