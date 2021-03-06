package bunkov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Camera {

    private final CameraRoll cameraRoll;

    @Autowired
    public Camera(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    void doPhotograhpy(){
        cameraRoll.processing();
    }
}
