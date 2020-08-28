# Setting up a Git-controlled Java project with a build system on windows

## 1. Download Java SDK 11 ([hotspot](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)) from open source website and install.

## 2. Download [Git](https://git-scm.com/downloads).

## 3. Dl/ install [IntelliJ IDEA](	https://www.jetbrains.com/idea/download/?fbclid=IwAR0llqYvLwoi69ICPQAoF-YE7kcgF_oE1mOSKU1a8mbPwPnlpRJxhnot1eQ#section=windows).

## 4. Download [latest Gradle binaries](https://gradle.org/releases/?fbclid=IwAR2vjJEGS52UzjSOWiZO9YICVTS4vlbXUPG3bMvYQy_SptAAuaHWfD6mPag).
   - Follow the installation directions for Microsoft Windows users:
      Create a new directory 'C:\gradle' with File Explorer.

      Open a second File Explorer window and go to the directory where the Gradle distribution was downloaded. Double-click the ZIP archive to expose the content. Drag the content folder gradle-6.6 to your newly created C:\Gradle folder.

      Alternatively you can unpack the Gradle distribution ZIP into C:\Gradle using an archiver tool of your choice.
	 - cd to your project directory
	 - run gradle init file
	 - Choose the following options when configuring gradle for the first time:
	 		* library
			* Java
			* Kotlin
			* test framework: jupiter
			* project name
## 4. cd into the project directory and run git init
```
		C:\Gradle\gradle-6.6\ init
```
## 5. edit gitignore: delete current text with the following three configs:
	- [Windows](https://github.com/github/gitignore/blob/master/Global/Windows.gitignore?fbclid=IwAR16bPap86gaKf2B3NvXSEzdXgxTf9xhoqOliq8J9iJ1iykEmuBSABMQWtw)
	- [Gradle](https://github.com/github/gitignore/blob/master/Gradle.gitignore?fbclid=IwAR03H-ulFLivEB8DZSA3XXHXtlHOrkQt3fbdiMYF2sCTZRlxwHWPfc-QQv0)
	- [Java](https://github.com/github/gitignore/blob/master/Java.gitignore?fbclid=IwAR07kLkLUnUfUxlnTgVaWHrcE3mbCerNvNFxsrSNJjqc1URDqVAss0Gnv34)
## 6. ```git add```
## 7. Run the following commands but with your info:
	```
	$ git config --global user.name "John Doe"
	$ git config --global user.email johndoe@example.com
	```
## 8. Run ```git commit -m "some message, such as initial commit"```
## 9. make a repo in github for your project.
## 10. github should give you a url. push the code to github.
## 11. Run ```.\gradlew build```

# Now you have a git-managed java project with a build system.
