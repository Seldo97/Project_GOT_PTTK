package grupa4.projektzespolowy.GOTTPKProjekt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfiguration {

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(500);
        executor.setQueueCapacity(50000);
        executor.setThreadNamePrefix("AsyncTask-");
        executor.initialize();

        return executor;
    }

}
