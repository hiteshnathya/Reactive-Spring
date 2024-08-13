package org.example;


public class ClaimStatusUpdate {
    private String claimNumber;
    private String status;

    public ClaimStatusUpdate(String claimNumber, String status) {
        this.claimNumber = claimNumber;
        this.status = status;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ClaimStatusUpdate{" +
                "claimNumber='" + claimNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}