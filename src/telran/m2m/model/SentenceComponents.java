package telran.m2m.model;

public class SentenceComponents {

    private static String getRandomString(String[] listOfStrings) {
        int index = (int) (Math.random() * (listOfStrings.length));
        return listOfStrings[index];
    }

    public static String conjunction() {
        String[] items = { "and", "or", "but", "because" };
        return getRandomString(items);
    }

    public static String properNoun() {
        String[] items = { "Fred", "Daphne", "Wilma", "Shaggy", "Scooby" };
        return getRandomString(items);
    }

    public static String commonNoun() {
        String[] items = { "man", "woman", "fish", "kitchen", "snacks", "trap" };
        return getRandomString(items);
    }

    public static String determiner() {
        String[] items = { "a", "the", "every", "some" };
        return getRandomString(items);
    }

    public static String adjective() {
        String[] items = { "big", "tiny", "scary", "meddling", "hungry" };
        return getRandomString(items);
    }

    public static String intransitiveVerb() {
        String[] items = { "runs", "jumps", "talks", "hides", "eats" };
        return getRandomString(items);
    }

    public static String transitiveVerb(){
        String[] items = { "loves", "hates", "sees", "knows", "looks for", "finds"};
        return getRandomString(items);
    }
}
