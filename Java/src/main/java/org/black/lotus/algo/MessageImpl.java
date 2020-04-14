package org.black.lotus.algo;

import java.util.UUID;

public class MessageImpl implements Message {

    private final byte[] payload;
    private UUID messageId;

    public MessageImpl(byte[] payload) {
        this.payload = payload;
        this.messageId = UUID.randomUUID();
    }

    @Override
    public UUID messageId() {
        return messageId;
    }
}
