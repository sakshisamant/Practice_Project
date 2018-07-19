package sakshi.com.practice_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button next, info;
    TextView name, email, mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (Button) findViewById(R.id.bt_next);
        info = (Button) findViewById(R.id.bt_info);
        name = (TextView) findViewById(R.id.tv_name);
        email = (TextView) findViewById(R.id.tv_mail);
        mobile = (TextView) findViewById(R.id.tv_mobile);


    }
}
