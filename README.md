# JPACRUDProject

## Week 8 Homework Project for Skill Distillery

## How To Run This Project

This project is run from the web, or from a local server. The RestaurantPickerWebApp is the project from which the web app is run.

## Project Description

My girlfriend likes to go out to eat, but she doesn't always know where to go, and she's not super confident that when I give a suggestion I'm telling her where I actually want to eat and not where I think she wants to eat. Three years ago, right around when we were just learning about arrays in this program, I decided to try and make a really simple app to offer a solution to this problem, just to get more comfortable with not only learning about Java technologies but using them as well. The app started off very simply - it basically was just a Math.random() with some restaurant names in an array, and it would randomly pick a name of a restaurant we liked to go out to eat. As I learned more and more, I returned to that app when I could and refactored it to include more technologies (changed the array to a List, had the program read restaurants form a file, etc.). This is something of a continuation of that evolution - I wanted to bring that simple little main method Java console app into the Web.

This project can pick a random restaurant from a database, and the program returns the restaurant and displays it on the page. The user can also enter the name of a restaurant to display that restaurant. From either of these pages, the user can update the restaurant or delete it. If the user chooses to update the restaurant, the user can enter in new values for several (although not all) of the fields for the restaurant, and the restaurant in the database will be updated successfully if provided with valid values. If the user chooses to delete the restaurant, the restaurant is removed from the database (or if the delete was unsuccessful, an error message displays). The user can also add restaurants to the database, and later find them with the search function or from being randomly selected. 

## Lessons Learned

Each week Rob and Steve tell us to make JUNIT tests before going too far into the coding, and each week I think to myself, "Well I need to have something to test in order to make tests for it" and end up blasting out 500 lines of code without unit tests. This week there were a lot of moving parts and My understanding of JUNIT testing in relation to some of those parts wasn't great, so I put it off until the end, but looking back this wasn't a good strategy. Even not having a deep understanding of JUNIT tests with Spring and dynamic web projects, it couldn't have taken more than 20 minutes to write some tests that would have been useful for troubleshooting some issues I had in developing the project. The DAO, the controller, and the web views each have their own complications, and writing JUNIT tests for at least one of those parts would have saved more time in the debugging stage. I overestimated how much actual code I needed in order to start writing JUNIT tests - I can write JUNIT tests without a lot of prewritten code as long as I know what I am testing for or against.

Last week I needed to utilize command objects to pass data between JSPs and controllers, but this week solidified for me better how command objects function. I understood the concept of command objects, but did not fully understand how they operated - command objects are, basically, Java objects being passed around from form submissions and they look to the getters and setters to know what data to pass, but I didn't quite appreciate that the command object actually uses the getters and setters the same way (or in a similar way) that other Java objects do. Not grasping this fully wasn't a problem until this project, when I tried to pass a primary key ID into a command object, which of course failed because the primary key ID did not have a setter method (by design). A lot of Spring feels like cheating, but this project hit home for me that Spring has to follow the rules of Java just like everyone else.

## Regrets/Things To Do Better Next Time

I spent more time than perhaps I should have dealing with setup and configuration issues in the beginning of the project. I was anxious to start translating my restaurant picker Java console app into something that goes on the web, so I started early on writing code for the DAO and controller before I got a handle on the configuration issues. This was a problem when I started running into the configuration issues - I wasn't entirely sure whether the problems that were arising were because of the controller/DAO code or because something wasn't quite configured exactly right in the web.xml, build.gradle or some other setup file.

I'm usually pretty good about keeping a good top-down view of what I'm working on, but this week my fingers were working a bit faster than my brain. I started writing lots of DAO and controller code before I got a handle on the JSPs or how they were going to be connected, so I ended up meangering a bit when I tried to fit the pieces back together. Next time I'm going to try harder to keep a "flow chart" that maps how the project will work in mind so I can more confidently assess what the code I'm typing in will actually do when I try to run the project. I know there are a lot of parts of the project that (are able to) work independently so that, for instance, I could have written the entirety of the DAO before even looking at the controller, but until I have a confident view of how the whole machine runs (at least roughly) I don't think this is the best approach for me - I'm going to try to start with the beginning (start at the welcome JSP, then do the controller for a button, then follow that to the DAO method it calls, etc.) 









