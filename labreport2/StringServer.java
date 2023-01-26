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
