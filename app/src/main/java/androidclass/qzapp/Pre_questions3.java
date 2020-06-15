package androidclass.qzapp;

/**
 * Created by hp on 7/6/2018.
 */

public class Pre_questions3 {
    public String mQuestions[] = {
            "What is ‘Basis of Encapsulation’?",
            "Which Keyword from the following is used to inherit properties from one class into another?",
            "Which of the following concept is often expressed by the phrase, ‘One interface, multiple methods’?",
            "___________ will immediately jump to the end of the current block of code",
            " Which is more memory efficient ?",
            "Which among following is correct way of declaring object of a class ?",
            "What will be output if you will compile and execute the following c code?",
            "What will be output if you will compile and execute the following c code?\n" +
                    "\n" +
                    "void main(){\n" +
                    "   float a=5.2;\n" +
                    "  if(a==5.2)\n" +
                    "     printf(\"Equal\");\n" +
                    "  else if(a<5.2)\n" +
                    "     printf(\"Less than\");\n" +
                    "  else\n" +
                    "     printf(\"Greater than\"); \n" +
                    "}",
            "What will be output if you will compile and execute the following c code?\n" +
                    "\n" +
                    "void main(){\n" +
                    "  int i=4,x;\n" +
                    "  x=++i + ++i + ++i;\n" +
                    "  printf(\"%d\",x); \n" +
                    "}",
            "What will be output if you will compile and execute the following c code?\n" +
                    "\n" +
                    "void main(){\n" +
                    "  int a=10;\n" +
                    "  printf(\"%d %d %d\",a,a++,++a); \n" +
                    "}"
    };

    public int c=mQuestions.length;

    public String mChoices[][] = {
            {"object", "class", "method", "all of the mentioned"},
            {"extends", "subclasses", "native", "all of the mentioned"},
            {"Abstraction", "Polymorphism", "Inheritance", "Encapsulation"},
            {"continue", "exit", "goto", "break"},
            {"structure", "union", "both use same memory", "depends on a programmer"},
            {"Classname Objectname;", "Class Classname Objectname;", "Class Classname Object Objectname;", "Classname Object Objectname;"},
            {"135", "+INF", "-121", "Compiler error"},
            {"Equal", "Less than", "Greater than", "Compiler error"},
            {"21", "18", "15", "Compiler error"},
            {"12 11 11", "12 10 10", "11 11 12", "10 10 12"}
    };

    public String mAnswers[] = { "all of the mentioned", "extends", "Polymorphism", "break", "union","Classname Objectname;","-121","Less than","18","12 11 11" };

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
