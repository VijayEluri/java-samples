package jp.canetrash.skype.sample;

import com.skype.Chat;
import com.skype.ChatMessage;
import com.skype.ContactList;
import com.skype.Friend;
import com.skype.Skype;
import com.skype.SkypeException;

public class SkypeChatClient {

	/**
	 * @param args
	 * @throws SkypeException 
	 */
	public static void main(String[] args) throws SkypeException {
		// コンタクトリストからコンタクトを取得
		/*
		ContactList contactList = Skype.getContactList();
		Friend friend = contactList.getFriend("kykcd23");
		Chat chat = friend.chat();
		//chat.send("Javaアプリからチャットのテストでござる");
		ChatMessage[] chatMessages = chat.getAllChatMessages();
		for (ChatMessage msg : chatMessages) {
			System.out.println(msg.getContent());
		}
		*/
		Chat[] chats = Skype.getAllBookmarkedChats();
		for (Chat c : chats) {
			System.out.println("【" + c.getWindowTitle() + "】");
			for (ChatMessage m : c.getRecentChatMessages()) {
				System.out.print(m.getTime() + ":");
				System.out.print(m.getSenderDisplayName() + ":");
				System.out.println(m.getContent());
			}
		}
	}

}
