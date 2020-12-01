
---

# PA7: Binary Search Trees (closed)
---

**This assignment is closed to collaboration.**

This assignment will teach you how to implement a Binary Search Tree and use it to order and filter data from a text file. 

### *Extra Credit Oppourtunity*
For this PA, if you submit early you will gain 3 extra points to your total score.
The early submission extra credit deadline is ** **Sunday, November 29 at 11:59pm** **  
This needs to be your final submission, if you submit again after this deadline you can not receieve extra credit.   
This is a way to encourage everyone to start early and finish early! 

### Deadlines
This PA is due on ** **Tuesday, December 1 at 11:59pm** **  
The Gradescope autograder will be released on ** **Sunday, November 22** **

### Starting Resources
Link to FAQ: https://piazza.com/class/kffnb3soo432qi?cid=973  
Link to PA Video: https://canvas.ucsd.edu/courses/18854/external_tools/82


## Getting the Code
The starter code is in the Github repository that you are currently looking at. If you are not familiar with Github, here are two easy ways to get your code.

1. Download as a ZIP folder 

    If you scroll to the top of Github repository, you should see a green button that says *Code*. Click on that button. Then click on *Download ZIP*. This should download all the files as a ZIP folder. You can then unzip/extract the zip bundle and move it to wherever you would like to work. The code that you will be changing is in the folder called *pa4-starter*.

2. Using git clone (requires terminal/command line)

    If you scroll to the top of the Github repository, you should see a green button that says *Code*. Click on that button. You should see something that says *Clone with HTTPS*. Copy the link that is in that section. In terminal/command line, navigate to whatever folder/directory you would like to work. Type the command `git clone _` where the `_` is replaced with the link you copied. This should clone the repository on your computer and you can then edit the files on whatever IDE you see fit.
    
If you are unsure or have questions about how to get the starter code, feel free to make a Piazza post or ask a tutor for help.

## Part 1: An Implementation of `DefaultMap` (18 points)
You’ll provide a fast implementation of an interface called `DefaultMap` in `BST.java`.  


You will implement all the methods defined in the `DefaultMap` interface. You must ensure that each has the specified big-O bound in the **worst case**, and argue why based on the documentation of any libraries you use, or based on your implementation. Note that these are big-O bounds, so doing _better_ (like O(1) where O(log(n)) is required) is acceptable. In each, _n_ represents the number of entries in the map.

- `put`, required O(n)
- `replace`, required _O(n)_
- `remove`, required _O(n)_
- `set`, required _O(n)_
- `get`, required _O(n)_
- `size`, required _O(1)_
- `isEmpty`, required _O(1)_
- `containsKey`, required _O(n)_
- `keys`, required _O(n)_

In `BST`, you will need come up with the proper instance variables to achieve the above runtime requirements.

The specifications for the other methods are defined in header comments in the `DefaultMap.java` file, which you should follow. 

**Important:** for keys(), the returned result need to be in ascending order

***Note:*** You are not allowed to use the java `SortedMap` interface or `Collections.sort`, or any other implementations of BSTs or sorting!!!

Your implementation of `DefaultMap` will be graded automatically by tests that we provide. We’ll provide a very minimal sanity check in the grader. DO NOT rely on it for testing!

## Part 2: Implementing the Frequency Filter (19 points)

### Instance Variables
##### `frequencyTrees`
This is an array of trees that you need to populate with data from the text file. For each tree, the key will be a prefix with a specified length that is different for every tree, and the value will be the frequency of that prefix in the given text file. 


### Required Methods
In the `FrequencyFilter.java` file, you are required to implement `buildFrequencyTrees()` and `filter()`. Note that you need to implement two versions of `filter()`, one taking in an integer, the other taking in an array of integers. See the comments in the starter code file for more details.


### Output of filter()
The output is a list of strings, where each element is a representation of a BST. Elements must be sorted in DESCENDING order based on the frequency of the prefix. Only one prefix per frequency: that is, select the FIRST prefix to map to a given frequency. Subsequent prefixes that map to already selected frequencies are ignored.

#### Format of a list of BST strings
[  
\ntree -> {\n  
    \t"<prefix>": ocurrences\n   
},    
\ntree -> {\n    
    \t"<prefix>": ocurrences\n    
},    
  
...    
]    

#### Format of one BST  
\ntree -> {\n    
    \t"<prefix>": ocurrences\n    
}  
    
