package com.nikolaevtsev.getpushwhatsapp.concrete.view_concrete.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolaevtsev.getpushwhatsapp.R;
import com.nikolaevtsev.getpushwhatsapp.concrete.model_concrete.pojo.MessageForView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    List<MessageForView> messages;

    public MessageAdapter() {
        messages = new ArrayList<>();
    }

    public void setMessages(List<MessageForView> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        MessageForView message = messages.get(position);
        holder.textViewPostTime.setText(message.getTimePost());
        holder.textViewMessageFrom.setText(message.getFromContact());
        holder.textViewMessageText.setText(message.getMessageText());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView textViewPostTime;
        TextView textViewMessageFrom;
        TextView textViewMessageText;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPostTime = itemView.findViewById(R.id.textViewPostTime);
            textViewMessageFrom = itemView.findViewById(R.id.textViewMessageFrom);
            textViewMessageText = itemView.findViewById(R.id.textViewMessageText);
        }
    }
}
