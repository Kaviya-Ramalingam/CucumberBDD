package dsalgo.utilities;

import java.time.Duration;

public enum Timeouts {
	
	SHORT(5),
    MEDIUM(10),
    LONG(20),
    VERY_LONG(30);

    private final int seconds;

    

	Timeouts(int seconds) {
        this.seconds = seconds;
    }

    public Duration getDuration() {
        return Duration.ofSeconds(seconds);
    }

    public int getSeconds() {
        return seconds;
    }

}
