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

public class Member {

	/* Unique Email Id for each member */
	private String emailId;

	/* Name of the member */
	private String name;

	/* Method to get the Email Id of the member */
	public String getEmailId() {
		return emailId;
	}

	/* Method to get the name of the member */
	public String getName() {
		return name;
	}

	Member() {
	}

	/* Parameterized constructor to initialize the object */
	Member(String emailId, String name) {
		this.emailId = emailId;
		this.name = name;
	}
}
