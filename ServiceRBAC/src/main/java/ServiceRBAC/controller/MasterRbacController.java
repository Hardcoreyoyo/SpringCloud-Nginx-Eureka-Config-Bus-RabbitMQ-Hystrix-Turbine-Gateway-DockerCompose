package ServiceRBAC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterRbacController {

    @GetMapping("")
    public String MasterPath(){
        return "Service RBAC MasterPath";
    }

}
