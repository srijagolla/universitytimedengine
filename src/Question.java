public abstract class Question implements java.io.Serializable {
    protected int id;
    protected String text;
    protected double maxMarks;
    protected double negativeMarks;
    protected String topic;
    protected String explanation;

    public Question(int id, String text, double maxMarks, double negativeMarks, String topic, String explanation) {
        this.id = id;
        this.text = text;
        this.maxMarks = maxMarks;
        this.negativeMarks = negativeMarks;
        this.topic = topic;
        this.explanation = explanation;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public String getTopic() { return topic; }
    public String getExplanation() { return explanation; }

    // Template method
    public final double evaluate(String userAnswer) {
        return score(userAnswer);
    }

    protected abstract double score(String userAnswer);
}
