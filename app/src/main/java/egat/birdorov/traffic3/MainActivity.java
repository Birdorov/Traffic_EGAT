package egat.birdorov.traffic3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private ListView trafficListView;
    private Button AboutMEButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Widget
        bindWidget();

        // Button Controller
        buttonController();

        // Creat ListView
        createListView();

    }   // Main Method

    private void createListView() {

        // Setup intDrawable
        final int intDrawable[] = {R.drawable.traffic_01, R.drawable.traffic_02,
                R.drawable.traffic_03, R.drawable.traffic_04,
                R.drawable.traffic_05, R.drawable.traffic_06,
                R.drawable.traffic_07, R.drawable.traffic_08,
                R.drawable.traffic_09, R.drawable.traffic_10,
                R.drawable.traffic_11, R.drawable.traffic_12,
                R.drawable.traffic_13, R.drawable.traffic_14,
                R.drawable.traffic_15, R.drawable.traffic_16,
                R.drawable.traffic_17, R.drawable.traffic_18,
                R.drawable.traffic_19, R.drawable.traffic_20};

        // Setup Title
        final String strTitle[] = new String[20];
        strTitle[0] = "ห้ามเลี้ยวซ้าย";
        strTitle[1] = "ห้ามเลี้ยวขวา";
        strTitle[2] = "ตรงไป";
        strTitle[3] = "เลี้ยวขวา";
        strTitle[4] = "เลี้ยวซ้าย";
        strTitle[5] = "ออก";
        strTitle[6] = "เข้า";
        strTitle[7] = "ออก";
        strTitle[8] = "หยุด";
        strTitle[9] = "จำกัดความสูง";
        strTitle[10] = "ทางแยก";
        strTitle[11] = "ห้ามกลับรถ";
        strTitle[12] = "ห้ามจอด";
        strTitle[13] = "รถสวน";
        strTitle[14] = "ห้ามแซง";
        strTitle[15] = "เข้า";
        strTitle[16] = "หยุดตรวจ";
        strTitle[17] = "จำกัดความเร็ว";
        strTitle[18] = "จำกัดความกว้าง";
        strTitle[19] = "จำกัดความสูง";

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, intDrawable, strTitle);
        trafficListView.setAdapter(objMyAdapter);

        // Active When Click
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Intent to DetailActivity
                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);
                objIntent.putExtra("Title", strTitle[position]);
                objIntent.putExtra("Image", intDrawable[position]);
                objIntent.putExtra("index", position);
                startActivity(objIntent);


            }   // Event
        });


    }   //createListView


    private void buttonController() {
        AboutMEButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Sound Effect
                MediaPlayer buttonMediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.phonton2);
                buttonMediaPlayer.start();

                // Internet to Webview
                Intent objIntent = new Intent(Intent.ACTION_VIEW);
                objIntent.setData(Uri.parse("http://www.egat.co.th/index.php?option=com_content&view=article&id=346&Itemid=209"));
                startActivity(objIntent);

            }   // event
        });


    }   // buttonController

    private void bindWidget() {

        trafficListView = (ListView) findViewById(R.id.listView);
        AboutMEButton = (Button) findViewById(R.id.button);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   // Main Class
