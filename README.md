# Dialog_game

## READ BEFORE WORKING ON THE PROJECT

======

Instruction to Colaborate.

[How to use Git in 30min](https://www.youtube.com/watch?v=N_bMCff8q6A&t=1150s) check out this Video.

---

Written Description.

### 1. Clone

Get clone from romote repository (github) to local repository (your computer)

> ```
> $ git clone [remote repository URL]
> ```

for specific branch in remote repository

> ```
> $ git clone -b [ branch naem ] [ remote repository URL ]
> ```

clone is basically same as...

> ```
> $ git init
> $ git remote add origin [remote repository URL]
> $ git fetch origin master
> ```

---

- fetch : Remote -> Local
- pull : fetch + merge

---

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
- start with what you did (ex) Add ~, Remove ~)

### 4. Push

Local(your computer) -> Remote(github)

> ```
> $ git push -u origin [branch-name]
> ```

## 5. Pull requests

1. Go to github
1. go to the branch that you worked on
1. Click "Compare & pull request"
1. Click "New pull request"
1. Add title & message.
   - title : one line, concise

======

After merge, local code == remote code.

### Get updated code

> ```
> $ git pull master
> or
> $ git pull origin master
> ```

### Remove branch

> ```
> $ git branch -d [branch-name] // remove branch
> ```

### Branch list

`git branch -r`: branch list in REMOTE(Github)
`git branch -a`: branch list in LOCAL & REMOTE
`git push origin --delete [branch_name]`: remove Remote brach

======

### useful commands

- `git status`: get status
- `git branch`: current branch
