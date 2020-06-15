package androidclass.qzapp;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hp on 7/6/2018.
 */

public class Pre_questions  {



    public String mQuestions[] = new String[] {
        "Who is father of C Language?",
        "C programs are converted into machine language with the help of",
        "Which one of the following is not a reserved keyword for C?",
        "A C variable cannot start with",
            "What will be printed after execution of the following program code?" +
                    "main()\n" +
                    "{\n" +
                    "      printf(\"\\\\nab\"); \n" +
                    "      printf(\"\\\\bsi\"); \n" +
                    "      printf(\"\\\\rha\"); \n" +
                    "}",
            "What is the correct value to return to the operating system upon the successful completion of a program?",
            "Which is the only function all C programs must contain?",
            "Which of the following is not a correct variable type?",
            "Find the output of the following program. void main() { int i=01289; printf(\"%d\", i); }",
            "If ASCII value of 'x' is 120, then what is the value of the H, if\n" +
                    "H = ('x' – 'w' ) / 3;"
    };

    public int c=mQuestions.length;

    public String mChoices[][] = {
            {"Bjarne Stroustrup", "James A. Gosling", "Dennis Ritchie", "Dr. E.F. Codd"},
            {"An Editor", "A compiler", "An operating system", "None of the above"},
            {"auto", "case", "main", "default"},
            {"A number", "A special symbol other than underscore", "Both of the above", "An alphabet"},
            {"absiha", "asiha", "haasi", "hai"},
            {"1", "-1", "0", "Program do no return a value."},
            {"start()", "system()", "main()", "getch()"},
            {"float", "real", "int", "char"},
            {"01289", "1289", "713", "Syntax error"},
            {"0", "1", "2", "3"}
    };

    public String mAnswers[] = { "Dennis Ritchie", "A compiler", "main", "Both of the above", "hai","0","main()","real","Syntax error","0"};

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
