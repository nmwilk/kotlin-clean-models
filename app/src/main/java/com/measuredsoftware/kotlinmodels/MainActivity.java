package com.measuredsoftware.kotlinmodels;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.measuredsoftware.kotlinmodels.api.ApiContact;
import com.measuredsoftware.kotlinmodels.dto.Contact;

import java.util.Arrays;
import java.util.List;

/**
 * Created by neil.wilkinson on 07/07/2016.
 */
public class MainActivity extends AppCompatActivity {
    private List<ApiContact> apiContactsList = Arrays.asList(
            new ApiContact(1, "Andy", "Aardvark Street", "Airton"),
            new ApiContact(2, "Brian", "Bird Street", "Barton")
    );

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final List<Contact> contactsList = MapperKt.mapApiContactsToContacts(apiContactsList);

        final String displayText = MapperKt.buildDisplayContactString(contactsList);

        ((TextView) findViewById(R.id.text_view)).setText(displayText);
    }
}
