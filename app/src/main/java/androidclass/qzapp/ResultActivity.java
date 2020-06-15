package androidclass.qzapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by hp on 7/7/2018.
 */

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
       // TextView t=(TextView)findViewById(R.id.textResult);
        TextView s=(TextView)findViewById(R.id.score_display);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
//display score

        s.setText(String.valueOf(score));
        //bar.setRating(score);
        /*switch (score)
        {
            case 1:
            case 2: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 3:
            case 4:t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                break;
            case 5:t.setText("Who are you? A trivia wizard???");
                break;
        }*/
    }
}
