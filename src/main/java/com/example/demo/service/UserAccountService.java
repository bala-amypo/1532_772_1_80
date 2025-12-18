import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


public interface UserAccountService {
    UserAccount register(UserAccount u);
    String login(UserAccount u);
}
