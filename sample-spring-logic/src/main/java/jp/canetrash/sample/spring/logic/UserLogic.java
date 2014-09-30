package jp.canetrash.sample.spring.logic;

import jp.canetrash.sample.spring.dbflute.exentity.Users;
import jp.canetrash.sample.spring.dbflute2.exentity.OtherUsers2;



public interface UserLogic {

	Users getUserById(Integer id);

	OtherUsers2 getOtherUserById(Integer id);

	Integer register(Users user);

	void registerOtherUser(Users users);

	void deleteUser(Integer id);
}
