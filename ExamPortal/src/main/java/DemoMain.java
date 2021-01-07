import com.vwits.OEP.dao.UserDAO;
import com.vwits.OEP.model.Users;

public class DemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Users u1 = new Users(1, "abc", "abc", "1234", "teacher", "Y");
		UserDAO userdao = new UserDAO();
		userdao.registerUser(u1);
	}

}
