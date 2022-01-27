package com.project.frqs.bryant;
import java.util.ArrayList;

public class UserName {
	// The list of possible user names, based on a user’s first and last names and initialized by the constructor.
	private ArrayList<String> possibleNames = new ArrayList<>();

	/** Constructs a UserName object as described in part (a).
	* Precondition: firstName and lastName have length greater than 0
	* and contain only uppercase and lowercase letters. */
	public UserName(String firstName, String lastName) {
		for (int i = 1; i <= firstName.length(); i++) {
			this.possibleNames.add(lastName + firstName.substring(0, i));
		}
	}

	/** Returns true if arr contains name, and false otherwise. */
	public boolean isUsed(String name, String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (name.equals(arr[i])) {
				return true;
			}
		}
		return false;
	}

	/** Removes strings from possibleNames that are found in usedNames as described in part (b). */

	public void setAvailableUserNames(String[] usedNames)
	{
		for (int i = possibleNames.size(); i > 0; i--) {
			if (isUsed(possibleNames.get(i - 1), usedNames)) {
				possibleNames.remove(i - 1);
			}
		}
	}
	
	public String getNames() {
		return possibleNames.toString();
	}
	
	public static void main(String[] args) {
		UserName nameList = new UserName("John", "Smith");
		System.out.println(nameList.getNames());
		nameList.setAvailableUserNames(new String[] {"SmithJ"});
		System.out.println(nameList.getNames());
    }
}