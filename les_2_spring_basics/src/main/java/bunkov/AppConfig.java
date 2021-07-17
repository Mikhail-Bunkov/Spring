package bunkov;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("bunkov")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Camera camera(CameraRoll cameraRoll ){
        return new Camera(cameraRoll);
    }
}
