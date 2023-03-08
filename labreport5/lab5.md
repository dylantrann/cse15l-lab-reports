# Lab Report 5
For this lab report, I'll be going over the process of turning Lab 7 into a script!
I've previously went over Lab 7's process in [Lab Report 4](https://dylantrann.github.io/cse15l-lab-reports/labreport4/lab4.html).
Lab Report 4 consisted of a 9 step process, which is pretty lengthy and contains a lot of exact commands and clicks. 
Now that we're comfortable with scripts, it can be easily condensed and made reusable.

We're going to do everything on VSCode, since that's how it would be done manually during the timed trial.

## Creating the Script
To start off, we have to create a new script file.

Press this button located above your current working directory to create a new file.

![image](https://user-images.githubusercontent.com/122491673/223856485-c6cc96d0-de93-4dad-9ca0-4536de57fd1c.png)

You will see a new text box appear above your current directories files, which is prompting you to name the file.
When naming the file, the name does not matter as long as you add the extension `.sh` after the name.
In my case, I'm naming the file `debug.sh`, as it debugs the file. 
You will know you correctly made a script file when it has the gree icon show on the right of the file name.

![image](https://user-images.githubusercontent.com/122491673/223856851-6a9790b6-3eb5-4799-aaf1-6ebc4ead827f.png)

## Coding the Script
Now that the script file has been created, you can start coding it. 

For a reminder, here are the steps required in the process
1. Log into ieng6
2. Clone your fork of the repository from your Github account
3. Run the tests, demonstrating that they fail
4. Edit the code file to fix the failing test
5. Run the tests, demonstrating that they now succeed
6. Commit and push the resulting change to your Github account (you can pick any commit message!)

I mentioned previously that it was a 9 step process, but I've removed the first three steps, as they aren't possible/required to be added in the script.
The first two steps are set-up, which including deleting and forking the repository on GitHub, something not possible and have to be done outside of the script.
The third step is starting the timer, which is not possible or necessary in the script. For now we will just focus on the script itself.

To be honest, writing the script is a lot easier a task than it seems. All we have to do is add the methods we created in Lab 4 to our script file and it should work a-okay.

**Step 1** is achieved by adding the command `ssh cs15lwi23***@ieng6.uscd.edu`. As usual, the three asterisks are replaced by your own personal identification letters, in which mine are "amz". 

Normally, when using `ssh` for the first time, you are required to enter a password. Luckily, there is a way to by pass this by creating your own key to automatically log you in without using a password.

It's a lengthy process that must be done before creating this script, so I suggest you check out the section titled "Generating SSH Keys for ieng6" located in [Week 7](https://ucsd-cse15l-w23.github.io/week/week7/#in-class-notes). It does an amazing job at explaining the steps and will help to greatly increase efficency when it comes to using the ieng6 server.

**Step 2** is achieved using the command `git clone https://github.com/dylantrann/lab7.git`. `git clone <url>` is the command used to clone a repository from github. The url should be the one that contains the lab7 repository, which in my case is https://github.com/dylantrann/lab7.git. 

**Step 3** is achieved by compiling and running the code. Before we can run and compile, we have to change our directory into the newly cloned `lab7/`, using the command `cd lab7/`. After that, we use the compiling and running commands for JUnit:

```
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples
```

**Step 4** is fixing the code, which is a little bit different than our steps in Lab Report 4.
