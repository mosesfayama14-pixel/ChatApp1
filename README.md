 POE Messaging System (Console Application)

This repository contains a Java-based console application driven by the main class `POE`. The system simulates a localized messaging network (branded in-app as 'QuickChat') that handles user authentication, message validation, dynamic routing, and local data persistence. It is built entirely on Object-Oriented Programming (OOP) principles and structured to handle real-world user workflows safely without crashing.

---

Core System Features

#1. Secure Access Control (Registration & Login)
Before accessing any system features, the `POE` main class forces users through a sign-up and authorization sequence:
1. Username Security: Enforces that usernames must contain an underscore (`_`) and be a maximum of 5 characters.
2. Password Complexity: Requires a minimum of 8 characters, including at least one uppercase letter, one digit, and one special character.
3. Authentication Gate: Compares active login attempts directly against stored registration data in memory.

#2. Message Creation Pipeline & Data Model
When creating messages, the app packages inputs into a dedicated `Message` object. The data goes through multiple validation checkpoints built into the `POE` pipeline:
1. Phone Validation: Ensures cell phone numbers match standard formatting structures using a strict Regular Expression (Regex).
2. Length Guardrails: Restricts the text message to a strict maximum of 250 characters.
3. Dynamic Hash Generation:** For every message, the system creates a random 10-digit ID and algorithmically generates a unique uppercase hash token using parts of the ID and the first and last words of the text content.

#3. Dynamic Routing & Data Persistence
Once a message is validated, users can route it into distinct tracking categories:
1. Sent Buffer: Routes active messages directly to the sent registry list.
2. Disregarded Repository: Drops unwanted or skipped messages safely into separate history pools.
3. Stored Buffer: populates items into a dedicated storage tracker for deep database access.
4. JSON Serialization Engine: Automatically serializes data, cleans formatting with a custom string-escaping utility, and saves to a local `messages.json` file via a `FileWriter` stream.

# 4. Advanced Search & Analysis Submenu
The POE application includes a specialized management submenu to analyze and interact with the stored data repository:
1. Summary Reports: Lists full layout profiles of all stored messages, mapping active sender names to destination recipient targets.
2. Algorithmic Search: Automatically scans the memory pool to identify and isolate the longest message string stored.
3. Targeted Lookups: Allows administrators to filter and find message clusters instantly by typing a specific Message ID or Recipient phone number.
4. Safe Memory Management (Deletion): Users can pass a unique alphanumeric tracking hash to drop a message from memory safely, which immediately synchronizes with the local disk file.

# 5. Automated Unit Testing (`MessageTest`)
To guarantee backend stability and prevent bugs when updating the application, the project includes a dedicated unit testing suite named `MessageTest`. This testing layer isolates and validates core utility methods from the `POE` class against edge cases:
1. Authentication Tests: Verifies that both valid and invalid formats for usernames and passwords fail or pass exactly as expected.
2. Format Checking: Assures that phone number regex rules correctly identify poorly formatted strings and international formats.
3. Hash Verification: Ensures the string manipulation engine accurately grabs the correct tracking parameters (ID substring, loop counter, and text boundary words) to build perfectly formatted uppercase hashes every single time.

Video Link
https://vt.tiktok.com/ZSQ9RRrrH/

