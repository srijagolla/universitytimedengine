import java.util.concurrent.*;
import java.util.*;

public class ExamTimer {
    private ScheduledExecutorService scheduler;
    private int remainingSeconds;
    private List<Runnable> tickListeners = new ArrayList<>();
    private Runnable onExpire;

    public ExamTimer() {}

    public void addTickListener(Runnable r) { tickListeners.add(r); }

    public void start(int minutes, Runnable onExpire) {
        this.onExpire = onExpire;
        remainingSeconds = minutes * 60;
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            remainingSeconds--;
            for (Runnable r : tickListeners) {
                try { r.run(); } catch (Exception ignored) {}
            }
            if (remainingSeconds <= 0) {
                stop();
                if (this.onExpire != null) this.onExpire.run();
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    public void stop() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow();
        }
    }

    public int getRemainingSeconds() { return remainingSeconds; }
}
