public class MCQQuestion extends Question {
    private String correctOption;

    public MCQQuestion(int id, String text, String correctOption, double maxMarks, double negativeMarks, String topic, String explanation) {
        super(id, text, maxMarks, negativeMarks, topic, explanation);
        this.correctOption = correctOption;
    }

    protected double score(String userAnswer) {
        if (userAnswer == null) return 0.0;
        if (userAnswer.trim().equalsIgnoreCase(correctOption.trim())) {
            return maxMarks;
        } else {
            return -Math.abs(negativeMarks);
        }
    }

    public String getCorrectOption() { return correctOption; }
}
