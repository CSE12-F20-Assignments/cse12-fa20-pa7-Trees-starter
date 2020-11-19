import java.util.ArrayList;
import java.util.List;

public class FrequencyFilter {
	// You should use the string constants below for throwing exceptions:
	// e.g. throw new IllegalArgumentException(ILLEGAL_ARG_BAD_RANGE);
	
	public static final String ILLEGAL_ARG_LENGTH = "List must be same length as number of trees";
	public static final String ILLEGAL_ARG_BAD_RANGE = "maxPrefixLen cannot be less than minPrefixLen";
	public static final String ILLEGAL_ARG_MIN_PREFIX = "maxPrefixLen must be positive";
	
	// Array of BSTs that map prefixes to frequency (number of occurrences)
    private BST<String, Integer>[] frequencyTrees;
    

    /**
     * Builds this FrequencyFilter's frequencyTrees array of BSTs. 
     * Each element in the array is a BST whose keys are the prefixes of a certain length
     * and values are the frequency of each prefix
     * @param data the data from which to parse prefixes
     * @param minPrefixLen the minimum prefix length, inclusive, equivalent to the prefix length of 
     * 						the first BST in the this FrequencyFilter's frequencyTrees array
     * @param maxPrefixLen the maximum prefix length, inclusive, equivalent to the prefix length of 
     * 						the last BST in the this FrequencyFilter's frequencyTrees array
     * 
     * @throws IllegalArgumentException if maxPrefixLen is less than minPrefixLen or minPrefixLen not positive
     */
	public void buildFrequencyTrees(String data, int minPrefixLen, int maxPrefixLen) throws IllegalArgumentException {
    	// TODO
    }

    /**
     * Filters every BST in this FrequencyFilter's frequencyTrees array, removing any elements
     * whose frequency falls below the cutoff frequency. That is, if a prefix occurs less than the
     * cutoff frequency, it is removed 
     * @param freq the cutoff frequency
     * @return a modified String representation of each tree in this FrequencyFilter, as specified
     * 			in the PA7 spec. 
     */
    public List<String> filter(int freq) {
    	// TODO
    	return new ArrayList<>();
    }

    /**
     * Filters every BST as in filter(int freq) above, except that each BST is filtered with its
     * own cutoff frequency. 
     * @param freqs the cutoff frequencies to filter the BSTs with. Each element in freqs is 
     * 			applied to one corresponding BST (same index).
     * @return a modified String representation of each tree in this FrequencyFilter, as specified
     * 			in the PA7 spec. 
     * @throws IllegalArgumentException if the length of freqs and frequencyTrees is not the same
     */
    public List<String> filter(int[] freqs) throws IllegalArgumentException {
        // TODO
        return new ArrayList<>();
    }

}
