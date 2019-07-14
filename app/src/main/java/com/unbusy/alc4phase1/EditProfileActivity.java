package com.unbusy.alc4phase1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class EditProfileActivity extends AppCompatActivity {

    private TextView myName;
    private TextView mySlackName;
    private TextView myEmail;
    private TextView myPhone;
    private Spinner trackSpinner;
    private Spinner countrySpinner;
    private ArrayList<String> mTracks;
    private ArrayList<String> mCountries;
    private UserProfileInfo mUserProfileInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        trackSpinner = findViewById(R.id.track_spinner);
        countrySpinner = findViewById(R.id.country_spinner);

        mTracks = new ArrayList<>();
        mTracks.addAll(Arrays.asList(getResources().getStringArray(R.array.alc_tracks)));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, mTracks);
        trackSpinner.setAdapter(arrayAdapter);

        mCountries = new ArrayList<>();
        mCountries.addAll(Arrays.asList(getResources().getStringArray(R.array.countries)));
        ArrayAdapter<String> countryArrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, mCountries);
        countrySpinner.setAdapter(countryArrayAdapter);

        myName = findViewById(R.id.my_name_textedit);
        mySlackName = findViewById(R.id.slack_value_textedit);
        myEmail = findViewById(R.id.email_value_textedit);
        myPhone = findViewById(R.id.phone_value_textedit);

        initializeEditUI();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initializeEditUI() {
        mUserProfileInfo = ProfileManager.getInstance().getUserProfileInfo();

        myName.setText(mUserProfileInfo.getmName());
        trackSpinner.setSelection(mTracks.indexOf(mUserProfileInfo.getmTrack()));
        countrySpinner.setSelection(mCountries.indexOf(mUserProfileInfo.getmCountry()));
        myEmail.setText(mUserProfileInfo.getmEmailAddress());
        mySlackName.setText(mUserProfileInfo.getmSlackUsername());
        myPhone.setText(mUserProfileInfo.getmPhoneNumber());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.save_edit:
                mUserProfileInfo.setmName(myName.getText().toString());
                mUserProfileInfo.setmSlackUsername(mySlackName.getText().toString());
                mUserProfileInfo.setmCountry(countrySpinner.getSelectedItem().toString());
                mUserProfileInfo.setmTrack(trackSpinner.getSelectedItem().toString());
                mUserProfileInfo.setmEmailAddress(myEmail.getText().toString());
                mUserProfileInfo.setmPhoneNumber(myPhone.getText().toString());

                ProfileManager.updateProfileManager(mUserProfileInfo);

                Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}
