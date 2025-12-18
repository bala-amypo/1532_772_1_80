import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository repo;

    @Override
    public UserAccount register(UserAccount u) {
        return repo.save(u);
    }

    @Override
    public String login(UserAccount u) {
        UserAccount exist = repo.findByUsername(u.getUsername());
        if(exist != null && exist.getPassword().equals(u.getPassword())) {
            return "Login Success";
        }
        return "Invalid Username or Password";
    }
}
