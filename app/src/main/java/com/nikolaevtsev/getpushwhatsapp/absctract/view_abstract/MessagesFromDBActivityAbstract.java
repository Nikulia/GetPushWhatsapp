package com.nikolaevtsev.getpushwhatsapp.absctract.view_abstract;

import com.nikolaevtsev.getpushwhatsapp.concrete.model_concrete.pojo.MessageForView;

import java.util.List;

public interface MessagesFromDBActivityAbstract {
    void dataChanged (List<MessageForView> messages);
}
