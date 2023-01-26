# Week 3 Lab Report

This lab report will be separated into three separate parts. 
The first part will be creating a web server, the second part will be debugging, and the third part will be reflection.

# Part 1: Web Server
There are two files used to run the server. One file being the `Server.java` file given to us in the week 2 lab report and the second being my own `StringServer.java` file, which allows StringServer's url functions.

The code of `StringServer.java` is as follows: 

```
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    ArrayList<String> arr = new ArrayList<>();
    
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return makeString(arr);
        }
        else if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            arr.add(parameters[1]);
            return makeString(arr);
        }
        return "404 Not Found!";
    }

    public String makeString(ArrayList<String> arr) {
        String str = "";

        for (int i = 0; i < arr.size(); i++) {
            str = str + arr.get(i) + "\n";
        }

        return str;
    }
}

public class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```

## Running the Server
When ran with `Server.java`, `StringServer.java` creates an online server that is able to store and display strings.
Inputting specific paths allows strings to be added and displayed on the site. 

The input is as follows: `/add-message?s=<string>`, in which "<string>" is your choice of words. 

Here is an example of the server in work:
  
![image](https://user-images.githubusercontent.com/122491673/214768457-cbe43082-6265-404e-af9b-88e3d67168bb.png)
  
In the image above, I added the word "cat" to the server. Now it's stored in the server until it restarts. Lets add another word.
  
![image](https://user-images.githubusercontent.com/122491673/214768560-ea2c8694-5e24-4f26-8666-75504dad647b.png)
  
Here we add the word "doggy", and as you can see "cat" is still there in addition to the new word "doggy".
  
## Functionality
Let's take a look at `StringServer.java` itself. When the file is ran in terminal, the main method is processed.
    
```
public class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```

The main method's parameter "args" is the port of the server. The method starts by checking if a port was given. If it wasn't, it will display an error and prompt the host to try again. Then, the first arg is parseInted to an Integer type so it can be used as the port. Once the  port is processed, the server is started through the `Server.java` file.

```
class Handler implements URLHandler {
    ArrayList<String> arr = new ArrayList<>();
    
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return makeString(arr);
        }
        else if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            arr.add(parameters[1]);
            return makeString(arr);
        }
        return "404 Not Found!";
    }

    public String makeString(ArrayList<String> arr) {
        String str = "";

        for (int i = 0; i < arr.size(); i++) {
            str = str + arr.get(i) + "\n";
        }

        return str;
    }
}
```

Above is the `Handler` class, which deals with the url input. The class begins by initializing a string ArrayList called `arr`. `arr` is used to store all inputs by the user. 

```
public String handleRequest(URI url) {
    if (url.getPath().equals("/")) {
        return makeString(arr);
    }
    else if (url.getPath().equals("/add-message")) {
        String[] parameters = url.getQuery().split("=");
        arr.add(parameters[1]);
        return makeString(arr);
    }
    return "404 Not Found!";
}
```

The first method in `Handler` is `handleRequest`. This method is what goes through the url input to determine what action to take.

1. If there is no added path, it will return the current state of `arr`. 
2. If the path is "/add-message", it will read the query and add the string after the "=" to `arr`. Then it will return the current state of `arr`.
3. If the path is invalid, return an error "404 Not Found!"

As you might observe, there is a method called `makeString` included everytime arr is returned.

```
public String makeString(ArrayList<String> arr) {
    String str = "";

    for (int i = 0; i < arr.size(); i++) {
        str = str + arr.get(i) + "\n";
    }

    return str;
}
```

`makeString` does as it sounds, it formats `arr` into a string. It does so by going through each element of the ArrayList and adding it to a string, with newlines between each element. This is necessary because the `handleRequest` method's return type is String and `arr` is an ArrayList.

# Part 2: Debugging

As a part of Week 3's Lab, we were given many files which contained buggy methods. One such file was `ArrayExamples.java`, which consisted of two buggy methods. One of which was `reverse`.

```
static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return newArray;
  }
```

This method was supposed to take an array `arr` and return a new copy with it's contents in reverse order. For example, an array of {1, 2, 3} is supposed to return a new array containing {3, 2, 1}. The code is tested with a JUnit test, which is passed when ran.

```
@Test
  public void testReversed() {
    int[] input1 = { };
    assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));
  }
```

While this test passed, the code itself has a major bug which wasn't accounted for with this test.Using the same example as before, if `arr` was {1, 2, 3}, the actual array returned would be {0, 0, 0} when the expected is {3, 2, 1}. 

![image](https://user-images.githubusercontent.com/122491673/214774360-52a88753-cc1b-4957-9faf-1cec9baf7aaf.png)

The photo above shows the original JUnit test plus another test I added. The test checks the error in two ways. First is by checking the new array. It should have been {3, 2, 1} but instead was {0, 0, 0}. Second is by checking the original array. Since the `reversed` method was supposed to create a new array, the original shouldn’t have been tampered with. Checking `arr` after using the reversed method, it ended up becoming {0, 0, 0} when it should have been {1, 2, 3}.

This was because the code mixed up the assignment in the for loop, assigning the new empty array `newArray`'s values to the parameter array `arr`. 

Original method:

```
static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return newArray;
  }
```

Fixed method:

```
static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      newArray[i] = arr[arr.length - i - 1]; //newArray is swapped with arr
    }
    return newArray; //newArray is returned instead of arr
  }
```

With the fixed code, the method runs as expected and both JUnit tests are passed. It was a simple switch of the two variables in the for loop as well as swapping the return from `arr` to `newArray`.
    
![image](https://user-images.githubusercontent.com/122491673/214776199-2a26a8a1-cf5a-4655-8501-fec6e7d435f7.png)
