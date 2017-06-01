package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.TripServiceTest.UserBuilder;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    public static final User BOB = new User();
    public static final User PAUL = new User();

    @Test
    public void should_inform_when_users_are_not_friends() throws Exception {
        User user = new UserBuilder().friendsWith(BOB)
                                    .build();

        assertThat(user.isFriendWith(PAUL), is(false));
    }

    @Test
    public void should_inform_when_users_are_friends() throws Exception {
        User user = new UserBuilder().friendsWith(BOB, PAUL)
                .build();

        assertThat(user.isFriendWith(PAUL), is(true));
    }
}
