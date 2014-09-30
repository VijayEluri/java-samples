// Copyright(c) 2007 ATL Systems, Incorporated.
//
//
package sample.twitter4j;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import junit.framework.TestCase;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.UserWithStatus;

public class SampleTest extends TestCase {
    
    public void testSample() throws Exception {
        Twitter twitter = new Twitter("XXXXX","XXXXX");
        twitter.update("うはー。おｋｗｗｗ。てｓｔ。てｓｔ。");
        /*
        List<Status> statuses = twitter.getFriendsTimeline();
        System.out.println("Showing friends timeline.");
        FileWriter writer = new FileWriter(new File("test.txt"));
        for (Status status : statuses) {
            writer.write(status.getId() + ":"+ status.getUser().getName() + ":" + status.getText() + "\n");
        }
        writer.close();
        */
        /*
        UserWithStatus user = twitter.getUserDetail("tfunato");
        System.out.println(user.getDescription());
        System.out.println(user.getFavouritesCount());
        System.out.println(user.getFollowersCount());
        System.out.println(user.getFriendsCount());
        System.out.println(user.getId());
        System.out.println(user.getLocation());
        System.out.println(user.getName());
        System.out.println(user.getScreenName());
        */
    }

}
