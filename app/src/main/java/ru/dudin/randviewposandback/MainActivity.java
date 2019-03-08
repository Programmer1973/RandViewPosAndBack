package ru.dudin.randviewposandback;

/**
 * Experiments with TextView position by pressing the Button.
 * Start position in screen center, then in random manner position changes to the edges/angles of
 * the screen, then move backwards to the initial position.
 *
 * @created 09.03.2019
 * @author Andrey Dudin <programmer1973@mail.ru>
 * @version 0.1.0.2019.03.09
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private int mDefaultGravity;
    private int mGravity;
    private Boolean mStartPosition = true;
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = findViewById(R.id.relative_layout);
        mDefaultGravity = mRelativeLayout.getGravity();

        findViewById(R.id.press_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mStartPosition) {

                    switch(new Random().nextInt(8)) {
                        case 0:
                             mGravity = Gravity.START;
                             break;

                        case 1:
                            mGravity = Gravity.CENTER_HORIZONTAL;
                            break;

                        case 2:
                            mGravity = Gravity.END;
                            break;

                        case 3:
                            mGravity = Gravity.END|Gravity.CENTER_VERTICAL;
                            break;

                        case 4:
                            mGravity = Gravity.BOTTOM|Gravity.END;
                            break;

                        case 5:
                            mGravity = Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL;
                            break;

                        case 6:
                            mGravity = Gravity.BOTTOM;
                            break;

                        case 7:
                            mGravity = Gravity.START|Gravity.CENTER_VERTICAL;
                            break;

                        default:
                            showMessage();
                    }
                } else {
                    mGravity = mDefaultGravity;
                }

                setTextViewGravity(mGravity);
            }
        });
    }

    private void setTextViewGravity(int mGravity) {
        mRelativeLayout.setGravity(mGravity);
        mStartPosition = !mStartPosition;
    }

    private void showMessage() {
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(getApplicationContext(), "Unknown position", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}