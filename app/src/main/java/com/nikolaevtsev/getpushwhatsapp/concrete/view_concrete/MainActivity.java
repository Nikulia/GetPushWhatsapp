package com.nikolaevtsev.getpushwhatsapp.concrete.view_concrete;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nikolaevtsev.getpushwhatsapp.R;
import com.nikolaevtsev.getpushwhatsapp.concrete.model_concrete.services.NotificationListener;

public class MainActivity extends AppCompatActivity {

    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String ACTION_NOTIFICATION_LISTENER_SETTINGS =
            "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
    public static final String IS_RECORD_START_INTENT = "Is record start?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isNotificationServiceEnabled()) {
            startActivity(new Intent(ACTION_NOTIFICATION_LISTENER_SETTINGS));
        }
    }

    public void onClickStartRecordMessages(View view) {
        Button button = (Button) view;
        Intent intent = new Intent(this, NotificationListener.class);
        if (button.getTag().toString().equals(getString(R.string.false_answer))) {
            intent.putExtra(IS_RECORD_START_INTENT, true);
            button.setText(getString(R.string.stop_record_whatsapp_messages));
            button.setTag(getString(R.string.true_answer));
        } else if (button.getTag().toString().equals(getString(R.string.true_answer))) {
            intent.putExtra(IS_RECORD_START_INTENT, false);
            button.setText(getString(R.string.start_record_whatsapp_messages));
            button.setTag(getString(R.string.false_answer));
        }
        startService(intent);
    }

    private boolean isNotificationServiceEnabled() {
        String pkgName = getPackageName();
        final String flat = Settings.Secure.getString(getContentResolver(),
                ENABLED_NOTIFICATION_LISTENERS);
        if (!TextUtils.isEmpty(flat)) {
            final String[] names = flat.split(":");
            for (int i = 0; i < names.length; i++) {
                final ComponentName cn = ComponentName.unflattenFromString(names[i]);
                if (cn != null) {
                    if (TextUtils.equals(pkgName, cn.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void onClickGoToMessagesFromDBActivity(View view) {
        Intent intent = new Intent(this, MessagesFromDBActivity.class);
        startActivity(intent);
    }
}
