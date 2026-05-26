# QuickChat
Good day, sir. Today, I will be presenting my Java application called QuickChat. It is a secure, interactive desktop messaging application that allows a user to register, log in, validate messages, and save them automatically to a local storage file."

Startup: Registration and Login
"When the program first runs, it handles user security.

First, it opens visual pop-up boxes to ask a new user for their first name, last name, and to choose a username and password.

Once registered, the system takes them to a security screen. It checks if the username and password they type in match the registered details exactly. If they don't match, access is denied and the program stops."

The Main Menu
"Once logged in, the user is greeted with a main menu panel. This menu runs inside a loop, meaning it keeps showing up until the user explicitly chooses option 3 to quit.

Option 1 lets them send messages, option 2 is a placeholder for future updates, and option 3 exits the application safely."

Messaging and Validation Logic
"The most important part of the code is the messaging workflow under Option 1. It asks the user how many messages they want to send, and then loops through that exact number. For each message, it performs a few checks:

Phone Number Check: It ensures the recipient's phone number is at least 10 characters long and starts with a proper international code like a plus sign. If it's wrong, it asks them to try again.

Length Check: It checks the message text. If the message is under 250 characters, it accepts it. If it is too long, it calculates exactly how many characters it went over by and tells the user to reduce the size.

ID & Hash Generation: Once the data is clean, the program randomly generates a unique 10-digit Message ID. It then automatically builds a unique tracking code, called a hash, by combining the first two digits of the ID, the loop number, and parts of the message content."

User Actions and Saving to JSON
"After generating the tracking details, the user chooses what to do with the message: send it, disregard it, or store it.

If they choose to send or store it, the program creates a new ⁠Message⁠ object and adds it to an internal list. Right after that, it calls a save method that writes the entire list into a file called ⁠messages.json⁠ on the hard drive. It uses a custom text builder to make sure the data matches standard JSON formatting so it can be retrieved cleanly later."

Conclusion

"In summary, this project combines user authentication, strict input validation based on the assignment rules, dynamic ID generation, and persistent file saving to create a reliable messaging framework.

Thank you."

Youtube links

https://youtu.be/YLtlz88zrLg?shttps://

https://youtu.be/Jhra__USVYE?si=iwu0FUW4lv40w01Y

https://youtu.be/r4MLHHLctKw?si=lcq2LgoY0MPAe5Y-

https://youtu.be/rWChttps:

https://youtu.be/nl96BIVUM60?si=LBPJ7hr4Tmz6gQRG

As mentioned in my speech in created a program called Quickchat, even though my mic didnt work I managed to show how my code ran and the unit tests associated with it. With that being said that concludes part 2 of my POE assignment.
