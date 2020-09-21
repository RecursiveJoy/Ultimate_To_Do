@Author
Megan West, September 2020 - present

# Ultimate To Do
Ultimate To Do is a growing planner application based on popular planner designs and bullet journals. It will feature a priority-sorted to do list, a calendar, text fields for brain dumps, wellness activities, and meals, a photo gallery, and reminders for upcoming appointments. Unfinished to do list items will 'roll over' into the next day's list.

# Introduction: The Project's Aim
The goal of this project is to create a planner that focuses on wellness in a variety of ways and engenders creativity in the user. It aims to help the user achieve more of their goals and live positively and healthily. Bullet journals are growing in popularity and offer a beautiful way to track hobby and project progress in addition to daily planning. Gratitude apps allow their users to focus on the highlights of their day, cultivating a higher sense of satisfaction with life. The app will also allow users to track what they've eaten throughout the day without the punitive red numbers that calorie trackers often feature. It will also encourage the user to plan exercise or wellness activities for the day. Finally the app will feature sections for users to enter in their ideas and free thoughts, so that they can look back at a later date and turn these entries into real projects.

# Technologies
The project currently uses HTML and Vaadin as frontend, but we will soon be migrating toward Angular. The end goal is a clear, organized, and beautiful planner that does not confuse the user.
Most of the code for the project will be written in Java and Javascript. We are using Spring Framework to make the coding and testing process easier. 
The build system for this project is currently Maven, but we will soon be migrating over to Gradle. We are also running this app in a Docker container.
Under the hood we are using JPA and Hibernate to store Java objects in the Postgres tables, and Liquibase to document changes to the database.

# Ideas
Right now we are working on the main feature of the project-- the toDoList and its CRUD menus. Some ideas we hope to incorporate include a calendar, pomodoro timer, hobby tracker, a grocery list, and a mood tracker. In the far future, perhaps the planner could be modular, with the user compiling chosen components into a template.
