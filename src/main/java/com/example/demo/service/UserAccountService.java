import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.example.demo.entity.EventMergeRecord;

public interface UserAccountService {
    UserAccount register(UserAccount u);
    String login(UserAccount u);
}
