import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class IniRealmTest {
    IniRealm iniRealm = new IniRealm("classpath:user.ini");

    @Test
    public void authTest(){

        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("abg","123456");
        subject.login(token);

        System.out.println("isAuthenticated : " + subject.isAuthenticated());

        subject.checkRole("admin");
        subject.checkPermission("user:delete");
    }
}
