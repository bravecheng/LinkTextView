package mobi.chy.linkexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mobi.chy.linkexample.R;
import mobi.chy.linktextview.LinkTextView;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        LinkTextView ltvDemo = findViewById(R.id.ltv_demo);
        ltvDemo.setOnLinkClickListener(new LinkTextView.OnLinkClickListener() {
            @Override
            public void onLinkClick() {
                Toast.makeText(DemoActivity.this,"link clicked!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
