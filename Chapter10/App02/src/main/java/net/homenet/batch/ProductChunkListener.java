package net.homenet.batch;

import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.stereotype.Component;

@Component
public class ProductChunkListener {
    @BeforeChunk
    public void beforeChunk() {
        System.out.println("*** Before chunk");
    }

    @AfterChunk
    public void afterChunk() {
        System.out.println("*** After chunk");
    }
}
