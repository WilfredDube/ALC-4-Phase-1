package com.unbusy.alc4phase1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private TextView myTrack;
    private TextView myCountry;
    private TextView myName;
    private TextView mySlackName;
    private TextView myEmail;
    private TextView myPhone;
    private UserProfileInfo myProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeProfileUI();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initializeProfileUI() {
        myTrack = findViewById(R.id.track_value_textview);
        myCountry = findViewById(R.id.country_value_textview);
        myName = findViewById(R.id.my_name_textedit);
        mySlackName = findViewById(R.id.slack_value_textedit);
        myEmail = findViewById(R.id.email_value_textedit);
        myPhone = findViewById(R.id.phone_value_textedit);

        myProfile = ProfileManager.getInstance().getUserProfileInfo();

        myName.setText(myProfile.getmName());
        myTrack.setText(myProfile.getmTrack());
        myCountry.setText(myProfile.getmCountry());
        myEmail.setText(myProfile.getmEmailAddress());
        mySlackName.setText(myProfile.getmSlackUsername());
        myPhone.setText(myProfile.getmPhoneNumber());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){

            case R.id.edit_profile:
                intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.share_profile:
                sendProfile();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void sendProfile() {
        String messageToShare = myProfile.getFormattedSendText();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, messageToShare);
        intent.setType("text/plain");

        Intent chooser = Intent.createChooser(intent, "Send by");

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}
