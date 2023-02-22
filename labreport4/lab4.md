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
8. Run the tests, demonstrating that they now succeed.
9. Commit and push the resulting change to your Github account.

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

## Step 3: Logging into ieng6 Server
