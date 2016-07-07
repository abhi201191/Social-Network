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

import java.util.ArrayList;
import java.util.HashMap;

public class SocialNetwork {

	/*
	 * HashMap to stores the detail of a member and friends, Key is email id and
	 * value is link to the ArrayList of friends
	 */
	protected HashMap<String, ArrayList<Member>> map = new HashMap<String, ArrayList<Member>>();

	/*
	 * HashMap to stores the detail of a member, Key is email id and value is
	 * object of a member
	 */
	protected HashMap<String, Member> networkDirectory = new HashMap<String, Member>();

	/* Method to add friends and update both ArrayList of both */
	public void addFriend(Member from, Member to) {
		/* If both the members are in network */
		if (map.containsKey(from.getEmailId()) == true
				&& map.containsKey(to.getEmailId()) == true) {

			ArrayList<Member> friends;
			/* Obtains the link to ArrayList of the member from HashMap entry */
			friends = map.get(from.getEmailId());
			/* If they are not friends then add it to list */
			if (!friends.contains(to))
				friends.add(to);

			/* Obtains the link to ArrayList of the member from HashMap entry */
			friends = map.get(to.getEmailId());
			/* If they are not friends then add it to list */
			if (!friends.contains(from))
				friends.add(from);

			System.out.println(from.getName() + " and " + to.getName()
					+ " are now friends");
		}

		/* If any of the member is not in the network, then print the message */
		else {
			if (map.containsKey(from.getEmailId()) != true)
				System.out.println(from.getName()
						+ "is not a member of Network");
			else

				System.out
						.println(to.getName() + " is not a member of Network");
		}
	}

	/* Method to print friends of particular member (passed in parameter) */
	public void printFriends(Member obj) {
		/* If the member is in the network */
		if (map.containsKey(obj.getEmailId()) == true) {
			ArrayList<Member> friends;
			/* Obtains the link to ArrayList of the member from HashMap entry */
			friends = map.get(obj.getEmailId());
			/* If friend list is empty then print the message */
			if (friends.size() == 0)
				System.out.println("\n" + obj.getName() + " has no friends");
			/* Prints the friends */
			else {
				for (Member member : friends) {
					System.out.println("\nFriends of " + obj.getName() + " :");
					System.out.println("\t" + member.getName());
				}
			}
		}

		/* If the member is not in the network then print the message */
		else
			System.out.println(obj.getName() + " is not a member of Network");
	}

	/* Method to add a member in the network */
	public void addMember(Member member) {
		/* Creates the empty ArrayList */
		ArrayList<Member> list = new ArrayList<Member>();
		/* Stores the Email Id and ArrayList of friends in HashMap */
		map.put(member.getEmailId(), list);
		/* Stores the Email Id and Object of member in HashMap */
		networkDirectory.put(member.getEmailId(), member);
	}

	/* Method to find common friends between two members */
	public void commonFriends(Member member1, Member member2) {
		/* Get the ArrayList of friends of member1 */
		ArrayList<Member> friendOfMember1 = map.get(member1.getEmailId());
		/* Get the ArrayList of friends of member2 */
		ArrayList<Member> friendOfMember2 = map.get(member2.getEmailId());
		System.out.println("\nCommon Friends between " + member1.getName()
				+ " and " + member2.getName() + " are : ");
		int counter = 0;
		/* Iterative loop to print common friends */
		for (Member member : friendOfMember1) {
			/* If particular member is in the list of other member's friend list */
			if (friendOfMember2.contains(member)) {
				counter++;
				System.out.println(member.getName());
			}
		}

		/* If no common friend then print the message */
		if (counter == 0)
			System.out.println("No common friends ");
	}

	/* Method to print the friend suggestion for every member */
	public void friendSuggestions() {
		/* Iterate over HashMap and check for every other member in HashMap */
		for (String keySet1 : map.keySet()) {
			ArrayList<Member> friendSuggestion = new ArrayList<Member>();
			/* Get the ArrayList of friends of member1 */
			ArrayList<Member> friendsOfMember1 = map.get(keySet1);

			/* Iterate over HashMap */
			for (String keySet2 : map.keySet()) {
				/* Get the ArrayList of friends of member2 */
				ArrayList<Member> friendsOfMember2 = map.get(keySet2);
				int counter = 0;

				/* If member2 is not the friend of member1 */
				if (!friendsOfMember1.contains(networkDirectory.get(keySet2))) {
					/* If both the members are not same */
					if (keySet1 != keySet2) {
						/* Count the number of mutual friends */
						for (Member members : friendsOfMember2)
							if (friendsOfMember1.contains(members))
								counter++;

						/*
						 * If count is greater than equals to 2 then add it to
						 * friend suggestion list of member1
						 */
						if (counter >= 2)
							friendSuggestion.add(networkDirectory.get(keySet2));
					}
				}
			}
			System.out.println("\nFriend Suggestion for "
					+ networkDirectory.get(keySet1).getName() + " :");

			/* If friendSuggestion ArrayList is empty then print the message */
			if (friendSuggestion.size() == 0)
				System.out.println("\tNo friend Suggestion for "
						+ networkDirectory.get(keySet1).getName());
			/* Else prints the friendSuggestion List */
			else {
				for (Member suggestedMember : friendSuggestion) {
					System.out.println("\t" + suggestedMember.getName());
				}
			}
		}
	}
}
