Samyam C. Shrestha
ss4674
SE 311
Lab 4

The program works as required for the Lab 4. There are two projects namely OddFinderServer and NumberFeederClient. 

To run: Simply unzip the projects and import them to eclipse. The OddFinderServer project includes a multithreaded server. The NumberFeederClient includes a client that is capable of conecting to the server and feed the server with a list of number inputs from the user. Mkae sure you run the server code first so that the server is up and running and waiting for the client to connect. Then once the server is running, run the client file from the NumberFeederCleint project. 

After the server and client connects, the user will be prompted to enter integers. The user will have to enter 'q' when done with entering the integers. Incase the user inputs a non-integer value, the client program gracefully ignores that input value and does not add it to the output stream. The server then accordingly processes the input from the client and gives back the list of odd integers. Then the client will display the total number of integers along with the integer values.

