package assignment12;

public class UnsortedDictionary extends DictionaryADT {

	public UnsortedDictionary() {
		super();
	}

	@Override
	public void add(String s) {
		comparisons = 0;
		list.add(s);
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
		comparisons = 0;
		for(int i = 0; i < list.size(); i++) {
			comparisons++;
			if(list.get(i).toLowerCase().equals(s.toLowerCase()))
				return i;
		}
		
		return -1;
	}
}
