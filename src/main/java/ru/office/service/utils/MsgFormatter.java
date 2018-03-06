package ru.office.service.utils;

public class MsgFormatter {

    public static final String formatMsgWithId(String msg, long id){
        return String.format(msg, id);
    }
}
