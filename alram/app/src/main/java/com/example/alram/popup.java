package com.example.alram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        TextView tv = (TextView)findViewById(R.id.message);

        tv.setText(getIntent().getStringExtra("답변이 도착했어요!");

        ImageButton ib = (ImageButton)findViewById(R.id.confirm);

        ib.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                // 확인버튼을 누르면 앱의 런처액티비티를 호출한다.

                Intent intent = new Intent(popup.this, popup.class);

                startActivityForResult(intent, K.REQUEST_NORMAL);

                finish();

            }

        });
    }
    public static boolean isScreenOn(Context context) {
        return ((PowerManager)context.getSystemService(Context.POWER_SERVICE)).isScreenOn();
    }
    private void getMessage(Intent intent, Context context) {

        // 만약 팝업 알림 설정이 켜져있으면 실행한다.

        if (isPopup) {

            // 팝업으로 사용할 액티비티를 호출할 인텐트를 작성한다.

            Intent popupIntent = new Intent(context, Popup.class)

                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // 그리고 호출한다.

            context.startActivity(popupIntent);

        }

    }

}