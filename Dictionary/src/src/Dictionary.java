package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map; 
import java.util.Set;
 
public class Dictionary {
	
    private Map<String, Set<String>> dictionary;
 
    public Dictionary() {
        dictionary = new HashMap<>();
    }
    
    public Dictionary(Map<String, Set<String>> dictionary ) {
    	this.dictionary = dictionary;
    }

	public void add(String key, String member) { 
        if (dictionary.keySet().contains(key) && dictionary.get(key).contains(member)) { 
            System.out.println("> Key already contains that member.");
        } 
        if (dictionary.keySet().contains(key)) { 
         dictionary.get(key).add(member); 
        } else { 
            dictionary.put(key, new HashSet<String>(Arrays.asList(member))); 
        }
    }
 
    public void clear() {
        dictionary.clear();
    }

    public List<String> getAllMembers() {
        if (dictionary == null || dictionary.isEmpty() || dictionary.keySet() == null || dictionary.keySet().isEmpty()) {
            return null;
        }
        List<String> allMembersList = new ArrayList<>();
        for (String key : dictionary.keySet()) {
            allMembersList.addAll(dictionary.get(key));
        }
        return allMembersList;
    }

    public Map<String, Set<String>> getItems() {
        if (dictionary == null || dictionary.isEmpty()) {
            return null;
        }
        return dictionary;
    }
 
    public Set<String> getKeys() { 
        if (dictionary == null || dictionary.isEmpty() || dictionary.keySet() == null || dictionary.keySet().isEmpty()) { 
            return null;
        } return dictionary.keySet();
    }
 
    public Set<String> getMembers(String key) { 
        if (dictionary == null || dictionary.isEmpty() || dictionary.get(key) == null || dictionary.get(key).isEmpty()) { 
            return null;
        } return dictionary.get(key);
    }

    public boolean hasKey(String key) {
        if (!dictionary.keySet().contains(key)) {
            return false;
        } return dictionary.keySet().contains(key);
    }
 
    public boolean hasMember(String key, String member) {
        if (dictionary == null || dictionary.isEmpty() || !dictionary.keySet().contains(key)) {
            return false;
        } return dictionary.get(key).contains(member);
    }
 
    public void remove(String key, String member) { 
        if (!dictionary.keySet().contains(key)) { 
            System.out.println("> Specified key does not exist.");
        } else if (!dictionary.get(key).contains(member)) { 
            System.out.println("> Can’t delete non-existent member from key.");
        } if (dictionary.get(key).size() > 1) {
            dictionary.get(key).remove(member); 
        } else { 
            dictionary.remove(key);
        }
    }
 
    public void removeAll(String key) {
        if (!dictionary.keySet().contains(key)) {
            System.out.println("> Specified key does not exist.");
        } dictionary.remove(key);
    }
}
