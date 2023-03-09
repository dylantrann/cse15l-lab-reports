# Lab Report 5
For this lab report, I'll be going over the process of turning Lab 7 into a script!
I've previously went over Lab 7's process in [Lab Report 4](https://dylantrann.github.io/cse15l-lab-reports/labreport4/lab4.html).
Lab Report 4 consisted of a 9 step process, which is pretty lengthy and contains a lot of exact commands and clicks. 
Now that we're comfortable with scripts, it can be easily condensed and simplified for the user.

We're going to do everything on VSCode, since that's how it would be done manually during the timed trial.

## Creating the Script
To start off, we have to create a new script file.

Press this button located above your current working directory to create a new file.

![image](https://user-images.githubusercontent.com/122491673/223856485-c6cc96d0-de93-4dad-9ca0-4536de57fd1c.png)

You will see a new text box appear above your current directories files, which is prompting you to name the file.
When naming the file, the name does not matter as long as you add the extension `.sh` after the name.
In my case, I'm naming the file `debug.sh`, as it debugs the file. 
You will know you correctly made a script file when it has the green icon show on the right of the file name.

![image](https://user-images.githubusercontent.com/122491673/223856851-6a9790b6-3eb5-4799-aaf1-6ebc4ead827f.png)

## Coding the Script
Now that the script file has been created, you can start coding it. 

For a reminder, here are the steps required in the process
1. Clone your fork of the repository from your Github account
2. Run the tests, demonstrating that they fail
3. Edit the code file to fix the failing test
4. Run the tests, demonstrating that they now succeed
5. Commit and push the resulting change to your Github account (you can pick any commit message!)

I mentioned previously that it was a 9 step process, but I've removed the first four steps, as they aren't possible/required to be added in the script.
The first two steps are set-up, which including deleting and forking the repository on GitHub, something not possible and have to be done outside of the script.
The third step is starting the timer, which is not possible or necessary in the script. For now we will just focus on the script itself.
The fourth step is logging into the ieng6 server. It isn't possible to login as well as run the script, so we're just going to focus on running the script on our own personal devices instead.

To be honest, writing the script is a lot easier a task than it seems. All we have to do is add the methods we created in Lab 4 to our script file, make some minor adjustments, and it should work a-okay. 

---

**Step 1** is achieved using the command `git clone https://github.com/dylantrann/lab7.git`. `git clone <url>` is the command used to clone a repository from github. The url should be the one that contains the lab7 repository, which in my case is https://github.com/dylantrann/lab7.git. 

---

**Step 2** is achieved by compiling and running the code. Before we can run and compile, we have to change our directory into the newly cloned `lab7/`, using the command `cd lab7/`. After that, we use the compiling and running commands for JUnit:

```
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > run-output.txt
```

You may notice a slight difference in the commands compared to those used in Lab 4. I've added `> run-output.txt` to the end of the run command to make the output into a file. 

By doing this, we can display results in an organized manner. To do this, we'll use an if statement:

```
grepCount=`grep -c "OK" run-output.txt`

if [[ $grepCount -eq 0 ]]
then
    echo `grep "Tests run:" run-output.txt`
else
    echo "All tests passed!"
fi
```

This starts off by finding the success message "OK" in the output. If it's present, we display "All tests passed!". If it's not present in the output, we echo `grep "Tests run:" run-output.txt` to display the test results.

Running the command `grep "Tests run:" run-output.txt` will not only result in the words "Tests run:", but it will result in the entire line containing "Tests run:", which allows us to get the entire results using a reliable file search method. I discovered this method when reviewing a peer's code in Lab 8, which is a really nice way of using grep. 

---

**Step 3** is fixing the code, which sadly cannot be something completely automated. For this step, we will still be using `nano ListExamples`, in which you will have to manually correct line 43 to fix the error. I'll build more on this later, when we run the script.

---

**Step 4** is the same Step 3, except it should be successful this time around.

---

**Step 5** is achieved using three commands in succession. 

```
git add ListExamples.java
git commit -m "Fixed ListExamples.java"
git push
```

This adds the change, commits it, and pushes the commit back to GitHub. Thus, completing the process.

## Running the Script
To run the script, we open our bash terminal and run the command `bash debug.sh`. This will start executing the script.

When running the script, you'll notice the file clones and almost instantly opens up the `nano` display. 

![image](https://user-images.githubusercontent.com/122491673/223890270-e6fe11c1-7ace-408d-bb58-0a108a8cb275.png)

While in the display, we'll follow the same steps as on Lab Report 4 to edit the file. We use arrow keys to move towards the error and fix it. To save our changes, we use `<ctrl + o>` then press enter to confirm the change. To exit the `nano` display, use `<ctrl + x>`. 

![image](https://user-images.githubusercontent.com/122491673/223890350-fd3b9a21-91b8-4629-8dc4-dc7328fe35a6.png)

Once you exit the `nano`, the rest of the script will attempt to execute, but you'll soon realize the script pauses at this point:

![image](https://user-images.githubusercontent.com/122491673/223890462-91e12db6-7f8d-4dd0-a1f3-b6e826635e26.png)

This is because you have to confirm you own the GitHub account you're pushing the changes to. You may not have noticed, but a pop up window should have opened, requesting you to verify your GitHub account to confirm your changes.

![image](https://user-images.githubusercontent.com/122491673/223890702-b7d6cbad-440e-454e-93a4-a5e527fd004a.png)

I chose to sign in with browser, which opens up this window:

![image](https://user-images.githubusercontent.com/122491673/223890817-c48cc109-bb7f-4e11-b4d9-3db2d9c3c830.png)

In which I press the green button and type in my password to confirm. After that, the script will completely finish and it's output looks something like this: 

![image](https://user-images.githubusercontent.com/122491673/223890947-7aaca2db-fa65-424e-ba8e-3267124b8edb.png)


## Overview
That's it! I'll include the final script and how it affects `ListExamples.java` below. I hope you found this helpful and thanks for reading!

Here's the final script `debug.sh`: 

```
# Step 1
git clone https://github.com/dylantrann/lab7.git

# Step 2
cd lab7/

javac -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" *.java
java -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" org.junit.runner.JUnitCore ListExamplesTests > run-output.txt
grepCount=`grep -c "OK" run-output.txt`

if [[ $grepCount -eq 0 ]]
then
    echo `grep "Tests run:" run-output.txt`
else
    echo "All tests passed!"
fi

# Step 3
nano ListExamples.java

# Step 4
javac -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" *.java
java -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" org.junit.runner.JUnitCore ListExamplesTests > run-output.txt
grepCount=`grep -c "OK" run-output.txt`

if [[ $grepCount -eq 0 ]]
then
    echo `grep "Tests run:" run-output.txt`
else
    echo "All tests passed!"
fi

# Step 5
git add ListExamples.java
git commit -m "Fixed ListExamples.java"
git push
```

Here's `ListExamples.java` before and after the script is run:

![image](https://user-images.githubusercontent.com/122491673/223867344-34f38285-354a-46a6-b93e-7e06f5159f3d.png)

![image](https://user-images.githubusercontent.com/122491673/223891324-3b7b4e02-fa8b-453b-87eb-744a92d01602.png)