### Example
If we have only have one tree that contains prefixes of length one, and it has the following entries:

"I": 10,  
"AM": 10,  
"happy": 11,  
"Bored": 12,  
"Awesome": 12 

The output will be as follows:

[  
\ntree -> {\n  
\t"Awesome": 12\n

\t"happy": 11\n  

\t"AM": 10\n   
}  
]  

## Testing
### BST - BSTTest.java
For this PA, your unit tests will be graded for completion only, however, we **strongly** encourage you to thoroughly test every public method in your class (helper methods you create should inherently be *private*). You are required to have at least **two unique unit tests for each method** written by yourself. 

### FrequencyFilter - Main.java
In the starter code we provide you with a Main class where you can run your implementation. This is a simple program that:
1. Reads a file
2. Creates an instance of your FrequencyFilter
3. Calls `buildFrequencyTrees()` on the instance of your FrequencyFilter with a specified minimum prefix length and maximum prefix length
4. Calls `filter()` on the instance of your FrequencyFilter with either a cutoff frequency or an array of cutoff frequecies, based on the value of `USE_FREQ_LIST`

You can freely modify this file as you see fit for testing purposes. The following constants will be helpful for you:	

`DEFAULT_TRAINING_FILENAME` To set the filename of the file to read for building the filter. Must be a relative path (just the name and extension)

`CUTOFF_FREQUENCY` The smallest frequecy that your FrequencyFilter will keep when it's passed in as an argument of `filter()`

`FREQ_LIST` The list of frequencies to filter the trees (this is used in the second version of your filter() method)

`MIN_PREFIX_LEN` The length of the prefixes in the first tree in the filter

`MAX_PREFIX_LEN` The length of the prefixes in the last tree in the filter

`USE_FREQ_LIST` Set to true if you decide to use an array of cutoff frequencies instead of one cutoff frequency for every tree

**Note** we've provided some files for you in the *starter/* directory. If you wish to use your own files for building the FrequencyFilter, they must be placed in this folder as well.

## Part 3: Gradescope Assignment (8 points)

Respond to the following prompts in *Programming Assignment 7 - questions*:

1. Find a different example for the text file (you may use one from PA6 or find your own). What are some observations about the frequencies from this file that you found interesting? 
2. Describe what the best case would be for a BST, specifically, what does the tree look like? How is this the best case? What methods benefit from the best case scenario? 
3. Speculate – would doing a frequency count with the `MyHashMap` in PA6 be faster or slower than with the `BSTMap`. Why?
4. Justify the runtime bounds (worst case) for the methods you wrote in `BST`.


## Style (4 points)

This PA has the same style guidelines as PA5.

- Lines **must not** be longer than 100 characters except for method headers
- Indentation must be consistent
- Test method names must have meaning related to the test
- Lines **must not** be indented more than 6 times. If you have a need to
  indent more than 6 levels, build a helper method or otherwise reorganize your code
- Helper method names should describe their purpose
- If you write a helper method with a body longer than 2 statements, **you
  must** add a header comment (a comment above the method) that summarizes what it does in English

## Asking for Help

This is a **closed** PA. That said, there are many ways to ask for related help:

- Ask anything as a private Piazza question (though you are not guaranteed a detailed answer)
- PA6 is still open, and you can learn a lot by completing PA6 fully. You can do all of the `BST` methods without thinking about PA6, but it's a great idea to get detailed help on PA6 before tackling the methods in PA7 if you don't have a complete PA6
- You can always ask for clarification about built-in Java libraries
- You can always ask for clarification and help with the BST implementations we work through in class

## Submitting

#### Part 1 & 2
On the Gradescope assignment **Programming Assignment 7 - code** please submit the following file structure:
* BST.java
* BSTTest.java
* FrequencyFilter.java

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

#### Part 3
Please submit your answers to the questions from part 3 on the Gradescope assignment **Programming Assignment 7 - questions**. You may submit as many times as you like till the deadline.

#### Part 3
Please submit your answers to the questions from part 3 on the Gradescope assignment **Programming Assignment 7 - questions**. You may submit as many times as you like till the deadline.


## Scoring (50 points total)
- 18 points: implementation of `DefaultMap` [automatically graded]
- 19 points: `filter()` methods [automatically graded]
- 1 point: BSTTest graded on completition [manually graded]
- 8 points: Gradescope Questions [manually graded]
- 4 points: Style [manually graded]






