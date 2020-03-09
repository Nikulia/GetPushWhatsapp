package com.nikolaevtsev.getpushwhatsapp.concrete.view_concrete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.nikolaevtsev.getpushwhatsapp.R;
import com.nikolaevtsev.getpushwhatsapp.absctract.view_abstract.MessagesFromDBActivityAbstract;
import com.nikolaevtsev.getpushwhatsapp.concrete.model_concrete.pojo.MessageForView;
import com.nikolaevtsev.getpushwhatsapp.concrete.presenter_concrete.MessagesFromDBPresenter;
import com.nikolaevtsev.getpushwhatsapp.concrete.view_concrete.adapters.MessageAdapter;

import java.util.List;

public class MessagesFromDBActivity extends AppCompatActivity implements MessagesFromDBActivityAbstract {

    private RecyclerView recyclerViewMessages;
    private MessageAdapter adapter;
    private MessagesFromDBPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_from_db);
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        presenter = new MessagesFromDBPresenter(this, this);
        adapter = new MessageAdapter();
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(adapter);
            }

    @Override
    public void dataChanged(List<MessageForView> messages) {
        adapter.setMessages(messages);
    }

    public void onClickClear(View view) {
        presenter.clearDB();
    }
}
