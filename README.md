To get repository:

Authenticate with git if you need to by running:
"git credential-manager github login"

Create a folder where you want the repository to be in.
Run "git clone https://github.com/YellowCardinal/IT326_Project.git" in that folder.
Enter the project root folder

To run:

1. Make sure you have java 21 installed and configured as your JAVA_HOME enviornment variable
Download from: https://adoptium.net/temurin/releases

2. Type ".\mvnw.cmd clean spring-boot:run" from project root folder in terminal.

3. Open a browser and type "http://localhost:8080" as the url

4. press ctrl c in terminal to stop hosting.

MongoDB connection:

- Put the connection URI in the project root `.env` file as `MONGODB_URI=...`. The app loads this file when it starts.
- The default `.env` connects to `mongodb://localhost:27017/it326_group_project`; start a local MongoDB server to use it.
- For MongoDB Atlas, replace the value in `.env` with your Atlas connection URI. Keep `.env` private; it is excluded from Git. A shareable template is in `.env.example`.
- `StudentRepository` provides standard MongoDB CRUD operations and `findByIsuEmail` for looking up a student by their ISU email.

To get new changes:
git pull origin main

To push changes:
git add .
git commit -m "commit message"
git push origin main

To make a branch:
git switch -c branch-name (This creates the branch)
git branch (This shows the current branches)
git switch branch-name (Switches to a branch)

For branches, use "git push origin branch-name" to push to your branch.
Don't use git push origin main

After you pushed your branch to github servers(origin), go onto github's website and open the repository
Click "Pull Requests"
Click green "New Pull Request" button.
Select it so it's "main <- branch-name" 
(You are merging your branch into main)
Click "Create Pull Request"
Click green "Merge Pull Request" button.
