package org.example;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class ClaimStatusUpdateTest {

    @Autowired
    private ClaimStatusUpdateHandler claimStatusUpdateHandler;

    @Test
    void testHandleClaimStatusUpdates() {
        Flux<ClaimStatusUpdate> updates = claimStatusUpdateHandler.handleClaimStatusUpdates();
        StepVerifier.create(updates)
                .expectNextCount(1)
                .verifyComplete();
    }
}