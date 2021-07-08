package bunkov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlockOfCameras {

    @Autowired
    private Camera camera1;

    @Autowired
    private Camera camera2;

    @Autowired
    private Camera camera3;


    public void doPhoto(){
        camera1.doPhotograhpy();
        camera2.doPhotograhpy();
        camera3.doPhotograhpy();
    }
}
