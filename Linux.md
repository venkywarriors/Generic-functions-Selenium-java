
## Basic Linux Commands
Click this link to view <a href="https://github.com/venkywarriors/Generic-functions-Selenium-java/blob/master/linux-commands-cheat-sheet-pdf.pdf" title="Click here to view Cheet sheet">*Cheet sheet* </a><br>
Executing Selenium Scripts on Linux Ubuntu Machine
| Command | Description |
| --- | --- |
| `ls` | Lists all files and directories in the current directory |
| `ls -R` | Lists files in sub-directories as well |
| `ls -a` | Lists hidden files as well |
| `ls -al` | Lists files and directories with detailed information |
| `cd or cd ~` | Navigate to HOME directory |
| `cd ..` | Move one level up |
| `cd` | To change to a particular directory |
| `cd /` | Move to the root directory |
| `cat > filename` | Creates a new file |
| `cat filename` | Displays the file content |
| `cat file1 file2 > file3` | Joins two files (file1, file2) and stores the output in a new file (file3) |
| `mv file "new file path"` | Moves the files to the new location |
| `mv filename new_file_name` | Renames the file to a new filename |
| `sudo` | Allows regular users to run programs with the security privileges of the superuser or root |
| `rm filename` | Deletes a file |
| `man` | Gives help information on a command |
| `history` | Gives a list of all past commands typed in the current terminal session |
| `clear` | Clears the terminal |
| `mkdir directoryname` | Creates a new directory in the present working directory or at the specified path |
| `rmdir` | Deletes a directory |
| `mv` | Renames a directory |
| `pr -x` | Divides the file into x columns |
| `pr -h` | Assigns a header to the file |
| `pr -n` | Denotes the file with Line Numbers |
| `lp -nc , lpr c` | Prints “c” copies of the File |
| `lp-d lp-P` | Specifies the name of the printer |
| `apt-get` | Command used to install and update packages |
| `mail -s 'subject' -c 'cc-address' -b 'bcc-address' 'to-address'` | Command to send email |
| `mail -s "Subject" to-address < Filename` | Command to send email with attachment |

## File Permission Commands

| Command | Description |
| --- | --- |
| `ls -l` | To show file type and access permission |
| `r` | Read permission |
| `w` | Write permission |
| `x` | Execute permission |
| `-` | No permission |
| `Chown user` | For changing the ownership of a file/directory |
| `Chown user:group filename` | Change the user as well as group for a file or directory |

## Environment Variables Commands

| Command | Description |
| --- | --- |
| `echo $VARIABLE` | To display the value of a variable |
| `env` | Displays all environment variables |
| `VARIABLE_NAME= variable_value` | Create a new variable |
| `Unset` | Remove a variable |
| `export Variable=value` | To set the value of an environment variable |

## User Management Commands

| Command | Description |
| --- | --- |
| `sudo adduser username` | To add a new user |
| `sudo passwd -l 'username'` | To change the password of a user |
| `sudo userdel -r 'username'` | To remove a newly created user |
| `sudo usermod -a -G GROUPNAME USERNAME` | To add a user to a group |
| `sudo deluser USER GROUPNAME` | To remove a user from a group |
| `finger` | Shows information of all the users logged in |
| `finger username` | Gives information of a particular user |

## Networking Commands

| Command | Description |
| --- | --- |
| `SSH username@ip-address or hostname` | Login into a remote Linux machine using SSH |
| `Ping hostname="" or =""` | To ping and analyze network and host connections |
| `dir` | Display files in the current directory of a remote computer |
| `cd "dirname"` | Change directory to “dirname” on a remote computer |
| `put file` | Upload ‘file’ from local to remote computer |
| `get file` | Download ‘file’ from remote to local computer |
| `quit` | Logout |

## Process Commands

| Command | Description |
| --- | --- |
| `bg` | To send a process to the background |
| `fg` | To run a stopped process in the foreground |
| `top` | Details on all active processes |
| `ps` | Give the status of processes running for a user |
| `ps PID` | Gives the status of a particular process |
| `pidof` | Gives the Process ID (PID) of a process |
| `kill PID` | Kills a process |
| `nice` | Starts a process with a given priority |
| `renice` | Changes priority of an already running process |
| `df` | Gives free hard disk space on your system |
| `free` | Gives free RAM on your system |

## VI Editing Commands

| Command | Description |
| --- | --- |
| `i` | Insert at cursor (goes into insert mode) |
| `a` | Write after the cursor (goes into insert mode) |
| `A` | Write at the end of the line (goes into insert mode) |
| `ESC` | Terminate insert mode |
| `u` | Undo the last change |
| `U` | Undo all changes to the entire line |
| `o` | Open a new line (goes into insert mode) |
| `dd` | Delete line |
| `3dd` | Delete 3 lines |
| `D` | Delete contents of the line after the cursor |
| `C` | Delete contents of a line after the cursor and insert new text. Press the ESC key to end insertion |
| `dw` | Delete word |
| `4dw` | Delete 4 words |
| `cw` | Change word |
| `x` | Delete character at the cursor |
| `r` | Replace character |
| `R` | Overwrite characters from cursor onward |
| `s` | Substitute one character under the cursor and continue to insert |
| `S` | Substitute the entire line and begin to insert at the beginning of the line |
| `~` | Change the case of an individual character |

### :dart:How to launch Firefox and Chrome browsers using Selenium on Linux | Ubuntu 18.04:
WebDriverManager is an open-source Java library that automatically performs the four steps (find, download, setup, and maintenance) mentioned above for the drivers required for Selenium tests. <br>
Click this link to view <a href="https://www.youtube.com/watch?v=er3AcbcsNlY" title="Click here to view Executing Selenium Scripts on Ubuntu">*Executing Selenium Scripts on Ubuntu* </a><br>
```

        // Set up the WebDriverManager for chrome driver
        WebDriverManager.chromedriver().OperatingSystem(OperatingSystem.Linux)setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); or options.addArguments("--headless=chrome") or '--headless=new'
        // Create the driver object
        driver = new ChromeDriver();

```
```

        // Set up the WebDriverManager for firefox driver
        WebDriverManager.firefoxdriver().OperatingSystem(OperatingSystem.Linux)setup();
        FirefoxOptions options=new FirefoxOptions();
        options.addArguments("--headless=new");
        // Create the driver object
        driver = new firefoxDriver();

```
* WebDriverManager automates the management of WebDriver binaries, thereby avoiding installing any device binaries manually.
* WebDriverManager checks the version of the browser installed on your machine and downloads the proper driver binaries into the local cache (~/.cache/selenium by default) if not already present.
* WebDriverManager matches the version of the drivers. If unknown, it uses the latest version of the driver
* WebDriverManager offers cross browser testing without the hassle of installing and maintaining different browser driver binaries.
* WebDriverManager can create browsers in Docker containers
