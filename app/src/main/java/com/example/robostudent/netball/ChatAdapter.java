package com.example.robostudent.netball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChatAdapter extends ArrayAdapter<ChatMesage> {
    public ChatAdapter(Context context, int resource) {
        super(context, resource);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_massenger, null);

            viewHolder = new ViewHolder();
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.username = (TextView) convertView.findViewById(R.id.nic_user);
        viewHolder.messagetext = (TextView) convertView.findViewById(R.id.message_text);

        ChatMesage item = getItem(position);
        if (item != null) {
            viewHolder.username.setText(item.getMessageUser());
            viewHolder.messagetext.setText(item.getMessageText());
        }

        return convertView;
    }

    private static class ViewHolder{
        TextView username;
        TextView messagetext;
    }

}

