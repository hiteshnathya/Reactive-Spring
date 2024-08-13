package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

@Component
public class ClaimStatusWebSocketHandler implements WebSocketHandler {

    @Autowired
    private ClaimStatusUpdateHandler claimStatusUpdateHandler;

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(claimStatusUpdateHandler.handleClaimStatusUpdates()
                .map(claimStatusUpdate -> session.textMessage(claimStatusUpdate.toString())));
    }
}