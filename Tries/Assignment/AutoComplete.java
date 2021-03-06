/*
Given n number of words and an incomplete word w. You need to auto-complete that word w.
That means, find and print all the possible words which can be formed using the incomplete word w.
Note : Order of words does not matter.

Constraints:
Time Limit: 1 sec
Sample Input 1 :
7
do dont no not note notes den
no
Sample Output 2 :
no
not
note
notes
Sample Input 2 :
7
do dont no not note notes den
de
Sample Output 2 :
den
Sample Input 3 :
7
do dont no not note notes den
nom
Sample Output 3 :
(Empty) There is no word which starts with "nom"

*/

package Assignment;
import java.lang.constant.DynamicCallSiteDesc;
import java.util.*;

public class AutoComplete {

    private TrieNode root;
	public int count;
	public AutoComplete() {
		root = new TrieNode('\0');
	}
    
    private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

    public void autoComplete(ArrayList<String> input, String word) {
        for(String s : input) add(s);
        TrieNode dummy_root = findDummyRoot(root, word);
		if(dummy_root == null) return;
		if(dummy_root.isTerminal) System.out.println(word);
		print(dummy_root, word);
    }

	// prints all words possible from root
	private void print(TrieNode root, String word){
		if(root == null) return;
		for(int i = 0; i<26; i++){
			if(root.children[i] != null){
				char letter = root.children[i].data;
				if(root.children[i].isTerminating) System.out.println(word + letter);
				print(root.children[i], word + letter);
			}
		}
	}

	//finds the address of last letter of word
	private TrieNode findDummyRoot(TrieNode root, String word){
		if(word.length() == 0) return root;
		int childIndex = word.charAt(0) - 'a';
		return findDummyRoot(root.children[childIndex], word.substring(1));
	}
}
