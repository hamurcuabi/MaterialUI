package com.infinite.fireapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.infinite.fireapp.R;
import com.infinite.fireapp.adapters.ContactDetailsAdapter;
import com.infinite.fireapp.model.realms.Message;
import com.infinite.fireapp.model.realms.PhoneNumber;
import com.infinite.fireapp.model.realms.RealmContact;
import com.infinite.fireapp.model.realms.User;
import com.infinite.fireapp.utils.ClipboardUtil;
import com.infinite.fireapp.utils.FireManager;
import com.infinite.fireapp.utils.IntentUtils;
import com.infinite.fireapp.utils.NetworkHelper;
import com.infinite.fireapp.utils.RealmHelper;

public class ContactDetailsActivity extends AppCompatActivity {
    private TextView tvContactNameDetails;
    private Button btnAddContact;


    private RecyclerView recyclerView;
    AlertDialog b;
    AlertDialog.Builder dialogBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        tvContactNameDetails = findViewById(R.id.tv_contact_name_details);
        recyclerView = findViewById(R.id.rv_contact_details);
        btnAddContact = findViewById(R.id.btn_add_contact);


        if (!getIntent().hasExtra(IntentUtils.EXTRA_MESSAGE_ID))
            return;

        String id = getIntent().getStringExtra(IntentUtils.EXTRA_MESSAGE_ID);
        String chatId = getIntent().getStringExtra(IntentUtils.EXTRA_CHAT_ID);
        Message message = RealmHelper.getInstance().getMessage(id, chatId);
        if (message == null)
            return;

        getSupportActionBar().setTitle(R.string.contact_info);
        final RealmContact contact = message.getContact();
        tvContactNameDetails.setText(contact.getName());
        ContactDetailsAdapter adapter = new ContactDetailsAdapter(contact.getRealmList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(IntentUtils.getAddContactIntent(contact));
            }
        });

        adapter.setOnItemClick(new ContactDetailsAdapter.OnItemClick() {
            @Override
            public void onItemClick(View view, int pos) {
                if (!NetworkHelper.isConnected(ContactDetailsActivity.this)) {
                    Snackbar.make(findViewById(android.R.id.content), R.string.no_internet_connection, Snackbar.LENGTH_SHORT).show();
                    return;
                }

                PhoneNumber phoneNumber = contact.getRealmList().get(pos);
                showProgress();
                FireManager.isHasFireApp(phoneNumber.getNumber(), new FireManager.IsHasAppListener() {
                    @Override
                    public void onFound(User user) {
                        hideProgress();
                        startChatActivityWithDifferentUser(user);
                    }

                    @Override
                    public void onNotFound() {
                        hideProgress();
                        Snackbar.make(findViewById(android.R.id.content), R.string.does_not_have_fireapp, Snackbar.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onItemLongClick(View view, int pos) {

                PhoneNumber phoneNumber = contact.getRealmList().get(pos);
                ClipboardUtil.copyTextToClipboard(ContactDetailsActivity.this, phoneNumber.getNumber());
                Toast.makeText(ContactDetailsActivity.this, R.string.copied_to_clipboard, Toast.LENGTH_SHORT).show();
            }
        });


    }


    public void showProgress() {
        dialogBuilder = new AlertDialog.Builder(ContactDetailsActivity.this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.progress_dialog_layout, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(true);
        b = dialogBuilder.create();
        b.show();
    }

    public void hideProgress() {

        b.dismiss();
    }

    private void startChatActivityWithDifferentUser(User user) {
        Intent intent = new Intent(ContactDetailsActivity.this, ChatActivity.class);
        intent.putExtra(IntentUtils.UID, user.getUid());
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
