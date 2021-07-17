package bunkov;

import org.springframework.stereotype.Component;

//@Component
public class BAWCameraRoll implements CameraRoll{
    @Override
    public void processing() {
        System.out.println("-1 черно-белый кадр");
    }
}
