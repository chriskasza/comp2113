package assignment12;

public class SortedDictionary extends DictionaryADT {
	
	public SortedDictionary() {
		super();
	}

	@Override
	public void add(String s) {
		int compare;
		comparisons = 0;
		if(list.size() == 0) {
			list.add(s);
			return;
		}
		
		list.add("");
		for(int i = list.size() - 2; i >= 0; i--) {
			comparisons++;
			compare = s.toLowerCase().compareTo(list.get(i).toLowerCase());
			if(compare < 0) {
				// new string is "smaller" than current item
				list.set(i + 1, list.get(i));
			}
			else if(compare > 0) {
				// new string is "larger" than current item, so insert
				list.set(i + 1, s);
				return;
			}
			else {
				// new string is same as current item; do not add
				return;
			}
		}		
		list.set(0, s);		
	}

	@Override
	public void delete(String s) {
		int index = find(s);
		if(index != -1) {
			for(int i = index; i < list.size() - 1; i++) {
				comparisons++;
				list.set(i, list.get(i+1));
			}
			list.remove(list.size() - 1);
		}
	}

	@Override
	public int find(String s) {
		final int NOTFOUND = -1;
		int first = 0;
		int last = list.size() - 1;
		int location;
		int compare;
		
		while(first <= last) {
			location = (first + last) / 2;
			compare = s.toLowerCase().compareTo(list.get(location).toLowerCase());
			if(compare == 0) {
				return location;
			}
			else if(compare < 0) {
				last = location - 1;
			}
			else {
				first = location + 1;
			}			
		}
		return NOTFOUND;
	}
}
