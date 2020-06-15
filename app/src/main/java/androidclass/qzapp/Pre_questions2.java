package androidclass.qzapp;

/**
 * Created by hp on 7/6/2018.
 */

public class Pre_questions2 {

    public String mQuestions[] = {
        "Which of the following numbers gives 240 when added to its own square?",
            "A clock strikes once at 1 o’clock, twice at 2 o’clock, thrice at 3 o’clock and so on. How many times will it strike in 24 hours?",
                "Evaluation of 83 × 82 × 8-5 is …………. ",
                "$ 2496 is spend in the floor repair of 30 × 16 ft hall. What is repair cost per square feet?",
                "Take out the wrong number from the given series.\n" +
                        "3, 4, 9, 33, 136, 685, 4116",
                        "Light from the Sun reaches us in nearly",
                    "Pick out the scalar quantity",
                    "Magnetism at the centre of a bar magnet is",
            "Of the following properties of a wave, the one that is independent of the other is its",
                    "Sound of frequency below 20 Hz is called"
    };

    public int c=mQuestions.length;

    public String mChoices[][] = {
            {"15", "16", "18", "20"},
            {"78", "136", "156", "178"},
            {"1", "0", "8", "None of these"},
            {"$ 5.20", " $ 78.00", "$ 12.48", "$ 52.00"},
            {"33", "9", "685", "133"},
            {"2 minutes", "4 minutes", "8 minutes", "16 minutes"},
            {"force", "pressure", "velocity", "acceleration"},
            {"minimum", "maximum", "zero", "minimum or maximum"},
            {"amplitude", "velocity", "wavelength", "frequency"},
            {"audio sounds", "infrasonic", "ultrasonic", "supersonics"}
    };

    public String mAnswers[] = { "15", "156", "1", "$ 5.20", "9", "8 minutes","pressure","zero","amplitude","infrasonic" };

    public String getQuestions(int a)
    {
        String questions = mQuestions[a];
        return questions;
    }

    public String getChoice1(int a)
    {
        String answer1 = mChoices[a][0];
        return answer1;
    }

    public String getChoice2(int a)
    {
        String answer2 = mChoices[a][1];
        return answer2;
    }

    public String getChoice3(int a)
    {
        String answer3 = mChoices[a][2];
        return answer3;
    }

    public String getChoice4(int a)
    {
        String answer4 = mChoices[a][3];
        return answer4;
    }
    public String getCorrectAnswer(int a)
    {
        String answer = mAnswers[a];
        return answer;
    }



}
