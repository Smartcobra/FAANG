package org.asiczen;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    // Map to track user requests within the window
    private final ConcurrentHashMap<String, UserRequestTracker> requestMap = new ConcurrentHashMap<>();
    private final int maxRequests; // Maximum allowed requests per window
    private final long windowSizeMillis; // Time window in milliseconds

    public RateLimiter(int maxRequests, long windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
    }

    public boolean isAllowed(String userId) {
        long currentTime = System.currentTimeMillis();

        // Get or create a tracker for the user
        UserRequestTracker tracker = requestMap.computeIfAbsent(userId, k -> new UserRequestTracker(currentTime));

        synchronized (tracker) {
            if (currentTime - tracker.startTime >= windowSizeMillis) {
                // Reset the window
                tracker.startTime = currentTime;
                tracker.requestCount.set(0);
            }

            if (tracker.requestCount.incrementAndGet() <= maxRequests) {
                return true; // Allowed
            } else {
                return false; // Rate limit exceeded
            }
        }
    }

    // Inner class to track requests for a user
    private static class UserRequestTracker {
        private long startTime;
        private AtomicInteger requestCount;

        public UserRequestTracker(long startTime) {
            this.startTime = startTime;
            this.requestCount = new AtomicInteger(0);
        }
    }
}
