 Project Introduction

This platform provides an interactive communication space for campus students and merchants, which not only helps users to fully understand the merchants on campus, but also introduces the function of merchant coupon seconds, which is convenient for students to flexibly choose the right merchants. At the same time, the platform also provides merchants with more exposure and profit channels.

 Main Functions

1. Login Registration:
   - Use Redis to store the authentication code and token.
   - User authentication is accomplished through customized interceptors, and double interceptors are used to solve the token refreshing problem.
2. user rights saving:
   - Use ThreadLocal with interceptor for token verification to determine whether the user is in the login state.
   - To solve the problem of HTTP statelessness and to ensure that the server can remember the user's information. 3.
3. cache consistency issues:
   - In-depth understanding of common solutions to cache consistency problems.
   - Use active update + timeout rejection cache update program in the system to meet the higher data consistency requirements.
4. second coupon:
   - Solve the inventory overselling problem by optimistic locking.
   - Use Redisson distributed locks to solve the one-person-one-order problem.
5. second kill performance optimization:
   - Use message queues (such as RabbitMQ) and Lua scripts to implement asynchronous processing of the ordering process.
   - Change the synchronous order to asynchronous order, optimize the second kill business process, the average time consumed from more than 400 milliseconds to more than 100 milliseconds.
6. statistical check-in:
   - Use Redis Bitmap data type for check-in and statistics function.
   - Compared with the MySQL storage method, it saves more memory space.
 Solutions
- The solution to the cache penetration and cache hit problems:
  - Use cache update policies and protection measures to ensure the efficiency and stability of the cache.
