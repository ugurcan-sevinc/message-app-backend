This is a backend code for a simple chat application built with Ktor, a Kotlin framework for creating server-side applications. The project uses Koin for dependency injection and KMongo for interacting with MongoDB, a NoSQL database.

Features:
- WebSocket-based chat functionality with support for group chat
- Session management using Ktor's built-in sessions feature
- Password support for user authentication
- Basic message encryption for security
- RoomController class that handles chat room operations such as joining, sending messages, and disconnecting
- Custom exceptions for handling member already exists scenarios
- Integration with MongoDB for storing and retrieving chat messages

The backend code includes routes for handling WebSocket connections, along with functions for processing chat messages and managing chat sessions. Koin is used for dependency injection, allowing for modular and testable code. KMongo is used for seamless interaction with MongoDB, enabling efficient storage and retrieval of chat messages.

Please note that I'm new to backend and Ktor so this is a basic implementation and may require further customization and security hardening depending on your specific use case. Proper testing and security measures should be implemented in a production environment.

<img width="1045" alt="resim" src="https://user-images.githubusercontent.com/69902076/230777728-a077fd73-4a73-4785-9be0-cf8dcb5a474a.png">
