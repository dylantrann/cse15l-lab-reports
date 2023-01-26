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
Let's take a look at `StringServer.java` itself. When the file is ran in terminal, the `main method` is run. 
    
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

The main method's parameter "args" is the port of the server. The method starts by checking if a port was given, if not it would display an error and prompt the host to try again. One a successful port is given, the server is started through the `Server.java` file.

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
