package jp.canetrash.sample.spring.service;

import jp.canetrash.sample.spring.dbflute.exentity.Users;
import jp.canetrash.sample.spring.dbflute2.exentity.OtherUsers2;

public interface UserService {

	Users getUserById(Integer id);
	
	OtherUsers2 getOtherUserById(Integer id);
	
	Integer registerUser(Users user);

	/**
	 * sample.userテーブルから、sample2.user2テーブルへレコードを移動する。<br/>
	 * userテーブルからレコードを削除して、user2テーブルにインサートをかける
	 * @param id
	 */
	void moveUser(Integer id);
}
