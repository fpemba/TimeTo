//package com.TimeTo.TimeTo;
//
//import javax.persistence.*;
//import java.util.Collection;
//
//@Entity
//public class FriendList {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    @OneToOne
//    private User user;
//    @OneToMany(mappedBy = "friendList")
//    private Collection<Friend> friends;
//
//    public FriendList(Collection<Friend> friends, User user) {
//        this.friends = friends;
//        this.user = user;
//    }
//
//    public FriendList(){
//
//    }
//
//
//}
