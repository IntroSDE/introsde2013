Exercise 1 - Basic GIT
===

Change the README file, add your name on it, stage it, commit it and then, push it to your remote origin repository. After that, add the ogirinal repository as a new remote called "upstream" (to download the code of the future lab sessions that we will put there)

Solution 
===
After modifying the file README.md (you can modify it as you wish), this is what you need to do with git

	git add README.md
	git commit -m "added my name to the readme"
	git push origin master

For the second part, add the original repository as a remote called upstream (so that you can "fetch" future lab sessions code from there)

	git remote add upstream https://github.com/cdparra/introsde2013.git

Now, you can download new files in it (without modifying your own) by using "git fetch" as follows

	git fetch upstream master

You should now see the new "lab2" folder already is there. 
