# athDGS-lib
Project description 
 
Steam is a distribution platform for software in general. Steam is also known for selling games for the PC as a target platform. Installation and maintenance are automated via the Steam client and it is also possible to download games before the official release date, especially if the amount of data includes several gigabytes. 

For the reasons mentioned above, it is common for third-party vendors to sell license keys for Steam games. From this starting position the requirement is derived to develop software to enable the client to establish itself in the market as an official retailer. 
In order to come one step closer to this goal, four software components are being developed. 

The lib module contains all entity classes. The object-relational framework JPA automates the mapping between the database tables and the entity classes, which eliminates the need for manual programming of the database tables. There are also interfaces of all business procedures annotated with @Remote. 
