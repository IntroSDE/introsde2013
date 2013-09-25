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

	git fetch upstream

Now, the newer commits from the original repository are your local repository (but they haven't yet been merged to your repository, so you will not see them yet). The next step is to do a "merge"

	git merge upstream/master
	
Here, there are two posibilities: there are no conflicts, there are conflicts. If no conflict exist, the file ".git/MERGE_MSG" will be automaticall open/displayed, with a merge commit message in it. Just saved and exit the file and the merge will be completed with output similar to this: 

	Merge made by the 'recursive' strategy.
 		lab1/solutions/Ex1.md | 4 +++-
 	1 file changed, 3 insertions(+), 1 deletion(-)

In our case, we will have conflicts because we modified the file "README.md" and pushed that commit, so you will probably see the following output

	Auto-merging README.md
	CONFLICT (content): Merge conflict in README.md
	Automatic merge failed; fix conflicts and then commit the result. 

To fix the conflicts, you can either do it manually (opening the file and solving the conflicts as suggested [here](https://help.github.com/articles/resolving-merge-conflicts)) or use the "git mergetool". For this time, let's do it manually (you can later learn how to setup and use a visual mergetool)

So, fixing manually: open the file with the conflicts (README.md) and you will see something like this

	<<<<<<< HEAD
	your changes will be here
	=======
	the changes made in the "upstream" repository will be here
	>>>>>>> upstream/master

Choose either the paragraph above ======= or the one below and remove the other. For example, let's select your local changes and this section should be like the following.

	your changes will be here
	
If there is any other block of text like the one we saw before, you need to do the same. Once yo are done, there are some files that you just need to delete from the folder (remaining of the conflict resolution)

	README.md.BACKUP.72417.md 
	README.md.BASE.72417.md   
	README.md.LOCAL.72417.md  
	README.md.REMOTE.72417.md  

Now you can stage, commit and push the fixed version of README.md

	git add README.md
	git commit -m "conflict solved"
	git push origin master