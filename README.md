<img src="https://github.com/ThatGhostToast/AZSnowSports/blob/main/src/main/resources/static/assets/images/AZSnowSports-logos_white.png" width="300" height="300"> </br>
# AZSnowSports
## The first ever social media designed for people who love to hit the slopes!
> Last Updated: 4/15/22</br>
> Authors: Austin Driver, Zac Almas
</br>

### What is AZSnowSports?
We designed AZSnowSports with skiers and snowboarders in mind. Here you can post the tales of your great adventures on the slopes and make friends along the way. In future updates, we plan on AZSnowSports to include a shop where you can sell your old used gear and a way to create groups, so you're never alone when you hit the mountain.

![Home Screencap](https://github.com/ThatGhostToast/AZSnowSports/blob/main/readme%20assets/NewVideo.gif)

<img src= https://github.com/ThatGhostToast/AZSnowSports/blob/main/readme%20assets/loginScreenshot.png>

<img src= https://github.com/ThatGhostToast/AZSnowSports/blob/main/readme%20assets/TimelineScreenshot.png>

### Database
Inside the github you should find a file labeled AZSnowSports.sql this is the database. You need to import this file into your SQL server before running AZSnowSports. If you don't have access to a SQL server then you can use the server that [MAMP][mamp] provides. Download [MAMP][mamp] and run the server. Through the web start button you can access PHPMyAdmin which is where you can import the SQL file. Please note you must have [MAMP][mamp] running everytime you start AZSnowSports

### API
Inside the github their are zip files labeled BlogAPI, UserAPI, and EurekaServer, these are seperate applications used by AZSnowSports to pull data from the database. You need to unzip them, import them into your IDE, and run them all before trying to access AZSnowSports. Please note you must run the EurekaServer first.

### Latest Update
* Blogs are now pulled from an API
* Users are now pulled from an API

### Pending Bugs
* Admin navbar buttons have a strange positioning

[mamp]: https://www.mamp.info/en/downloads/
