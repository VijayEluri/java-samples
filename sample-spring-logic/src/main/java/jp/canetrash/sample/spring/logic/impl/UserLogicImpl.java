package jp.canetrash.sample.spring.logic.impl;

import jp.canetrash.sample.spring.dbflute.exbhv.UsersBhv;
import jp.canetrash.sample.spring.dbflute.exentity.Users;
import jp.canetrash.sample.spring.dbflute2.exbhv.OtherUsers2Bhv;
import jp.canetrash.sample.spring.dbflute2.exentity.OtherUsers2;
import jp.canetrash.sample.spring.logic.UserLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLogicImpl implements UserLogic {

	@Autowired
	private UsersBhv usersBhv;
	@Autowired
	private OtherUsers2Bhv otherUsers2Bhv;

	public Users getUserById(Integer id) {
		return usersBhv.selectByPKValue(id);
	}

	public OtherUsers2 getOtherUserById(Integer id) {
		return otherUsers2Bhv.selectByPKValue(id);
	}

	public Integer register(Users user) {
		if (user.getId() == null) {
			throw new RuntimeException("IDがnullです");
		}
		usersBhv.insert(user);
		return user.getId();
	}

	public void registerOtherUser(Users users) {
		if (users.getId() == null) {
			throw new RuntimeException("IDがnullです");
		}
		OtherUsers2 otherUser = otherUsers2Bhv.newMyEntity();
		otherUser.setId(users.getId());
		otherUser.setName(users.getName());
		otherUser.setHome(users.getHome());
		otherUsers2Bhv.insert(otherUser);
	}

	public void deleteUser(Integer id) {
		Users users = usersBhv.selectByPKValueWithDeletedCheck(id);
		usersBhv.delete(users);
	}
}
