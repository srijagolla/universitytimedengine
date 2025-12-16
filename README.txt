University Timed Exam Engine (Java) - Command-based CLI
=====================================================

What is included:
- src/*.java : Java source files (Main, ExamEngine, Question types, Timer, Exceptions)
- questions.csv : Sample questions (MCQ + Short Answer)
- key.csv : Sample key (optional, can override)
- After running and submitting, program generates:
    - scores.csv
    - review_log.txt

How to run:
1. Install Java (JDK 8+).
2. From project root, compile:
   javac -d bin src/*.java
3. Copy sample CSVs into the same folder where you run the program (questions.csv, key.csv).
4. Run:
   java -cp bin Main
5. Sample CLI commands:
   load questions.csv
   load key.csv
   start 2
   answer 1 A
   answer 3 Polymorphism is when objects take many forms
   save
   submit
   export

Notes:
- Timer strict: when time ends the program auto-submits and exits.
- Autosave writes to autosave_responses.txt every minute.
- Short answer scoring uses keyword matching (partial credit proportional to matched keywords).
- Feel free to expand evaluation strategies, persistence, and CLI ergonomics.

Files to inspect/modify:
- src/ExamEngine.java : core logic for loading, autosave, evaluation, export.
- src/ShortAnswerQuestion.java : keyword-based partial scoring.
- src/MCQQuestion.java : MCQ scoring with negative marks.

Prepared by ChatGPT — you can modify sample CSV to add more questions.
