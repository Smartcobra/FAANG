package org.asiczen;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 1000); // 5 requests per second

        // Simulate user requests
        String userId = "user123";
        for (int i = 0; i < 10; i++) {
            boolean allowed = rateLimiter.isAllowed(userId);
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Rate limit exceeded"));
            Thread.sleep(200); // Simulate time gap between requests
        }
    }
}