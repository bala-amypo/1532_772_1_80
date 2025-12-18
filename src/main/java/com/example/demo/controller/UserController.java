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
