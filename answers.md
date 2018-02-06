1) Allows users to specify files that they would like git to ignore when commiting. 
2) Gradle acts as the server for this project. It allows for users to build and run the web application for the project.
3) Allows for automated testing of the project every time the project is pushed to GitHub. Travs CI allows for users to easily identify when a project broke, to hopefully help with finding why it broke.  
4) A route sends incoming requests to a specified response.
5) The server class runs the server and creates a database to be used by UserController. 
  The UserController class manages requests for user information.
    -The page users redirects to '/users.html'
    -The page api/users runs the getUsers function in the UserController class, which returns a JSON object.
    -The page api/users?age=25 runs the getUsers function in the UserController class, which then uses the listUsers function in the Database class. This function filters users by a parameter in the Request called 'age'. It then returns the filtered results as a JSON object.
    -The page api/users/588935f5de613130e931ffd5 runs the getUser function in the UserController class which returns a JSON object with a matching id to the id that was given (in this case 588935f5de613130e931ffd5).
6) The public folder contains all of the CSS files, as well as the HTML and Javascript files. These files work together to build the webpage that the consumer sees. The HTML files are there because they populate each individual webpage with text and basic structure.
7) 
8) The client-side JavaScript is defined in the /public/javascript/ file and is named users.js. The JavaScript file is used specifically in the users.html file. 
