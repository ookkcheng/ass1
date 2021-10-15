[![Build Status](https://app.travis-ci.com/ookkcheng/ass1.svg?branch=main)](https://app.travis-ci.com/ookkcheng/ass1)

(We have uploaded the project to Gitee which tracks all the issues and changes. But to get feedback from Travis CI, We also upload just the final version to Github )

# Overall

**Gitee repository URL:** https://gitee.com/jiaodongyi/text-editor.git



**Group members :** 

(1)Dongyi Jiao : 20007900

(2)Mike Chen : 20007902



# Instruction

## Folders

**data**:  contain 'print.txt' , all texts in the CodeArea will be saved into this file initially when trying to print.

**target**: The default compilation path ,containing class

**src/test**: using JUnit to test the following functionalities: open, save and search

**src/main/resources**:  contains some layout files--- style.css(ability to read source code files such as .java, .py, .cpp or similar.) and textEditor.FXML(GUI using JavaFx)

**src/main/java**: java files to implement the functions for this text editor.

**$project$/reports**: metrics and PMD reports for code quality.



## Run it

You can just use your IDE like IDEA or Eclipse to open the program, and run src\main\java\com\example\assigenment1pro\Main.java to use our text editor.

Or you can also use Maven ,cmd or jar to run it.



## Functions

**New** : to create a new (fresh) window.

**Open**: To read other text files (.txt/.rtf/.py/.css/.java). Users can navigate the file system to search for a file.

​			(different syntax can be shown in different colours.)

**Save**: Save text output into .txt file format. Users can navigate the file system to save the file in a selected drive/location.

**Print**: Print text by connecting it to the local printer in your machine.

**Save as PDF**: The file can be saved into PDF format (for standard text files).

**Exit**: to quit the program – close all windows.

**Search**: Search for text within the screen.

**View**: Select text, Copy, Paste and Cut (SCPC) capabilities.

**About**: display the names of both team members and a brief message in a popup message box.

**Time and Date (T&D)**: retrieve the current time and data from the OS and place it at the top of the page of the editor.



# Git Commit IDs

[simple function](https://gitee.com/jiaodongyi/text-editor/commit/f0b34ccd159565dc611a78525c5d58b812190e80)/[TD](https://gitee.com/jiaodongyi/text-editor/commit/9093eb12b27d8cee83c4223ec05c3f18eee1745c)/[save](https://gitee.com/jiaodongyi/text-editor/commit/09fff6e68adc8546a9426f5dea56d0dedaa72f8e)/[revise](https://gitee.com/jiaodongyi/text-editor/commit/0181d9facc090deb5c5ab5a956d547a1dad684b0)/[suitable](https://gitee.com/jiaodongyi/text-editor/commit/8a85a9a863a9f5e40957f43dfe58786bef11d578)/: accomplish some simple functions by Mike

[add some function](https://gitee.com/jiaodongyi/text-editor/commit/b769af5912f116fc3dc866dc1811df0c7aab21e0): add "search" function made by Jiao 

[new framework](https://gitee.com/jiaodongyi/text-editor/commit/4c38dc4c91060eb929c9d8bfca06d17cabf96800): improve the GUI to make it more suitable made by Mike

[Second commit](https://gitee.com/jiaodongyi/text-editor/commit/4f9d52c551d22d78470b0b345f96f7d0aef9fe6e) : achieve the word warp and print out by Jiao

[merge 1 to 2](https://gitee.com/jiaodongyi/text-editor/commit/505ef429690612db494dfc95d4bd9a27a084b8ad) : merge Mike's work to Jiao's work successfully by Jiao

[almost finish](https://gitee.com/jiaodongyi/text-editor/commit/d27df33fbd73ed86dea558295cfd5e498de341de) ([v1.0](https://gitee.com/jiaodongyi/text-editor/tree/v1.0)): add comments and toPDF (although there are some bugs) by Mike

[add highlight print rtf](https://gitee.com/jiaodongyi/text-editor/commit/17136182ea003949011fa5366bb6b760d869f26b) : make rtf available and can change the color for different syntax by Jiao

[merge 2 to 3](https://gitee.com/jiaodongyi/text-editor/commit/14f76b262557140a8aa8350f201485e75167b504) /[little change](https://gitee.com/jiaodongyi/text-editor/commit/6fe0d1cadce137cac7f078959181039fc30bce9e) : merge Mike's work to Jiao's work successfully by Jiao

[just without test](https://gitee.com/jiaodongyi/text-editor/commit/9e60a2801cd6ed79b2fd85f6ba53d316e4aa613c)([v1.1](https://gitee.com/jiaodongyi/text-editor/tree/v1.1)): revise the toPDF function(can generate many lines) and print function,  add more commits and readme by Mike

[final](https://gitee.com/jiaodongyi/text-editor/commit/fe29f55abf3dab222ac0f2de12f8d5630962df40) : add test by Jiao, now just without code quality reports.

[finish](https://gitee.com/jiaodongyi/text-editor/commit/9b66fc65a146bf45afeda9bf95136a7d26f7a80d)([v1.2](https://gitee.com/jiaodongyi/text-editor/tree/v1.2)) : add quality reports(pmd, metrics and Travis CI) by Mike , probably the final version.
