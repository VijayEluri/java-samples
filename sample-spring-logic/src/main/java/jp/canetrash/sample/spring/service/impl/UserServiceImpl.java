package jp.canetrash.sample.spring.service.impl;

import jp.canetrash.sample.spring.dbflute.exentity.Users;
import jp.canetrash.sample.spring.dbflute2.exentity.OtherUsers2;
import jp.canetrash.sample.spring.logic.UserLogic;
import jp.canetrash.sample.spring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {


	@Autowired
	private UserLogic userLogic;
	
	public Users getUserById(Integer id) {
		return userLogic.getUserById(id);
	}

	public OtherUsers2 getOtherUserById(Integer id) {
		return userLogic.getOtherUserById(id);
	}

	public Integer registerUser(Users user) {
		
		return userLogic.register(user);
	}

	public void moveUser(Integer id) {
		// XXX 移動対象のUsers取ってくる
		if (id == null) {
			throw new RuntimeException("引数idがnullです");
		}
		Users users = userLogic.getUserById(id);
		if (users == null) {
			throw new RuntimeException("対象ユーザが見つかりませんでした。id:" + id);
		}
		userLogic.registerOtherUser(users);
		userLogic.deleteUser(id);
	}
}
