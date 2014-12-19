package share;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class PrimitiveVarInSingleThread {
	public static Ark ark; 
	
	public int loadTheArk(Collection<Animal> candidates) {
		SortedSet<Animal> animals;
		int numPairs = 0;
		Animal candidate = null;
		
		// animals 被封闭在方法中，不要使他们逸出！
		animals = new TreeSet<Animal>(new SpeciesGenderComparator());
		animals.addAll(candidates);
		for (Animal a : animals) {
			if (candidate == null || !candidate.isPotentialiMate(a))
				candidate = a;
			else {
				ark.load(new AnimalPair(candidate, a));
				++numPairs;
				candidate = null;
			}
		}
		return numPairs;
	}
}
class Animal {
	boolean isPotentialiMate(Animal a) {
		return false;
	}
}

class SpeciesGenderComparator implements Comparator<Animal> {
	@Override
	public int compare(Animal arg0, Animal arg1) {
		return 0;
	}}

class Ark {
	void load(AnimalPair ap) {}
}

class AnimalPair {
	public AnimalPair (Animal a, Animal b) {
		
	}
}