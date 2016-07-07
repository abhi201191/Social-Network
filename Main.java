/*------------------------------------------------------------------
Name: Abhishek Singh
Roll Number: CS1423
Date of Submission: 18-09-2014
Deadline date: 18-09-2014 
Program description: 
	1) A member can simply join the social network. In other words, a member can be added to the network. At the time of adding, (s)he has no friends. All members have names, but the members are identified by their email addresses, as same names can  exist many times. 
	2) A member can add another member as friend. For simplicity, assume there is no need for the other member to accept any request, one adding another automatically makes them friends. 
	3) There is a way to get the list of friends of a member. 
	4) A member can see who are the common friends between him/her and another member.
	5) For every member, there would be a list of friend suggestions. The list is simply the friends of friends of the member M who have at least two common friends with M, and is not currently a friend of M.
Acknowledgement: 
--------------------------------------------------------------------*/

package cs1423;

public class Main {

	public static void main(String[] args) {

		/* Objects of Member class */
		Member member1 = new Member("abhi.gbpant1@gmail.com", "Abhishek1");
		Member member2 = new Member("abhi.gbpant2@gmail.com", "Abhishek2");
		Member member3 = new Member("abhi.gbpant3@gmail.com", "Abhishek3");
		Member member4 = new Member("abhi.gbpant4@gmail.com", "Abhishek4");
		Member member5 = new Member("abhi.gbpant5@gmail.com", "Abhishek5");
		Member member6 = new Member("abhi.gbpant6@gmail.com", "Abhishek6");
		Member member7 = new Member("abhi.gbpant7@gmail.com", "Abhishek7");
		Member member8 = new Member("abhi.gbpant8@gmail.com", "Abhishek8");
		Member member9 = new Member("abhi.gbpant9@gmail.com", "Abhishek9");

		SocialNetwork sol = new SocialNetwork();

		/* Method calls to add the members */
		sol.addMember(member1);
		sol.addMember(member2);
		sol.addMember(member3);
		sol.addMember(member4);
		sol.addMember(member5);
		sol.addMember(member6);
		sol.addMember(member7);
		sol.addMember(member8);
		sol.addMember(member9);

		/* Method calls to add as a friend */
		sol.addFriend(member1, member2);
		sol.addFriend(member1, member3);
		sol.addFriend(member1, member4);
		sol.addFriend(member2, member3);
		sol.addFriend(member2, member4);
		sol.addFriend(member2, member5);
		sol.addFriend(member2, member6);
		sol.addFriend(member3, member7);
		sol.addFriend(member3, member8);
		sol.addFriend(member3, member4);
		sol.addFriend(member4, member6);

		/* Method calls to print the friend list of the members */
		sol.printFriends(member1);
		sol.printFriends(member2);
		sol.printFriends(member3);
		sol.printFriends(member4);
		sol.printFriends(member5);
		sol.printFriends(member6);
		sol.printFriends(member7);
		sol.printFriends(member8);
		sol.printFriends(member9);

		/* Method call to print the common friends between two members */
		sol.commonFriends(member1, member2);
		sol.commonFriends(member3, member4);
		sol.commonFriends(member8, member9);

		/*
		 * Method call to print the friend suggestion for every member in the
		 * network
		 */
		sol.friendSuggestions();
	}
}
