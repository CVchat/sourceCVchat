package telran.m2m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @PostMapping("/command")
    public String viewCommand(@RequestBody String data) {
        System.out.println("Query ...");
        System.out.println(data);
        return data;
        //TODO create control and change of the objects by control
    }
}
