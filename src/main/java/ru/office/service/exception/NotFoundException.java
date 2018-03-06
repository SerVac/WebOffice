package ru.office.service.exception;

import ru.office.service.utils.MsgFormatter;

public class NotFoundException extends Exception {

    private static final String NOT_FOUND_EXC_MSG_WITH_PARAM = "Can't found entity with Id = %s";
    private final String msg;

    public NotFoundException(long id) {
        super(MsgFormatter.formatMsgWithId(NOT_FOUND_EXC_MSG_WITH_PARAM, id));
        msg = super.getMessage();
    }

    public final String getMsg() {
        return msg;
    }
}
