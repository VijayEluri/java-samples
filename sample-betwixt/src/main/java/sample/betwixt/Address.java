package sample.betwixt;

import java.util.ArrayList;
import java.util.List;


public class Address {
    String myName;
    String myAddress;
    String tel;
    int age;

    public int getAge() {
        return age;
    }

    public String getMyAddress() {
        return myAddress;
    }

    public String getMyName() {
        return myName;
    }

    public String getTel() {
        return tel;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    List friends = new ArrayList();

    public List getFriends() {
        return friends;
    }

    public void setFriends(List friends) {
        this.friends = friends;
    }

    public void addFriends(Friend bean) {
        this.friends.add(bean);
    }
}
