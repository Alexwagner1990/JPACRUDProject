# JPACRUDProject

## Week 8 Homework Project for Skill Distillery

## How To Run This Project

This project is run from the web, or from a local server. The RestaurantPickerWebApp is the project from which the web app is run. On startup, the program will direct the user to the UserController getToLoginPage method, which will open up the login page. The user must log in to use the app - a new user account can be made, or the following combination can be used:

UN: alexwagner
PW: alexwagner

UPDATE 4/25: User functionality appears to work as expected - now you will not see data unless you use the login credentials listed above. Please see the commit on Sunday, April 22 to see the app as it was before the due date.

## NOTE ABOUT PROJECT

~~This project requires a user name and a password to log in, but the functionality tying a user to a particular restaurant in the database is not yet implemented. For now, any valid login will take the user to a shared database of restaurants. I intended for each user to have a unique set of restaurants based on a restaurant's user_id, but I ran out of time - I will definitely implement it in the near future.~~

UPDATE 4/25: User functionality appears to function as expected. Basic CRUD operations still worked before the 4/22 deadline (on both Users and Restaurants).

I also realize the visual state of the project itself is a bit rough - I spent much more time implementing additional functionalities and I didn't spend much time utilizing Bootstrap to the fullest. I'll have to dive deeper into Bootstrap nuances to figure out what's going on with the odd formatting of some of the buttons/tables. That's also something I plan on improving in the future.

## Project Description

My girlfriend likes to go out to eat, but she doesn't always know where to go, and she's not super confident that when I give a suggestion I'm telling her where I actually want to eat and not where I think she wants to eat. Right around when we were just learning about arrays in this program (feels like years ago), I decided to try and make a really simple app to offer a solution to this problem, just to get more comfortable with using the Java technologies I was learning about. The app started off very simply - it was basically just an array of restaurant names, and it would sysout a Math.random()'ed array index to pick a random restaurant. As I learned more and more, I returned to that app (when I could) and refactored it to include more technologies (changed the array to a List, had the program read restaurants from a file, etc.). This is something of a continuation of that evolution - I wanted to bring that simple little main method Java console app to the Web.

To use this project the user must log in using a valid username/password combination. For some pre-populated data, use the following credentials:

UN: alexwagner
PW: alexwagner

User passwords can also be updated and unwanted users can be deleted with no database issues. Once a valid user is created and used to log in, the app transitions to the restaurant picker portion of the app.  

This project can pick a random restaurant from a database, and the program returns the restaurant and displays it on the page. The user can also enter the name of a restaurant to display that restaurant. From either of these pages, the user can update the restaurant or delete it. If the user chooses to update the restaurant, the user can enter in new values for several (although not all) of the fields for the restaurant, and the restaurant in the database will be updated successfully if provided with valid values. If the user chooses to delete the restaurant, the restaurant is removed from the database (or if the delete was unsuccessful, an error message displays). The user can also add restaurants to the database, and later find them with the search function or from being randomly selected.

The restaurants that are available to a particular user are limited to restaurants that the user has actually added - restaurants added by user A are not visible to user B, and when a user picks a random restaurant (by any filter) the user is given back only a restaurant that corresponds to his or her unique user ID (which cannot be changed by the user and is assigned upon account creation).

## Lessons Learned

Each week Rob and Steve tell us to make JUNIT tests before going too far into the coding, and each week I think to myself, "Well I need to have something to test in order to make tests for it" and end up blasting out 500 lines of code without unit tests. This week there were a lot of moving parts and My understanding of JUNIT testing in relation to some of those parts wasn't great, so I put it off until the end, but looking back this wasn't a good strategy. Even not having a deep understanding of JUNIT tests with Spring and dynamic web projects, it couldn't have taken more than 20 minutes to write some tests that would have been useful for troubleshooting some issues I had in developing the project. The DAO, the controller, and the web views each have their own complications, and writing JUNIT tests for at least one of those parts would have saved more time in the debugging stage. I overestimated how much actual code I needed in order to start writing JUNIT tests - I can write JUNIT tests without a lot of prewritten code as long as I know what I am testing for or against.

This project was the first project I extensively used Enums - they were present in Blackjack as well, but in the Blackjack projects the enums were more of a set-it-and-forget it element. In this project, I had to work more extensively with enums in terms of adding enum data to the database, taking enum data from a user, and passing enum data between JSPs and the controller. I'll admit that I could have delt with enums more elegantly - I essentially delt with them by treating all enum data passed by a user as strings (constraining input with dropdown menus) and then converting the string to the proper enum on the backend in the DAO. I only used two enums with not very many options so this ended up being manageable, but it was far from ideal - enums are class objects and can be treated as such in JSP forms and ModelAndView objects. I ran into several errors when I tried to use enums as objects in a ModelAndView, and my experience with enums was too limited to confidently parse the error messages into a useful debugging strategy, which is why I ended up approaching the issue like I did. I'm a little more confident with enums now - next time, I'll try to use enums within JSPs/Controllers from the outset, since it will end up saving me lots of if() conversion statements.

Last week I needed to utilize command objects to pass data between JSPs and controllers, but this week solidified for me better how command objects function. I understood the concept of command objects, but did not fully understand how they operated - command objects are, basically, Java objects being passed around from form submissions and they look to the getters and setters to know what data to pass, but I didn't quite appreciate that the command object actually uses the getters and setters the same way (or in a similar way) that other Java objects do. Not grasping this fully wasn't a problem until this project, when I tried to pass a primary key ID into a command object, which of course failed because the primary key ID did not have a setter method (by design). A lot of Spring feels like cheating, but this project hit home for me that Spring has to follow the rules of Java just like everyone else.

## Regrets/Things To Do Better Next Time

I spent more time than perhaps I should have dealing with setup and configuration issues in the beginning of the project. I was anxious to start translating my restaurant picker Java console app into something that goes on the web, so I started early on writing code for the DAO and controller before I got a handle on the configuration issues. This was a problem when I started running into the configuration issues - I wasn't entirely sure whether the problems that were arising were because of the controller/DAO code or because something wasn't quite configured exactly right in the web.xml, build.gradle or some other setup file.

I'm usually pretty good about keeping a good top-down view of what I'm working on, but this week my fingers were working a bit faster than my brain. I started writing lots of DAO and controller code before I got a handle on the JSPs or how they were going to be connected, so I ended up meangering a bit when I tried to fit the pieces back together. Next time I'm going to try harder to keep a "flow chart" that maps how the project will work in mind so I can more confidently assess what the code I'm typing in will actually do when I try to run the project. I know there are a lot of parts of the project that (are able to) work independently so that, for instance, I could have written the entirety of the DAO before even looking at the controller, but until I have a confident view of how the whole machine runs (at least roughly) I don't think this is the best approach for me - I'm going to try to start with the beginning (start at the welcome JSP, then do the controller for a button, then follow that to the DAO method it calls, etc.) until I can at least grasp how the whole thing will work form a top-down perspective.
