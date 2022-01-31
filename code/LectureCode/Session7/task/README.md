# Session 7 - Task

This task explores the creation of different objects, created as instances from different classes written by you.

## Implementing different classes
Within the `object` package, in IntelliJ, create a new class.

Name it as any object, and begin with "simple" ones.

For example:
- wallet
- light bulb
- soda can
- coin
- pizza

By simple, I mean understandable. Something that has identifiable features, something that may contain information (pizza has X slices, light bulb is on or off, soda can be opened or not). Identify features that can stored in fields within the class. It could be anything from:
- color
- size
- weight
- height
- position
- temperature
- quantity

Specific state can also be stored as boolean fields, for example:
- isOpen
- isInitialized
- isCeilingFanRunning
- isCold

If you get stuck, try creating another class, and get back to your code later. 

---


# Specific tasks

- [ ] Create at least 3 new objects within the `object`-package.
- [ ] Create an object that inherits from another object that you have created, to use less code over all.
- [ ] Create a main method (in which class isn't important) that uses some of the classes that you have made. You can see `examples/Wallet` and `examples/Coin` for example of main-methods which does this.

> Note: When creating these objects, take notes! 


# Extra tasks

- [ ] Create the following classes:
    - `FileArchive` `File`
    - The archive should contain files:
      - You can add and remove files
      - No duplicate files
      - The archive should have a method which prints the list of files within the archive. Search for "ASCII file tree" for inspiration.
    - **Extra**: Implement folders and files within folders inside your archive, and update the method which displays the directory of files
    - **Hint**: Implement a `Folder` class or use a boolean flag in the `File`-class to 

## If you want to share some code with the class:

- Create a new class within the `examples`-package (In IntelliJ) which represents an object of your choice.
    - Create a branch before you start
    - Write your code and comments
    - Push this new branch with your code committed upstream
    - Open a pull request via GitHub

- Hint: Explore how to do each task above! 

---

Tips:

Always ask yourself questions when coding:
- How do I do this specific thing?
- What should be accessible when?
- Have I done something similar before?

Remember, do not just read code, play with it!

