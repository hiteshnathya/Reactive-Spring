package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class ClaimStatusUpdateHandler {

    @Autowired
    private ClaimRepository claimRepository;

    public Flux<ClaimStatusUpdate> handleClaimStatusUpdates() {
        return claimRepository.findClaimStatusUpdates();
    }
}