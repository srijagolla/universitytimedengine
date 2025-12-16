import java.util.*;
public class ShortAnswerQuestion extends Question {
    private List<String> keywords;

    public ShortAnswerQuestion(int id, String text, List<String> keywords, double maxMarks, double negativeMarks, String topic, String explanation) {
        super(id, text, maxMarks, negativeMarks, topic, explanation);
        this.keywords = new ArrayList<>();
        for (String k : keywords) this.keywords.add(k.trim().toLowerCase());
    }

    protected double score(String userAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) return -Math.abs(negativeMarks);
        String ua = userAnswer.toLowerCase();
        long matches = keywords.stream().filter(k -> ua.contains(k)).count();
        if (matches == 0) return -Math.abs(negativeMarks);
        // Partial credit proportional to matches
        double portion = (double) matches / keywords.size();
        return Math.round(maxMarks * portion * 100.0) / 100.0;
    }

    public List<String> getKeywords() { return keywords; }
}
