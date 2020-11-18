# Dialog_game

<br>
## Instruction to Colaborate.
### READ BEFORE WORKING ON THE PROJECT
<br>

[How to use Git in 30min](https://www.youtube.com/watch?v=N_bMCff8q6A&t=1150s) check out this Video.

---

Written Description.
<br>

### 1. Clone

Get clone from romote repository (github) to local repository (your computer)

> ```
> $ git clone [remote repository URL]
> ```
>
> <br>
> for specific branch in remote repository

> ```
> $ git clone -b [ branch naem ] [ remote repository URL ]
> ```
>
> <br>
> clone is basically same as...

> ```
> $ git init
> $ git remote add origin [remote repository URL]
> $ git fetch origin master
> ```

---

- fetch : Remote -> Local
- pull : fetch + merge

---

<br>
### 2. Branch

Make branch and go to the branch
Use branch in order to seperate works from master branch

> ```
> $ git checkout -b [branch name]
> or
> $ git branch [branch name]
> $ git checkout [branch name]
> ```

Use `$ git branch` to check existing branches
<br>

---

### 3. Add & Commit

If you are done with some methods or classes, do Add & Commit

> ```
> $ git add * // add all the files to staging area
> or
> $ git add [file-name] // add specific file
> $ git commit -m "commit message"
> ```

`commit message` should be

- one line
- start with what you did (ex) Add ~, Remove ~
<br>

---

### 4. Push

Local branch(your computer) -> Remote(github)

> ```
> $ git push -u origin [branch-name]
> ```

<br>

---

### 5. Pull requests

1. Go to github
1. go to the branch that you worked on
1. Click "Compare & pull request"
1. Click "New pull request"
1. Add title & message.
   - title : one line, concise
1. Use "Squash and merge"

<br>

---

After merge, local code == remote code.

### Get updated code

Remote -> Local

> ```
> $ git pull [master]
> or
> $ git pull origin [master]
> ```

<br>

---

### Remove branch

> ```
> $ git branch -d [branch-name] // remove branch
> ```

<br>

---

### Branch list

- `git branch -r`: branch list in REMOTE(Github)
- `git branch -a`: branch list in LOCAL & REMOTE
- `git push origin --delete [branch_name]`: remove Remote brach

<br>

---

### useful commands

- `git status`: get status
- `git branch`: current branch
- `git checkout -t [remote branch name]`
- `git checkout -b [local branch name] [remote branch name]`
- `git reset --soft HEAD^`
- `git reset --hard HEAD^`
- `git revert HEAD`
- `git push --set-upstream origin master`
