package org.example;



import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ClaimRepository {

    @Autowired
    private R2dbcTemplate r2dbcTemplate;

    public Flux<ClaimStatusUpdate> findClaimStatusUpdates() {
        return r2dbcTemplate.getDatabaseClient()
                .sql("SELECT claim_number, status FROM claims WHERE status = 'IN_PROGRESS'")
                .map(row -> new ClaimStatusUpdate(row.get("claim_number", String.class), row.get("status", String.class)))
                .flux();
    }

    public Mono<Void> updateClaimStatus(String claimNumber, String status) {
        return r2dbcTemplate.getDatabaseClient()
                .sql("UPDATE claims SET status = :status WHERE claim_number = :claimNumber")
                .bind("claimNumber", claimNumber)
                .bind("status", status)
                .then();
    }
}