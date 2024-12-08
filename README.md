
---

# 📚 Spring Boot Library Management System Project

![Library Management System](images/library.jpeg)


The **Spring Boot Library Management System** is a robust platform for managing library operations such as adding, borrowing, and managing books and users. The project is fully responsive, user-friendly, and designed to handle complex relationships between entities seamlessly.

---

## 🎯 **User Experience (UX)**

### User Stories

#### 🚀 **First Time Visitor Goals**
- As a **First Time Visitor**, I want to:
    - Understand the main purpose of the system and its functionality.
    - Learn how to interact with the APIs and test them using tools like Postman.
    - Explore sample test cases and understand the project structure.

#### 🔄 **Returning Visitor Goals**
- As a **Returning Visitor**, I want to:
    - Quickly test existing and new API endpoints.
    - Fetch book borrowing statistics and user details.
    - Report issues or suggest improvements.

#### ⭐ **Frequent User Goals**
- As a **Frequent User**, I want to:
    - Manage books, users, and borrowing operations efficiently.
    - Test newly added APIs using Postman collections.
    - Contribute to the project by following the guidelines.

---

## 🎨 **Design**

### **Color Scheme**
- The system uses a professional combination of white backgrounds with subtle blue and green accents for the user interface when extended to frontend development.

### **Typography**
- The default typography is clean and minimal, aimed at ensuring readability.

### **Imagery**
- Example database tables and API request/response examples are included to help understand the flow.

---

## 🌟 **Features**

- **📚 Book Management**:
    - Add, update, delete, and fetch books.
    - Borrow and return books.

- **👤 User Management**:
    - Create, update, delete, and fetch users.
    - Associate users with borrowed books.

- **🛠️ API Integration**:
    - Easily test APIs with tools like Postman.
    - Includes ready-to-use Postman collection.

- **🧪 Testing**:
    - Validated and tested with Spring Boot built-in testing tools.
    - Postman : API testings

- **🔒 Security**:
    - Secure endpoints for safe data handling.

---

## 🛠️ **Technologies Used**

### **Languages & Frameworks**
- **Java**: Backend logic.
- **Spring Boot**: Application framework.
- **Hibernate**: ORM for database interaction.
- **PostgreSQL/MySQL**: Database (supports multiple DBs).
- **Lombok**: Simplified model creation.
- **ModelMapper**: Mapping DTOs to entities.

### **Tools**
- **Postman**: API testing.
- **Maven**: Dependency management.
- **Git**: Version control.
- **IntelliJ IDEA**: IDE for development.

---

## 🧪 **Testing**

The following API testing flow was conducted using Postman:

1. **Add a Book**:
    - `POST /book`
    - Example Body:
      ```json
      {
        "title": "The Great Gatsby",
        "author": "F. Scott Fitzgerald",
        "borrowed": false
      }
      ```

2. **Fetch a Book by ID**:
    - `GET /book/{id}`

3. **Update a Book**:
    - `PUT /book`
    - Example Body:
      ```json
      {
        "id": 1,
        "title": "1984",
        "author": "George Orwell"
      }
      ```

4. **Borrow a Book**:
    - `PUT /book/borrow/{bookId}/{userId}`

5. **Delete a Book**:
    - `DELETE /book/{id}`

### **Postman API Testing Example**

Below is a sample response for the `GET /book/{id}` request:

```json
{
  "statusCode": 200,
  "message": "Book Found",
  "data": {
    "bookId": 1,
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "borrowed": false
  }
}
```

---

## 🚀 **Deployment**

### **Local Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR-USERNAME/library-management-system.git
   ```
2. Import the project into your IDE (e.g., IntelliJ IDEA).
3. Set up the database in `application.properties`.
4. Run the application using:
   ```bash
   mvn spring-boot:run
   ```

### **Postman Setup**
1. Import the Postman collection provided in the project folder.
2. Use the base URL `http://localhost:8080` for all API requests.

---

## 📄 **License**

This project is licensed under the **MIT License**. For details, refer to the [LICENSE](C:\Users\puroh\Downloads\_  library-management-system\LICENSE) file.

---

## 🤝 **Contributing**

We welcome contributions! Please follow the steps below:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch-name`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch-name`).
5. Open a Pull Request.

For guidelines, refer to the [LICENSE](C:\Users\puroh\Downloads\_  library-management-system\LICENSE) file.

---

## 🙏 **Acknowledgements**

- **Spring Boot Documentation**: For detailed framework guidelines.
- **Stack Overflow**: For solving complex issues during development.
- **Postman**: For seamless API testing.

---

## 📞 Contact

If you have any questions, feedback, or suggestions, feel free to connect with me:

- **LinkedIn**: [Param Purohit](https://www.linkedin.com/in/param-p-370616310/)
- **GitHub**: [Purohit1999](https://github.com/Purohit1999)

I'm always open to collaborations and discussions. Don't hesitate to reach out! ✨

---

## ⭐ **Show Your Support**

If you found this project helpful, please ⭐ **star the repository** and share it with others!

---
