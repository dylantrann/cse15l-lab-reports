# Lab Report 4
For this week's lab report, I'll be going through the processes of cloning, editing, and updating files in GitHub using only the command line.
I'll use the same process I did during the week 7 lab and explain my thoughts and processes in between.

Here are the actual steps involved in the process:
1. **Setup** Delete any existing forks of the repository you have on your GitHub account.
2. **Setup** Fork the given repository.
3. Log into the ieng6 server.
4. Clone your fork of the repository from your Github account.
5. Run the tests, demonstrating that they fail.
6. Edit the code file to fix the failing test.
7. Run the tests, demonstrating that they now succeed.
8. Commit and push the resulting change to your Github account.

For this entire process, we'll be using a fork of [this repository](https://github.com/ucsd-cse15l-w23/lab7), which I'll be referring to as `lab7`. 
Without further ado, let's get started!

## Step 1: Deleting Existing Forks
This is a setup only required if these steps have been previously replicated. By clearing the fork, we're able to reset our tests and try again. This might not be
useful for a first timer but I thought it was still useful to include this, since it's something I didn't originally know how to do. 

To delete your repository, first visit it on GitHub. When viewing it, press the repository specific settings button located in the top middle of the screen.

![image](https://user-images.githubusercontent.com/122491673/220776075-c016271f-eaa9-4ff8-be4c-9b99aaabc351.png)


Then, scroll all the way down to the bottom until you locate the "Delete this repository" button. Press it.

![image](https://user-images.githubusercontent.com/122491673/220776506-7e336701-e8cd-48b4-a1cc-b2c21474c045.png)

It will then prompt you to type out the repository's path to confirm your decision. Once you do, you should be able to delete the repository and all its contents.

## Step 2: Fork a Repository
This is something we've done multiple times but it doesn't hurt to see it again. 

Visit the repository you want to fork (in our case, [lab7](https://github.com/ucsd-cse15l-w23/lab7)).

Press the fork button on the top right corner of the repository. 

![image](https://user-images.githubusercontent.com/122491673/220777215-14134e55-2a79-4aca-bfee-5edc3fae5727.png)

Then, press "Create fork" and you're done!

![image](https://user-images.githubusercontent.com/122491673/220777312-08c6d554-6d41-43d8-8a7b-f93f2758b9bb.png)

## Step 3: Logging Into `ieng6` Server
This is another step constantly repeated but an important one nonetheless. 

To log in, open up your bash terminal. In the terminal, type out and enter the command:

`ssh cs15lwi23***@ieng6.ucsd.edu`

Make sure to replace the three asterisks with your unique three letter code associated with your account.

Once entered, the terminal should prompt you to enter your password. When you type out your password, it won't be visible for safety reasons but it still will be processed. An incorrect password will prompt the terminal to re-request your password. A successful password submission should display something similar to this: 

![image](https://user-images.githubusercontent.com/122491673/220799303-0172898b-7079-4954-942f-b13ed1a2181b.png)

## Step 4: Cloning from Github
Next up, we'll be cloning, or creating a copy of, our repository in GitHub and importing it into our server using only the terminal. 

To do so, we use the command `git clone <link/path>`. Using the `lab7` repository, I used the command:

`git clone https://github.com/dylantrann/lab7.git`

Which produced this result:

![image](https://user-images.githubusercontent.com/122491673/220800392-d176d5b8-85ba-4857-a3fb-3cf5c28d767d.png)

## Step 5: Testing for Error
Cloning `lab7`, we've created a copy of the repository as a directory in our server. To access that directory, we must change our current directory into `lab7`. To do this, we use: 

`cd lab7/`

When I actually typed out the command, I only typed `cd l` and then pressed `<tab>`, which auto completed the words "lab7/", shortcutting the typing process. This can help avoid spelling errors or wasting time typing out longer names.

You can tell we successfully changed directories by looking at the terminal's display. Following the colon after your bracketed username, it displays `currDirectory:lineNumber`. Meaning that since first text after my username is `lab7`, I know I successfully changed directories to `lab7`. 
  
  ![image](https://user-images.githubusercontent.com/122491673/220801441-de658f48-0926-4727-af20-05c325b1a36d.png)

  Now that we're in the correct directory, we can test our files. In `lab7`, we have two files, `ListExamples.java` and `TestListExamples.java`, as well as a lib file containing information for JUnit. 
  
  To run the JUnit tests, we compile and run given these two commands:
  
  ```
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples
  ```
  
  Due to an error in `ListExamples.java`, there is an error displayed in the JUnit tests. 
  
  ![image](https://user-images.githubusercontent.com/122491673/220802083-5cdb8438-4ceb-43e7-bb2b-c7317d01e002.png)

  While there is an error displayed, our compiling and running were successful, meaning we can move onto actually fixing that error. 
  
## Step 6: Editting in Terminal
  Since we know the error is located in `ListExamples.java`, we're going to open it up and find the error. We can view and edit the contents of the file using the `nano` command. I type: 
  
  `nano ListExamples.java`
  
  This opens up a large-scale display of the file in terminal, and allows us to view and edit it without opening up the file itself. 
  
  ![image](https://user-images.githubusercontent.com/122491673/220802931-d04bc2cb-6942-4168-a411-7517761670b9.png)

  To transerse the file, we use the arrow keys to move up and down. The actual error is located near the bottom, in which index1 should be replaced with index2. To get there, I pressed `<down arrow>` 42 times. To edit it, I pressed `<right arrow>` 12 times, putting my cursor right before the 1. I then pressed `<backspace>` followed by a `<2>`. 
  
  ![image](https://user-images.githubusercontent.com/122491673/220803397-307e8a72-28db-4750-ae3a-e0024c8d526b.png)
  
  To save the changes we've made, we press `<ctrl + O>`, the command known as "WriteOut". You might not notice, but on the bottom, this will prompt you to enter a name for the file. Since we don't have to change the current name, we don't type anything and just press `<enter>` to confirm.
  
  ![image](https://user-images.githubusercontent.com/122491673/220804359-b64607f0-a983-4ba1-a423-fd90b769b17c.png)

  To exit, use `<ctrl + X>` and it will immediately exit the display and return you to the normal terminal.
  
## Step 7: Rerun the Tests
  We'll just be repeating **Step 5** but we'll be getting a different result. As with **Step 5**, we'll use:
  
  ```
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples
  ```
  
  It should give us a successful test result.
  
  ![image](https://user-images.githubusercontent.com/122491673/220818423-2462ce61-3614-4114-92f7-402692e8059c.png)

## Step 8: Committing and Pushing to GitHub
  Now that we've fixed the error and the test runs fine, we'll have to commit our updates and push them to GitHub. Committing our updates is like confirming the changes we've made and pushing is the same as sending those confirmed changes back to GitHub. 
  
  Before we can commit or push, we first have to add the file we've changed. To do so, we use the `git add` command:
  
  `git add ListExamples.java`
  
  This adds the updated file to my `.git` folder, which holds all the changes we want to commit. To commit those files, we use the `git commit` command. In this command, we include an option, `-m`, to add a message explaining the changes we've made. The actual command I used is this:
  
  `git commit -m "Fixed ListExamples.java"`
  
  A successful commit should display a message similar to the one shown below. At the bottom of the message, it displays the actual changes that occurred. In our case, we changed one file, `ListExamples.java`, and made one insertion and deletetion, changing the 1 to a 2. 
  
  ![image](https://user-images.githubusercontent.com/122491673/220819452-b35e31a9-b661-4a00-9550-263d56fa0c90.png)

  Finally, we have to push these changes back to GitHub. To do so, we use the `git push` command, which is literally typed out as:
  
  `git push`
  
  It will provide a success message such as the one displayed below.
  
  ![image](https://user-images.githubusercontent.com/122491673/220820476-aa6f407e-9018-422b-9dcd-0bf29b3b7774.png)
  
  As you can see, in GitHub, the "index1" is now "index2". This means the changes have been updated and we're successful!
  
  ![image](https://user-images.githubusercontent.com/122491673/220820632-6a9c0791-3c12-4121-b1ea-079dca8653cd.png)

---

With that, we're done! You've learned how to update files and push those updates to GitHub all in the terminal. I hope this was helpful!
