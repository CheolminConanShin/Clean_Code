package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

public class TripServiceTest {

    public static final User GUEST = null;
    public static final User UNUSED_USER = null;
    public static final User REGISTERED_USER = new User();
    public static final Trip TO_BRAZIL = new Trip();
    public static final Trip TO_LONDON = new Trip();

    @Mock private TripDAO tripDAO;

    @InjectMocks @Spy private TripService tripService = new TripService();

    @Test(expected = UserNotLoggedInException.class)
    public void should_throw_on_exception_when_user_is_not_logged_in() {
        tripService.getTripsByUser(UNUSED_USER, GUEST);
    }

    @Test
    public void should_not_return_any_trips_when_users_are_not_friends() throws Exception {
        User anotherFriend = new User();
        User friend = new UserBuilder().friendsWith(anotherFriend)
                                        .withTrips(TO_BRAZIL)
                                        .build();

        List<Trip> friendTrips = tripService.getTripsByUser(friend, REGISTERED_USER);

        assertThat(friendTrips.size(), is(0));
    }

    @Test
    public void should_return_friend_trips_when_users_are_friends() throws Exception {
        User anotherFriend = new User();
        User friend = new UserBuilder().friendsWith(anotherFriend, REGISTERED_USER)
                                        .withTrips(TO_BRAZIL, TO_LONDON)
                                        .build();

        given(tripDAO.tripsBy(friend)).willReturn(friend.trips());
        List<Trip> friendTrips = tripService.getTripsByUser(friend, REGISTERED_USER);

        assertThat(friendTrips.size(), is(2));
    }

    public static class UserBuilder extends User {
        private User[] friends = new User[]{};
        private Trip[] trips = new Trip[]{};

        public UserBuilder UserBuilder() {
            return new UserBuilder();
        }

        public UserBuilder friendsWith(User... friends) {
            this.friends = friends;
            return this;
        }

        public UserBuilder withTrips(Trip... trips) {
            this.trips = trips;
            return this;
        }

        public User build() {
            User user = new User();
            addFriendsTo(user);
            addTripsTo(user);
            return user;
        }

        private void addFriendsTo(User user) {
            for(User friend: friends) {
                user.addFriend(friend);
            }
        }

        private void addTripsTo(User user) {
            for(Trip trip: trips) {
                user.addTrip(trip);
            }
        }
    }
}