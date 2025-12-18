import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class UserController {

    @Autowired
    private UserAccountService service;

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount u) {
        return service.register(u);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount u) {
        return service.login(u);
    }
}
