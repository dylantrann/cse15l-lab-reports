# Lab Report 3
For this lab report, we were given the option to research any of the three different commands: `grep`, `find`, and `less`. I decided to choose `less` since its the command we have the least experience with. I've looked into four different options that help modify the way `less` is used. For the most part, I used [this website](https://phoenixnap.com/kb/less-command-in-linux) to find interesting options for `less` and learned how they worked by testing it on my own in VSCode. 


## Auto Exit: `-e`
The first one I looked into was `-e`. At first glance it seems really basic but it's actually really convient for reading multiple connected articles.

When using `less <file>`, the end of a file is signified by an (END) placed after all the document's contents have been explored. To exit, you would have to press `q`.

The end of a file using `less` looks a little something like this:

![image](https://user-images.githubusercontent.com/122491673/217431565-09122319-3b55-4217-91d2-380e853ac48a.png)

But, if you use `less -e <file>`, it will automatically end the command after the file's contents have been explored. It won't show the end symbol and instead will instantly exit the program.

Here is an example using same file in the `less <file>` example above.

![image](https://user-images.githubusercontent.com/122491673/217432023-b679e08a-48f8-45fb-b8f3-bfc314ca77a1.png)

Notice how there's no longer an (END) mark and instead we are returned back to the terminal. The ends of the text file don't look the same in both examples but that's because after leaving the `less` command, most of the text file is hidden away. If you would like to check they are the same file, I used the `JungleMalaysia.txt` file, located in `written_2/travel_guides/berlitz1/`. 

It may seem a little bit basic but it can be really useful when examing multiple documents of similar content. It would be bothersome to exit and retype less for every document, especially if they are supposed to be read in succession. 

When looking through the files in `written_2/travel_guides/berlitz2/`, I realized a lot of them follow a similar pattern of four files. All the locations that had a travel guide contained one or multiple of these four topics: Intro, History, WhatToDo, and/or WhereToGo. Wouldn't it be easier to read them all in succession rather than having to re-insert `less` over and over again? I created a script called `read.sh` to allow anyone to read about a destination of their choice and it would display them in succession until reaching the final document, in which it will show the (END) symbol. To run it, use the command: `$ bash read.sh <location-of-choice->`.

This is what the file `read.sh` contains:
```
less -e travel_guides/berlitz2/$1-Intro.txt
less -e travel_guides/berlitz2/$1-History.txt
less -e travel_guides/berlitz2/$1-WhatToDo.txt
less travel_guides/berlitz2/$1-WhereToGo.txt
```

For reasons of convience, I think `-e` can be a very convient tool for scripting and easier access of multiple files.

## The Ctrl+F: `-p[pattern]`
We all know the windows search command, `Ctrl+F`, which pulls up a little search menu on the top right and allows you to search for specific words throughout the website you're located on. Imagine there was a similar command we could use in terminal...

Well, there is, and its `less -p[pattern]`.

`less -p[pattern]` is used by replacing [pattern] with any string of words and it will start the `less` process at the first instance of that word. Not only will it go straight to that word, it will highlight all instances of that word throughout the search of the file, which makes it extremely helpful if you're looking for specific information. If the pattern you desire is more than one word, you can contain them between quotation marks and it will work fine.

Here's an example of me searching through `written_2/non_fiction/OUP/Castro/chL.txt` for the pattern "La Llorona":

![image](https://user-images.githubusercontent.com/122491673/217438883-3e31beb3-5475-4c17-b31b-7dc8542c208e.png)

Using `$ less -p"La Llorona" non-fiction/OUP/Castro/chL.txt`, it brings us to the first instance of "La Llorona" while highlighting all instances of "La Llorona" visible. It also allows us to continue transversing the file with the `less` command, and each new instance of "La Llorona" is also highlighted. 

What if we wanted to look for beaches in Puerto Rico? We could scan the travel guide using `less -pbeach travel_guides/berlitz2/PuertoRico-WhereToGo.txt` and locate all instances of "beach" in order to find one.

![image](https://user-images.githubusercontent.com/122491673/217440227-72fdc1d3-cb05-4828-94cc-70e425d4a84a.png)

Doing so brings us to the location above, which isn't really that helpful since it doesn't mention the name of any beaches we can visit. Luckily we can continue going through the file, thanks to the `less` aspect, which eventually leads us to some more useful information: 

![image](https://user-images.githubusercontent.com/122491673/217440985-4dafb7c5-0587-4409-9bb6-08f96c4d60b2.png)

`-p[pattern]` is an extremely helpful option since it can be used to locate specific pieces of information within a file. This can be used not only in text documents but also files, as it allows you to single out certain parts of code, something very useful in debugging. 

## Pause: `-X`
After exiting the `less` command, most, if not all, the text is removed from the terminal. Using the `-X` option prevents that by disabling the screen clear command that occurs after `less`. 

While transversing through `written_2/non-fiction/OUP/Fletcher/ch2.txt`, I find an important name I want to write down. Luckily, I used `less -X`, so when I quit, the text stays and I can access the terminal to echo it into my notes file.

![image](https://user-images.githubusercontent.com/122491673/217441994-113563d7-2b7f-4fe8-8c06-1b3f816af424.png)

It can also be used with `p[pattern]` to return to your previous location in the file. Let's say we were reading `Barcelona-WhereToGo.txt` but needed to take a break. Since we used `less -X`, we can quit the terminal and our last place will be saved. To return there, we just used `less -p[pattern]` to return to our chosen location. 

![image](https://user-images.githubusercontent.com/122491673/217445788-ff9c25f6-081f-4642-abae-fdb89d2303a0.png)

![image](https://user-images.githubusercontent.com/122491673/217445884-faa50f0d-e29e-4b43-a36c-c04049611688.png)

And we can continue where we left off!

Basically, `-X` is a useful option since it allows you to keep your traces of `less` so you can remember what you've previously seen without having to re-transverse the entire file once more. Of course, sometimes you might not want to keep the file's contents there, which is why `-X` is also a situational option and should only be used when the situation calls for it.

## Line Numbering: `-N`

Using the option `-N` adds line numbers to the left of the text, which tells you exactly which lines are being displayed from the file. 

Here's an example using `$ less -N travel_guides/berlitz1/HandRIsrael.txt`:

![image](https://user-images.githubusercontent.com/122491673/217446547-a0834b0c-f041-40d6-aa84-d044095c5036.png)

As you can see, each line is numbered just as the file itself is.

Here's another example, using larger line sizes with `$ less -N travel_guides/berlitz2/Amsterdam-History.txt`:

![image](https://user-images.githubusercontent.com/122491673/217447029-c59cfd15-83f0-48b0-b618-702de57762ce.png)

On the right, you might notice some numbers are repeating. This is because the line numbering matches the file. Since the terminal isn't infinitely wide as a file, it splits the file's extremely long lines into multiple lines, but keeps the line number consistent. 

`-N` is extremely helpful if you have access to the actual file. Since you are able to see the exact line number, you don't have to waste time searching throughout the entire file. You can directly find your spot from the terminal in the actual file with more efficency. 

---

As I mentioned before I used [this website](https://phoenixnap.com/kb/less-command-in-linux) to find all of the options but I tested them and found situations in which they'd be useful on my own. I hope my research was worth it's time and thanks for reading!
