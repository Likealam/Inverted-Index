## Inverted Index

It is a data structure that stores mapping from words (terms) to documents or set of documents i.e. directs you from word to document.

Steps to build Inverted index are:
1. Fetch the document and gather all the words.
2. Check for each word, if it is present then add reference of document to index else create new entry in index for that word.
3. Repeat above steps for all documents and sort the words.

Indexing is slow as it first checks that word is present or not.
Searching is very fast.
Example of Inverted index:
```
Word                              Documents
hello                             doc1      
sky                               doc1, doc3
coffee                            doc2
hi                                doc2
greetings                         doc3
```                               
It does not store duplicate keywords in index.

Real life example of Inverted index:
* Index at the back of the book.

## Requirements:

Develop a program that builds inverted index for text documents. 

**Input** is a path to folder with files.

**Output** of the program is a result file in a result folder.
 
Index is based on next factors:
 * word appearance
 * file length
 * date of last modification
  
Representation of the file is a formatted table of indexed terms with next columns: 
```
term filename
...  ...
```
 
 - Custom exception should be created and thrown at appropriate place
 - Execution of the program should be logged at the log file
 - Stop words shouldn't be present at result - length less 3 letters
 - Sort terms by sum of its inverted indexes
 
Formula for index evaluation: 

```k1 * document_length + log_k2(n_term_appearance) + 1 / log_k3(date_of_1_july_2021_in_ms - date_of_file_last_modification_in_ms)```

where k1 = 0.1, k2 = 10, k3 = 10000

Index factors values should be stored at property file.

Stack that should be used:
 - Conditions, loops
 - OOP
 - IO Streams
 - Stream API
 - Exceptions handling
 - Custom exceptions
 - Regex
 - Equals&Hashcode
 - Date
 - Sorting
 - Comparison
 - Collections
 
 ps: all necessary classes are already exist in project.